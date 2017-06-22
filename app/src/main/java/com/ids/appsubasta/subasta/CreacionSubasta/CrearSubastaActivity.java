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
import android.widget.Toast;

import com.ids.appsubasta.subasta.R;

import java.util.Calendar;

public class CrearSubastaActivity extends AppCompatActivity implements View.OnClickListener {

    Button FechaInicialID, FechaFinalID, enviar;
    EditText InicioID, FinalID;
    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_subasta);
        enviar = (Button) findViewById(R.id.EnviarID);
        FechaInicialID = (Button) findViewById(R.id.FechaInicialID);
        FechaFinalID = (Button) findViewById(R.id.FechaFinalID);
        InicioID = (EditText) findViewById(R.id.InicioID);
        FinalID = (EditText) findViewById(R.id.FinalID);
        FechaInicialID.setOnClickListener(this);
        FechaFinalID.setOnClickListener(this);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = ((EditText) findViewById(R.id.TituloID)).getText().toString();
                String subtitulo = ((EditText) findViewById(R.id.TituloID)).getText().toString();
                String descripcion = ((EditText) findViewById(R.id.descripcionID)).getText().toString();
                String monto = ((EditText) findViewById(R.id.montoID)).getText().toString();
                int precio = Integer.parseInt(monto);
                if (precio > 0) {
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
