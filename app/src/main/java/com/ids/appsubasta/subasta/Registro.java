package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ids.appsubasta.subasta.Usuario.Usuario;

import io.realm.Realm;


public class Registro extends AppCompatActivity {
    Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        final Realm realm = Realm.getDefaultInstance();
        registro = (Button) findViewById(R.id.registrarse_registro);
        registro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String nombre = ((EditText) findViewById(R.id.nombre_registro)).getText().toString();
                final String apellido = ((EditText) findViewById(R.id.apellido_registro)).getText().toString();
                final String telefono = ((EditText) findViewById(R.id.telefono_registro)).getText().toString();
                final String email = ((EditText) findViewById(R.id.email_registro)).getText().toString();
                final String usuario = ((EditText) findViewById(R.id.usuario_registro)).getText().toString();
                final String contrasena = ((EditText) findViewById(R.id.contrasena_registro)).getText().toString();
                /*Enviamos los datos a la base de datos y entramos al timeline*/
                if ((nombre != null)&&(apellido != null)&&(telefono !=null)&&(email !=null)&&(usuario !=null)&&(contrasena !=null)){
                    //añade Usuario a la base de datos
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Usuario u = realm.createObject(Usuario.class,usuario);
                            u.setNombre(nombre);
                            u.setApellido(apellido);
                            u.setContraseña(contrasena);
                            u.setEmail(email);
                            u.setTelefono(telefono);
                        }
                    });
                    //------------------------------------
                    Intent creacion = new Intent(Registro.this, Timeline.class);
                    startActivity(creacion);
                }
                else{
                    Toast.makeText(getApplicationContext(), "¡Error!, por favor llene los campos solicitados", Toast.LENGTH_SHORT).show();
                }

            }


        });
    }
}