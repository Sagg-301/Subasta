package com.ids.appsubasta.subasta.Bien;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Bienes {

    private String nombre;
    private String descripcion;
    private String identificacion;
    private String monto;
    private int foto;


    public Bienes (int foto, String nombre, String descripcion, String monto){
        this.nombre= nombre;
        this.descripcion= descripcion;
        this.monto = monto;
        this.setFoto(foto);
    }


    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
