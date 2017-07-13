package com.ids.appsubasta.subasta.Pujas;

import android.os.Parcel;
import android.os.Parcelable;

import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.Interfaz.Foto;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmObject;


public class Pujas implements Parcelable{
    private Monedas valor;
    private String idPostor;
    private String fecha;

    public Pujas() {
    }

    public Pujas(Monedas valor, String idPostor, Date fecha) {
        this.valor = valor;
        this.idPostor = idPostor;
        this.fecha = fecha.toString();
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


    //------------------------------------------------------------------

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(idPostor);
        out.writeString(fecha);
        out.writeParcelable(valor,flags);
    }

    public static final Parcelable.Creator<Pujas> CREATOR
            = new Parcelable.Creator<Pujas>() {
        public Pujas createFromParcel(Parcel in) {
            return new Pujas(in);
        }

        public Pujas[] newArray(int size) {
            return new Pujas[size];
        }
    };

    private Pujas(Parcel in) {
        idPostor=in.readString();
        fecha=in.readString();
        valor = in.readParcelable(Monedas.class.getClassLoader());
    }

}
