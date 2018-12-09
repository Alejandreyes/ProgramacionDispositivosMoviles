package com.proyecto.alejandreyes.recuperacion.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.proyecto.alejandreyes.recuperacion.R;

import java.util.ArrayList;

public class ListaByBreedAdapter extends RecyclerView.Adapter<ListaByBreedAdapter.ViewHolder>{


    private ArrayList<String> porRaza ;
    private final String TAG = this.getClass().getName();
    private Context context;
    private String byBreed ;
    public ListaByBreedAdapter(Context context) {
        this.context = context;
        porRaza = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_razas, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        byBreed = porRaza.get(i);
        //holder.razaActual = razaActual;
        Glide.with(context)
                .load(byBreed)
                .into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return porRaza.size();
    }
    public ArrayList<String> getPorRaza() {
        return porRaza;
    }

    public void setPorRaza(ArrayList<String> porRaza) {
        this.porRaza = porRaza;
        Log.e(TAG, "setPorRaza: Volvio a pasar"+ porRaza.size());
        notifyDataSetChanged();
    }

    public void replaceDataSet(ArrayList<String> message) {
        porRaza.clear();
        porRaza.addAll(message);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        private CardView tarjetas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenRazas);
            tarjetas = (CardView) itemView.findViewById(R.id.tarjetas);
       }
    }
}
