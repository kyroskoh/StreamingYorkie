package com.lethalmaus.streaming_yorkie.request;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.lethalmaus.streaming_yorkie.Globals;
import com.lethalmaus.streaming_yorkie.adapter.UserAdapter;
import com.lethalmaus.streaming_yorkie.entity.FollowerEntity;
import com.lethalmaus.streaming_yorkie.file.WriteFileHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Class for requesting Followers
 * @author LethalMaus
 */
public class FollowersRequestHandler extends RequestHandler {

    private String cursor = "";

    @Override
    public String url() {
        return "https://api.twitch.tv/kraken/channels/" + userID + "/follows?limit=" + Globals.USER_REQUEST_LIMIT + "&direction=desc&cursor=" + cursor;
    }

    @Override
    public int method() {
        return Request.Method.GET;
    }

    /**
     * Constructor for FollowersRequestHandler
     * @author LethalMaus
     * @param weakActivity weak referenced activity
     * @param weakContext weak referenced context
     * @param recyclerView weak referenced recycler view
     */
    FollowersRequestHandler(final WeakReference<Activity> weakActivity, final WeakReference<Context> weakContext, final WeakReference<RecyclerView> recyclerView) {
        super(weakActivity, weakContext, recyclerView);
        this.requestType = "FOLLOWERS";
    }

    @Override
    public void responseHandler(final JSONObject response) {
        new Thread() {
            public void run() {
                try {
                    if (response.has("_cursor")) {
                        cursor = response.getString("_cursor");
                    }
                    if (twitchTotal == 0) {
                        twitchTotal = response.getInt("_total");
                    }
                    itemCount += response.getJSONArray("follows").length();
                    for (int i = 0; i < response.getJSONArray("follows").length(); i++) {
                        FollowerEntity followerEntity = new FollowerEntity(Integer.parseInt(response.getJSONArray("follows").getJSONObject(i).getJSONObject("user").getString("_id")),
                                response.getJSONArray("follows").getJSONObject(i).getJSONObject("user").getString("display_name"),
                                response.getJSONArray("follows").getJSONObject(i).getJSONObject("user").getString("logo").replace("300x300", "50x50"),
                                response.getJSONArray("follows").getJSONObject(i).getString("created_at"),
                                response.getJSONArray("follows").getJSONObject(i).getBoolean("notifications"),
                                timestamp);
                        FollowerEntity existingFollowerEntity = streamingYorkieDB.followerDAO().getUserById(followerEntity.getId());
                        if (existingFollowerEntity != null) {
                            if (existingFollowerEntity.getStatus() != null && existingFollowerEntity.getStatus().contentEquals("EXCLUDED")) {
                                followerEntity.setStatus("EXCLUDED");
                            } else {
                                followerEntity.setStatus("CURRENT");
                            }
                            streamingYorkieDB.followerDAO().updateUser(followerEntity);
                        } else {
                            followerEntity.setStatus("NEW");
                            streamingYorkieDB.followerDAO().insertUser(followerEntity);
                        }
                    }
                    if (response.getJSONArray("follows").length() == Globals.USER_REQUEST_LIMIT && itemCount < twitchTotal) {
                        sendRequest(true);
                    } else {
                        if (twitchTotal != itemCount && Globals.checkWeakActivity(weakActivity)) {
                            weakActivity.get().runOnUiThread(() ->
                                    Toast.makeText(weakActivity.get(), "Twitch is slow. Its data for 'Followers' is out of sync. Total should be '" + twitchTotal
                                            + "' but is only giving '" + itemCount + "'", Toast.LENGTH_SHORT).show()
                            );
                        }
                        new WriteFileHandler(weakActivity, weakContext, "TWITCH_FOLLOWERS_TOTAL_COUNT", null, String.valueOf(twitchTotal), false).run();
                        List<FollowerEntity> unfollowed = streamingYorkieDB.followerDAO().getUnfollowedUsers(timestamp);
                        for (int i = 0; i < unfollowed.size(); i++) {
                            unfollowed.get(i).setStatus("UNFOLLOWED");
                            streamingYorkieDB.followerDAO().updateUser(unfollowed.get(i));
                        }
                        //TODO this can be added to onCompletion by extending a base adapter
                        if (Globals.checkWeakActivity(weakActivity) && Globals.checkWeakRecyclerView(recyclerView)) {
                            final UserAdapter userAdapter = (UserAdapter) recyclerView.get().getAdapter();
                            if (userAdapter != null) {
                                weakActivity.get().runOnUiThread(() -> {
                                    recyclerView.get().stopScroll();
                                    recyclerView.get().scrollToPosition(0);
                                    recyclerView.get().getRecycledViewPool().clear();
                                    recyclerView.get().post(userAdapter::datasetChanged);
                                });
                            }
                        }
                        onCompletion(true);
                    }
                } catch (JSONException e) {
                    if (Globals.checkWeakActivity(weakActivity)) {
                        weakActivity.get().runOnUiThread(() ->
                                Toast.makeText(weakActivity.get(), "Twitch has changed its API, please contact the developer.", Toast.LENGTH_SHORT).show()
                        );
                    }
                    new WriteFileHandler(weakActivity, weakContext, "ERROR", null, "Followers response error | " + e.toString(), true).run();
                }
            }
        }.start();
    }
}