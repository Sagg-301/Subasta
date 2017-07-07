package com.ids.appsubasta.subasta.Bien;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ids.appsubasta.subasta.CreacionSubasta.CrearSubastaActivity;
import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.LoginActivity;
import com.ids.appsubasta.subasta.Pujas.HistorialPujas;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Registro;
import com.ids.appsubasta.subasta.Slider_Adapter;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Timeline;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import io.realm.Realm;

/**
 * Created by Usuario on 04/07/2017.
 */

public class verLotesMartillero extends AppCompatActivity {

    ImageView imagen;
    TextView titulo, descripcion, monto, fechafinal, mayorpuja, tiempo;
    Button adjudicar;
    RadioButton publicidad, encurso, adjudicada;
    ViewPager view;
    Usuario usuario;
    Subasta subasta;
    Bienes bien;
    Realm realm;
    Fase fase;
    Slider_Adapter adaptador;
    Typeface century, futura;
    Pujas pujas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlotes_martillero);

        realm = Realm.getDefaultInstance();
        usuario = realm.where(Usuario.class).equalTo("nombreUsuario", getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();
        subasta = realm.where(Subasta.class).equalTo("Id",getIntent().getStringExtra("EXTRA_ID_SUBASTA")).findFirst();
        usuario.initTipoUsuario();


        view = (ViewPager) findViewById(R.id.screenshots);
        adaptador = new Slider_Adapter(this,subasta.getBienes().get(0).getFotos());
        view.setAdapter(adaptador);

        /*Instancias*/
        imagen = (ImageView) findViewById(R.id.VerLotesImagen);
        titulo = (TextView) findViewById(R.id.tituloVerLotes);
        descripcion = (TextView) findViewById(R.id.descricionVerLotes);
        monto = (TextView) findViewById(R.id.montoVerLotes);
        fechafinal = (TextView) findViewById(R.id.fechafinalVerLotes);
        tiempo = (TextView) findViewById(R.id.tiempoVerLotes);
        mayorpuja = (TextView) findViewById(R.id.mayorVerLotes);
        publicidad = (RadioButton) findViewById(R.id.btnpublicidad);
        encurso = (RadioButton) findViewById(R.id.btnencurso);
        adjudicada = (RadioButton) findViewById(R.id.btnadjudicada);


        imagen.setImageResource(getIntent().getIntExtra("img_id", 00));
        titulo.setText("" +subasta.getBienes().get(0).getNombre());
        descripcion.setText("DESCRIPCIÓN: " +subasta.getBienes().get(0).getDescripcion());
        monto.setText("MONTO: " +subasta.getBienes().get(0).getMonto());
        mayorpuja.setText("PUJA");
        tiempo.setText("TIEMPO");
        fechafinal.setText("FECHAFINAL" );
        /* Hay que agregar mayorpuja,tiempo y fechafinal en el adaptador para que nos muestre estos*/

        adjudicar = (Button) findViewById(R.id.btnadjudicada);
        adjudicar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (publicidad.isChecked()){

                }
                else if(encurso.isChecked()){

                }
                else if(adjudicada.isChecked()){

                }
            }
        });

    }
}
