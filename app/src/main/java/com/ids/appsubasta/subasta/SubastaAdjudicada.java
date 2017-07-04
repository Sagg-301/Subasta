package com.ids.appsubasta.subasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.realm.Realm;


public class SubastaAdjudicada extends AppCompatActivity {
    TextView puja, usuario;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Realm realm = Realm.getDefaultInstance();
        puja = (TextView) findViewById(R.id.monto_subastacreada);
        usuario = (TextView) findViewById(R.id.usuario_subastacreada);
        home = (Button) findViewById(R.id.home_subastacreada);

        usuario.setText("DESCRIPCIÓN: " + getIntent().getStringExtra("Descripcion"));
        puja.setText("MONTO: " + getIntent().getStringExtra("Precio"));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent timeline = new Intent(SubastaAdjudicada.this, Timeline.class);
                    startActivity(timeline);
                }
        });
    }
}
