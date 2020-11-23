package com.example.scheactim.data;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

import com.example.scheactim.modelos.ModeloActividades;
import com.example.scheactim.helpers.FileHelper;



public class ActividadesAssetSource {

    private final Gson parser;
    private final Context mContext;
    private static final String POINTS_FILE_NAME = "points.json";

    ActividadesAssetSource(@NonNull Context context) {
        mContext = context;
        parser = new Gson();
    }


    public List<ModeloActividades> getAll(int count) {
        String json = FileHelper.getJsonFromAssets(mContext, POINTS_FILE_NAME);
        ListResult listResult = parser.fromJson(json, ListResult.class);
        if(listResult == null) return null;
        return listResult.list;
    }

    static class ListResult {
        @SerializedName("data")
        List<ModeloActividades> list;

        public ListResult(List<ModeloActividades> list) {
            this.list = list;
        }
    }
}
