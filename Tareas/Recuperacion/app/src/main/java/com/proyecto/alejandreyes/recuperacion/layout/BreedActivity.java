package com.proyecto.alejandreyes.recuperacion.layout;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.proyecto.alejandreyes.recuperacion.API.ByBreedAPI.*;
import com.proyecto.alejandreyes.recuperacion.API.BySubBreedAPI.*;
import com.proyecto.alejandreyes.recuperacion.Adaptadores.ActionListener;
import com.proyecto.alejandreyes.recuperacion.Adaptadores.ListaByBreedAdapter;
import com.proyecto.alejandreyes.recuperacion.MODELS.AllBreeds;
import com.proyecto.alejandreyes.recuperacion.MODELS.ByBreed;
import com.proyecto.alejandreyes.recuperacion.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;

public class BreedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView raza;
    private Spinner subraza;
    private RecyclerView recyclerView ;
    private ListaByBreedAdapter listaByBreedAdapter;

    private String url ="https://dog.ceo/";
    private ActionListener actionListener;
    private String razaAux;
    private ArrayList<String> subRazaAux;

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public ListaByBreedAdapter getListaByBreedAdapter() {
        return listaByBreedAdapter;
    }

    public void setListaByBreedAdapter(ListaByBreedAdapter listaByBreedAdapter) {
        this.listaByBreedAdapter = listaByBreedAdapter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRazaAux() {
        return razaAux;
    }

    public void setRazaAux(String razaAux) {
        this.razaAux = razaAux;
    }

    public ArrayList<String> getSubRazaAux() {
        return subRazaAux;
    }

    public void setSubRazaAux(ArrayList<String> subRazaAux) {
        this.subRazaAux = subRazaAux;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed);
        Intent intent = getIntent();
        razaAux =  intent.getStringExtra("raza");
        subRazaAux =intent.getStringArrayListExtra("subrazas") ;
        raza = findViewById(R.id.raza);
        subraza = findViewById(R.id.subrazas);
        if(subRazaAux.size() == 0){
            subRazaAux = new ArrayList<String>();
            subRazaAux.add(0,"No tiene Subrazas");
        }else{
            subRazaAux.add(0,"Selecciona Subraza");
        }
        raza.setText(razaAux);
        recyclerView = findViewById(R.id.recyclerView);
        listaByBreedAdapter = new ListaByBreedAdapter(this);
        recyclerView.setAdapter(listaByBreedAdapter);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(layoutManager);
        }
        recyclerView.setHasFixedSize(true);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,subRazaAux);
        subraza.setAdapter(adapter);

        actionListener = new ActionListener(this);
        subraza.setOnItemSelectedListener(actionListener);
        cargarInfo(razaAux);
    }
    private void cargarInfo(String nombreRaza) {
        Retrofit retrofit ;
//        final RequestOptions options = new RequestOptions()
//                .placeholder(R.drawable.perro_esperando)
//                .dontAnimate()
//                .dontTransform();
        switch (nombreRaza){
            case "affenpinscher":
                retrofit = new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomaffenpinscher service = retrofit.create(Randomaffenpinscher.class);
                Call<ByBreed> call = service.getObjectData();
                call.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call, Response<ByBreed> response) {
                        ByBreed al = response.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }

                    @Override
                    public void onFailure(Call<ByBreed> call, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "bulldog":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombulldog serviceBulldog = retrofit.create(Randombulldog.class);
                Call<ByBreed> callBulldog = serviceBulldog.getObjectData();
                callBulldog.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "african":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomafrican serviceAfrican = retrofit.create(Randomafrican.class);
                Call<ByBreed> callAfrican = serviceAfrican.getObjectData();
                callAfrican.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "appenzeller":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomappenzeller serviceAppenzeller = retrofit.create(Randomappenzeller.class);
                Call<ByBreed> callAppenzeller = serviceAppenzeller.getObjectData();
                callAppenzeller.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "akita":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomakita serviceAkita = retrofit.create(Randomakita.class);
                Call<ByBreed> callAkita = serviceAkita.getObjectData();
                callAkita.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "airedale":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomairedale serviceairedale = retrofit.create(Randomairedale.class);
                Call<ByBreed> callairedale = serviceairedale.getObjectData();
                callairedale.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "basenji":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombasenji servicebasenji = retrofit.create(Randombasenji.class);
                Call<ByBreed> callbasenji = servicebasenji.getObjectData();
                callbasenji.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "beagle":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombeagle servicebeagle = retrofit.create(Randombeagle.class);
                Call<ByBreed> callbeagle = servicebeagle.getObjectData();
                callbeagle.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "bluetick":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombluetick servicebluetick = retrofit.create(Randombluetick.class);
                Call<ByBreed> callbluetick = servicebluetick.getObjectData();
                callbluetick.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "borzoi":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomborzoi serviceborzoi = retrofit.create(Randomborzoi.class);
                Call<ByBreed> callborzoi = serviceborzoi.getObjectData();
                callborzoi.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "bouvier":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombouvier servicebouvier = retrofit.create(Randombouvier.class);
                Call<ByBreed> callbouvier = servicebouvier.getObjectData();
                callbouvier.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "boxer":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomboxer serviceboxer = retrofit.create(Randomboxer.class);
                Call<ByBreed> callboxer = serviceboxer.getObjectData();
                callboxer.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "spaniel":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspaniel servicespaniel = retrofit.create(Randomspaniel.class);
                Call<ByBreed> callspaniel = servicespaniel.getObjectData();
                callspaniel.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "brabancon":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombrabancon servicebrabancon = retrofit.create(Randombrabancon.class);
                Call<ByBreed> callbrabancon = servicebrabancon.getObjectData();
                callbrabancon.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "briard":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombriard servicebriard = retrofit.create(Randombriard.class);
                Call<ByBreed> callbriard = servicebriard.getObjectData();
                callbriard.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "bullterrier":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombullterrier servicebullterrier = retrofit.create(Randombullterrier.class);
                Call<ByBreed> callbullterrier = servicebullterrier.getObjectData();
                callbullterrier.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "cairn":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcairn servicecairn = retrofit.create(Randomcairn.class);
                Call<ByBreed> callcairn = servicecairn.getObjectData();
                callcairn.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "cattledog":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcattledog servicecattledog = retrofit.create(Randomcattledog.class);
                Call<ByBreed> callcattledog = servicecattledog.getObjectData();
                callcattledog.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "chihuahua":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomchihuahua servicechihuahua = retrofit.create(Randomchihuahua.class);
                Call<ByBreed> callchihuahua = servicechihuahua.getObjectData();
                callchihuahua.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "chow":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomchow servicechow = retrofit.create(Randomchow.class);
                Call<ByBreed> callchow = servicechow.getObjectData();
                callchow.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "clumber":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomclumber serviceclumber = retrofit.create(Randomclumber.class);
                Call<ByBreed> callclumber = serviceclumber.getObjectData();
                callclumber.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "cockapoo":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcockapoo servicecockapoo = retrofit.create(Randomcockapoo.class);
                Call<ByBreed> callcockapoo = servicecockapoo.getObjectData();
                callcockapoo.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "collie":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcollie servicecollie = retrofit.create(Randomcollie.class);
                Call<ByBreed> callcollie = servicecollie.getObjectData();
                callcollie.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "coonhound":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcoonhound servicecoonhound = retrofit.create(Randomcoonhound.class);
                Call<ByBreed> callcoonhound = servicecoonhound.getObjectData();
                callcoonhound.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "corgi":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcorgi servicecorgi = retrofit.create(Randomcorgi.class);
                Call<ByBreed> callcorgi = servicecorgi.getObjectData();
                callcorgi.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "cotondetulear":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcotondetulear servicecotondetulear = retrofit.create(Randomcotondetulear.class);
                Call<ByBreed> callcotondetulear = servicecotondetulear.getObjectData();
                callcotondetulear.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "dachshund":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomdachshund servicedachshund = retrofit.create(Randomdachshund.class);
                Call<ByBreed> calldachshund = servicedachshund.getObjectData();
                calldachshund.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "dalmatian":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomdalmatian servicedalmatian = retrofit.create(Randomdalmatian.class);
                Call<ByBreed> calldalmatian = servicedalmatian.getObjectData();
                calldalmatian.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "dane":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomdane servicedane = retrofit.create(Randomdane.class);
                Call<ByBreed> calldane = servicedane.getObjectData();
                calldane.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "deerhound":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomdeerhound servicedeerhound = retrofit.create(Randomdeerhound.class);
                Call<ByBreed> calldeerhound = servicedeerhound.getObjectData();
                calldeerhound.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "dhole":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomdhole servicedhole = retrofit.create(Randomdhole.class);
                Call<ByBreed> calldhole = servicedhole.getObjectData();
                calldhole.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "dingo":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomdingo servicedingo = retrofit.create(Randomdingo.class);
                Call<ByBreed> calldingo = servicedingo.getObjectData();
                calldingo.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "doberman":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomdoberman servicedoberman = retrofit.create(Randomdoberman.class);
                Call<ByBreed> calldoberman = servicedoberman.getObjectData();
                calldoberman.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "elkhound":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomelkhound serviceelkhound = retrofit.create(Randomelkhound.class);
                Call<ByBreed> callelkhound = serviceelkhound.getObjectData();
                callelkhound.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "entlebucher":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomentlebucher serviceentlebucher = retrofit.create(Randomentlebucher.class);
                Call<ByBreed> callentlebucher = serviceentlebucher.getObjectData();
                callentlebucher.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "eskimo":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomeskimo serviceeskimo = retrofit.create(Randomeskimo.class);
                Call<ByBreed> calleskimo = serviceeskimo.getObjectData();
                calleskimo.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "frise":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomfrise servicefrise = retrofit.create(Randomfrise.class);
                Call<ByBreed> callfrise = servicefrise.getObjectData();
                callfrise.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "germanshepherd":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomgermanshepherd servicegermanshepherd = retrofit.create(Randomgermanshepherd.class);
                Call<ByBreed> callgermanshepherd = servicegermanshepherd.getObjectData();
                callgermanshepherd.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "greyhound":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomgreyhound servicegreyhound = retrofit.create(Randomgreyhound.class);
                Call<ByBreed> callgreyhound = servicegreyhound.getObjectData();
                callgreyhound.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "groenendael":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomgroenendael servicegroenendael = retrofit.create(Randomgroenendael.class);
                Call<ByBreed> callgroenendael = servicegroenendael.getObjectData();
                callgroenendael.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "hound":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomhound servicehound = retrofit.create(Randomhound.class);
                Call<ByBreed> callhound = servicehound.getObjectData();
                callhound.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "husky":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomhusky servicehusky = retrofit.create(Randomhusky.class);
                Call<ByBreed> callhusky = servicehusky.getObjectData();
                callhusky.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "keeshond":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomkeeshond servicekeeshond = retrofit.create(Randomkeeshond.class);
                Call<ByBreed> callkeeshond = servicekeeshond.getObjectData();
                callkeeshond.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "kelpie":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomkelpie servicekelpie = retrofit.create(Randomkelpie.class);
                Call<ByBreed> callkelpie = servicekelpie.getObjectData();
                callkelpie.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "komondor":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomkomondor servicekomondor = retrofit.create(Randomkomondor.class);
                Call<ByBreed> callkomondor = servicekomondor.getObjectData();
                callkomondor.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "kuvasz":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomkuvasz servicekuvasz = retrofit.create(Randomkuvasz.class);
                Call<ByBreed> callkuvasz = servicekuvasz.getObjectData();
                callkuvasz.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "labrador":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomlabrador servicelabrador = retrofit.create(Randomlabrador.class);
                Call<ByBreed> calllabrador = servicelabrador.getObjectData();
                calllabrador.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "leonberg":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomleonberg serviceleonberg = retrofit.create(Randomleonberg.class);
                Call<ByBreed> callleonberg = serviceleonberg.getObjectData();
                callleonberg.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "lhasa":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomlhasa servicelhasa = retrofit.create(Randomlhasa.class);
                Call<ByBreed> calllhasa = servicelhasa.getObjectData();
                calllhasa.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "malamute":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommalamute servicemalamute = retrofit.create(Randommalamute.class);
                Call<ByBreed> callmalamute = servicemalamute.getObjectData();
                callmalamute.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "malinois":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommalinois servicemalinois = retrofit.create(Randommalinois.class);
                Call<ByBreed> callmalinois = servicemalinois.getObjectData();
                callmalinois.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "maltese":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommaltese servicemaltese = retrofit.create(Randommaltese.class);
                Call<ByBreed> callmaltese = servicemaltese.getObjectData();
                callmaltese.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "mastiff":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommastiff servicemastiff = retrofit.create(Randommastiff.class);
                Call<ByBreed> callmastiff = servicemastiff.getObjectData();
                callmastiff.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "mexicanhairless":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommexicanhairless servicemexicanhairless = retrofit.create(Randommexicanhairless.class);
                Call<ByBreed> callmexicanhairless = servicemexicanhairless.getObjectData();
                callmexicanhairless.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "mix":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommix servicemix = retrofit.create(Randommix.class);
                Call<ByBreed> callmix = servicemix.getObjectData();
                callmix.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "mountain":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommountain servicemountain = retrofit.create(Randommountain.class);
                Call<ByBreed> callmountain = servicemountain.getObjectData();
                callmountain.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "newfoundland":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomnewfoundland servicenewfoundland = retrofit.create(Randomnewfoundland.class);
                Call<ByBreed> callnewfoundland = servicenewfoundland.getObjectData();
                callnewfoundland.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "otterhound":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomotterhound serviceotterhound = retrofit.create(Randomotterhound.class);
                Call<ByBreed> callotterhound = serviceotterhound.getObjectData();
                callotterhound.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "papillon":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompapillon servicepapillon = retrofit.create(Randompapillon.class);
                Call<ByBreed> callpapillon = servicepapillon.getObjectData();
                callpapillon.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "pekinese":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompekinese servicepekinese = retrofit.create(Randompekinese.class);
                Call<ByBreed> callpekinese = servicepekinese.getObjectData();
                callpekinese.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "pembroke":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompembroke servicepembroke = retrofit.create(Randompembroke.class);
                Call<ByBreed> callpembroke = servicepembroke.getObjectData();
                callpembroke.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "pinscher":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompinscher servicepinscher = retrofit.create(Randompinscher.class);
                Call<ByBreed> callpinscher = servicepinscher.getObjectData();
                callpinscher.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "pointer":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompointer servicepointer = retrofit.create(Randompointer.class);
                Call<ByBreed> callpointer = servicepointer.getObjectData();
                callpointer.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "pomeranian":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompomeranian servicepomeranian = retrofit.create(Randompomeranian.class);
                Call<ByBreed> callpomeranian = servicepomeranian.getObjectData();
                callpomeranian.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "poodle":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompoodle servicepoodle = retrofit.create(Randompoodle.class);
                Call<ByBreed> callpoodle = servicepoodle.getObjectData();
                callpoodle.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "pug":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompug servicepug = retrofit.create(Randompug.class);
                Call<ByBreed> callpug = servicepug.getObjectData();
                callpug.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "puggle":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompuggle servicepuggle = retrofit.create(Randompuggle.class);
                Call<ByBreed> callpuggle = servicepuggle.getObjectData();
                callpuggle.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "pyrenees":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompyrenees servicepyrenees = retrofit.create(Randompyrenees.class);
                Call<ByBreed> callpyrenees = servicepyrenees.getObjectData();
                callpyrenees.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "redbone":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomredbone serviceredbone = retrofit.create(Randomredbone.class);
                Call<ByBreed> callredbone = serviceredbone.getObjectData();
                callredbone.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "retriever":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomretriever serviceretriever = retrofit.create(Randomretriever.class);
                Call<ByBreed> callretriever = serviceretriever.getObjectData();
                callretriever.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "ridgeback":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomridgeback serviceridgeback = retrofit.create(Randomridgeback.class);
                Call<ByBreed> callridgeback = serviceridgeback.getObjectData();
                callridgeback.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "rottweiler":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomrottweiler servicerottweiler = retrofit.create(Randomrottweiler.class);
                Call<ByBreed> callrottweiler = servicerottweiler.getObjectData();
                callrottweiler.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "saluki":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomsaluki servicesaluki = retrofit.create(Randomsaluki.class);
                Call<ByBreed> callsaluki = servicesaluki.getObjectData();
                callsaluki.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "samoyed":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomsamoyed servicesamoyed = retrofit.create(Randomsamoyed.class);
                Call<ByBreed> callsamoyed = servicesamoyed.getObjectData();
                callsamoyed.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "schipperke":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomschipperke serviceschipperke = retrofit.create(Randomschipperke.class);
                Call<ByBreed> callschipperke = serviceschipperke.getObjectData();
                callschipperke.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "schnauzer":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomschnauzer serviceschnauzer = retrofit.create(Randomschnauzer.class);
                Call<ByBreed> callschnauzer = serviceschnauzer.getObjectData();
                callschnauzer.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "setter":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomsetter servicesetter = retrofit.create(Randomsetter.class);
                Call<ByBreed> callsetter = servicesetter.getObjectData();
                callsetter.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "sheepdog":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomsheepdog servicesheepdog = retrofit.create(Randomsheepdog.class);
                Call<ByBreed> callsheepdog = servicesheepdog.getObjectData();
                callsheepdog.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "shiba":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomshiba serviceshiba = retrofit.create(Randomshiba.class);
                Call<ByBreed> callshiba = serviceshiba.getObjectData();
                callshiba.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "shihtzu":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomshihtzu serviceshihtzu = retrofit.create(Randomshihtzu.class);
                Call<ByBreed> callshihtzu = serviceshihtzu.getObjectData();
                callshihtzu.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "springer":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspringer servicespringer = retrofit.create(Randomspringer.class);
                Call<ByBreed> callspringer = servicespringer.getObjectData();
                callspringer.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "stbernard":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomstbernard servicestbernard = retrofit.create(Randomstbernard.class);
                Call<ByBreed> callstbernard = servicestbernard.getObjectData();
                callstbernard.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "terrier":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrier serviceterrier = retrofit.create(Randomterrier.class);
                Call<ByBreed> callterrier = serviceterrier.getObjectData();
                callterrier.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "vizsla":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomvizsla servicevizsla = retrofit.create(Randomvizsla.class);
                Call<ByBreed> callvizsla = servicevizsla.getObjectData();
                callvizsla.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "weimaraner":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomweimaraner serviceweimaraner = retrofit.create(Randomweimaraner.class);
                Call<ByBreed> callweimaraner = serviceweimaraner.getObjectData();
                callweimaraner.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "whippet":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomwhippet servicewhippet = retrofit.create(Randomwhippet.class);
                Call<ByBreed> callwhippet = servicewhippet.getObjectData();
                callwhippet.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "wolfhound":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomwolfhound servicewolfhound = retrofit.create(Randomwolfhound.class);
                Call<ByBreed> callwolfhound = servicewolfhound.getObjectData();
                callwolfhound.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            default:
                break ;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        cargarInfoSub(razaAux+"."+subRazaAux.get(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void cargarInfoSub(String nombreRaza) {
        final Context context = this  ;
        Retrofit retrofit ;
//        final RequestOptions options = new RequestOptions()
//                .placeholder(R.drawable.perro_esperando)
//                .dontAnimate()
//                .dontTransform();
        switch (nombreRaza){
            case "bulldog.boston":
                retrofit = new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombulldogboston service = retrofit.create(Randombulldogboston.class);
                Call<ByBreed> call = service.getObjectData();
                call.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call, Response<ByBreed> response) {
                        ByBreed al = response.body();
                        listaByBreedAdapter.replaceDataSet(al.getMessage());
                    }

                    @Override
                    public void onFailure(Call<ByBreed> call, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "bulldog.french":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombulldogfrench serviceBulldog = retrofit.create(Randombulldogfrench.class);
                Call<ByBreed> callBulldog = serviceBulldog.getObjectData();
                callBulldog.enqueue(new Callback<ByBreed>() {
                    @Override
                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
                        ByBreed al = response2.body();
                        listaByBreedAdapter.setPorRaza(al.getMessage());
                    }
                    @Override
                    public void onFailure(Call<ByBreed> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
//            case "african":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomafrican serviceAfrican = retrofit.create(Randomafrican.class);
//                Call<ByBreed> callAfrican = serviceAfrican.getObjectData();
//                callAfrican.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "appenzeller":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomappenzeller serviceAppenzeller = retrofit.create(Randomappenzeller.class);
//                Call<ByBreed> callAppenzeller = serviceAppenzeller.getObjectData();
//                callAppenzeller.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "akita":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomakita serviceAkita = retrofit.create(Randomakita.class);
//                Call<ByBreed> callAkita = serviceAkita.getObjectData();
//                callAkita.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "airedale":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomairedale serviceairedale = retrofit.create(Randomairedale.class);
//                Call<ByBreed> callairedale = serviceairedale.getObjectData();
//                callairedale.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "basenji":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randombasenji servicebasenji = retrofit.create(Randombasenji.class);
//                Call<ByBreed> callbasenji = servicebasenji.getObjectData();
//                callbasenji.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "beagle":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randombeagle servicebeagle = retrofit.create(Randombeagle.class);
//                Call<ByBreed> callbeagle = servicebeagle.getObjectData();
//                callbeagle.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "bluetick":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randombluetick servicebluetick = retrofit.create(Randombluetick.class);
//                Call<ByBreed> callbluetick = servicebluetick.getObjectData();
//                callbluetick.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "borzoi":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomborzoi serviceborzoi = retrofit.create(Randomborzoi.class);
//                Call<ByBreed> callborzoi = serviceborzoi.getObjectData();
//                callborzoi.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "bouvier":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randombouvier servicebouvier = retrofit.create(Randombouvier.class);
//                Call<ByBreed> callbouvier = servicebouvier.getObjectData();
//                callbouvier.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "boxer":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomboxer serviceboxer = retrofit.create(Randomboxer.class);
//                Call<ByBreed> callboxer = serviceboxer.getObjectData();
//                callboxer.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "spaniel":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomspaniel servicespaniel = retrofit.create(Randomspaniel.class);
//                Call<ByBreed> callspaniel = servicespaniel.getObjectData();
//                callspaniel.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "brabancon":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randombrabancon servicebrabancon = retrofit.create(Randombrabancon.class);
//                Call<ByBreed> callbrabancon = servicebrabancon.getObjectData();
//                callbrabancon.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "briard":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randombriard servicebriard = retrofit.create(Randombriard.class);
//                Call<ByBreed> callbriard = servicebriard.getObjectData();
//                callbriard.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "bullterrier":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randombullterrier servicebullterrier = retrofit.create(Randombullterrier.class);
//                Call<ByBreed> callbullterrier = servicebullterrier.getObjectData();
//                callbullterrier.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "cairn":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomcairn servicecairn = retrofit.create(Randomcairn.class);
//                Call<ByBreed> callcairn = servicecairn.getObjectData();
//                callcairn.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "cattledog":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomcattledog servicecattledog = retrofit.create(Randomcattledog.class);
//                Call<ByBreed> callcattledog = servicecattledog.getObjectData();
//                callcattledog.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "chihuahua":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomchihuahua servicechihuahua = retrofit.create(Randomchihuahua.class);
//                Call<ByBreed> callchihuahua = servicechihuahua.getObjectData();
//                callchihuahua.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "chow":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomchow servicechow = retrofit.create(Randomchow.class);
//                Call<ByBreed> callchow = servicechow.getObjectData();
//                callchow.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "clumber":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomclumber serviceclumber = retrofit.create(Randomclumber.class);
//                Call<ByBreed> callclumber = serviceclumber.getObjectData();
//                callclumber.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "cockapoo":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomcockapoo servicecockapoo = retrofit.create(Randomcockapoo.class);
//                Call<ByBreed> callcockapoo = servicecockapoo.getObjectData();
//                callcockapoo.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "collie":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomcollie servicecollie = retrofit.create(Randomcollie.class);
//                Call<ByBreed> callcollie = servicecollie.getObjectData();
//                callcollie.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "coonhound":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomcoonhound servicecoonhound = retrofit.create(Randomcoonhound.class);
//                Call<ByBreed> callcoonhound = servicecoonhound.getObjectData();
//                callcoonhound.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "corgi":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomcorgi servicecorgi = retrofit.create(Randomcorgi.class);
//                Call<ByBreed> callcorgi = servicecorgi.getObjectData();
//                callcorgi.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "cotondetulear":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomcotondetulear servicecotondetulear = retrofit.create(Randomcotondetulear.class);
//                Call<ByBreed> callcotondetulear = servicecotondetulear.getObjectData();
//                callcotondetulear.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "dachshund":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomdachshund servicedachshund = retrofit.create(Randomdachshund.class);
//                Call<ByBreed> calldachshund = servicedachshund.getObjectData();
//                calldachshund.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "dalmatian":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomdalmatian servicedalmatian = retrofit.create(Randomdalmatian.class);
//                Call<ByBreed> calldalmatian = servicedalmatian.getObjectData();
//                calldalmatian.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "dane":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomdane servicedane = retrofit.create(Randomdane.class);
//                Call<ByBreed> calldane = servicedane.getObjectData();
//                calldane.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "deerhound":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomdeerhound servicedeerhound = retrofit.create(Randomdeerhound.class);
//                Call<ByBreed> calldeerhound = servicedeerhound.getObjectData();
//                calldeerhound.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "dhole":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomdhole servicedhole = retrofit.create(Randomdhole.class);
//                Call<ByBreed> calldhole = servicedhole.getObjectData();
//                calldhole.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "dingo":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomdingo servicedingo = retrofit.create(Randomdingo.class);
//                Call<ByBreed> calldingo = servicedingo.getObjectData();
//                calldingo.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "doberman":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomdoberman servicedoberman = retrofit.create(Randomdoberman.class);
//                Call<ByBreed> calldoberman = servicedoberman.getObjectData();
//                calldoberman.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "elkhound":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomelkhound serviceelkhound = retrofit.create(Randomelkhound.class);
//                Call<ByBreed> callelkhound = serviceelkhound.getObjectData();
//                callelkhound.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "entlebucher":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomentlebucher serviceentlebucher = retrofit.create(Randomentlebucher.class);
//                Call<ByBreed> callentlebucher = serviceentlebucher.getObjectData();
//                callentlebucher.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "eskimo":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomeskimo serviceeskimo = retrofit.create(Randomeskimo.class);
//                Call<ByBreed> calleskimo = serviceeskimo.getObjectData();
//                calleskimo.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "frise":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomfrise servicefrise = retrofit.create(Randomfrise.class);
//                Call<ByBreed> callfrise = servicefrise.getObjectData();
//                callfrise.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "germanshepherd":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomgermanshepherd servicegermanshepherd = retrofit.create(Randomgermanshepherd.class);
//                Call<ByBreed> callgermanshepherd = servicegermanshepherd.getObjectData();
//                callgermanshepherd.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "greyhound":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomgreyhound servicegreyhound = retrofit.create(Randomgreyhound.class);
//                Call<ByBreed> callgreyhound = servicegreyhound.getObjectData();
//                callgreyhound.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "groenendael":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomgroenendael servicegroenendael = retrofit.create(Randomgroenendael.class);
//                Call<ByBreed> callgroenendael = servicegroenendael.getObjectData();
//                callgroenendael.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "hound":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomhound servicehound = retrofit.create(Randomhound.class);
//                Call<ByBreed> callhound = servicehound.getObjectData();
//                callhound.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "husky":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomhusky servicehusky = retrofit.create(Randomhusky.class);
//                Call<ByBreed> callhusky = servicehusky.getObjectData();
//                callhusky.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "keeshond":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomkeeshond servicekeeshond = retrofit.create(Randomkeeshond.class);
//                Call<ByBreed> callkeeshond = servicekeeshond.getObjectData();
//                callkeeshond.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "kelpie":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomkelpie servicekelpie = retrofit.create(Randomkelpie.class);
//                Call<ByBreed> callkelpie = servicekelpie.getObjectData();
//                callkelpie.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "komondor":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomkomondor servicekomondor = retrofit.create(Randomkomondor.class);
//                Call<ByBreed> callkomondor = servicekomondor.getObjectData();
//                callkomondor.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "kuvasz":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomkuvasz servicekuvasz = retrofit.create(Randomkuvasz.class);
//                Call<ByBreed> callkuvasz = servicekuvasz.getObjectData();
//                callkuvasz.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "labrador":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomlabrador servicelabrador = retrofit.create(Randomlabrador.class);
//                Call<ByBreed> calllabrador = servicelabrador.getObjectData();
//                calllabrador.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "leonberg":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomleonberg serviceleonberg = retrofit.create(Randomleonberg.class);
//                Call<ByBreed> callleonberg = serviceleonberg.getObjectData();
//                callleonberg.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "lhasa":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomlhasa servicelhasa = retrofit.create(Randomlhasa.class);
//                Call<ByBreed> calllhasa = servicelhasa.getObjectData();
//                calllhasa.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "malamute":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randommalamute servicemalamute = retrofit.create(Randommalamute.class);
//                Call<ByBreed> callmalamute = servicemalamute.getObjectData();
//                callmalamute.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "malinois":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randommalinois servicemalinois = retrofit.create(Randommalinois.class);
//                Call<ByBreed> callmalinois = servicemalinois.getObjectData();
//                callmalinois.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "maltese":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randommaltese servicemaltese = retrofit.create(Randommaltese.class);
//                Call<ByBreed> callmaltese = servicemaltese.getObjectData();
//                callmaltese.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "mastiff":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randommastiff servicemastiff = retrofit.create(Randommastiff.class);
//                Call<ByBreed> callmastiff = servicemastiff.getObjectData();
//                callmastiff.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "mexicanhairless":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randommexicanhairless servicemexicanhairless = retrofit.create(Randommexicanhairless.class);
//                Call<ByBreed> callmexicanhairless = servicemexicanhairless.getObjectData();
//                callmexicanhairless.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "mix":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randommix servicemix = retrofit.create(Randommix.class);
//                Call<ByBreed> callmix = servicemix.getObjectData();
//                callmix.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "mountain":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randommountain servicemountain = retrofit.create(Randommountain.class);
//                Call<ByBreed> callmountain = servicemountain.getObjectData();
//                callmountain.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "newfoundland":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomnewfoundland servicenewfoundland = retrofit.create(Randomnewfoundland.class);
//                Call<ByBreed> callnewfoundland = servicenewfoundland.getObjectData();
//                callnewfoundland.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "otterhound":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomotterhound serviceotterhound = retrofit.create(Randomotterhound.class);
//                Call<ByBreed> callotterhound = serviceotterhound.getObjectData();
//                callotterhound.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "papillon":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompapillon servicepapillon = retrofit.create(Randompapillon.class);
//                Call<ByBreed> callpapillon = servicepapillon.getObjectData();
//                callpapillon.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "pekinese":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompekinese servicepekinese = retrofit.create(Randompekinese.class);
//                Call<ByBreed> callpekinese = servicepekinese.getObjectData();
//                callpekinese.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "pembroke":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompembroke servicepembroke = retrofit.create(Randompembroke.class);
//                Call<ByBreed> callpembroke = servicepembroke.getObjectData();
//                callpembroke.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "pinscher":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompinscher servicepinscher = retrofit.create(Randompinscher.class);
//                Call<ByBreed> callpinscher = servicepinscher.getObjectData();
//                callpinscher.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "pointer":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompointer servicepointer = retrofit.create(Randompointer.class);
//                Call<ByBreed> callpointer = servicepointer.getObjectData();
//                callpointer.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "pomeranian":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompomeranian servicepomeranian = retrofit.create(Randompomeranian.class);
//                Call<ByBreed> callpomeranian = servicepomeranian.getObjectData();
//                callpomeranian.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "poodle":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompoodle servicepoodle = retrofit.create(Randompoodle.class);
//                Call<ByBreed> callpoodle = servicepoodle.getObjectData();
//                callpoodle.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "pug":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompug servicepug = retrofit.create(Randompug.class);
//                Call<ByBreed> callpug = servicepug.getObjectData();
//                callpug.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "puggle":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompuggle servicepuggle = retrofit.create(Randompuggle.class);
//                Call<ByBreed> callpuggle = servicepuggle.getObjectData();
//                callpuggle.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "pyrenees":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randompyrenees servicepyrenees = retrofit.create(Randompyrenees.class);
//                Call<ByBreed> callpyrenees = servicepyrenees.getObjectData();
//                callpyrenees.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "redbone":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomredbone serviceredbone = retrofit.create(Randomredbone.class);
//                Call<ByBreed> callredbone = serviceredbone.getObjectData();
//                callredbone.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "retriever":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomretriever serviceretriever = retrofit.create(Randomretriever.class);
//                Call<ByBreed> callretriever = serviceretriever.getObjectData();
//                callretriever.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "ridgeback":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomridgeback serviceridgeback = retrofit.create(Randomridgeback.class);
//                Call<ByBreed> callridgeback = serviceridgeback.getObjectData();
//                callridgeback.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "rottweiler":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomrottweiler servicerottweiler = retrofit.create(Randomrottweiler.class);
//                Call<ByBreed> callrottweiler = servicerottweiler.getObjectData();
//                callrottweiler.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "saluki":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomsaluki servicesaluki = retrofit.create(Randomsaluki.class);
//                Call<ByBreed> callsaluki = servicesaluki.getObjectData();
//                callsaluki.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "samoyed":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomsamoyed servicesamoyed = retrofit.create(Randomsamoyed.class);
//                Call<ByBreed> callsamoyed = servicesamoyed.getObjectData();
//                callsamoyed.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "schipperke":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomschipperke serviceschipperke = retrofit.create(Randomschipperke.class);
//                Call<ByBreed> callschipperke = serviceschipperke.getObjectData();
//                callschipperke.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "schnauzer":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomschnauzer serviceschnauzer = retrofit.create(Randomschnauzer.class);
//                Call<ByBreed> callschnauzer = serviceschnauzer.getObjectData();
//                callschnauzer.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "setter":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomsetter servicesetter = retrofit.create(Randomsetter.class);
//                Call<ByBreed> callsetter = servicesetter.getObjectData();
//                callsetter.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "sheepdog":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomsheepdog servicesheepdog = retrofit.create(Randomsheepdog.class);
//                Call<ByBreed> callsheepdog = servicesheepdog.getObjectData();
//                callsheepdog.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "shiba":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomshiba serviceshiba = retrofit.create(Randomshiba.class);
//                Call<ByBreed> callshiba = serviceshiba.getObjectData();
//                callshiba.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "shihtzu":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomshihtzu serviceshihtzu = retrofit.create(Randomshihtzu.class);
//                Call<ByBreed> callshihtzu = serviceshihtzu.getObjectData();
//                callshihtzu.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "springer":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomspringer servicespringer = retrofit.create(Randomspringer.class);
//                Call<ByBreed> callspringer = servicespringer.getObjectData();
//                callspringer.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "stbernard":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomstbernard servicestbernard = retrofit.create(Randomstbernard.class);
//                Call<ByBreed> callstbernard = servicestbernard.getObjectData();
//                callstbernard.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "terrier":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomterrier serviceterrier = retrofit.create(Randomterrier.class);
//                Call<ByBreed> callterrier = serviceterrier.getObjectData();
//                callterrier.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "vizsla":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomvizsla servicevizsla = retrofit.create(Randomvizsla.class);
//                Call<ByBreed> callvizsla = servicevizsla.getObjectData();
//                callvizsla.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "weimaraner":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomweimaraner serviceweimaraner = retrofit.create(Randomweimaraner.class);
//                Call<ByBreed> callweimaraner = serviceweimaraner.getObjectData();
//                callweimaraner.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "whippet":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomwhippet servicewhippet = retrofit.create(Randomwhippet.class);
//                Call<ByBreed> callwhippet = servicewhippet.getObjectData();
//                callwhippet.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
//            case "wolfhound":
//                retrofit =  new Retrofit.Builder()
//                        .baseUrl("https://dog.ceo/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                Randomwolfhound servicewolfhound = retrofit.create(Randomwolfhound.class);
//                Call<ByBreed> callwolfhound = servicewolfhound.getObjectData();
//                callwolfhound.enqueue(new Callback<ByBreed>() {
//                    @Override
//                    public void onResponse(Call<ByBreed> call2, Response<ByBreed> response2) {
//                        ByBreed al = response2.body();
//                        listaByBreedAdapter.setPorRaza(al.getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<ByBreed> call2, Throwable t) {
//                        Log.e(TAG, "onFailure: " );
//                    }
//                });
//                break;
            default:
                break ;
        }
    }
}
