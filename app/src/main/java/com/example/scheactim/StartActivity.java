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
        Intent intent;
        if(userConfig.isFirstTime()) {
            intent = new Intent(getBaseContext(), appintro.class);
        } else {
            if(userConfig.userExists()) {
                intent = new Intent(getBaseContext(), MenuPrincipal.class);
            } else {
                intent = new Intent(getBaseContext(), signup.class);
            }
        }
        startActivity(intent);
        //finalizar esta actividad
        finish();
    }
}
