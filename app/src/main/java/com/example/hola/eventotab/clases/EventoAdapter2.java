package com.example.hola.eventotab.clases;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hola.eventotab.R;

import java.util.List;

/**
 * Created by Ivan on 2/8/2016.
 */
public class EventoAdapter2 extends RecyclerView.Adapter<EventoAdapter2.AnimeViewHolder> {
    private static List<Evento> items;
    private View v;

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item

        public ImageView imagenTarjeta;
        public TextView nombreExpositorTarjeta;
        public TextView tituloTarjeta;
        public TextView horaTarjeta;


        public AnimeViewHolder(final View v) {
            super(v);
            imagenTarjeta = (ImageView) v.findViewById(R.id.card_image);
            nombreExpositorTarjeta = (TextView) v.findViewById(R.id.tarjetaNombreExpositor);
            tituloTarjeta = (TextView) v.findViewById(R.id.tarjetaTituloEvento);
            horaTarjeta = (TextView) v.findViewById(R.id.tarjetaHora);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Evento evento = items.get(pos);
                    String key = evento.getKeyEvento();
                    String url = evento.getImagenEvento();

                    //Toast.makeText(v.getContext(),String.valueOf(evento.getKeyEvento()),Toast.LENGTH_LONG).show();
                    //Toast toast1 = Toast.makeText(v.getContext(),String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT);
                    //toast1.show();
                }
            });
        }
    }
    public EventoAdapter2(List<Evento> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public AnimeViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int i) {
        v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragmento_targeta_evento, viewGroup, false);
        /*v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast1 =
                        Toast.makeText(v.getContext(),String.valueOf(1), Toast.LENGTH_SHORT);

                toast1.show();
            }
        });*/
        return new AnimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AnimeViewHolder viewHolder, int i) {

        viewHolder.nombreExpositorTarjeta.setText(items.get(i).getNombreExpositorEvento());
        viewHolder.tituloTarjeta.setText(items.get(i).getTituloEvento());
        viewHolder.horaTarjeta.setText(items.get(i).getHoraEvento());
    }
}
