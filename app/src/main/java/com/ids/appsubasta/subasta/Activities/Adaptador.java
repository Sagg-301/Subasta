package com.ids.appsubasta.subasta.Activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.R;
import com.ids.appsubasta.subasta.Subasta;
import com.ids.appsubasta.subasta.Usuario.Usuario;

import java.util.List;


public class Adaptador extends RecyclerView.Adapter<Adaptador.adaptadorHolder>{
    List<Subasta> subastas;
    Context ctx;
    Usuario usuario;

    public Adaptador (Usuario usuario,List<Subasta> subastas, Context ctx){
        this.subastas = subastas;
        this.ctx = ctx;
        this.usuario = usuario;
    }

    @Override
    public adaptadorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new adaptadorHolder(v,ctx,subastas);
    }

    @Override
    public void onBindViewHolder(adaptadorHolder adaptadorViewHolder, int position) {
        Subasta subasta = subastas.get(position);
        adaptadorViewHolder.texto.setText(subasta.getBienes().get(0).getNombre());
        adaptadorViewHolder.descripcion.setText(subasta.getBienes().get(0).getDescripcion());
        adaptadorViewHolder.monto.setText(subasta.getBienes().get(0).getMonto());
        Bitmap bmp = BitmapFactory.decodeByteArray(subasta.getBienes().get(0).getFotos().get(0).getData(),
                0,
                subasta.getBienes().get(0).getFotos().get(0).getData().length);
        adaptadorViewHolder.img.setImageBitmap(bmp);
    }

    @Override
    public int getItemCount() {
        return subastas.size();
    }

    public class adaptadorHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView texto, descripcion, monto;
        private ImageView img;
        private List<Subasta> subastas;
        private Context ctx;


        public adaptadorHolder(View itemView, Context ctx, List<Subasta> subastas){
            super(itemView);
            this.subastas = subastas;
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
            Subasta subasta = this.subastas.get(position);
            subasta.initiSubasta();
            usuario.getTipoUsuario().verLote(usuario.getNombreUsuario(),this.ctx,subasta);
        }
    }
}