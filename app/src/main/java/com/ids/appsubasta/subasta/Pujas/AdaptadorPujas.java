package com.ids.appsubasta.subasta.Pujas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.Adaptador;
import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Bien.verLotes;
import com.ids.appsubasta.subasta.Pujas.Pujas;
import com.ids.appsubasta.subasta.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class AdaptadorPujas extends RecyclerView.Adapter<AdaptadorPujas.adaptadorHolder>{
    List<Pujas> pujas;
    Context ctx;

    public AdaptadorPujas (List<Pujas> pujas, Context ctx){
        this.pujas = pujas;
        this.ctx = ctx;
    }

    @Override
    public adaptadorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.historial_row_item, parent, false);
        return new adaptadorHolder(v,ctx,pujas);
    }

    @Override
    public void onBindViewHolder(adaptadorHolder adaptadorViewHolder, int position) {
        Pujas puja = pujas.get(position);
        adaptadorViewHolder.idpostor.setText(puja.getIdPostor());
        adaptadorViewHolder.monto.setText((CharSequence) puja.getValor());
        adaptadorViewHolder.fecha.setText(puja.getFecha());
    }

    @Override
    public int getItemCount() {
        return pujas.size();
    }

    public class adaptadorHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView idpostor, monto, fecha;
        private List<Pujas> pujas;
        private Context ctx;


        public adaptadorHolder(View itemView, Context ctx, List<Pujas> pujas){
            super(itemView);
            this.pujas = pujas;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            idpostor = (TextView)itemView.findViewById(R.id.usuarioPujador);
            monto = (TextView)itemView.findViewById(R.id.fechaPujador);
            fecha = (TextView)itemView.findViewById(R.id.montoPujador);
        }

        @Override
        public void onClick(View v) {

        }
    }
}