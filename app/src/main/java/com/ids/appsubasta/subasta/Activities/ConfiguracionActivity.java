package com.ids.appsubasta.subasta.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.RealmController;
import com.ids.appsubasta.subasta.Usuario.Martillero;
import com.ids.appsubasta.subasta.Usuario.Postor;
import com.ids.appsubasta.subasta.Usuario.TipoUsuario;
import com.ids.appsubasta.subasta.Usuario.Usuario;
import com.ids.appsubasta.subasta.Usuario.Vendedor;

import io.realm.Realm;

public class ConfiguracionActivity extends AppCompatActivity {
    Switch martillero,postor,vendedor;
    Button atras;
    Usuario usuario;
    RealmController rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        atras = (Button) findViewById(R.id.back);
        martillero = (Switch) findViewById(R.id.martilleroSwitch);
        postor = (Switch) findViewById(R.id.postorSwitch);
        vendedor = (Switch) findViewById(R.id.vendedorSwitch);
        rc = new RealmController();
        usuario = rc.findUsuario(getIntent().getStringExtra("EXTRA_USUARIO"));
        initSwitch();

        martillero.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    TipoUsuario uMartillero = new Martillero();
                    rc.changeTipoUsuario(usuario,uMartillero);
                    //------------------------
                    vendedor.setChecked(false);
                    postor.setChecked(false);
                }
            }
        });

        postor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    TipoUsuario uPostor = new Postor(usuario.getNombreUsuario());
                    rc.changeTipoUsuario(usuario,uPostor);
                    //------------------------
                    martillero.setChecked(false);
                    vendedor.setChecked(false);
                }
            }
        });

        vendedor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    TipoUsuario uVendedor = new Vendedor();
                    rc.changeTipoUsuario(usuario,uVendedor);
                    //------------------------
                    martillero.setChecked(false);
                    postor.setChecked(false);
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timeline = new Intent(ConfiguracionActivity.this,Timeline.class);
                timeline.putExtra("EXTRA_USUARIO",usuario.getNombreUsuario());
                startActivity(timeline);
            }
        });
    }

    void initSwitch(){
        if(usuario.getTipoUsuarioS().equals("martillero")){
            martillero.setChecked(true);
        }
        else if(usuario.getTipoUsuarioS().equals("postor")){
            postor.setChecked(true);
        }
    }
}
