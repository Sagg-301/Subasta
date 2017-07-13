package com.ids.appsubasta.subasta.Activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Cartera.Bolivares;
import com.ids.appsubasta.subasta.Cartera.Monedas;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.RealmController;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Usuario.Usuario;
import com.mancj.slideup.SlideUp;

import io.realm.Realm;


public class verLotes extends AppCompatActivity {
    private ImageView imagen;
    private TextView titulo, descripcion, monto, mayor, montovl,fecha;
    private Button pujar, verhistorial;
    private ViewPager view;
    private Usuario usuario;
    private Subasta subasta;
    private RealmController rc;
    private Slider_Adapter adaptador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlotes);
        /*Fuentes*/
        /*String fuentee= ("assets/fuentes/gothic.TTF");
        this.century = Typeface.createFromAsset(getAssets(),fuentee);
        String fuentees= ("assets/fuentes/futura.ttf");
        this.futura = Typeface.createFromAsset(getAssets(),fuentees);*/
        //Typeface font = Typeface.createFromAsset(getAssets(), "FjallaOne-Regular.ttf");


        rc = new RealmController();
        usuario = rc.findUsuario(getIntent().getStringExtra("EXTRA_USUARIO"));
        usuario.initTipoUsuario();
        subasta = rc.findSubasta(getIntent().getStringExtra("EXTRA_ID_SUBASTA"));
        subasta.adscribirUsuario(usuario);



        view = (ViewPager) findViewById(R.id.screenshots);
        adaptador = new Slider_Adapter(this, subasta.getBienes().get(0).getFotos());
        view.setAdapter(adaptador);


        imagen = (ImageView) findViewById(R.id.VerLotesImagen);
        titulo = (TextView) findViewById(R.id.tituloVerLotes);
        descripcion = (TextView) findViewById(R.id.descricionVerLotes);
        monto = (TextView) findViewById(R.id.montoVerLotes);
        mayor = (TextView) findViewById(R.id.mayorVerLotes);
        montovl = (TextView) findViewById(R.id.montoVL);
        fecha = (TextView) findViewById(R.id.fechafinalVerLotes);


        titulo.setText(subasta.getBienes().get(0).getNombre());
        descripcion.setText(subasta.getBienes().get(0).getDescripcion());
        monto.setText(subasta.getBienes().get(0).getMonto());
        mayor.setText(subasta.getBienes().get(0).getMonto());
        fecha.setText(subasta.getFechaFinal().toString());

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
                    Toast.makeText(getApplicationContext(), "Puja realizada con exito", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Su puja no es suficientemente alta", Toast.LENGTH_SHORT).show();
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

    /*void initPuja(Subasta s) {
        Date f = new Date();
        Monedas m = new Bolivares();
        m.setMonto(Integer.parseInt(subasta.getBienes().get(0).getMonto()));
        Pujas puja = new Pujas(m, "", f);
        subasta.setPujas(puja);
    }*/
}

