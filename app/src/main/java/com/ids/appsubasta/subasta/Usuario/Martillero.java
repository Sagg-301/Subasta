package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Subasta;

import java.util.ArrayList;

import io.realm.RealmList;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Martillero implements TipoUsuario {
    private ArrayList<Subasta> subasta;

    public Martillero() {
    }

    public ArrayList<Subasta> getSubasta() {
        return subasta;
    }

    public void setSubasta(ArrayList<Subasta> subasta) {
        this.subasta = subasta;
    }

    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
    }

    public void cambiarFase(Subasta subasta){

    }
}
