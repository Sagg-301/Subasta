package com.ids.appsubasta.subasta.CreacionSubasta;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Fase.Fase;
import com.ids.appsubasta.subasta.Fase.Inactiva;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Subasta;

import java.util.Calendar;

import io.realm.Realm;

public class CrearSubastaActivity extends AppCompatActivity implements View.OnClickListener {

    Button FechaInicialID, FechaFinalID, enviar;
    EditText InicioID, FinalID;
    ImageView imagen;
    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_subasta);
        final Realm realm = Realm.getDefaultInstance();
        enviar = (Button) findViewById(R.id.EnviarID);
        FechaInicialID = (Button) findViewById(R.id.FechaInicialID);
        FechaFinalID = (Button) findViewById(R.id.FechaFinalID);
        InicioID = (EditText) findViewById(R.id.InicioID);
        FinalID = (EditText) findViewById(R.id.FinalID);
        imagen = (ImageView) findViewById(R.id.imagenid);
        FechaInicialID.setOnClickListener(this);
        FechaFinalID.setOnClickListener(this);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String titulo = ((EditText) findViewById(R.id.TituloID)).getText().toString();
                final String subtitulo = ((EditText) findViewById(R.id.TituloID)).getText().toString();
                final String descripcion = ((EditText) findViewById(R.id.descripcionID)).getText().toString();
                final String monto = ((EditText) findViewById(R.id.montoID)).getText().toString();
                final String fechaInicial = InicioID.getText().toString();
                final String fechaFinal = FinalID.getText().toString();
                int precio = Integer.parseInt(monto);
                if (precio > 0) {
                    //Copia nueva subasta a Realm
                    realm.executeTransaction(new Realm.Transaction() {
                                                 @Override
                                                 public void execute(Realm realm) {
                                                     Bienes bien = realm.createObject(Bienes.class);
                                                     bien.setMonto(monto);
                                                     bien.setNombre(titulo);
                                                     bien.setDescripcion(descripcion);

                                                     Subasta subasta = realm.createObject(Subasta.class,titulo);
                                                     subasta.addBien(bien);
                                                 }
                                             }
                                             );
                    //-----------------------------
                    Intent creacion = new Intent(CrearSubastaActivity.this, SubastaCreada.class);
                    startActivity(creacion);
                } else {
                    Toast.makeText(getApplicationContext(), "¡Error!, Ingrese un valor mayor a 0", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v == FechaInicialID) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    InicioID.setText(dayOfMonth + "/" + month + "/" + year);
                }
            }
                    , dia, mes, ano);
            datePickerDialog.show();
        }


        if (v == FechaFinalID) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    FinalID.setText(dayOfMonth + "/" + month + "/" + year);
                }
            }
                    , dia, mes, ano);
            datePickerDialog.show();
        }

    }
}
