package com.example.scheactim.adaptadores.adaptadoresFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scheactim.Entidades.Semanas;
import com.example.scheactim.R;

import java.util.ArrayList;

public class AdapterSemana extends RecyclerView.Adapter<AdapterSemana.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    ArrayList<Semanas> model;

    private View.OnClickListener listener;

    public AdapterSemana(Context context, ArrayList<Semanas> model) {
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_semanal_actividades, parent, false);
        view.setOnClickListener(this);
        return new AdapterSemana.ViewHolder(view);
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String Semana1 = model.get(position).getSemanas();
        int Logo_semana1 = model.get(position).getId_presentacion();

        holder.Semana.setText(Semana1);
        holder.Logo_semana.setImageResource(Logo_semana1);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Semana;
        ImageView Logo_semana;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            Semana = itemView.findViewById(R.id.tv_fecha_semanal);

            Logo_semana = itemView.findViewById(R.id.Logo_principal);
        }
    }

}
