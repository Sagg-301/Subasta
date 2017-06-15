package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Cartera.Cartera;
import com.ids.appsubasta.subasta.Subasta;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String id;
    private Cartera cartera;
    private Subasta subasta;
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getId() {
        return id;
    }

    public Cartera getCartera() {
        return cartera;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCartera(Cartera cartera) {
        this.cartera = cartera;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void actualizar(Subasta subasta){
        this.subasta = subasta;
    }


}
