package com.ids.appsubasta.subasta;

import android.content.Intent;
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
        bienes.add(new Bienes("iPhone 7","Telefono movil con 256GB de memoria","Monto: 500", "Finaliza el: 20/07/2017", "En curso"));
        bienes.add(new Bienes("Camisa","Camisa del Real Madrid","Monto: 300", "Finaliza el: 25/07/2017", "En curso"));
        bienes.add(new Bienes("Camisa","Camisa del Caracas Futbol club", "Monto: 185", "Finaliza el: 30/07/2017", "En curso"));
        bienes.add(new Bienes("Balon","Balon de futbol del Manchester United", "Monto: 500", "Finaliza el: 26/06/2017", "En curso"));
        bienes.add(new Bienes("Computadora","Mac con 16gb de ram, Intel Core i7", "Monto: 200", "Finaliza el: 29/07/2017", "En curso"));
    }
    public void inicializaAdaptador(){
        adaptador = new Adaptador (bienes);
        bienestimeline.setAdapter(adaptador);
        boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CrearSubastaActivity.class);
                startActivity(intent);
            }
        });
    }


}
