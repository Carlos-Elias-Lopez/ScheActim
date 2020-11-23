package com.example.scheactim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.content.ContentValues.TAG;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        cambiaractivity();
    }

    private void cambiaractivity(){

        Button BtnRegistrar = findViewById(R.id.btn_signup);
        BtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navegarActivity();
            }
        });
    }

    private void navegarActivity(){


        Intent transicion = new Intent(this, RecyclerActividadesActivity.class);
        //la proxima activity ahora será la primera en el back stack
        //transicion.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(transicion);
    }
}