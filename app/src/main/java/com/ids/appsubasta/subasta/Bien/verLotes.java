package com.ids.appsubasta.subasta.Bien;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.R;


public class verLotes extends AppCompatActivity {
    ImageView imagen;
    TextView titulo,descripcion,monto,fecha;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlotes);
        imagen = (ImageView) findViewById(R.id.VerLotesImagen);
        titulo = (TextView) findViewById(R.id.tituloVerLotes);
        descripcion = (TextView) findViewById(R.id.descricionVerLotes);
        monto = (TextView) findViewById(R.id.montoVerLotes);
        fecha = (TextView) findViewById(R.id.fechaVerLotes);
        imagen.setImageResource(getIntent().getIntExtra("img_id",00));
        titulo.setText("" +getIntent().getStringExtra("Titulo"));
        descripcion.setText("DESCRIPCIÓN: " +getIntent().getStringExtra("Descripcion"));
        monto.setText("MONTO: " +getIntent().getStringExtra("Precio"));
        fecha.setText("FINALIZACIÓN: " +getIntent().getStringExtra("Tiempo"));
    }
}
