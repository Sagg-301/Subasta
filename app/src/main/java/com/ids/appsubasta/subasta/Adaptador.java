package com.ids.appsubasta.subasta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.Bien.Bienes;
import com.ids.appsubasta.subasta.Bien.verLotes;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class Adaptador extends RecyclerView.Adapter<Adaptador.adaptadorHolder>{
    List<Bienes> bienes;
    Context ctx;

    public Adaptador (List<Bienes> bienes, Context ctx){
        this.bienes = bienes;
        this.ctx = ctx;
    }

    @Override
    public adaptadorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new adaptadorHolder(v,ctx,bienes);
    }

    @Override
    public void onBindViewHolder(adaptadorHolder adaptadorViewHolder, int position) {
        Bienes bien = bienes.get(position);
        adaptadorViewHolder.texto.setText(bien.getNombre());
        adaptadorViewHolder.descripcion.setText(bien.getDescripcion());
        adaptadorViewHolder.monto.setText(bien.getMonto());
        adaptadorViewHolder.img.setImageResource(bien.getFoto());
    }

    @Override
    public int getItemCount() {
        return bienes.size();
    }

    public class adaptadorHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView texto, descripcion, monto, estado;
        private ImageView img;
        private List<Bienes> bienes;
        private Context ctx;


        public adaptadorHolder(View itemView, Context ctx, List<Bienes> bienes){
            super(itemView);
            this.bienes = bienes;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            texto = (TextView)itemView.findViewById(R.id.textoidrow);
            descripcion = (TextView)itemView.findViewById(R.id.descripcionidrow);
            monto = (TextView)itemView.findViewById(R.id.montoidrow);
            img = (ImageView)itemView.findViewById(R.id.imagenid);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Bienes bienes = this.bienes.get(position);
            Intent intent = new Intent (this.ctx,verLotes.class);
            intent.putExtra("img_id",bienes.getFoto());
            intent.putExtra("Titulo",bienes.getNombre());
            intent.putExtra("Descripcion",bienes.getDescripcion());
            intent.putExtra("Precio",bienes.getMonto());
            this.ctx.startActivity(intent);
        }
    }
}