package com.ids.appsubasta.subasta.Fase;

import com.ids.appsubasta.subasta.Subasta;

/**
 * Created by Sergio on 23/6/2017.
 */

public class EnCurso implements Fase {
    @Override
    public void cambiarFase(Subasta subasta) {
        subasta.setFase(this);
    }
}
