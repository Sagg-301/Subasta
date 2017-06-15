package com.ids.appsubasta.subasta.Bien;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Bienes {

    private String nombre;
    private String descripcion;
    private String identificacion;
    private int foto;

    public Bienes (String nombre, String descripcion, String identificacion, int foto){
        this.nombre= nombre;
        this.descripcion= descripcion;
        this.identificacion= identificacion;
        this.foto= foto;
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
