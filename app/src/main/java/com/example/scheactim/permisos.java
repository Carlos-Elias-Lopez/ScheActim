package com.example.scheactim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.scheactim.data.UserConfig;

public class permisos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);
        cambiaractivity();
    }
    private void cambiaractivity(){

        Button BtnCambiar = findViewById(R.id.btn_permitir);
        Button BtnCancelar = findViewById(R.id.btn_denegar);
        BtnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navegarActivity();
            }
        });

        BtnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navegarActivityCancelar();
            }
        });

    }
    private void navegarActivity(){
        saveFirstStart();
        Intent transicion = new Intent(this, signup.class);
        //la proxima activity ahora será la primera en el back stack
        transicion.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(transicion);
    }
    private void navegarActivityCancelar(){
        saveFirstStart();
        Intent transicion = new Intent(this, appintro.class);
        //la proxima activity ahora será la primera en el back stack
        transicion.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(transicion);
    }

    private void saveFirstStart() {

        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setIsFirstTime(false);
    }

}