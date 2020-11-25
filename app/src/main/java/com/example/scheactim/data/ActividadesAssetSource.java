package com.example.scheactim.data;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

import com.example.scheactim.modelos.ModeloActividades;
import com.example.scheactim.helpers.FileHelper;

import static android.content.ContentValues.TAG;


public class ActividadesAssetSource implements IActividadesSource {

    private final Gson parser;
    private final Context mContext;
    private static final String POINTS_FILE_NAME = "activities.json";

    ActividadesAssetSource(@NonNull Context context) {
        mContext = context;
        parser = new Gson();
    }


    public List<ModeloActividades> getAll(int count) {

        String json = FileHelper.getJsonFromAssets(mContext, POINTS_FILE_NAME);
        ListResult listResult = parser.fromJson(json, ListResult.class);
        return listResult.data;
    }


    static class ListResult {
        @SerializedName("data")
        List<ModeloActividades> data;

        public ListResult(List<ModeloActividades> data) {
            this.data = data;
        }
    }
}
