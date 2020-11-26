package com.example.scheactim.data;

import android.content.Context;
import android.util.Log;

import com.example.scheactim.modelos.ModeloActividades;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ActividadesRepo {
    private final IActividadesSource mSource;

    public ActividadesRepo(Context context) {

        mSource = new ActividadesAssetSource(context);
    }

    public ActividadesRepo(IActividadesSource source) {
        mSource = source;
    }

    public List<ModeloActividades> getAll() {
        return mSource.getAll(50);
    }
}
