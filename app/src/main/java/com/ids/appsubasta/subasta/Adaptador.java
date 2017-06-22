package com.ids.appsubasta.subasta;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ids.appsubasta.subasta.Bien.Bienes;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Usuario on 15/06/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.adaptadorHolder>{

private List<Bienes> bienes;
    public Adaptador (List<Bienes> bienes){
        this.bienes = bienes;
    }

    @Override
    public adaptadorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new adaptadorHolder(v);
    }

    @Override
    public void onBindViewHolder(adaptadorHolder adaptadorViewHolder, int position) {
       Bienes bien = bienes.get(position);
        adaptadorViewHolder.texto.setText(bien.getNombre());
        adaptadorViewHolder.descripcion.setText(bien.getDescripcion());
        adaptadorViewHolder.monto.setText(bien.getMonto());
        adaptadorViewHolder.tiempo.setText(bien.getTiempo());
        adaptadorViewHolder.estado.setText(bien.getEstado());
       // adaptadorViewHolder.imagen.setImageDrawable(R.drawable);
    }

    @Override
    public int getItemCount() {
        return bienes.size();
    }

    public class adaptadorHolder extends RecyclerView.ViewHolder{
        private TextView texto, descripcion, monto, tiempo, estado;
        private ImageView imagen;

        public adaptadorHolder(View itemView){
            super(itemView);
            texto = (TextView)itemView.findViewById(R.id.textoidrow);
            descripcion = (TextView)itemView.findViewById(R.id.descripcionidrow);
            monto = (TextView)itemView.findViewById(R.id.montoidrow);
            tiempo = (TextView)itemView.findViewById(R.id.tiempoidrow);
            estado = (TextView)itemView.findViewById(R.id.estadoidrow);
            //imagen = (ImageView) itemView.findViewById(R.id.imagenid);
        }
    }
}
