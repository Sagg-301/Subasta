package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.loginlogin);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //si el login y la contraseña existen en la base de datos entonces entra al timeline
                Intent creacion = new Intent(MainActivity.this, Timeline.class);
                startActivity(creacion);
            }
           /* else{
                Toast.makeText(getApplicationContext(), "¡Error!, EL usuario o la contraseña no existen", Toast.LENGTH_SHORT).show();
            }*/
        });
    }
}



