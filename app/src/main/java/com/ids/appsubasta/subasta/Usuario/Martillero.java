package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Subasta;

import io.realm.RealmList;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Martillero implements TipoUsuario {
    private RealmList<Subasta> subasta;

    public Martillero() {
    }

    public RealmList<Subasta> getSubasta() {
        return subasta;
    }

    public void setSubasta(RealmList<Subasta> subasta) {
        this.subasta = subasta;
    }

    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
    }
}
