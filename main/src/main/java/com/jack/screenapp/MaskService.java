package com.jack.screenapp;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.IBinder;
import android.preference.PreferenceManager;

public class MaskService extends Service {

    private MaskView maskView;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int alpha = preferences.getInt("mask_alpha", 0x50);
        int red = preferences.getInt("mask_red", 0xff);
        int green = preferences.getInt("mask_green", 0xff);
        int blue = preferences.getInt("mask_blue", 0x00);
        int color = Color.argb(alpha, red, green, blue);

        maskView = new MaskView(this);
        maskView.setBackgroundColor(color);
    }

    @Override
    public void onDestroy() {
        maskView.onDestroy();
        super.onDestroy();
    }
}
