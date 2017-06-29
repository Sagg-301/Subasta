package com.ids.appsubasta.subasta.Pujas;

import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;


public class Pujas {
    private Monedas valor;
    private String idPostor, Cedula, fecha;

    public Pujas() {
    }

    public Pujas(Monedas valor, String idPostor) {
        this.valor = valor;
        this.idPostor = idPostor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Monedas getValor() {
        return valor;
    }

    public void setValor(Monedas valor) {
        this.valor = valor;
    }

    public String getIdPostor() {
        return idPostor;
    }

    public void setIdPostor(String idPostor) {
        this.idPostor = idPostor;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

}
