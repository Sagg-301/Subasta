package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registro extends AppCompatActivity {
    Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        registro = (Button) findViewById(R.id.registrarse_registro);
        registro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nombre = ((EditText) findViewById(R.id.nombre_registro)).getText().toString();
                String apellido = ((EditText) findViewById(R.id.apellido_registro)).getText().toString();
                String telefono = ((EditText) findViewById(R.id.telefono_registro)).getText().toString();
                String email = ((EditText) findViewById(R.id.email_registro)).getText().toString();
                String usuario = ((EditText) findViewById(R.id.usuario_registro)).getText().toString();
                String contrasena = ((EditText) findViewById(R.id.contrasena_registro)).getText().toString();
                /*Enviamos los datos a la base de datos y entramos al timeline*/
                if ((nombre != null)&&(apellido != null)&&(telefono !=null)&&(email !=null)&&(usuario !=null)&&(contrasena !=null)){
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
