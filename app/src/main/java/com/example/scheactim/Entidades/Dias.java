package com.example.scheactim.Entidades;

public class Dias {
    private String dia;
    private String descripcionDia;
    private int id_iconogrande;

    public Dias(String dia, String descripcionDia, int id_iconogrande) {
        this.dia = dia;
        this.descripcionDia = descripcionDia;
        this.id_iconogrande = id_iconogrande;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDescripcionDia() {
        return descripcionDia;
    }

    public void setDescripcionDia(String descripcionDia) {
        this.descripcionDia = descripcionDia;
    }

    public int getId_iconogrande() {
        return id_iconogrande;
    }

    public void setId_iconogrande(int id_iconogrande) {
        this.id_iconogrande = id_iconogrande;
    }




}
