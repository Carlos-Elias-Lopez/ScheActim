package com.example.scheactim.modelos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Locale;
public class ModeloActividades implements Parcelable{

    //DECLARACION DE ATRIBUTOS
    private String id;
    private String nombre;
    private String descripcion;
    private boolean prioridad;
    private String category;
    private String fecha_inicio;
    private String fecha_fin;


    //GENERACION DE CONSTRUCTOR
    public ModeloActividades(String id, String nombre, String descripcion, String category) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.category = category;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    //ENCASULAMIENTO DE ATRIBUTOS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFecha_inicio(String fecha_inicio) {
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin(String fecha_fin) {
        return fecha_fin;
    }
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


    //GENERADO CON http://www.parcelabler.com/

    protected ModeloActividades(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        descripcion = in.readString();
        prioridad = in.readByte() != 0x00;
        category = in.readString();
        long tmpFecha_inicio = in.readLong();
        fecha_inicio = in.readString();
        long tmpFecha_fin = in.readLong();
        fecha_fin = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeByte((byte) (prioridad ? 0x01 : 0x00));
        dest.writeString(category);
        dest.writeString(fecha_inicio);
        dest.writeString(fecha_fin );
    }


    public static final Parcelable.Creator<ModeloActividades> CREATOR = new Parcelable.Creator<ModeloActividades>() {
        @Override
        public ModeloActividades createFromParcel(Parcel in) {
            return new ModeloActividades(in);
        }

        @Override
        public ModeloActividades[] newArray(int size) {
            return new ModeloActividades[size];
        }
    };
}

