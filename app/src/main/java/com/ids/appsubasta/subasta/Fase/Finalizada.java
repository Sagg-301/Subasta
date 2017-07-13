package com.ids.appsubasta.subasta.Fase;

import android.content.Context;

import com.ids.appsubasta.subasta.Subasta;

/**
 * Created by Sergio on 23/6/2017.
 */

public class Finalizada implements Fase {
    @Override
    public void cambiarFase(Subasta subasta) {
        subasta.setFase(this);
    }

    @Override
    public void verSubasta(String idusuario, String idSubasta, Context ctx) {

    }
}
