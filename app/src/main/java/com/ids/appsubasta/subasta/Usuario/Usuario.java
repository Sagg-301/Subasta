package com.ids.appsubasta.subasta.Usuario;

import android.widget.ImageView;

import com.ids.appsubasta.subasta.Ban.TipoBan;
import com.ids.appsubasta.subasta.Cartera.Cartera;
import com.ids.appsubasta.subasta.Subasta;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Usuario extends RealmObject{                   //Observador
    private String nombre;
    private String apellido;
    private String telefono;
    private String contraseña;
    private String tipoUsuarioS;
    private RealmList<Subasta> subastasPropias;
    @PrimaryKey
    private String nombreUsuario;
    private String email;
    @Ignore
    private Cartera cartera;
    @Ignore
    private Subasta subastaObservable;                                //Sujeto a Observar
    @Ignore
    private TipoUsuario tipoUsuario;
    @Ignore
    private TipoBan ban;


    public Usuario() {
        tipoUsuario = null;
    }

    public Usuario(String nombre, String apellido, String telefono, String contraseña, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
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

    public String getEmail() {
        return email;
    }

    public Cartera getCartera() {
        return cartera;
    }

    public Subasta getSubastaObservable() {
        return subastaObservable;
    }

    public TipoBan getBan() {
        return ban;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public String getTipoUsuarioS() {
        return tipoUsuarioS;
    }

    public RealmList<Subasta> getSubastasPropias() {
        return subastasPropias;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCartera(Cartera cartera) {
        this.cartera = cartera;
    }

    public void setSubastaObservable(Subasta subastaObservable) {
        this.subastaObservable = subastaObservable;
    }

    public void setBan(TipoBan ban) {
        this.ban = ban;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setTipoUsuarioS(String tipoUsuarioS) {
        this.tipoUsuarioS = tipoUsuarioS;
    }

    public void setSubastasPropias(RealmList<Subasta> subastasPropias) {
        this.subastasPropias = subastasPropias;
    }

    //Terminan Getter y Setters------------------------------------------------------------

    public void actualizar(Subasta subasta){            //Metodo Update de clase observadora
        this.subastaObservable = subasta;
    }


    public String generarIdSubasta(){
        String idSubasta;
        int cantidadSubasta;
        cantidadSubasta = subastasPropias.size();
        idSubasta = this.nombreUsuario + Integer.toString(cantidadSubasta);
        return idSubasta;
    }

    public String generarIdBienes(){
        String idSubasta;
        int cantidadSubasta;
        cantidadSubasta = subastasPropias.size();
        idSubasta = this.nombreUsuario + Integer.toString(cantidadSubasta);
        return idSubasta;
    }

    public void initTipoUsuario(){
        if (this.tipoUsuarioS.equals("martillero")){
            TipoUsuario x = new Martillero();
            this.tipoUsuario=x;
        }
        else if (this.tipoUsuarioS.equals("postor")){
            TipoUsuario x = new Postor();
            this.tipoUsuario=x;
        }
        else if (this.tipoUsuarioS.equals("vendedor")){
            TipoUsuario x = new Vendedor();
            this.tipoUsuario=x;
        }
    }

}
