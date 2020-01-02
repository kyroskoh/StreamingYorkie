package com.lethalmaus.streaming_yorkie.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.lethalmaus.streaming_yorkie.Globals;
import com.lethalmaus.streaming_yorkie.R;
import com.lethalmaus.streaming_yorkie.view.UserView;
import com.lethalmaus.streaming_yorkie.worker.AutoFollowWorker;
import com.lethalmaus.streaming_yorkie.worker.AutoVODExportWorker;

import java.lang.ref.WeakReference;

/**
 * Activity for showing settings categories.
 * @author LethalMaus
 */
public class SettingsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ImageButton f4f = findViewById(R.id.menu_settings_f4f);
        f4f.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SettingsMenu.this, SettingsF4F.class);
                        startActivity(intent);
                    }
                });

        ImageButton vod = findViewById(R.id.menu_settings_vod);
        vod.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SettingsMenu.this, SettingsVOD.class);
                        startActivity(intent);
                    }
                });

        ImageButton logout = findViewById(R.id.menu_settings_logout);
        logout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SettingsMenu.this, Authorization.class);
                        startActivity(intent);
                    }
                });
        new UserView(new WeakReference<>(this), new WeakReference<>(getApplicationContext())).execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Globals.activateWorker(new WeakReference<>(getApplicationContext()), "SETTINGS_F4F", Globals.SETTINGS_AUTOFOLLOW, AutoFollowWorker.class, Globals.AUTOFOLLOW_NOTIFICATION_CHANNEL_ID, Globals.AUTOFOLLOW_NOTIFICATION_CHANNEL_NAME, Globals.AUTOFOLLOW_NOTIFICATION_CHANNEL_DESCRIPTION);
        Globals.activateWorker(new WeakReference<>(getApplicationContext()), "SETTINGS_VOD", Globals.SETTINGS_AUTOVODEXPORT, AutoVODExportWorker.class, Globals.AUTOVODEXPORT_NOTIFICATION_CHANNEL_ID, Globals.AUTOVODEXPORT_NOTIFICATION_CHANNEL_NAME, Globals.AUTOVODEXPORT_NOTIFICATION_CHANNEL_DESCRIPTION);
    }

    //Back to Settings Menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return true;
    }
}
