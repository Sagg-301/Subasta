package com.ids.appsubasta.subasta.Fase;

import android.content.Context;
import android.content.Intent;

import com.ids.appsubasta.subasta.Activities.verLotes;
import com.ids.appsubasta.subasta.Subasta;

/**
 * Created by Sergio on 23/6/2017.
 */

public class EnCurso implements Fase {
    @Override
    public void cambiarFase(Subasta subasta) {
        subasta.setFase(this);
        subasta.setFaseS("EnCurso");
    }

    @Override
    public void verSubasta(String idusuario, String idSubasta, Context ctx) {
        Intent intent = new Intent (ctx,verLotes.class);
        intent.putExtra("EXTRA_ID_SUBASTA",idSubasta);
        //PassData-------------------------------
        intent.putExtra("EXTRA_USUARIO",idusuario);
        //---------------------------------------
        ctx.startActivity(intent);
    }
}
