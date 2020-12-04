package com.example.scheactim.adaptadores.adaptadoresFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scheactim.Entidades.VerActivades;
import com.example.scheactim.R;

import java.util.ArrayList;


public class AdapterVerActivades extends RecyclerView.Adapter<AdapterVerActivades.ViewHolder> implements View.OnClickListener{

    LayoutInflater inflater;
    ArrayList<VerActivades> model;

    private View.OnClickListener listener;

    public AdapterVerActivades(Context context, ArrayList<VerActivades> model) {
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }


    @NonNull
    @Override
    public AdapterVerActivades.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_ver_actividades, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVerActivades.ViewHolder holder, int position) {
        String titulo = model.get(position).getTitulo();
        String descripcion = model.get(position).getDescripcion();
        String tv_categoria = model.get(position).getCategoria();
        String fecha_inicio = model.get(position).getFecha_inicio();
        String fecha_fin = model.get(position).getFecha_fin();
        int id_imagen = model.get(position).getId_imagen();

        holder.titulo.setText(titulo);
        holder.tv_desc.setText(descripcion);
        holder.tv_categoria.setText(tv_categoria);
        holder.fecha_inicio.setText(fecha_inicio);
        holder.fecha_fin.setText(fecha_fin);
        holder.imagen_actividad.setImageResource(id_imagen);
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
        TextView titulo, tv_desc, tv_categoria, fecha_inicio, fecha_fin;
        ImageView imagen_actividad;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.tv_titulo);
            tv_desc = itemView.findViewById(R.id.tv_descripcion);
            tv_categoria = itemView.findViewById(R.id.tv_categoria);
            fecha_inicio = itemView.findViewById(R.id.fecha_inicio);
            fecha_fin = itemView.findViewById(R.id.fecha_fin);
            imagen_actividad = itemView.findViewById(R.id.imagen_actividad);
        }
    }

}
