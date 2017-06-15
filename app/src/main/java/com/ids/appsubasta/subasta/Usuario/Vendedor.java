package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Usuario.TipoUsuario;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Vendedor implements TipoUsuario {


    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
    }
}
