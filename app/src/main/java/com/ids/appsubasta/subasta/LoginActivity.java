package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ids.appsubasta.subasta.Usuario.Usuario;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {
    Button login, registro;
    Usuario usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Realm realm = Realm.getDefaultInstance();
        login = (Button) findViewById(R.id.loginlogin);

        //-------------------------------------------------------------------------------------
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String usuario = ((EditText) findViewById(R.id.usuariologin)).getText().toString();
                String contrasena = ((EditText) findViewById(R.id.contraseñalogin)).getText().toString();
                usuarios = realm.where(Usuario.class).equalTo("nombreUsuario",usuario).findAll().where().equalTo("contraseña",contrasena).findFirst();
                if (usuarios != null){
                    Intent timeline = new Intent(LoginActivity.this, Timeline.class);
                    timeline.putExtra("EXTRA_USUARIO", usuarios.getNombreUsuario());
                    startActivity(timeline);
                }
                else{
                    Toast.makeText(getApplicationContext(), "¡Error!, El Usuario no existe", Toast.LENGTH_SHORT).show();
                }
            }
        });
        registro = (Button) findViewById(R.id.registrologin);
        registro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent creacion = new Intent(LoginActivity.this, Registro.class);
                startActivity(creacion);
            }
        });

    }
}



