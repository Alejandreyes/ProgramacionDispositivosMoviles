package com.proyecto.alejandreyes.pokedex.Activity;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.proyecto.alejandreyes.pokedex.API.PokemonService;
import com.proyecto.alejandreyes.pokedex.API.ListaPokemonAdapter;
import com.proyecto.alejandreyes.pokedex.R;
import com.proyecto.alejandreyes.pokedex.modelo.Pokemon;
import com.proyecto.alejandreyes.pokedex.modelo.PokemonRespuesta;

import java.util.ArrayList;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Retrofit retrofit;
    private static final String TAG = "MAINACTIVITY";
    //private ArrayList<Pokemon> pokemons;
    private RecyclerView recyclerView;
    private ListaPokemonAdapter listaPokemonAdapter;

    private int offset;
    private boolean aptoParaCargar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaPokemonAdapter = new ListaPokemonAdapter(this);
        recyclerView.setAdapter(listaPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        int orientation = getResources().getConfiguration().orientation;
        //GridLayoutManager layoutManager =  new GridLayoutManager(this, 3);;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            final GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (dy >0){
                        int visibleItemCount = layoutManager.getChildCount();
                        int totalItemCount = layoutManager.getItemCount();
                        int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                        if(aptoParaCargar) {
                            if ((visibleItemCount +pastVisibleItems ) >= totalItemCount) {
                                aptoParaCargar = false;
                                offset += 20;
                                obtenerDatos(offset);
                            }
                        }
                    }
                }
            });
        } else {
            final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (dy >0){
                        int visibleItemCount = layoutManager.getChildCount();
                        int totalItemCount = layoutManager.getItemCount();
                        int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                        if(aptoParaCargar) {
                            if ((visibleItemCount +pastVisibleItems ) >= totalItemCount) {
                                aptoParaCargar = false;
                                offset += 20;
                                obtenerDatos(offset);
                            }
                        }
                    }
                }
            });
        }
        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;
        offset = 0;
        obtenerDatos(offset);
        setUpToolBar();
    }

    /**
     * Metodo que sirve para ejecutar el codigo de retrofit
     * @param offset
     */
    private void obtenerDatos(int offset) {
        PokemonService service = retrofit.create(PokemonService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon(20,offset);

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                aptoParaCargar = true;
                if(response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta = response.body();
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();
                    listaPokemonAdapter.adicionarListaPokemon(listaPokemon);
                } else
                    Log.e(TAG, " on response "+ response.errorBody());
            }
            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                aptoParaCargar = true;
                Log.e(TAG," on Failure "+ t.getMessage());
            }
        });
    }

    /**
     * Metodo que sirve para inflar el menu (Agregar el menu y sus respectivos elementos)
     */
    private void setUpToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showHomeUpIcon();
        setUpHomeIcon(R.drawable.pokeball);
        customTitleToolBar();
    }

    /**
     * Metodo que sirve para poder mostrar un icono
     */
    private void showHomeUpIcon() {
        if(getSupportActionBar()!= null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Metodo que agrega la informacion al menu
     * @param upHomeIcon id del icono de la barra
     */
    public void setUpHomeIcon(int upHomeIcon) {
        if(getSupportActionBar()!= null){
            final Drawable icon = getResources().getDrawable(upHomeIcon);
            // Linea  para cambiar el color de un icono de la toolbar recomendado para elementos monocromaticos
            //icon.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(icon);
        }
    }
    //Nos crea el menú de opciones en la Action Bar y aparecen los tres puntos
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //menuIconColor(menu, R.color.colorWhiteApp);
        MenuItem searchItem = menu.findItem(R.id.busqueda);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String textoFiltrado) {
                listaPokemonAdapter.getFilter().filter(textoFiltrado);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.busqueda:
                Log.e(TAG, "homeButton - onOptionsItemSelected");
                break;
            case R.id.tema:
                Log.e(TAG, "tema - onOptionsItemSelected");
                break;
            default:
                //Error Desconocido
        }
        return super.onOptionsItemSelected(item);
    }

    //Se ejecuta cuando se pulsa el boton Navigate Up
    // En este caso no se ejecutaria ninguna accion porque el funcionamiento de este boton es regresar al activity main
    @Override
    public boolean onSupportNavigateUp() {
        //Log.e("TAG", "homeButton - onSupportNavigateUp");
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
