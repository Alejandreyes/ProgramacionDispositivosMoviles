package com.proyecto.alejandreyes.pokedex.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.proyecto.alejandreyes.pokedex.API.HttpHandler;
import com.proyecto.alejandreyes.pokedex.R;
import com.proyecto.alejandreyes.pokedex.modelo.PokemonDetalle;
import java.util.List;

public class DetaillPokemon extends AppCompatActivity {
    private static final String TAG = "DETAILLPOKEMON";
    private int number;
    private Toolbar toolbar;
    private TextView nombrePokemonDetalle, numeroPokemonDetalles,habilidadOculta, habilidadSecundaria,habilidadPrimaria;
    private ImageView imagenPokemonNormal,tipoDetalles1,tipoDetalles2;
    private ImageView imagenPokemonShiny;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this ;
        Bundle bundle = getIntent().getExtras();
        number = bundle.getInt("pokemonNum");
        setContentView(R.layout.activity_detaill_pokemon);
        nombrePokemonDetalle = (TextView) findViewById(R.id.nombrePokemonDetalles);
        numeroPokemonDetalles = (TextView) findViewById(R.id.numeroPokemonDetalles);
        habilidadPrimaria = (TextView) findViewById(R.id.habilidadPrimaria);
        habilidadSecundaria = (TextView) findViewById(R.id.habilidadSecundaria);
        habilidadOculta = (TextView) findViewById(R.id.habilidadOculta);
        imagenPokemonNormal = (ImageView) findViewById(R.id.imagenPokemonNormal);
        imagenPokemonShiny = (ImageView) findViewById(R.id.imagenPokemonShiny);
        tipoDetalles1= (ImageView) findViewById(R.id.tipoDetalles1);
        tipoDetalles2 = (ImageView) findViewById(R.id.tipoDetalles2);
        Glide.with(this)
                .load("http://pokeapi.co/media/sprites/pokemon/" + number + ".png")
                .into(imagenPokemonNormal);
        Glide.with(this)
                .load("http://pokeapi.co/media/sprites/pokemon/shiny/" + number + ".png")
                .into(imagenPokemonShiny);
        new PokemonDetallado().execute();
        setUpToolBar();
    }
    private class PokemonDetallado extends AsyncTask<Void, Void, Void> {
        private String nombre;
        private List tipos;
        private List<PokemonDetalle.Abilities> abilitys;
        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String url = "https://pokeapi.co/api/v2/pokemon/"+number+"/";
            String jsonStr = sh.makeServiceCall(url);
            if (jsonStr != null) {
                Gson gson = new Gson();
                PokemonDetalle data = gson.fromJson(jsonStr,PokemonDetalle.class);
                nombre = data.getForms().toString().substring(data.getForms().toString().indexOf("=")+1,(data.getForms().toString().indexOf(",")));
                tipos = data.getTypes();
                abilitys = data.getAbilities();
            } else {
                Log.e(TAG, "Couldn't get json from server.");
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            nombrePokemonDetalle.setText(nombre);
            asignaNumero(number);
            asignaTipo(tipos);
            asignaHabilidades(abilitys);
        }

        private void asignaHabilidades(List<PokemonDetalle.Abilities> abilities) {
            String temp = habilidadSecundaria.getText().toString()+" ";
            temp+= "N/A";
            habilidadSecundaria.setText(temp);
            temp = habilidadOculta.getText().toString()+" ";
            temp+= "N/A";
            habilidadOculta.setText(temp);

            for(PokemonDetalle.Abilities ability : abilities){
//                Log.e(TAG, "asignaHabilidades: "+ability.getSlot());
//                Log.e(TAG, "asignaHabilidades: "+ability.getAbility().getName());
//                Log.e(TAG, "asignaHabilidades: "+ability.isIs_hidden());
                String temporal;
                switch (ability.getSlot()){
                    case 1:
                        temporal = habilidadPrimaria.getText().toString()+" ";
                        temporal+= ability.getAbility().getName().replace("-"," ");
                        habilidadPrimaria.setText(temporal);
                        break;
                    case 2:
                        temporal = habilidadSecundaria.getText().toString()+" ";
                        temporal = temporal.substring(0,temporal.length()-4);
                        temporal+= ability.getAbility().getName().replace("-"," ");

                        habilidadSecundaria.setText(temporal);
                        break;
                    case 3:
                        temporal = habilidadOculta.getText().toString()+" ";
                        temporal = temporal.substring(0,temporal.length()-4);
                        temporal+= ability.getAbility().getName().replace("-"," ");
                        habilidadOculta.setText(temporal);
                        break;
                }
            }
        }

        private void asignaTipo(List tipos) {
            String tipo1 = tipos.get(0).toString();
            tipo1 = tipo1.replaceAll("\"","");
            int slot = Integer.parseInt(tipo1.substring(tipo1.indexOf("=") +1,tipo1.indexOf(".")));
            int slot2 = -1 ;
            String tipo2 = null;
            if(tipos.size()==2){
                tipo2 = tipos.get(1).toString();
                tipo2 = tipo2.replaceAll("\"","");
                slot2 = Integer.parseInt(tipo2.substring(tipo2.indexOf("=") +1,tipo2.indexOf(".")));
            }
            tipo1 = (tipo1.substring(tipo1.indexOf(",")+1)).substring(tipo1.indexOf("=")+1);
            String tipoA1 = tipo1.substring(tipo1.indexOf("=") +1,tipo1.indexOf(","));
            tipoA1 = tipoA1.replaceAll("\"","");
            if(slot2 != -1){
                tipo2 = (tipo2.substring(tipo2.indexOf(",")+1)).substring(tipo2.indexOf("=")+2);
                String tipoA2 = tipo2.substring(tipo2.indexOf("=") +1,tipo2.indexOf(","));
                tipoA2 = tipoA2.replaceAll("\"","");
                if(slot2 == 2) {
                    Glide.with(context)
                            .load(obtenerRecurso(tipoA1))
                            .into(tipoDetalles1);
                    Glide.with(context)
                            .load(obtenerRecurso(tipoA2))
                            .into(tipoDetalles2);
                }else{
                    Glide.with(context)
                            .load(obtenerRecurso(tipoA1))
                            .into(tipoDetalles2);
                    Glide.with(context)
                            .load(obtenerRecurso(tipoA2))
                            .into(tipoDetalles1);
                }
            }else{
                Glide.with(context)
                        .load(obtenerRecurso(tipoA1))
                        .into(tipoDetalles1);
            }
        }
        private int obtenerRecurso(String tipo) {
            switch (tipo){
                case "bug" :
                    return R.drawable.bug;
                case "dark" :
                    return  R.drawable.dark;
                case "dragon" :
                    return R.drawable.dragon;
                case "electric" :
                    return  R.drawable.electric;
                case "fire" :
                    return R.drawable.fire;
                case "fairy" :
                    return R.drawable.fairy;
                case "flying" :
                    return  R.drawable.flying;
                case "fighting" :
                    return  R.drawable.fighting;
                case "ghost" :
                    return R.drawable.ghost;
                case "grass" :
                    return  R.drawable.grass;
                case "ground" :
                    return R.drawable.ground;
                case "ice" :
                    return  R.drawable.ice;
                case "normal" :
                    return R.drawable.normal;
                case "poison" :
                    return  R.drawable.poisson;
                case "psychic" :
                    return R.drawable.psychic;
                case "rock" :
                    return  R.drawable.rock;
                case "steel" :
                    return R.drawable.steel;
                case "water" :
                    return  R.drawable.water;
                default:
                    return 0 ;
            }
        }
        private void asignaNumero(int n) {
            String num = "N";
            if((n/100)>=1){
                num+=n;
            }else{
                if((n/10)>=1){
                    num+="0"+n;
                }else{
                    num+="00"+n;
                }
            }
            numeroPokemonDetalles.setText(num);
        }
    }
    private void setUpToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showHomeUpIcon();
        setUpHomeIcon(R.drawable.pokeball);
        customTitleToolBar();
    }
    private void showHomeUpIcon() {
        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    public void setUpHomeIcon(int upHomeIcon) {
        if(getSupportActionBar()!= null){
            final Drawable icon = getResources().getDrawable(upHomeIcon);
            // Linea  para cambiar el color de un icono de la toolbar recomendado para elementos monocromaticos
            //icon.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(icon);
        }
    }
    public boolean onSupportNavigateUp() {
        Intent i = new Intent(this,MainActivity.class);
        this.startActivity(i);
        return true;
    }
    private void customTitleToolBar(){
        if (getSupportActionBar() != null) {
            //Ocultamos el titulo por defecto de la Toolbar
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            TextView textView = toolbar.findViewById(R.id.titleToolbar);

        }
    }
}
