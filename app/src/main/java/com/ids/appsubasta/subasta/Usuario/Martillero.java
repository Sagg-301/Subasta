package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Subasta;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Martillero extends TipoUsuario {
    private Realm realm;

    public Martillero() {
        realm = Realm.getDefaultInstance();
    }


    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
        u.setTipoUsuarioS("martillero");
    }


    public void cambiarFase(Subasta subasta, Fase fase){
        fase.cambiarFase(subasta);
    }
}
