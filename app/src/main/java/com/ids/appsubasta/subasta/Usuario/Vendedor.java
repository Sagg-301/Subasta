package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Usuario.TipoUsuario;

import io.realm.RealmObject;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Vendedor extends TipoUsuario {
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

    public void cambiarFase(String idSubasta, Fase fase) {
        //Vendedor no tiene permitido cambiar fase
    }
}
