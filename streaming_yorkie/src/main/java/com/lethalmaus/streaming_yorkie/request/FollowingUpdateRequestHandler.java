package com.lethalmaus.streaming_yorkie.request;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.lethalmaus.streaming_yorkie.Globals;
import com.lethalmaus.streaming_yorkie.R;
import com.lethalmaus.streaming_yorkie.file.ReadFileHandler;
import com.lethalmaus.streaming_yorkie.file.WriteFileHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.lang.ref.WeakReference;

/**
 * Class for requesting Followers to check if an Update is needed
 * @author LethalMaus
 */
public class FollowingUpdateRequestHandler extends RequestHandler {

    @Override
    public String url() {
        return "https://api.twitch.tv/kraken/users/" + userID + "/follows/channels?limit=" + Globals.USER_UPDATE_REQUEST_LIMIT + "&direction=desc";
    }

    @Override
    public int method() {
        return Request.Method.GET;
    }

    /**
     * Constructor for FollowersUpdateRequestHandler
     * @author LethalMaus
     * @param weakActivity weak referenced activity
     * @param weakContext weak referenced context
     * @param recyclerView weak referenced recycler view
     */
    public FollowingUpdateRequestHandler(final WeakReference<Activity> weakActivity, final WeakReference<Context> weakContext, final WeakReference<RecyclerView> recyclerView) {
        super(weakActivity, weakContext, recyclerView);
        this.requestType = "FOLLOWING_UPDATE";
    }

    @Override
    public void responseHandler(final JSONObject response) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    long lastUpdated = 0;
                    String lastUpdatedString = new ReadFileHandler(weakActivity, weakContext, "FOLLOWING_TIMESTAMP").readFile();
                    if (!lastUpdatedString.isEmpty()) {
                        lastUpdated = Long.parseLong(lastUpdatedString);
                    }
                    int[] lastFollowing = streamingYorkieDB.followingDAO().getLastUsers(lastUpdated);
                    if (lastFollowing.length == response.getJSONArray("follows").length()  && new File(weakContext.get().getFilesDir() + File.separator + "TWITCH_FOLLOWING_TOTAL_COUNT").exists() && response.getInt("_total") == Integer.parseInt(new ReadFileHandler(weakActivity, weakContext, "TWITCH_FOLLOWING_TOTAL_COUNT").readFile())) {
                        for (int i = 0; i < lastFollowing.length; i++) {
                            if (lastFollowing[i] != Integer.parseInt(response.getJSONArray("follows").getJSONObject(i).getJSONObject("channel").getString("_id"))) {
                                new FollowingRequestHandler(weakActivity, weakContext, recyclerView){
                                    @Override
                                    public void onCompletion() {
                                        super.onCompletion();
                                        FollowingUpdateRequestHandler.this.onCompletion();
                                    }
                                }.initiate().sendRequest();
                                return;
                            }
                        }
                        if (weakActivity != null && weakActivity.get() != null) {
                            weakActivity.get().runOnUiThread(new Runnable() {
                                public void run() {
                                    weakActivity.get().findViewById(R.id.progressbar).setVisibility(View.GONE);
                                }
                            });
                        }
                        onCompletion();
                    } else {
                        new FollowingRequestHandler(weakActivity, weakContext, recyclerView){
                            @Override
                            public void onCompletion() {
                                super.onCompletion();
                                FollowingUpdateRequestHandler.this.onCompletion();
                            }
                        }.initiate().sendRequest();
                    }
                } catch (JSONException e) {
                    if (weakActivity != null && weakActivity.get() != null) {
                        weakActivity.get().runOnUiThread(
                                new Runnable() {
                                    public void run() {
                                        Toast.makeText(weakActivity.get(), "Twitch has changed its API, please contact the developer.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        );
                    }
                    new WriteFileHandler(weakActivity, weakContext, "ERROR", null, "FollowingEntity Update response error | " + e.toString(), true).run();
                }
            }
        }).start();
    }
}
