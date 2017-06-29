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

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Usuario on 27/06/2017.
 */

public class HistorialPujas extends AppCompatActivity {
    private RecyclerView pujastimeline;
    private AdaptadorPujas adaptador;
    private Button boton;
    private Realm realm;
    private CrearSubastaActivity crearSubastaActivity;
    private List<Pujas> pujas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        setContentView(R.layout.activity_timeline);
        pujastimeline = (RecyclerView) findViewById(R.id.beta2);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        pujastimeline.setLayoutManager(lim);
        data();
        inicializaAdaptador();
    }

    public void data(){}

    public void inicializaAdaptador(){
        adaptador = new AdaptadorPujas (pujas,this);
        pujastimeline.setAdapter(adaptador);
        boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override /*Este boton es el signo mas que esta en la ventana TimeLine, al darle click me lleva a crear subasta*/
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),verLotes.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        adaptador.notifyDataSetChanged();
    }
}
