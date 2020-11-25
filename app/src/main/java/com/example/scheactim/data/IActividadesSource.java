package com.example.scheactim.data;

import com.example.scheactim.modelos.ModeloActividades;

import java.util.List;

public interface IActividadesSource {
    public interface Categories {
        public static final String TAREA_PEN = "pendiente";
        public static final String TAREA_FIN = "finalizado";
        public static final String TAREA_RET = "retrasado";

    }

    List<ModeloActividades> getAll(int count);
}
