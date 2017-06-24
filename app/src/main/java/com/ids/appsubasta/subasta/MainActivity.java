package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Bien.verLotes;
import com.ids.appsubasta.subasta.CreacionSubasta.CrearSubastaActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bienes> bienes;
    private RecyclerView bienestimeline;
    private Adaptador adaptador;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        bienestimeline = (RecyclerView) findViewById(R.id.beta);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        bienestimeline.setLayoutManager(lim);

        data();
        inicializaAdaptador();
    }

    public void data(){
        bienes = new ArrayList<>();
        /*bienes.add(new Bienes("iPhone 7","Telefono movil con 256 GB de memoria. Auriculares, cargador y forro","500", "20/07/2017", "En curso"));
        bienes.add(new Bienes("Collar","Collar de perlas","300", "25/07/2017", "En curso"));
        bienes.add(new Bienes("Camisa","Camisa del Caracas Futbol club", "185", "30/07/2017", "En curso"));
        bienes.add(new Bienes("Balon","Balon de futbol del Manchester United", "500", "26/06/2017", "En curso"));
        bienes.add(new Bienes("Mac","16gb de ram, Intel Core i7", "200", "Finaliza el: 29/07/2017", "En curso"));*/
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


}
