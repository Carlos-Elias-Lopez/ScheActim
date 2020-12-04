package com.example.scheactim.adaptadores.adaptadoresFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scheactim.Entidades.Dias;
import com.example.scheactim.Entidades.Semanas;
import com.example.scheactim.R;

import java.util.ArrayList;

public class AdapterDia extends RecyclerView.Adapter<AdapterDia.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    ArrayList<Dias> model;

    private View.OnClickListener listener;

    public AdapterDia(Context context, ArrayList<Dias> model) {
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_dias_actividades, parent, false);
        view.setOnClickListener(this);
        return new AdapterDia.ViewHolder(view);
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDia.ViewHolder holder, int position) {
        String dia = model.get(position).getDia();
        String descripcionDia = model.get(position).getDescripcionDia();
        int id_iconogrande = model.get(position).getId_iconogrande();

        holder.Dias.setText(dia);
        holder.descripciones.setText(descripcionDia);
        holder.Logo_dia.setImageResource(id_iconogrande);
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
        TextView Dias, descripciones;
        ImageView Logo_dia;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            Dias = itemView.findViewById(R.id.tv_dia);
            descripciones = itemView.findViewById(R.id.tv_descripcion_dia);
            Logo_dia = itemView.findViewById(R.id.Logo_principal_dia);
        }
    }

}
