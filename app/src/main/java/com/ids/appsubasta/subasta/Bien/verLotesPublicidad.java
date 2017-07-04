package com.ids.appsubasta.subasta.Bien;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Slider_Adapter;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Timeline;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import org.w3c.dom.Text;

import io.realm.Realm;

public class verLotesPublicidad extends AppCompatActivity {

    ImageView imagen;
    TextView titulo, descripcion, monto, fechafinal,fechainicial;
    Button adjudicar;
    ViewPager view;
    Usuario usuario;
    Bienes bien;
    Realm realm;
    Fase fase;
    Slider_Adapter adaptador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlotes_publicidad);

        realm = Realm.getDefaultInstance();
        usuario = realm.where(Usuario.class).equalTo("nombreUsuario", getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();
        bien = realm.where(Bienes.class).equalTo("identificacion", getIntent().getStringExtra("Id")).findFirst();


        view = (ViewPager) findViewById(R.id.screenshots);
        adaptador = new Slider_Adapter(this, bien.getFotos());
        view.setAdapter(adaptador);

        /*Instancias*/
        imagen = (ImageView) findViewById(R.id.VerLotesImagen);
        titulo = (TextView) findViewById(R.id.tituloVerLotes);
        descripcion = (TextView) findViewById(R.id.descricionVerLotes);
        monto = (TextView) findViewById(R.id.montoVerLotes);
        fechafinal = (TextView) findViewById(R.id.fechafinalVerLotes);
        fechainicial = (TextView) findViewById(R.id.fechainicialVerLotes);


        imagen.setImageResource(getIntent().getIntExtra("img_id", 00));
        titulo.setText("" + getIntent().getStringExtra("Titulo"));
        descripcion.setText("DESCRIPCIÓN: " + getIntent().getStringExtra("Descripcion"));
        monto.setText("MONTO: " + getIntent().getStringExtra("Precio"));
        fechafinal.setText("FECHAFINAL" + getIntent().getStringExtra("FechaFinal"));
        fechainicial.setText("FECHAINICIAL" + getIntent().getStringExtra("FechaInicial"));

        /* Hay que agregar fechainicial en el adaptador para que muestre*/
               /* Intent creacion = new Intent(verLotesPublicidad.this, Timeline.class);
                startActivity(creacion);*/

        }

}
