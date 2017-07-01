package com.ids.appsubasta.subasta;

import android.widget.ImageView;

import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Fase.EnCurso;
import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.Usuario.Usuario;
import java.util.ArrayList;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

import static android.R.attr.max;


public class Subasta extends RealmObject{
    @PrimaryKey
    private String Id;
    private Usuario martillero;
    @Ignore
    private Fase fase;
    private RealmList<Bienes> bienes;
    @Ignore
    private RealmList<Usuario> usuarios;
    @Ignore
    private ArrayList<Pujas> pujas;

    public Subasta() {
    }
    public Subasta(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public ArrayList<Pujas> getPujas() {
        return pujas;
    }

    public RealmList<Bienes> getBienes() {
        return bienes;
    }

    public Usuario getMartillero() {
        return martillero;
    }

    public RealmList<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setId(String id) {
        Id = id;
    }

    public void setPujas(ArrayList<Pujas> pujas) {
        this.pujas = pujas;
    }

    public void setBienes(RealmList<Bienes> bienes) {
        this.bienes = bienes;
    }

    public void setMartillero(Usuario martillero) {
        this.martillero = martillero;
    }

    public void setUsuarios(RealmList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    //-----------------------------------------------------------------------------------

    public void notificar(){
        for (Usuario u: usuarios){
            u.actualizar(this);
        }
    }

    public void adscribirUsuario(Usuario u){
        usuarios.add(u);
    }

    public void quitarUsuario(Usuario u){
        usuarios.remove(u);
    }

    public void recibirPuja(Pujas puja){
        pujas.add(puja);
    }

    public void addBien(Bienes bien){
        bienes.add(bien);
    }

    public Fase getFases() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public String generarIdBienes(){
        String idBienes;
        int cantidadBienes;
        cantidadBienes = this.bienes.size();
        idBienes = this.Id + Integer.toString(cantidadBienes);
        return idBienes;
    }

}
