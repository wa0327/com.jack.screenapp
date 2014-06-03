package com.jack.screenapp;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.SwitchPreference;

public class SettingsActivity extends PreferenceActivity {

    private SwitchPreference spMaskEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, MaskService.class));

        if (spMaskEnabled.isChecked()) {
            startService(new Intent(this, MaskService.class));
        }

        super.onDestroy();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_settings);

        spMaskEnabled = (SwitchPreference)findPreference("mask_enabled");
    }
}
