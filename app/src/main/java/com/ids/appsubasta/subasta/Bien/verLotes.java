package com.ids.appsubasta.subasta.Bien;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.CreacionSubasta.CrearSubastaActivity;
import com.ids.appsubasta.subasta.Pujas.HistorialPujas;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Slider_Adapter;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import io.realm.Realm;


public class verLotes extends AppCompatActivity {
    ImageView imagen;
    TextView titulo,descripcion,monto;
    Button pujar,verhistorial;
    ViewPager view;
    Usuario usuario;
    Bienes bien;
    Realm realm;
    Slider_Adapter adaptador;
    Typeface century, futura;
    Pujas pujas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlotes);
        /*Fuentes*/
        /*String fuentee= ("assets/fuentes/gothic.TTF");
        this.century = Typeface.createFromAsset(getAssets(),fuentee);
        String fuentees= ("assets/fuentes/futura.ttf");
        this.futura = Typeface.createFromAsset(getAssets(),fuentees);*/

        realm = Realm.getDefaultInstance();
        usuario = realm.where(Usuario.class).equalTo("nombreUsuario",getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();
        bien = realm.where(Bienes.class).equalTo("identificacion",getIntent().getStringExtra("Id")).findFirst();


        view = (ViewPager) findViewById(R.id.screenshots);
        adaptador = new Slider_Adapter(this,bien.getFotos());
        view.setAdapter (adaptador);


        imagen = (ImageView) findViewById(R.id.VerLotesImagen);
        titulo = (TextView) findViewById(R.id.tituloVerLotes);
        titulo.setTypeface(futura);
        descripcion = (TextView) findViewById(R.id.descricionVerLotes);
        descripcion.setTypeface(century);
        monto = (TextView) findViewById(R.id.montoVerLotes);
        monto.setTypeface(century);


        imagen.setImageResource(getIntent().getIntExtra("img_id",00));
        titulo.setText("" +getIntent().getStringExtra("Titulo"));
        descripcion.setText("DESCRIPCIÓN: " +getIntent().getStringExtra("Descripcion"));
        monto.setText("MONTO: " +getIntent().getStringExtra("Precio"));

        pujar = (Button) findViewById(R.id.pujarVerLotes);
        pujar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monto = ((EditText) findViewById(R.id.montoVerLotes)).getText().toString();
                int precio = Integer.parseInt(monto);
                    Intent intent = new Intent(verLotes.this,CrearSubastaActivity.class);
                    startActivity(intent);
            }
        });
        verhistorial = (Button) findViewById(R.id.verHistorialVerLotes);
        verhistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(verLotes.this,HistorialPujas.class);
                startActivity(intent);
            }
        });
    }
}
