package com.ids.appsubasta.subasta.Usuario;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.ConfiguracionActivity;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Timeline;

import org.w3c.dom.Text;

import io.realm.Realm;

public class MiCuenta extends AppCompatActivity {
    private TextView nombre, apellido,telefono,email, usuario;
    private Button atras;
    private ImageView fotoPerfil;
    private Usuario u;
    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micuenta);

        realm = Realm.getDefaultInstance();
        u = realm.where(Usuario.class).equalTo("nombreUsuario",getIntent().getStringExtra("EXTRA_USUARIO")).findFirst();

        nombre = (TextView) findViewById(R.id.nombre);
        apellido = (TextView) findViewById(R.id.apellido);
        telefono = (TextView) findViewById(R.id.telefono);
        usuario = (TextView) findViewById(R.id.usuario);
        email = (TextView) findViewById(R.id.email);
        fotoPerfil = (ImageView) findViewById(R.id.fotoperfil);
        atras = (Button) findViewById(R.id.micuentaAtras);

        usuario.setText("" + u.getNombreUsuario());
        nombre.setText("" +u.getNombre());
        apellido.setText("" +u.getApellido());
        telefono.setText("" +u.getEmail());
        email.setText("" +u.getEmail());
        Bitmap bmp = BitmapFactory.decodeByteArray(u.getFotoPerfil().getData(),0,u.getFotoPerfil().getData().length);
        fotoPerfil.setImageBitmap(bmp);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timeline = new Intent(MiCuenta.this,Timeline.class);
                timeline.putExtra("EXTRA_USUARIO",u.getNombreUsuario());
                startActivity(timeline);
            }
        });
    }
}
