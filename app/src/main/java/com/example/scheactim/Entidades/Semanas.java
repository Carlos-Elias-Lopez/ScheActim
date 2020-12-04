package com.example.scheactim.Entidades;

public class Semanas {
    private String Semanas;
    private int id_presentacion;

    public Semanas(String semanas, int id_presentacion) {
        this.Semanas = semanas;
        this.id_presentacion = id_presentacion;
    }


    public String getSemanas() {
        return Semanas;
    }

    public void setSemanas(String semanas) {
        Semanas = semanas;
    }

    public int getId_presentacion() {
        return id_presentacion;
    }

    public void setId_presentacion(int id_presentacion) {
        this.id_presentacion = id_presentacion;
    }


}
