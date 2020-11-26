package com.example.scheactim.adaptadores;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import  com.example.scheactim.R;
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

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_actividades, parent, false);
        ActividadesViewHolder viewHolder = new ActividadesViewHolder(itemView, mTapListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActividadesViewHolder holder, int position) {


        ModeloActividades currentModel = mModelList.get(position);
        holder.tvName.setText(currentModel.getNombre());
        holder.tvDesc.setText(currentModel.getDescripcion());
        /*holder.ivCategory.setImageResource(
                ActividadesViewHelper.getResIdByCategory(currentModel.getCategory())
        );*/
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }
}
