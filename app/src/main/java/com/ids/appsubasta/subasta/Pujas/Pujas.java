package com.ids.appsubasta.subasta.Pujas;

import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.Usuario.Usuario;


/**
 * Created by Sergio on 14/6/2017.
 */

public class Pujas {
    private Monedas valor;
    private String idPostor, Cedula;


    public Pujas() {
    }

    public Pujas(Monedas valor, String idPostor) {
        this.valor = valor;
        this.idPostor = idPostor;
    }



}
