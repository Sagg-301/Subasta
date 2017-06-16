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

    Button fechaInicioB, fechaFinalB, boton;
    EditText FechaInicioEdit, FechaFinalEdit;
    private int dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_subasta);
        boton = (Button) findViewById(R.id.enviart);
        fechaInicioB = (Button) findViewById(R.id.finicio);
        fechaFinalB = (Button) findViewById(R.id.ffinal);
        FechaInicioEdit = (EditText) findViewById(R.id.inicioid);
        FechaFinalEdit = (EditText) findViewById(R.id.finalid);
        fechaInicioB.setOnClickListener(this);
        fechaFinalB.setOnClickListener(this);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = ((EditText) findViewById(R.id.txttitulo)).getText().toString();
                String subtitulo = ((EditText) findViewById(R.id.txtsubtitulo)).getText().toString();
                String descripcion = ((EditText) findViewById(R.id.txtdescripcion)).getText().toString();
                String monto = ((EditText) findViewById(R.id.precio)).getText().toString();
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
        if (v == fechaInicioB) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    FechaInicioEdit.setText(dayOfMonth + "/" + month + "/" + year);
                }
            }
                    , dia, mes, ano);
            datePickerDialog.show();
        }


        if (v == fechaFinalB) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    FechaFinalEdit.setText(dayOfMonth + "/" + month + "/" + year);
                }
            }
                    , dia, mes, ano);
            datePickerDialog.show();
        }

    }
}
