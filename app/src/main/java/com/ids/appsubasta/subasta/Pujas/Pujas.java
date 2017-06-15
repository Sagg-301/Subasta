package com.ids.appsubasta.subasta.Pujas;

import com.ids.appsubasta.subasta.Cartera.Monedas;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Pujas {
    private Monedas valor;
    private String idPostor;

    public Pujas() {
    }

    public Pujas(Monedas valor, String idPostor) {
        this.valor = valor;
        this.idPostor = idPostor;
    }
}
