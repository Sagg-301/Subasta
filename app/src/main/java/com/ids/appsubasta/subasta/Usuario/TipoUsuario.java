package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Pujas.Pujas;

/**
 * Created by Sergio on 14/6/2017.
 */

public interface TipoUsuario {
    public void cambiarTipoDeUsuario(Usuario u);
    public void cambiarFase(String idSubasta, Fase fase);
}
