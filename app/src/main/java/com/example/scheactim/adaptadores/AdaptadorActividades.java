package com.example.scheactim.adaptadores;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import  com.example.scheactim.R;
import com.example.scheactim.adaptadores.viewholder.ActividadesViewHelper;
import  com.example.scheactim.adaptadores.viewholder.ActividadesViewHolder;
import  com.example.scheactim.helpers.eventos.ItemTapListener;
import  com.example.scheactim.modelos.ModeloActividades;

import static android.content.ContentValues.TAG;


public class AdaptadorActividades extends RecyclerView.Adapter<ActividadesViewHolder>  {

    @NonNull
    private List<ModeloActividades> mModelList;
    @Nullable
    private final ItemTapListener mTapListener;

    //pasamos parametros al adapter
    public AdaptadorActividades(@NonNull List<ModeloActividades> modelList, @Nullable ItemTapListener tapListener) {
        mModelList = modelList;
        mTapListener = tapListener;
    }

    public void updateList(List<ModeloActividades> newList) {
        mModelList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    //inflamos cada item con su respectiva vista.
    public ActividadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.e(TAG, "Entro a la inflacion");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recycler_actividades, parent, false);
        ActividadesViewHolder viewHolder = new ActividadesViewHolder(itemView, mTapListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActividadesViewHolder holder, int position) {

        Log.e(TAG, "Agrego a las dependencias los archivos de mockup");
        ModeloActividades currentModel = mModelList.get(position);
        holder.tvName.setText(currentModel.getNombre());
        holder.tvDesc.setText(currentModel.getDescripcion());
        holder.ivCategory.setImageResource(
                ActividadesViewHelper.getResIdByCategory(currentModel.getCategory())
        );
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }
}
