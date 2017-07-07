package com.ids.appsubasta.subasta.Usuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ids.appsubasta.subasta.ConfiguracionActivity;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Timeline;

import org.w3c.dom.Text;

import io.realm.Realm;

public class MiCuenta extends AppCompatActivity {
    TextView nombre, apellido,telefono,email;
    Button atras;
    Usuario u;
    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micuenta);

        realm = Realm.getDefaultInstance();
        u = realm.where(Usuario.class).equalTo("nombreUsuario",getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();

        nombre = (TextView) findViewById(R.id.nombre);
        apellido = (TextView) findViewById(R.id.apellido);
        telefono = (TextView) findViewById(R.id.telefono);
        email = (TextView) findViewById(R.id.email);
        //Usuario u = realm.createObject(Usuario.class, nombre);
        nombre.setText("" +u.getNombre());
        apellido.setText("" +u.getApellido());
        telefono.setText("" +u.getEmail());
        email.setText("" +u.getEmail());

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timeline = new Intent(MiCuenta.this,Timeline.class);
                startActivity(timeline);
            }
        });
    }
}
