package com.ids.appsubasta.subasta.Fase;

import com.ids.appsubasta.subasta.Subasta;

/**
 * Created by Sergio on 14/6/2017.
 */

public class Publicidad implements Fase {
    @Override
    public void cambiarFase(Subasta subasta) {
        subasta.setFase(this);
    }
}
