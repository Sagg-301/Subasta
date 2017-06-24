package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ids.appsubasta.subasta.Bien.verLotes;
import com.ids.appsubasta.subasta.CreacionSubasta.SubastaCreada;


public class login extends AppCompatActivity {

    Button login, registro,olvido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.loginlogin);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //si el login y la contraseña existen en la base de datos entonces entra al timeline
                Intent creacion = new Intent(login.this, MainActivity.class);
                startActivity(creacion);
            }
            /*else{
                Toast.makeText(getApplicationContext(), "¡Error!, EL usuario o la contraseña no existen", Toast.LENGTH_SHORT).show();
            }*/
        });
        registro = (Button) findViewById(R.id.registrologin);
        registro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent creacion = new Intent(login.this, MainActivity.class); //Ir a la pantalla crear usuario
                startActivity(creacion);
            }
        });

        olvido = (Button) findViewById(R.id.olvidocontralogin);
        olvido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent creacion = new Intent(login.this, MainActivity.class); //Ir a la pantalla de olvidar contraseña
                startActivity(creacion);
            }
        });

    }
}

