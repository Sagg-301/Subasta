package com.ids.appsubasta.subasta.Cartera;

import android.os.Parcel;
import android.os.Parcelable;

import com.ids.appsubasta.subasta.Pujas.Pujas;

/**
 * Created by Sergio on 24/6/2017.
 */

public class Monedas implements Parcelable {
    private int monto;

    public Monedas() {
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(monto);
    }

    public static final Parcelable.Creator<Monedas> CREATOR
            = new Parcelable.Creator<Monedas>() {
        public Monedas createFromParcel(Parcel in) {
            return new Monedas(in);
        }

        public Monedas[] newArray(int size) {
            return new Monedas[size];
        }
    };

    private Monedas(Parcel in) {
        monto=in.readInt();
    }
}
