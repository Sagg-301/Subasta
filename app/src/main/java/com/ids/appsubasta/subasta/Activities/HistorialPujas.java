package com.ids.appsubasta.subasta.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.R;

import java.util.ArrayList;

import io.realm.Realm;

public class HistorialPujas extends AppCompatActivity {
    private RecyclerView pujastimeline;
    private AdaptadorPujas adaptador;
    private Button boton;
    private Realm realm;
    private CrearSubastaActivity crearSubastaActivity;
    private ArrayList<Pujas> pujas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        setContentView(R.layout.activity_historialpujas);
        pujastimeline = (RecyclerView) findViewById(R.id.beta2);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        pujastimeline.setLayoutManager(lim);
        pujas = getIntent().getParcelableArrayListExtra("EXTRA_PUJAS");
        data();
        inicializaAdaptador();
    }

    public void data(){
        /* Aqui tienes que agregar todas las pujas que se fueron hechas en la subasta */
    }

    public void inicializaAdaptador(){ //Iniciamos el beta
        adaptador = new AdaptadorPujas (pujas,this);
        pujastimeline.setAdapter(adaptador);
    }

    @Override
    public void onResume() { /*Actualizamos la pantalla cada vez que se llama a esta clase*/
        super.onResume();
        adaptador.notifyDataSetChanged();
    }
}