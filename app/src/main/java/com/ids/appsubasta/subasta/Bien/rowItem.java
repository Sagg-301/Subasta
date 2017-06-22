package com.ids.appsubasta.subasta.Bien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.ids.appsubasta.subasta.R;


public class rowItem extends AppCompatActivity {

    Button verlotes, favoritos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_item);
        verlotes = (Button) findViewById(R.id.verlotesrow);
        verlotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent creacion = new Intent(rowItem.this, verLotes.class);
                    startActivity(creacion);
            }
        });
        favoritos = (Button) findViewById(R.id.favoritosrow);
        favoritos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent creacion = new Intent(rowItem.this, favoritos.class);
                startActivity(creacion);
            }
        });


    }
}
