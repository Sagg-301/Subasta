package com.ids.appsubasta.subasta.Ban;

import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.util.Date;

/**
 * Created by Sergio on 15/6/2017.
 */

public class NoPago implements TipoBan {
    private Date inicio;
    private Date fin;

    public NoPago() {
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Override
    public void cambiarBan(Usuario u) {
        u.setBan(this);
    }
}
