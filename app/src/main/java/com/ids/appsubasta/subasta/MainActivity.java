package com.ids.appsubasta.subasta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ids.appsubasta.subasta.Bien.Bienes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bienes> bienes;
    private RecyclerView bienestimeline;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bienestimeline = (RecyclerView) findViewById(R.id.beta);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        bienestimeline.setLayoutManager(lim);

        data();
        inicializaAdaptador();
    }

    public void data(){
        bienes = new ArrayList<>();
        bienes.add(new Bienes("Camisa","Camisa del club Barcelona", "12345",23));
        bienes.add(new Bienes("Camisa","Camisa del Real Madrid", "1234",24));
        bienes.add(new Bienes("Camisa","Camisa del Caracas Futbol club", "123",25));
        bienes.add(new Bienes("Camisa","Camisa de los Leones del Caracas", "123456",26));
        bienes.add(new Bienes("Camisa","Camisa del logo de iPhone", "12",27));
        bienes.add(new Bienes("Camisa","Camisa Nike", "123459",28));
    }
    public void inicializaAdaptador(){
        adaptador = new Adaptador (bienes);
        bienestimeline.setAdapter(adaptador);
    }
}
