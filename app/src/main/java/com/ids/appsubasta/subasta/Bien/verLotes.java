package com.ids.appsubasta.subasta.Bien;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ids.appsubasta.subasta.Cartera.Bolivares;
import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.CreacionSubasta.CrearSubastaActivity;
import com.ids.appsubasta.subasta.Pujas.HistorialPujas;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Slider_Adapter;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Usuario.Usuario;
import com.mancj.slideup.SlideUp;

import java.util.Date;

import io.realm.Realm;


public class verLotes extends AppCompatActivity {
    ImageView imagen;
    TextView titulo, descripcion, monto, mayor, montovl;
    Button pujar, verhistorial;
    ViewPager view;
    Usuario usuario;
    Subasta subasta;
    Bienes bien;
    Realm realm;
    Slider_Adapter adaptador;
    Typeface century, futura;
    Pujas pujas;
    private SlideUp slideUp;
    private View dim;
    private View slideView;
    private FloatingActionButton fab;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlotes);
        /*Fuentes*/
        /*String fuentee= ("assets/fuentes/gothic.TTF");
        this.century = Typeface.createFromAsset(getAssets(),fuentee);
        String fuentees= ("assets/fuentes/futura.ttf");
        this.futura = Typeface.createFromAsset(getAssets(),fuentees);*/
        Typeface font = Typeface.createFromAsset(getAssets(), "FjallaOne-Regular.ttf");


        realm = Realm.getDefaultInstance();
        usuario = realm.where(Usuario.class).equalTo("nombreUsuario", getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();
        usuario.initTipoUsuario();
        subasta = realm.where(Subasta.class).equalTo("Id", getIntent().getStringExtra("EXTRA_ID_SUBASTA")).findFirst();
        subasta.adscribirUsuario(usuario);

        if (subasta.getPujas() == null) {                    //inicializo la puja si nadie a pujado
            initPuja(subasta);
        }

        view = (ViewPager) findViewById(R.id.screenshots);
        adaptador = new Slider_Adapter(this, subasta.getBienes().get(0).getFotos());
        view.setAdapter(adaptador);


        imagen = (ImageView) findViewById(R.id.VerLotesImagen);
        titulo = (TextView) findViewById(R.id.tituloVerLotes);
        titulo.setTypeface(futura);
        descripcion = (TextView) findViewById(R.id.descricionVerLotes);
        descripcion.setTypeface(century);
        monto = (TextView) findViewById(R.id.montoVerLotes);
        monto.setTypeface(century);
        mayor = (TextView) findViewById(R.id.mayorVerLotes);
        mayor.setTypeface(century);
        montovl = (TextView) findViewById(R.id.montoVL);
        montovl.setTypeface(font);


        titulo.setText("" + subasta.getBienes().get(0).getNombre());
        descripcion.setText("DESCRIPCIÓN: " + subasta.getBienes().get(0).getDescripcion());
        monto.setText("MONTO: " + subasta.getBienes().get(0).getMonto());
        mayor.setText(subasta.getBienes().get(0).getMonto());

        pujar = (Button) findViewById(R.id.btnpujar);
        pujar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monto = ((EditText) findViewById(R.id.edtpuja)).getText().toString();
                int precio = Integer.parseInt(monto);
                Monedas bs = new Bolivares();
                bs.setMonto(precio);
                if (usuario.getTipoUsuario().realizarPuja(bs, subasta)) {
                    mayor.setText(monto);
                    Toast.makeText(getApplicationContext(), "Puja realizada con exito", Toast.LENGTH_SHORT);
                }

            }

        });
        /*verhistorial = (Button) findViewById(R.id.verHistorialVerLotes);
        verhistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(verLotes.this,HistorialPujas.class);
                intent.putExtra("EXTRA_USUARIO",usuario.getNombreUsuario());
                intent.putExtra("EXTRA_PUJAS",subasta.getPujas());
                startActivity(intent);
            }
        });*/
    }

    void initPuja(Subasta s) {
        Date f = new Date();
        Monedas m = new Bolivares();
        m.setMonto(Integer.parseInt(subasta.getBienes().get(0).getMonto()));
        Pujas puja = new Pujas(m, "", f);
        subasta.setPujas(puja);
    }
}

