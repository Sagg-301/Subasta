package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Ban.TipoBan;
import com.ids.appsubasta.subasta.Cartera.Cartera;
import com.ids.appsubasta.subasta.Subasta;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Usuario extends RealmObject{                   //Observador
    private String nombre;
    private String apellido;
    private String telefono;
    @PrimaryKey
    private String id;
    @Ignore
    private Cartera cartera;
    @Ignore
    private Subasta subasta;                                //Sujeto a Observar
    @Ignore
    private TipoUsuario tipoUsuario;
    @Ignore
    private TipoBan ban;

    public Usuario() {
        tipoUsuario = null;
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

    public Subasta getSubasta() {
        return subasta;
    }

    public TipoBan getBan() {
        return ban;
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

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public void setBan(TipoBan ban) {
        this.ban = ban;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void actualizar(Subasta subasta){            //Metodo Update de clase observadora
        this.subasta = subasta;
    }


}
