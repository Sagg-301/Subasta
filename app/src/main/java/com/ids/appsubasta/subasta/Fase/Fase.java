package com.ids.appsubasta.subasta.Fase;

import android.content.Context;

import com.ids.appsubasta.subasta.Subasta;

/**
 * Created by Sergio on 23/6/2017.
 */

public interface Fase {
    void cambiarFase(Subasta subasta);
    void verSubasta(String idusuario, String idSubasta, Context ctx);
}
