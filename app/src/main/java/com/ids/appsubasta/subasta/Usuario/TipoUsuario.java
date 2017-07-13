package com.ids.appsubasta.subasta.Usuario;

import android.content.Context;

import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.Subasta;

import io.realm.RealmObject;

/**
 * Created by Sergio on 14/6/2017.
 */

public interface TipoUsuario{
     public void cambiarTipoDeUsuario(Usuario u);
     public void cambiarFase(Subasta subasta, Fase fase);
     public boolean realizarPuja(Monedas valor, Subasta subasta);
     public void verLote(String idUsuario, Context ctx, Subasta subasta);
}
