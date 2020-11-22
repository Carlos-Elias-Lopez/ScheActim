package com.example.scheactim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.scheactim.data.UserConfig;

import static android.content.ContentValues.TAG;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchFirstActivity();
    }

    private void launchFirstActivity() {

        UserConfig userConfig = new UserConfig(getApplicationContext());
        Intent transicion;
        if(userConfig.isFirstTime()) {

            transicion = new Intent(getBaseContext(), MainActivity.class);

        } else {
            transicion = new Intent(getBaseContext(), signup.class);

        }

        startActivity(transicion);
        //finalizar esta actividad
        finish();
    }
}
