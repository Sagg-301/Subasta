package com.ids.appsubasta.subasta;

import android.graphics.Bitmap;

import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Fase.Publicidad;
import com.ids.appsubasta.subasta.Interfaz.Foto;
import com.ids.appsubasta.subasta.Usuario.Martillero;
import com.ids.appsubasta.subasta.Usuario.TipoUsuario;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Sergio on 13/7/2017.
 */

public class RealmController {
    Realm realm;

    public RealmController() {
        realm = Realm.getDefaultInstance();
    }

    public RealmResults<Subasta> getAllSubastas(){
        return realm.where(Subasta.class).findAll();
    }

    public Subasta findSubasta(String idSubasta){
     return  realm.where(Subasta.class).equalTo("Id", idSubasta).findFirst();
    }

    public void addSubastaToRealm(Usuario usuario, String monto, String titulo, String descripcion,
                                  RealmList<Foto> fotos, Date fechaInicial, Date fechaFinal){
        realm.beginTransaction();
        RealmList<Foto> newFotos = new RealmList<Foto>();
        for (Foto x: fotos) {
            Foto f = realm.createObject(Foto.class);
            f.setData(x.getData());
            newFotos.add(f);
        }
        Subasta subasta = realm.createObject(Subasta.class,usuario.generarIdSubasta());
        Bienes bien = realm.createObject(Bienes.class, subasta.generarIdBienes());
        realm.copyToRealm(fotos);
        bien.setMonto(monto);
        bien.setNombre(titulo);
        bien.setDescripcion(descripcion);
        bien.setFotos(newFotos);
        subasta.addBien(bien);
        subasta.setFechaInicial(fechaInicial);
        subasta.setFechaFinal(fechaFinal);
        usuario.addSubasta(subasta);
        realm.commitTransaction();
    }

    public void addUsuarioToRealm(String usuario, String nombre, String apellido, String contrasena,
                                  String email, String telefono, Foto foto){
                realm.beginTransaction();
                Foto f =realm.createObject(Foto.class);
                f.setData(foto.getData());
                Usuario u = realm.createObject(Usuario.class, usuario);
                u.setNombre(nombre);
                u.setApellido(apellido);
                u.setContraseña(contrasena);
                u.setEmail(email);
                u.setTelefono(telefono);
                u.setFotoPerfil(f);
                realm.commitTransaction();

    }

    public Usuario findUsuario(String nombreUsuario){
        return realm.where(Usuario.class).equalTo("nombreUsuario",nombreUsuario).findFirst();
    }

    public void changeTipoUsuario(Usuario usuario, TipoUsuario tipoUsuario){
        realm.beginTransaction();
        tipoUsuario.cambiarTipoDeUsuario(usuario);
        realm.copyToRealmOrUpdate(usuario);
        realm.commitTransaction();
    }

    public void changeFase(Subasta subasta, Fase f){
        realm.beginTransaction();
        f.cambiarFase(subasta);
        realm.copyToRealmOrUpdate(subasta);
        realm.commitTransaction();
    }
}
