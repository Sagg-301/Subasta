package com.ids.appsubasta.subasta.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Fase.EnCurso;
import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Fase.Publicidad;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.RealmController;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.text.SimpleDateFormat;

import io.realm.Realm;

/**
 * Created by Usuario on 04/07/2017.
 */

public class verLotesMartillero extends AppCompatActivity {

    private ImageView imagen;
    private TextView titulo, descripcion, monto, fechafinal, mayorpuja, tiempo;
    private Button adjudicar, atras;
    private RadioButton publicidad, encurso, adjudicada;
    private ViewPager view;
    private Usuario usuario;
    private Subasta subasta;
    private RealmController rc;
    private Slider_Adapter adaptador;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlotes_martillero);

        rc = new RealmController();
        usuario = rc.findUsuario(getIntent().getStringExtra("EXTRA_USUARIO"));
        usuario.initTipoUsuario();
        subasta = rc.findSubasta(getIntent().getStringExtra("EXTRA_ID_SUBASTA"));



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
        atras = (Button) findViewById(R.id.atrasMartillero);
        adjudicar = (Button) findViewById(R.id.btncambiarfase);
        initRadioButtons();


        titulo.setText(subasta.getBienes().get(0).getNombre());
        descripcion.setText(subasta.getBienes().get(0).getDescripcion());
        monto.setText(subasta.getBienes().get(0).getMonto());
        mayorpuja.setText("");
        tiempo.setText("");
        fechafinal.setText(formato.format(subasta.getFechaFinal()));
        /* Hay que agregar mayorpuja,tiempo y fechafinal en el adaptador para que nos muestre estos*/

        adjudicar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (publicidad.isChecked()){
                    Fase f = new Publicidad();
                    rc.changeFase(subasta,f);
                    Toast.makeText(getApplicationContext(),"Cambio a subasta a Publicidad",Toast.LENGTH_SHORT).show();
                }
                else if(encurso.isChecked()){
                    Fase f = new EnCurso();
                    rc.changeFase(subasta,f);
                    Toast.makeText(getApplicationContext(),"Cambio a subasta a En Curso",Toast.LENGTH_SHORT).show();
                }
                else if(adjudicada.isChecked()){
                    Toast.makeText(getApplicationContext(), "Funcion no valida por el momento", Toast.LENGTH_SHORT).show();
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(verLotesMartillero.this,Timeline.class);
                intent.putExtra("EXTRA_USUARIO",usuario.getNombreUsuario());
                startActivity(intent);
            }
        });

        encurso.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    publicidad.setChecked(false);
                    adjudicada.setChecked(false);
                }
            }
        });

        publicidad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    encurso.setChecked(false);
                    adjudicada.setChecked(false);
                }
            }
        });

        adjudicada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    publicidad.setChecked(false);
                    encurso.setChecked(false);
                }
            }
        });

    }

    void initRadioButtons(){
        if (subasta.getFaseS().equals("EnCurso")){
            encurso.setChecked(true);
        }
        else if (subasta.getFaseS().equals("Publicidad")){
            publicidad.setChecked(true);
        }
    }
}
