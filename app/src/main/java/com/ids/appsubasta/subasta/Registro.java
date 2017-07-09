package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ids.appsubasta.subasta.Interfaz.Foto;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.io.ByteArrayOutputStream;

import io.realm.Realm;


public class Registro extends AppCompatActivity {
    private Button registro,agregar;
    private ImageView imagen;
    private Realm realm;
    private Foto f;

    //Las primeras dos son para saber donde se guardaran nuestras fotos
    private String APP_DIRECTORY = "myPictureApp/"; //Directorio principal
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "myPictureApp"; //Subcarpeta

    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";
    private final int PHOTO_CODE=100;
    private final int SELECT_PICTURE = 200;
    private final int MY_PERMISSIONS = 100;
    static final int REQUEST_IMAGE_CAPTURE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        realm = Realm.getDefaultInstance();
        registro = (Button) findViewById(R.id.registrarse_registro);
        agregar = (Button) findViewById(R.id.BotonCamara);
        imagen = (ImageView) findViewById(R.id.ImagenUsuario);


        //OnClick----------------------------------------------------------------------
        registro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String nombre = ((EditText) findViewById(R.id.nombre_registro)).getText().toString();
                final String apellido = ((EditText) findViewById(R.id.apellido_registro)).getText().toString();
                final String telefono = ((EditText) findViewById(R.id.telefono_registro)).getText().toString();
                final String email = ((EditText) findViewById(R.id.email_registro)).getText().toString();
                final String usuario = ((EditText) findViewById(R.id.usuario_registro)).getText().toString();
                final String contrasena = ((EditText) findViewById(R.id.contrasena_registro)).getText().toString();
                /*Enviamos los datos a la base de datos y entramos al timeline*/
                if ((nombre != "")&&(apellido != "")&&(telefono !="")&&(email !="")&&(usuario !="")&&(contrasena !="")){
                    Usuario existe = realm.where(Usuario.class).equalTo("nombreUsuario",usuario).findFirst();
                    if (existe == null) {
                        //añade Usuario a la base de datos
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                Usuario u = realm.createObject(Usuario.class, usuario);
                                u.setNombre(nombre);
                                u.setApellido(apellido);
                                u.setContraseña(contrasena);
                                u.setEmail(email);
                                u.setTelefono(telefono);
                                u.setFotoPerfil(f);
                            }
                        });
                        //------------------------------------
                        Intent creacion = new Intent(Registro.this, LoginActivity.class);
                        startActivity(creacion);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"El nombre de usuario ya está en uso", Toast.LENGTH_SHORT);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "¡Error!, por favor llene los campos solicitados", Toast.LENGTH_SHORT).show();
                }

            }


        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarIntent();
            }
        });
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
            imagen.setImageBitmap(imageBitmap);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            realm.beginTransaction();
            f = realm.createObject(Foto.class);
            f.setData(byteArray);
            realm.commitTransaction();
        }
    }
}
