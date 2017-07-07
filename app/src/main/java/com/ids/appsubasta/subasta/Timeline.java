package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.CreacionSubasta.CrearSubastaActivity;
import com.ids.appsubasta.subasta.CreacionSubasta.SubastaCreada;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class Timeline extends AppCompatActivity {
    private RealmResults<Subasta> subastas;
    private RecyclerView bienestimeline;
    private NavigationView nav;
    private Adaptador adaptador;
    private Button boton;
    private Usuario usuario;
    private Realm realm;
    private CrearSubastaActivity crearSubastaActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        setContentView(R.layout.activity_timeline);
       nav = (NavigationView) findViewById(R.id.Nav_View);
        bienestimeline = (RecyclerView) findViewById(R.id.beta);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        bienestimeline.setLayoutManager(lim);
        data();
        //--------------------------
        usuario = realm.where(Usuario.class).equalTo("nombreUsuario",getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();
        usuario.initTipoUsuario();
        //--------------------------
        inicializaAdaptador();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mi_cuenta:
                        Intent intent = new Intent(Timeline.this, SubastaCreada.class);
                        startActivity(intent);
                        return true;
                    case R.id.settings:
                        Intent settings = new Intent(Timeline.this, ConfiguracionActivity.class);
                        settings.putExtra("EXTRA_USUARIO", usuario.getNombreUsuario());
                        startActivity(settings);
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

    public void data(){
        subastas = realm.where(Subasta.class).findAll();
    }

    public void inicializaAdaptador(){
        adaptador = new Adaptador (usuario,subastas,this);
        bienestimeline.setAdapter(adaptador);
        boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override /*Este boton es el signo mas que esta en la ventana TimeLine, al darle click me lleva a crear subasta*/
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CrearSubastaActivity.class);
                intent.putExtra("EXTRA_USUARIO",usuario.getNombreUsuario());
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