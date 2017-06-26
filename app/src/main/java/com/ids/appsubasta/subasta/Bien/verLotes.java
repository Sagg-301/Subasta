package com.ids.appsubasta.subasta.Bien;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.CreacionSubasta.CrearSubastaActivity;
import com.ids.appsubasta.subasta.R;


public class verLotes extends AppCompatActivity {
    ImageView imagen;
    TextView titulo,descripcion,monto;
    Button pujar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlotes);
        imagen = (ImageView) findViewById(R.id.VerLotesImagen);
        titulo = (TextView) findViewById(R.id.tituloVerLotes);
        descripcion = (TextView) findViewById(R.id.descricionVerLotes);
        monto = (TextView) findViewById(R.id.montoVerLotes);
        imagen.setImageResource(getIntent().getIntExtra("img_id",00));
        titulo.setText("" +getIntent().getStringExtra("Titulo"));
        descripcion.setText("DESCRIPCIÓN: " +getIntent().getStringExtra("Descripcion"));
        monto.setText("MONTO: " +getIntent().getStringExtra("Precio"));
        pujar = (Button) findViewById(R.id.pujarVerLotes);
        pujar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monto = ((EditText) findViewById(R.id.montoVerLotes)).getText().toString();
                /*Si el monto es mayor que la ultima puja realizada se envia a la base de datos*/
                /*Luego se refresca la pantalla*/
                Intent intent = new Intent(verLotes.this,CrearSubastaActivity.class);
                startActivity(intent);
            }
        });
    }
}
