package com.ids.appsubasta.subasta;

import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Interfaz.Interfaz;
import com.ids.appsubasta.subasta.Multimedia.Multimedia;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Subasta extends RealmObject {
    private Interfaz interfaz;
    private ArrayList<Multimedia> multimedia;
    private Fase fase;
    private Usuario martillero;
    private RealmList<Usuario> usuarios;
    private ArrayList<Pujas> pujas;

    public Subasta() {
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public ArrayList<Multimedia> getMultimedia() {
        return multimedia;
    }

    public Fase getFase() {
        return fase;
    }

    public Usuario getMartillero() {
        return martillero;
    }

    public RealmList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setInterfaz(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    public void setMultimedia(ArrayList<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public void setMartillero(Usuario martillero) {
        this.martillero = martillero;
    }

    public void setUsuarios(RealmList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void notificar(){
        for (Usuario u: usuarios){
            u.actualizar(this);
        }
    }

    public void adscribir(Usuario u){
        usuarios.add(u);
    }

    public void quitar(Usuario u){
        usuarios.remove(u);
    }

    public void recibirPuja(Pujas puja){
        pujas.add(puja);
    }

}
