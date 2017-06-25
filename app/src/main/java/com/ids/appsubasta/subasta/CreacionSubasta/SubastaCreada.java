package com.ids.appsubasta.subasta.CreacionSubasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ids.appsubasta.subasta.MainActivity;
import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Timeline;

/**
 * Created by Usuario on 15/06/2017.
 */

public class SubastaCreada extends AppCompatActivity {
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subasta_creada);
        home = (Button) findViewById(R.id.homecreadoid);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent creacion = new Intent(SubastaCreada.this, Timeline.class);
                    startActivity(creacion);

            }
        });
    }
}
