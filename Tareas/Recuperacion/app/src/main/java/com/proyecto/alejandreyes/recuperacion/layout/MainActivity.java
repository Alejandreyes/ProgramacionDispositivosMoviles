package com.proyecto.alejandreyes.recuperacion.layout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.proyecto.alejandreyes.recuperacion.API.AllBreedsApi;
import com.proyecto.alejandreyes.recuperacion.Adaptadores.ListaRazasAdapter;
import com.proyecto.alejandreyes.recuperacion.MODELS.AllBreeds;
import com.proyecto.alejandreyes.recuperacion.MODELS.RazasRecycler;
import com.proyecto.alejandreyes.recuperacion.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String url ="https://dog.ceo/";
    private static  final String  TAG = " Fragment" ;

    private RecyclerView recyclerView;
    private static Group pantallaPrincipal,carga;
    private ListaRazasAdapter listaRazasAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carga = findViewById(R.id.pantallaCarga);
        pantallaPrincipal = findViewById(R.id.pantallaPrincipal);
        recyclerView = findViewById(R.id.rvRazasFragment);
        listaRazasAdapter = new ListaRazasAdapter(this);
        recyclerView.setAdapter(listaRazasAdapter);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
            recyclerView.setLayoutManager(layoutManager);

        } else {
            final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(layoutManager);

        }
        recyclerView.setHasFixedSize(true);


        getRetrofitObject();
    }
    private void getRetrofitObject() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            AllBreedsApi service = retrofit.create(AllBreedsApi.class);
            Call<AllBreeds> call = service.getObjectData();
            call.enqueue(new Callback<AllBreeds>() {
                @Override
                public void onResponse(Call<AllBreeds> call, Response<AllBreeds> response) {

                    AllBreeds al = response.body();
                    ArrayList<RazasRecycler> temporal =  al.transformaObjetoLista();
                    listaRazasAdapter.setListaRazas(temporal);
                    liberarPantalla();
                }

                @Override
                public void onFailure(Call<AllBreeds> call, Throwable t) {


                    Log.e(TAG, "onFailure: " );
                }
            });

    }
    public void liberarPantalla() {
        carga.setVisibility(View.INVISIBLE);
        pantallaPrincipal.setVisibility(View.VISIBLE);
    }
}
