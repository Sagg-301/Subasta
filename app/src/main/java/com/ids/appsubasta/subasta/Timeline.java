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

public class Timeline extends AppCompatActivity {
    private List<Bienes> bienes;
    private RecyclerView bienestimeline;
    private Adaptador adaptador;
    private Button boton;
    private CrearSubastaActivity crearSubastaActivity;
    int[] imagen = {R.drawable.iphonee, R.drawable.gorra, R.drawable.internet};

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
        bienes.add(new Bienes(imagen[1],"iPhone 7","Telefono movil con 256 GB de memoria. Auriculares, cargador y forro","500"));
        bienes.add(new Bienes(imagen[2],"Collar","Collar de perlas, 8mm y 170cm de longitud","350"));
    }

    public void inicializaAdaptador(){
        adaptador = new Adaptador (bienes,this);
        bienestimeline.setAdapter(adaptador);
        boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override /*Este boton es el signo mas que esta en la ventana TimeLine, al darle click me lleva a crear subasta*/
            public void onClick(View v) {
                CrearSubastaActivity crearSubastaActivity = new CrearSubastaActivity(bienes);
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