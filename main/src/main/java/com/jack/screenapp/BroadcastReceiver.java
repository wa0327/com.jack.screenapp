package com.jack.screenapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            boolean maskEnabled = preferences.getBoolean("mask_enabled", false);
            if (maskEnabled) {
                context.startService(new Intent(context, MaskService.class));
            }
        }
    }
}
