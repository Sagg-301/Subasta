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

public class Timeline extends AppCompatActivity implements Parcelable {
    private ArrayList<Bienes> bienes;
    private RecyclerView bienestimeline;
    private Adaptador adaptador;
    private Button boton;
    //ArrayList<Bienes> lista = new ArrayList<>();
    private List<Bienes> lista;
    private CrearSubastaActivity crearSubastaActivity;
    int[] imagen = {R.drawable.iphonee, R.drawable.gorra, R.drawable.internet, R.drawable.collar_perlas, R.drawable.camisa_realmadrid};

    public Timeline() {
    }

    protected Timeline(Parcel in) {
        imagen = in.createIntArray();
    }

    public static final Creator<Timeline> CREATOR = new Creator<Timeline>() {
        @Override
        public Timeline createFromParcel(Parcel in) {
            return new Timeline(in);
        }

        @Override
        public Timeline[] newArray(int size) {
            return new Timeline[size];
        }
    };

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
        bienes = new ArrayList<Bienes>();
        bienes.add(new Bienes(imagen[0],"iPhone 7","Telefono movil con 256 GB de memoria. Auriculares, cargador y forro","500"));
        bienes.add(new Bienes(imagen[3],"Collar","Collar de perlas, 8mm y 170cm de longitud","350"));
        bienes.add(new Bienes(imagen[1],"Gorra","Gorra de los Yankees de NY , color: rojo","300"));
        bienes.add(new Bienes(imagen[4],"Camisa","Camisa original del Real Madrid","300"));
    }

    public void inicializaAdaptador(){
        adaptador = new Adaptador (bienes,this);
        bienestimeline.setAdapter(adaptador);
        boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override /*Este boton es el signo mas que esta en la ventana TimeLine, al darle click me lleva a crear subasta*/
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),CrearSubastaActivity.class);
                //intent.putExtra("array", bienes);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        adaptador.notifyDataSetChanged();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(imagen);
    }
}