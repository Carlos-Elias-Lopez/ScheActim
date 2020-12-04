package com.example.scheactim.data;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.scheactim.R;
import com.example.scheactim.modelos.ActividadesEntry;
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

    private TextView tvContent;
    private ScheActimEntriesDao entriesDao;
    ActividadesAssetSource(@NonNull Context context) {
        mContext = context;
        parser = new Gson();
    }


    public List<ModeloActividades> getAll(int count) {

        String json = FileHelper.getJsonFromAssets(mContext, POINTS_FILE_NAME);
        ListResult listResult = parser.fromJson(json, ListResult.class);
        if(listResult == null) return null;
        return filterByCount(listResult.list, count);





    }

    private List<ModeloActividades> filterByCount( @NonNull List<ModeloActividades> originalList, int count) {
        if(count < 0) throw new IllegalArgumentException("Parametro count inválido");
        if(count == 0) return originalList;
        if(count >= originalList.size()) return originalList;
        return originalList.subList(0, count);
    }


    static class ListResult {
        @SerializedName("data")
        List<ModeloActividades> list;

        public ListResult(List<ModeloActividades> list) {
            this.list = list;
        }
    }
}
