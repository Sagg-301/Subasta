package com.ids.appsubasta.subasta.Bien;

import com.ids.appsubasta.subasta.Interfaz.Foto;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Bienes extends RealmObject {

    private String nombre;
    private String descripcion;
    @PrimaryKey
    private String identificacion;
    private String monto;
    private int foto;
    private RealmList<Foto> fotos;

    public Bienes() {
    }

    public Bienes (int foto, String nombre, String descripcion, String monto){
        this.nombre= nombre;
        this.descripcion= descripcion;
        this.monto = monto;
        this.setFoto(foto);
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

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public RealmList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(RealmList<Foto> fotos) {
        this.fotos = fotos;
    }

    //-----------------------------------------------------

    public void addFotos(Foto fotos){
        this.fotos.add(fotos);
    }
}
