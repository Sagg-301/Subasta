package com.ids.appsubasta.subasta.Interfaz;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by Sergio on 30/6/2017.
 */

public class Foto extends RealmObject implements Parcelable{
    private byte[] data;

    public Foto() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    //-----------------------------------------------------------

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeByteArray(data);
    }

    public static final Parcelable.Creator<Foto> CREATOR
            = new Parcelable.Creator<Foto>() {
        public Foto createFromParcel(Parcel in) {
            return new Foto(in);
        }

        public Foto[] newArray(int size) {
            return new Foto[size];
        }
    };

    private Foto(Parcel in) {
        in.readByteArray(data);
    }
}
