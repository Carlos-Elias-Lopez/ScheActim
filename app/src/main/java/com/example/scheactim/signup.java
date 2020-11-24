package com.example.scheactim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.scheactim.data.UserConfig;
import com.example.scheactim.modelos.UserModel;
import com.google.android.material.textfield.TextInputLayout;

import static android.content.ContentValues.TAG;

public class signup extends AppCompatActivity {

    TextInputLayout tilFullname, tilEmail;
    EditText etFullname, etEmail;

    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        cambiaractivity();
    }

    private void cambiaractivity(){
        tilFullname = findViewById(R.id.til_fullname);
        tilEmail = findViewById(R.id.til_email);

        etFullname = tilFullname.getEditText();
        etEmail = tilEmail.getEditText();

        Button BtnRegistrar = findViewById(R.id.btn_signup);
        BtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

        //loadDefaultDataIfDebug();
    }

    private void signUp() {
        if(!validateFields()) {
            return;
        }
        userModel = new UserModel(etFullname.getText().toString(), etEmail.getText().toString());
        saveUser(userModel);
        navegarActivity(userModel);
    }

    private void saveUser(UserModel user) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        userConfig.setUser(user);
    }


    private void navegarActivity(UserModel user){


        Intent transicion = new Intent(this, RecyclerActividadesActivity.class);
        //la proxima activity ahora será la primera en el back stack
        //transicion.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(transicion);
    }

    private boolean validateFields() {
        if(etFullname.getText() == null || TextUtils.isEmpty(etFullname.getText().toString())) {
            showMessage("Ingresa tu nombre completo!!");
            return false;
        }
        if(etEmail.getText() == null || TextUtils.isEmpty(etEmail.getText().toString())) {
            showMessage("Ingresa tu Correo!!");
            return false;
        }

        showMessage("Usuario guardado con exito!");
        return true;
    }

    private void showMessage(String message) {
        Toast.makeText(
                this,
                message,
                Toast.LENGTH_LONG
        ).show();
    }
/*
    @SuppressLint("SetTextI18n")
    private void loadDefaultDataIfDebug() {
        if(!BuildConfig.DEBUG) return;
        etFullname.setText("Jimmy Saenz");
        etEmail.setText("jimmy.saenz@uca.edu.ni");
    }

 */

}