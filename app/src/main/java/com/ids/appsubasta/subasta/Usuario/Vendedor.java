package com.ids.appsubasta.subasta.Usuario;

import android.content.Context;

import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Usuario.TipoUsuario;

import io.realm.RealmObject;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Vendedor implements TipoUsuario {
    private Subasta subasta;


    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
        u.setTipoUsuarioS("vendedor");
    }

    @Override
    public void cambiarFase(Subasta subasta, Fase fase) {
        //Vendedor no tiene permitido cambiar fase
    }

    @Override
    public boolean realizarPuja(Monedas valor, Subasta subasta) {
        return false;
    }

    @Override
    public void verLote(String idUsuario, Context ctx, Subasta subasta) {

    }
}
