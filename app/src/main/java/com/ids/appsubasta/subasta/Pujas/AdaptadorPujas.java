package com.ids.appsubasta.subasta.Pujas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.Adaptador;
import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Bien.verLotes;
import com.ids.appsubasta.subasta.R;

import java.util.List;

/**
 * Created by Usuario on 27/06/2017.
 */

public class AdaptadorPujas extends RecyclerView.Adapter<Adaptador.adaptadorHolder>{
    List<Pujas> pujas;
    Context ctx;

    public AdaptadorPujas (List<Pujas> pujas, Context ctx){
        this.pujas = pujas;
        this.ctx = ctx;
    }
    @Override
    public Adaptador.adaptadorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.historial_row_item, parent, false);
        return new Adaptador.adaptadorHolder(v,ctx,pujas);
    }

    @Override
    public void onBindViewHolder(Adaptador.adaptadorHolder adaptadorViewHolder, int position) {
        Pujas puja = pujas.get(position);
        adaptadorViewHolder.usuario.setText(puja.getIdPostor());
        adaptadorViewHolder.fecha.setText(puja.getFecha());
        adaptadorViewHolder.monto.setText(puja.getValor());
    }

    @Override
    public int getItemCount() {
        return pujas.size();
    }

    public class adaptadorHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView usuario, fecha, monto;
        private List<Pujas> pujas;
        private Context ctx;


        public adaptadorHolder(View itemView, Context ctx, List<Pujas> pujas){
            super(itemView);
            this.pujas = pujas;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            usuario = (TextView)itemView.findViewById(R.id.usuarioPujador);
            fecha = (TextView)itemView.findViewById(R.id.fechaPujador);
            monto = (TextView)itemView.findViewById(R.id.montoPujador);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
