package com.proyecto.alejandreyes.pokedex.API;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.proyecto.alejandreyes.pokedex.Activity.DetaillPokemon;
import com.proyecto.alejandreyes.pokedex.R;
import com.proyecto.alejandreyes.pokedex.modelo.Pokemon;

import java.util.ArrayList;

/**
 * Created by Pride on 16/11/2018.
 */

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder> implements Filterable {
    private ArrayList<Pokemon> dataset;
    private ArrayList<Pokemon> todosPokemons;

    private static String TAG = "ListaPokemonAdapter.class";
    private Context context;
    private Pokemon p;

    public ListaPokemonAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
        todosPokemons= new ArrayList<>();
    }


    @Override
    public ListaPokemonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListaPokemonAdapter.ViewHolder holder, int position) {
        p = dataset.get(position);
        holder.nombrePokemon.setText(p.getName());
        //Log.e(TAG, "onBindViewHolder: "+ p.getNumber() );
        String numero = "N";
        int n = p.getNumber();
        if((n/100)>=1){
            numero+=n;
        }else{
            if((n/10)>=1){
                numero+="0"+n;
            }else{
                numero+="00"+n;
            }
        }
        holder.setNumero(n);
        holder.numeroPokemon.setText(numero);
        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/" + p.getNumber() + ".png")
                .into(holder.imagenPokemon);


    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        todosPokemons.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return listaPokemons;
    }

    private Filter listaPokemons = new Filter() {
        private int maxLeng = 0;
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Pokemon> listaFiltradadePokemons = new ArrayList<>();
            if(charSequence == null || charSequence.length() == 0){
                listaFiltradadePokemons.addAll(todosPokemons);
            }else {
                String filterPatter = charSequence.toString().toLowerCase().trim();
                for(Pokemon poke:todosPokemons){
                    // Unicamente Filtro los pokemons que inicien con la cadena filter
                    if(poke.getName().toLowerCase().startsWith(filterPatter)){
                        listaFiltradadePokemons.add(poke);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = listaFiltradadePokemons;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            dataset.clear();
            dataset.addAll((ArrayList)filterResults.values);
            notifyDataSetChanged();
        }
    };


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imagenPokemon;
        private TextView nombrePokemon;
        private TextView numeroPokemon;
        private int numero ;
        private CardView tarjetas;

        public ViewHolder(View itemView) {
            super(itemView);
            imagenPokemon = (ImageView) itemView.findViewById(R.id.imagenPokemon);
            nombrePokemon = (TextView) itemView.findViewById(R.id.nombrePokemon);
            numeroPokemon = (TextView) itemView.findViewById(R.id.numeroPokemon);
            tarjetas = (CardView) itemView.findViewById(R.id.tarjetas);
            tarjetas.setOnClickListener(this);
        }
        public void setNumero(int numero){
            this.numero = numero;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tarjetas:
                    String pokemon =  p.getName();
                    Intent i = new Intent(v.getContext(),DetaillPokemon.class);
                    i.putExtra("pokemonNum",numero);
                    v.getContext().startActivity(i);
//                    Snackbar.make(v, pokemon, Snackbar.LENGTH_SHORT).show();
                    break;
            }

        }
    }
}
