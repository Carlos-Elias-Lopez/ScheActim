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
    private Date fecha_inicio;
    private Date fecha_fin;


    //GENERACION DE CONSTRUCTOR
    public ModeloActividades(String id, String nombre, String descripcion, boolean prioridad, Date fecha_inicio, Date fecha_fin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


    //GENERADO CON http://www.parcelabler.com/

    protected ModeloActividades(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        descripcion = in.readString();
        prioridad = in.readByte() != 0x00;
        long tmpFecha_inicio = in.readLong();
        fecha_inicio = tmpFecha_inicio != -1 ? new Date(tmpFecha_inicio) : null;
        long tmpFecha_fin = in.readLong();
        fecha_fin = tmpFecha_fin != -1 ? new Date(tmpFecha_fin) : null;
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
        dest.writeLong(fecha_inicio != null ? fecha_inicio.getTime() : -1L);
        dest.writeLong(fecha_fin != null ? fecha_fin.getTime() : -1L);
    }

    @SuppressWarnings("unused")
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

