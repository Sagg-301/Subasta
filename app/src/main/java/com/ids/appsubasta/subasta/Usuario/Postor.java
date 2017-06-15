package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.Pujas.Pujas;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Postor implements TipoUsuario {
    private String id;

    public Postor() {
    }

    public Postor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
    }

    public Pujas realizarPuja(Monedas valor) {
        Pujas puja = new Pujas(valor,this.id);
        return puja;
    }
}
