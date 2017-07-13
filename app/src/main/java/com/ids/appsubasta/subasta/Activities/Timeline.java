package com.ids.appsubasta.subasta.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.RealmController;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import io.realm.Realm;
import io.realm.RealmResults;

public class Timeline extends AppCompatActivity {
    private RealmResults<Subasta> subastas;
    private RecyclerView bienestimeline;
    private NavigationView nav;
    private Adaptador adaptador;
    private Button boton;
    private Usuario usuario;
    private RealmController rc;
    private CrearSubastaActivity crearSubastaActivity;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        nav = (NavigationView) findViewById(R.id.Nav_View);
        bienestimeline = (RecyclerView) findViewById(R.id.beta);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        bienestimeline.setLayoutManager(lim);
        rc = new RealmController();
        data();
        //--------------------------
        usuario = rc.findUsuario(getIntent().getStringExtra("EXTRA_USUARIO"));
        usuario.initTipoUsuario();
        //--------------------------
        //Manejar Preferencias----------------------------------------------------------------------
        pref = this.getSharedPreferences("PreferenciasSubasta", Context.MODE_PRIVATE);
        String nombreUsuario = pref.getString("PREF_NOMBRE","NULL");
        if (nombreUsuario=="NULL"){
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("PREF_NOMBRE", usuario.getNombreUsuario());
            editor.putString("PREF_PASSWORD", usuario.getContraseña());
            editor.commit();
        }
        //------------------------------------------------------------------------------------------
        inicializaAdaptador();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mi_cuenta:
                        Intent intent = new Intent(Timeline.this, MiCuenta.class);
                        intent.putExtra("EXTRA_USUARIO", usuario.getNombreUsuario());
                        startActivity(intent);
                        return true;
                    case R.id.settings:
                        Intent settings = new Intent(Timeline.this, ConfiguracionActivity.class);
                        settings.putExtra("EXTRA_USUARIO", usuario.getNombreUsuario());
                        startActivity(settings);
                        return true;
                    case R.id.cerrar_sesion:
                        Intent finalizar = new Intent (Timeline.this, LoginActivity.class);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.clear();
                        edit.commit();
                        startActivity(finalizar);
                    default:
                        return false;
                }
            }
        });

    }

    public void data(){
        subastas = rc.getAllSubastas();
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