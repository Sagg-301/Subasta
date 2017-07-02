package com.ids.appsubasta.subasta.Pujas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.ids.appsubasta.subasta.Adaptador;
import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Bien.verLotes;
import com.ids.appsubasta.subasta.CreacionSubasta.CrearSubastaActivity;
import com.ids.appsubasta.subasta.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class HistorialPujas extends AppCompatActivity {
    private RecyclerView pujastimeline;
    private AdaptadorPujas adaptador;
    private Button boton;
    private Realm realm;
    private CrearSubastaActivity crearSubastaActivity;
    private RealmResults<Bienes> pujas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        setContentView(R.layout.activity_historialpujas);
        pujastimeline = (RecyclerView) findViewById(R.id.beta2);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        pujastimeline.setLayoutManager(lim);
        data();
        inicializaAdaptador();
    }

    public void data(){
       // pujas = realm.where(Pujas.class).findAll();
        /* Aqui tienes que agregar todas las pujas que se fueron hechas en la subasta */

    }

    public void inicializaAdaptador(){ //Iniciamos el beta
       // adaptador = new AdaptadorPujas (pujas,this);
        pujastimeline.setAdapter(adaptador);
    }

    @Override
    public void onResume() { /*Actualizamos la pantalla cada vez que se llama a esta clase*/
        super.onResume();
        adaptador.notifyDataSetChanged();
    }
}