package com.example.scheactim;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

public class ScheActimApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setup();
    }

    private void setup() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
