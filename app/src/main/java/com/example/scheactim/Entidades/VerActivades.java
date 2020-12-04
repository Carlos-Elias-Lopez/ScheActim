package com.example.scheactim.Entidades;

public class VerActivades {

    private String titulo;
    private String descripcion;
    private String categoria;
    private String fecha_inicio;
    private String fecha_fin;
    private int id_imagen;

    public VerActivades(String titulo, String descripcion, String categoria, String fecha_inicio, String fecha_fin, int id_imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_imagen = id_imagen;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId_imagen() {
        return id_imagen;
    }

    public void setId_imagen(int id_imagen) {
        this.id_imagen = id_imagen;
    }








}
