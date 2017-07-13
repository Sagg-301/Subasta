package com.ids.appsubasta.subasta.Activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import io.realm.Realm;

public class verLotesPublicidad extends AppCompatActivity {

    private ImageView imagen;
    private TextView titulo, descripcion, monto, fechafinal,fechainicial;
    private Button adjudicar;
    private ViewPager view;
    private Usuario usuario;
    private Bienes bien;
    private Subasta subasta;
    private Realm realm;
    private Slider_Adapter adaptador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlotes_publicidad);

        realm = Realm.getDefaultInstance();
        usuario = realm.where(Usuario.class).equalTo("nombreUsuario", getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();
        subasta = realm.where(Subasta.class).equalTo("Id", getIntent().getStringExtra("EXTRA_ID_SUBASTA")).findFirst();


        view = (ViewPager) findViewById(R.id.screenshots);
        adaptador = new Slider_Adapter(this, subasta.getBienes().get(0).getFotos());
        view.setAdapter(adaptador);

        /*Instancias*/
        imagen = (ImageView) findViewById(R.id.VerLotesImagen);
        titulo = (TextView) findViewById(R.id.tituloVerLotes);
        descripcion = (TextView) findViewById(R.id.descricionVerLotes);
        monto = (TextView) findViewById(R.id.montoVerLotes);
        fechafinal = (TextView) findViewById(R.id.fechafinalVerLotes);
        fechainicial = (TextView) findViewById(R.id.fechainicialVerLotes);


        titulo.setText(subasta.getBienes().get(0).getNombre());
        descripcion.setText(subasta.getBienes().get(0).getDescripcion());
        monto.setText(subasta.getBienes().get(0).getMonto());
        fechafinal.setText(subasta.getFechaFinal().toString());
        fechainicial.setText(subasta.getFechaFinal().toString());

        /* Hay que agregar fechainicial en el adaptador para que muestre*/
               /* Intent creacion = new Intent(verLotesPublicidad.this, Timeline.class);
                startActivity(creacion);*/

        }

}
