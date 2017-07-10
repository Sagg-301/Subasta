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
import com.ids.appsubasta.subasta.Interfaz.Foto;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Timeline;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmList;

public class CrearSubastaActivity extends AppCompatActivity implements View.OnClickListener {

    Button FechaInicialID, FechaFinalID, enviar, agregar;
    EditText InicioID, FinalID;
    ImageView imagen1, imagen2, imagen3;
    private int dia, mes, ano;

    //Las primeras dos son para saber donde se guardaran nuestras fotos
    private String APP_DIRECTORY = "myPictureApp/"; //Directorio principal
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "myPictureApp"; //Subcarpeta

    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";
    private final int PHOTO_CODE=100;
    private final int SELECT_PICTURE = 200;
    private final int MY_PERMISSIONS = 100;
    static final int REQUEST_IMAGE_CAPTURE =1;

    private int flag=1;
    private RealmList<Foto> fotos = new RealmList<>();
    private Realm realm;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_subasta);

        realm = Realm.getDefaultInstance();
        usuario = realm.where(Usuario.class).equalTo("nombreUsuario",getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();
        //Botones----------------------------------------
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
        //Botones----------------------------------------
        //Eventos----------------------------------------
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
                                                     Subasta subasta = realm.createObject(Subasta.class,usuario.generarIdSubasta());
                                                     Bienes bien = realm.createObject(Bienes.class, subasta.generarIdBienes());
                                                     bien.setMonto(monto);
                                                     bien.setNombre(titulo);
                                                     bien.setDescripcion(descripcion);
                                                     bien.setFotos(fotos);
                                                     subasta.addBien(bien);
                                                     subasta.addFechaInicio(fechaInicial);
                                                     subasta.addFechaFinal(fechaFinal);
                                                 }
                                             }
                    );
                    //-----------------------------
                    Intent creacion = new Intent(CrearSubastaActivity.this, Timeline.class);
                    creacion.putExtra("EXTRA_USUARIO", usuario.getNombreUsuario());
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
            Calendar c = Calendar.getInstance();
            Date d = new Date();
            c.setTime(d);
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {



                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    InicioID.setText(dayOfMonth + "/" + month + "/" + year);
                }
            }
                    , ano, mes, dia);
            datePickerDialog.show();
        }


        if (v == FechaFinalID) {
            Calendar c = Calendar.getInstance();
            Date d = new Date();
            c.setTime(d);
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    FinalID.setText(dayOfMonth + "/" + month + "/" + year);
                }
            }
                    , ano, mes, dia);
            datePickerDialog.show();
        }

    }


    private void llamarIntent() { //De aqui vas a la camara del dispositivo
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
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                realm.beginTransaction();
                Foto f = realm.createObject(Foto.class);
                f.setData(byteArray);
                realm.commitTransaction();
                fotos.add(f);
                flag = flag + 1;
            }
            else if (flag == 2){
                imagen2.setImageBitmap(imageBitmap);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream); //compress(Bitmap.CompressFormat format, int quality, OutputStream stream)
                byte[] byteArray = stream.toByteArray();
                realm.beginTransaction();
                Foto f = realm.createObject(Foto.class);
                f.setData(byteArray);
                realm.commitTransaction();
                fotos.add(f);
                flag = flag + 1;
            }
            else if (flag == 3){
                imagen3.setImageBitmap(imageBitmap);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                realm.beginTransaction();
                byte[] byteArray = stream.toByteArray();
                Foto f = realm.createObject(Foto.class);
                f.setData(byteArray);
                realm.commitTransaction();
                fotos.add(f);
                flag = 1;
            }
        }
    }

}
