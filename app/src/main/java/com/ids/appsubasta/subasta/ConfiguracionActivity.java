package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.ids.appsubasta.subasta.Ban.TipoBan;
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
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        realm = Realm.getDefaultInstance();
        atras = (Button) findViewById(R.id.back);
        martillero = (Switch) findViewById(R.id.martilleroSwitch);
        postor = (Switch) findViewById(R.id.postorSwitch);
        vendedor = (Switch) findViewById(R.id.vendedorSwitch);
        usuario = realm.where(Usuario.class).equalTo("nombreUsuario",getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();

        martillero.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    realm.beginTransaction();
                    TipoUsuario uMartillero = new Martillero();
                    uMartillero.cambiarTipoDeUsuario(usuario);
                    realm.copyToRealmOrUpdate(usuario);
                    realm.commitTransaction();
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
                    realm.beginTransaction();
                    TipoUsuario uPostor = new Postor();
                    uPostor.cambiarTipoDeUsuario(usuario);
                    realm.copyToRealmOrUpdate(usuario);
                    realm.commitTransaction();
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
                    realm.beginTransaction();
                    TipoUsuario uVendedor = new Vendedor();
                    uVendedor.cambiarTipoDeUsuario(usuario);
                    realm.copyToRealmOrUpdate(usuario);
                    realm.commitTransaction();
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
}
