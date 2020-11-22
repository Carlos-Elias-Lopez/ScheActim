package com.example.scheactim.data;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.example.scheactim.BuildConfig;

import java.util.Locale;

public class UserConfig {
    private static final Object USER_PREF_NAME = "user_prefs";
    private static final String PREF_FIRST_TIME = "is_first_time";
    private final SharedPreferences mPrefs;

    public  UserConfig ( @NonNull Context context){
        mPrefs = context.getSharedPreferences(getPrefsName(), context.MODE_PRIVATE);
    }

    public boolean isFirstTime() {
        return mPrefs.getBoolean(PREF_FIRST_TIME, true);
    }

    public boolean setIsFirstTime(Boolean value) {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putBoolean(PREF_FIRST_TIME, value);
        prefsEditor.apply();
        return true;
    }

    private String getPrefsName() {
        return String.format(
                Locale.getDefault(),
                "%s_%s",
                BuildConfig.APPLICATION_ID , USER_PREF_NAME
        );
    }
}
