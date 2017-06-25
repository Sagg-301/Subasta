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
/*
public class Martillero implements TipoUsuario {
    private RealmResults<Subasta> subasta;
    private Realm realm;

    public Martillero() {
        realm = Realm.getDefaultInstance();
    }


    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
        subasta= realm.where(Subasta.class).equalTo("id",u.getId()).findAll();
    }

    @Override
    public void cambiarFase(String idSubasta, Fase fase){
        for (Subasta s:
             subasta) {
            if (s.getId() == idSubasta){
                fase.cambiarFase(s);
            }
        }
    }
}*/
