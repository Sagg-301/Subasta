package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.CreacionSubasta.CrearSubastaActivity;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class Timeline extends AppCompatActivity {
    private RealmResults<Bienes> bienes;
    private RecyclerView bienestimeline;
    private Adaptador adaptador;
    private Button boton;
    private Realm realm;
    private CrearSubastaActivity crearSubastaActivity;
    int[] imagen = {R.drawable.iphonee, R.drawable.gorra, R.drawable.internet};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        setContentView(R.layout.activity_timeline);
        bienestimeline = (RecyclerView) findViewById(R.id.beta);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        bienestimeline.setLayoutManager(lim);
        data();
        inicializaAdaptador();
    }

    public void data(){
        bienes = realm.where(Bienes.class).findAll();
    }

    public void inicializaAdaptador(){
        adaptador = new Adaptador (bienes,this);
        bienestimeline.setAdapter(adaptador);
        boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override /*Este boton es el signo mas que esta en la ventana TimeLine, al darle click me lleva a crear subasta*/
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CrearSubastaActivity.class);
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