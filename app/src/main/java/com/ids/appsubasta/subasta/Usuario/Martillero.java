package com.ids.appsubasta.subasta.Usuario;

import android.content.Context;
import android.content.Intent;

import com.ids.appsubasta.subasta.Bien.verLotes;
import com.ids.appsubasta.subasta.Bien.verLotesMartillero;
import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Subasta;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Martillero implements TipoUsuario {
    private Realm realm;

    public Martillero() {
        realm = Realm.getDefaultInstance();
    }


    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
        u.setTipoUsuarioS("martillero");
    }

    @Override
    public void cambiarFase(Subasta subasta, Fase fase){
        fase.cambiarFase(subasta);
    }

    @Override
    public boolean realizarPuja(Monedas valor, Subasta subasta) {
            return false;
    }

    @Override
    public void verLote(String idUsuario, String idSubasta, Context ctx) {
        Intent intent = new Intent (ctx,verLotesMartillero.class);
        intent.putExtra("EXTRA_ID_SUBASTA",idSubasta);
        //PassData-------------------------------
        intent.putExtra("EXTRA_USUARIO",idUsuario);
        //---------------------------------------
        ctx.startActivity(intent);
    }
}
