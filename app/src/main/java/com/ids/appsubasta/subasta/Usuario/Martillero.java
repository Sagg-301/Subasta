package com.ids.appsubasta.subasta.Usuario;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Martillero implements TipoUsuario {

    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
    }
}
