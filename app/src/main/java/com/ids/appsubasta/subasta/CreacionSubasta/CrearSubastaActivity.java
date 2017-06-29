package com.ids.appsubasta.subasta.CreacionSubasta;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
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

import java.io.File;
import java.util.Calendar;

import io.realm.Realm;

public class CrearSubastaActivity extends AppCompatActivity implements View.OnClickListener {

    Button FechaInicialID, FechaFinalID, enviar, agregar;
    EditText InicioID, FinalID;
    ImageView imagen1, imagen2, imagen3;
    private int dia, mes, ano;
    private String APP_DIRECTORY = "myPictureApp/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";
    private final int PHOTO_CODE=100;
    private final int SELECT_PICTURE = 200;
    static final int REQUEST_IMAGE_CAPTURE =1;
    private int flag=1;

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
        imagen1 = (ImageView) findViewById(R.id.ImagenesID);
        imagen2 = (ImageView) findViewById(R.id.ImagenesID2);
        imagen3 = (ImageView) findViewById(R.id.ImagenesID3);
        FechaInicialID.setOnClickListener(this);
        FechaFinalID.setOnClickListener(this);
        agregar = (Button) findViewById(R.id.agregarID);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            llamarIntent();
                    }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String titulo = ((EditText) findViewById(R.id.TituloID)).getText().toString();
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
                                                     subasta.setFotos(imagen1);
                                                     subasta.setFotos(imagen2);
                                                     subasta.setFotos(imagen3);
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


    private void llamarIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            if(flag == 1){
                imagen1.setImageBitmap(imageBitmap);
                flag = flag + 1;
            }
            else if (flag == 2){
                imagen2.setImageBitmap(imageBitmap);
                flag = flag + 1;
            }
            else if (flag == 3){
                imagen3.setImageBitmap(imageBitmap);
                flag = 1;
            }
        }
    }

}
