package com.ids.appsubasta.subasta.Usuario;

import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Pujas.Pujas;

import io.realm.RealmObject;

/**
 * Created by Sergio on 14/6/2017.
 */

public abstract class TipoUsuario{
     public void cambiarTipoDeUsuario(Usuario u){};
     public void cambiarFase(){};
}
