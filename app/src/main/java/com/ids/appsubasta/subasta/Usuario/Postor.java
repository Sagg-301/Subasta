package com.ids.appsubasta.subasta.Usuario;

import android.content.Context;
import android.content.Intent;

import com.ids.appsubasta.subasta.Bien.verLotes;
import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.Subasta;

import java.util.Date;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Postor implements TipoUsuario {
    private String id;

    public Postor() {
    }

    public Postor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void cambiarTipoDeUsuario(Usuario u) {
        u.setTipoUsuario(this);
        u.setTipoUsuarioS("postor");
    }

    @Override
    public void cambiarFase(Subasta subasta, Fase fase) {
        //Postor no tiene permitido cambiar fase
    }

    @Override
    public void verLote(String idUsuario, String idSubasta, Context ctx) {
        Intent intent = new Intent (ctx,verLotes.class);
        intent.putExtra("EXTRA_ID_SUBASTA",idSubasta);
        //PassData-------------------------------
        intent.putExtra("EXTRA_USUARIO",idUsuario);
        //---------------------------------------
        ctx.startActivity(intent);
    }

    public boolean realizarPuja(Monedas valor, Subasta subasta) {
        Date fecha = new Date();
        Pujas puja = new Pujas(valor,this.id, fecha);
        return subasta.recibirPuja(puja);
    }
}
