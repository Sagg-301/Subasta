package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearSubastaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_subasta);
        Button boton = (Button) findViewById(R.id.enviart);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = ((EditText)findViewById(R.id.txttitulo)).getText().toString();
                String subtitulo = ((EditText)findViewById(R.id.txtsubtitulo)).getText().toString();
                String descripcion = ((EditText)findViewById(R.id.txtdescripcion)).getText().toString();
                String precio = ((EditText)findViewById(R.id.precio)).getText().toString();
                if (precio.equals("5000")){
                    Intent creacion = new Intent(CrearSubastaActivity.this,SubastaCreada.class);
                    startActivity(creacion);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"¡Error!, Ingrese un valor mayor a 0", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
