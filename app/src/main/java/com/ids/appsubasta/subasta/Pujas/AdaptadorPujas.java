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
                .inflate(R.layout.row_item, parent, false);
        return new adaptadorHolder(v,ctx,pujas);
    }

    @Override
    public void onBindViewHolder(adaptadorHolder adaptadorViewHolder, int position) {
        //Bienes bien = pujas.get(position);
        Pujas puja = pujas.get(position);
        adaptadorViewHolder.idpostor.setText(puja.getIdPostor());
        //adaptadorViewHolder.monto.setText(puja.getValor());
    }

    @Override
    public int getItemCount() {
        return pujas.size();
    }

    public class adaptadorHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView idpostor, monto;
        private List<Pujas> pujas;
        private Context ctx;


        public adaptadorHolder(View itemView, Context ctx, List<Pujas> pujas){
            super(itemView);
            this.pujas = pujas;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            idpostor = (TextView)itemView.findViewById(R.id.textoidrow);
            monto = (TextView)itemView.findViewById(R.id.montoidrow);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            //Bienes bienes = this.bienes.get(position);
            Pujas pujas = this.pujas.get(position);
            Intent intent = new Intent (this.ctx,verLotes.class);
            /*intent.putExtra("img_id",bienes.getFoto());
            intent.putExtra("Titulo",bienes.getNombre());
            intent.putExtra("Descripcion",bienes.getDescripcion());
            intent.putExtra("Precio",bienes.getMonto());*/
            this.ctx.startActivity(intent);
        }
    }
}