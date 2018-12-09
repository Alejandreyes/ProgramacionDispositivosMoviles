package com.proyecto.alejandreyes.recuperacion.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.proyecto.alejandreyes.recuperacion.MODELS.ByBreed;
import com.proyecto.alejandreyes.recuperacion.layout.BreedActivity;

import java.util.ArrayList;
import com.proyecto.alejandreyes.recuperacion.API.BySubBreedAPI.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActionListener extends BreedActivity
implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "ActionListener" ;
    BreedActivity activity;
    private RecyclerView recyclerView ;
    private ListaByBreedAdapter listaByBreedAdapter;
    private String url ="https://dog.ceo/";
    private String razaAux;
    private ArrayList<String> subRazaAux;
    private String nombreCompleto ;
    public ActionListener(BreedActivity breedActivity) {
        activity = breedActivity;
        recyclerView = activity.getRecyclerView();
        listaByBreedAdapter = activity.getListaByBreedAdapter();
        razaAux = activity.getRazaAux();
        nombreCompleto = razaAux;
        subRazaAux = activity.getSubRazaAux();
        Log.e(TAG, "ActionListener: "+subRazaAux.size() );
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(subRazaAux != null){
            if(!subRazaAux.isEmpty()){

                Log.e(TAG, "onItemSelected: "+nombreCompleto+"."+subRazaAux.get(i));
                cargarInfoSub(nombreCompleto+"."+subRazaAux.get(i));
            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    private void cargarInfoSub(String nombreRaza) {
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
                        listaByBreedAdapter.setPorRaza(al.getMessage());
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
            case "bullterrier.staffordshire":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randombullterrierstaffordshire servicebullterrier = retrofit.create(Randombullterrierstaffordshire.class);
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
            case "cattledog.australian":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcattledogaustralian servicecattledog = retrofit.create(Randomcattledogaustralian.class);
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
            case "collie.border":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcollieborder servicecollie = retrofit.create(Randomcollieborder.class);
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
            case "corgi.cardigan":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomcorgicardigan servicecorgi = retrofit.create(Randomcorgicardigan.class);
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
            case "dane.great":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomdanegreat servicedane = retrofit.create(Randomdanegreat.class);
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
            case "deerhound.scottish":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomdeerhoundscottish servicedeerhound = retrofit.create(Randomdeerhoundscottish.class);
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
            case "elkhound.norwegian":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomelkhoundnorwegian serviceelkhound = retrofit.create(Randomelkhoundnorwegian.class);
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
            case "frise.bichon":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomfrisebichon servicefrise = retrofit.create(Randomfrisebichon.class);
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
            case "greyhound.italian":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomgreyhounditalian servicegreyhound = retrofit.create(Randomgreyhounditalian.class);
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
            case "hound.afghan":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomhoundafghan servicehound = retrofit.create(Randomhoundafghan.class);
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
            case "hound.basset":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomhoundbasset servicehound1 = retrofit.create(Randomhoundbasset.class);
                Call<ByBreed> callhound1 = servicehound1.getObjectData();
                callhound1.enqueue(new Callback<ByBreed>() {
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
            case "hound.blood":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomhoundblood servicehound2 = retrofit.create(Randomhoundblood.class);
                Call<ByBreed> callhound2 = servicehound2.getObjectData();
                callhound2.enqueue(new Callback<ByBreed>() {
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
            case "hound.english":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomhoundenglish servicehound3 = retrofit.create(Randomhoundenglish.class);
                Call<ByBreed> callhound3 = servicehound3.getObjectData();
                callhound3.enqueue(new Callback<ByBreed>() {
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
            case "hound.ibizan":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomhoundibizan servicehound4 = retrofit.create(Randomhoundibizan.class);
                Call<ByBreed> callhound4 = servicehound4.getObjectData();
                callhound4.enqueue(new Callback<ByBreed>() {
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
            case "hound.walker":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomhoundwalker servicehound5 = retrofit.create(Randomhoundwalker.class);
                Call<ByBreed> callhound5 = servicehound5.getObjectData();
                callhound5.enqueue(new Callback<ByBreed>() {
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



            case "mastiff.bull":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommastiffbull servicemastiff = retrofit.create(Randommastiffbull.class);
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
            case "mastiff.tibetan":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommastifftibetan servicemastiff1 = retrofit.create(Randommastifftibetan.class);
                Call<ByBreed> callmastiff1 = servicemastiff1.getObjectData();
                callmastiff1.enqueue(new Callback<ByBreed>() {
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
            case "mountain.bernese":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommountainbernese servicemountain = retrofit.create(Randommountainbernese.class);
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
            case "mountain.swiss":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randommountainswiss servicemountainswiss = retrofit.create(Randommountainswiss.class);
                Call<ByBreed> callmountainswiss = servicemountainswiss.getObjectData();
                callmountainswiss.enqueue(new Callback<ByBreed>() {
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
            case "pinscher.miniature":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompinscherminiature servicepinscher = retrofit.create(Randompinscherminiature.class);
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
            case "pointer.german":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompointergerman servicepointergerman = retrofit.create(Randompointergerman.class);
                Call<ByBreed> callpointergerman = servicepointergerman.getObjectData();
                callpointergerman.enqueue(new Callback<ByBreed>() {
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
            case "pointer.germanlonghair":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompointergermanlonghair servicepointer = retrofit.create(Randompointergermanlonghair.class);
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
            case "poodle.miniature":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompoodleminiature servicepoodle = retrofit.create(Randompoodleminiature.class);
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
            case "poodle.standard":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompoodlestandard servicepoodlestandard = retrofit.create(Randompoodlestandard.class);
                Call<ByBreed> callpoodlestandard = servicepoodlestandard.getObjectData();
                callpoodlestandard.enqueue(new Callback<ByBreed>() {
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
            case "poodle.toy":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randompoodletoy servicepoodletoy = retrofit.create(Randompoodletoy.class);
                Call<ByBreed> callpoodletoy = servicepoodletoy.getObjectData();
                callpoodletoy.enqueue(new Callback<ByBreed>() {
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
            case "retriever.chesapeake":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomretrieverchesapeake serviceretriever = retrofit.create(Randomretrieverchesapeake.class);
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
            case "retriever.curly":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomretrievercurly serviceretrievercurly = retrofit.create(Randomretrievercurly.class);
                Call<ByBreed> callretrievercurly = serviceretrievercurly.getObjectData();
                callretrievercurly.enqueue(new Callback<ByBreed>() {
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
            case "retriever.flatcoated":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomretrieverflatcoated serviceretrieverflatcoated = retrofit.create(Randomretrieverflatcoated.class);
                Call<ByBreed> callretrieverflatcoated = serviceretrieverflatcoated.getObjectData();
                callretrieverflatcoated.enqueue(new Callback<ByBreed>() {
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
            case "retriever.golden":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomretrievergolden serviceretrievergolden = retrofit.create(Randomretrievergolden.class);
                Call<ByBreed> callretrievergolden = serviceretrievergolden.getObjectData();
                callretrievergolden.enqueue(new Callback<ByBreed>() {
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
            case "ridgeback.rhodesian":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomridgebackrhodesian serviceridgeback = retrofit.create(Randomridgebackrhodesian.class);
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
            case "schnauzer.giant":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomschnauzergiant serviceschnauzer = retrofit.create(Randomschnauzergiant.class);
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
            case "schnauzer.miniature":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomschnauzerminiature serviceschnauzerminiature = retrofit.create(Randomschnauzerminiature.class);
                Call<ByBreed> callschnauzerminiature = serviceschnauzerminiature.getObjectData();
                callschnauzerminiature.enqueue(new Callback<ByBreed>() {
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
            case "setter.english":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomsetterenglish servicesetter = retrofit.create(Randomsetterenglish.class);
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
            case "setter.gordon":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomsettergordon servicesettergordon = retrofit.create(Randomsettergordon.class);
                Call<ByBreed> callsettergordon = servicesettergordon.getObjectData();
                callsettergordon.enqueue(new Callback<ByBreed>() {
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
            case "setter.irish":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomsetterirish servicesetterirish = retrofit.create(Randomsetterirish.class);
                Call<ByBreed> callsetterirish = servicesetterirish.getObjectData();
                callsetterirish.enqueue(new Callback<ByBreed>() {
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
            case "sheepdog.english":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomsheepdogenglish servicesheepdog = retrofit.create(Randomsheepdogenglish.class);
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
            case "sheepdog.shetland":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomsheepdogshetland servicesheepdogshetland = retrofit.create(Randomsheepdogshetland.class);
                Call<ByBreed> callsheepdogshetland = servicesheepdogshetland.getObjectData();
                callsheepdogshetland.enqueue(new Callback<ByBreed>() {
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
            case "spaniel.blenheim":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspanielblenheim servicespaniel = retrofit.create(Randomspanielblenheim.class);
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

            case "spaniel.brittany":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspanielbrittany servicespanielbrittany = retrofit.create(Randomspanielbrittany.class);
                Call<ByBreed> callspanielbrittany = servicespanielbrittany.getObjectData();
                callspanielbrittany.enqueue(new Callback<ByBreed>() {
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

            case "spaniel.cocker":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspanielcocker servicespanielcocker = retrofit.create(Randomspanielcocker.class);
                Call<ByBreed> callspanielcocker = servicespanielcocker.getObjectData();
                callspanielcocker.enqueue(new Callback<ByBreed>() {
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

            case "spaniel.irish":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspanielirish servicespanielirish = retrofit.create(Randomspanielirish.class);
                Call<ByBreed> callspanielirish = servicespanielirish.getObjectData();
                callspanielirish.enqueue(new Callback<ByBreed>() {
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

            case "spaniel.japanese":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspanieljapanese servicespanieljapanese = retrofit.create(Randomspanieljapanese.class);
                Call<ByBreed> callspanieljapanese = servicespanieljapanese.getObjectData();
                callspanieljapanese.enqueue(new Callback<ByBreed>() {
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

            case "spaniel.sussex":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspanielsussex servicespanielsussex = retrofit.create(Randomspanielsussex.class);
                Call<ByBreed> callspanielsussex = servicespanielsussex.getObjectData();
                callspanielsussex.enqueue(new Callback<ByBreed>() {
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

            case "spaniel.welsh":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspanielwelsh servicespanielwelsh = retrofit.create(Randomspanielwelsh.class);
                Call<ByBreed> callspanielwelsh = servicespanielwelsh.getObjectData();
                callspanielwelsh.enqueue(new Callback<ByBreed>() {
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
            case "springer.english":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomspringerenglish servicespringer = retrofit.create(Randomspringerenglish.class);
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
            case "terrier.american":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrieramerican serviceterrier = retrofit.create(Randomterrieramerican.class);
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
            case "terrier.australian":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrieraustralian serviceterrieraustralian = retrofit.create(Randomterrieraustralian.class);
                Call<ByBreed> callterrieraustralian = serviceterrieraustralian.getObjectData();
                callterrieraustralian.enqueue(new Callback<ByBreed>() {
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
            case "terrier.bedlington":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierbedlington serviceterrierbedlington = retrofit.create(Randomterrierbedlington.class);
                Call<ByBreed> callterrierbedlington = serviceterrierbedlington.getObjectData();
                callterrierbedlington.enqueue(new Callback<ByBreed>() {
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
            case "terrier.border":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierborder serviceterrierborder = retrofit.create(Randomterrierborder.class);
                Call<ByBreed> callterrierborder = serviceterrierborder.getObjectData();
                callterrierborder.enqueue(new Callback<ByBreed>() {
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
            case "terrier.dandie":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierdandie serviceterrierdandie = retrofit.create(Randomterrierdandie.class);
                Call<ByBreed> callterrierdandie = serviceterrierdandie.getObjectData();
                callterrierdandie.enqueue(new Callback<ByBreed>() {
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
            case "terrier.fox":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierfox serviceterrierfox = retrofit.create(Randomterrierfox.class);
                Call<ByBreed> callterrierfox = serviceterrierfox.getObjectData();
                callterrierfox.enqueue(new Callback<ByBreed>() {
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
            case "terrier.irish":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierirish serviceterrierirish = retrofit.create(Randomterrierirish.class);
                Call<ByBreed> callterrierirish = serviceterrierirish.getObjectData();
                callterrierirish.enqueue(new Callback<ByBreed>() {
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
            case "terrier.kerryblue":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierkerryblue serviceterrierkerryblue = retrofit.create(Randomterrierkerryblue.class);
                Call<ByBreed> callterrierkerryblue = serviceterrierkerryblue.getObjectData();
                callterrierkerryblue.enqueue(new Callback<ByBreed>() {
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
            case "terrier.lakeland":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierlakeland serviceterrierlakeland = retrofit.create(Randomterrierlakeland.class);
                Call<ByBreed> callterrierlakeland = serviceterrierlakeland.getObjectData();
                callterrierlakeland.enqueue(new Callback<ByBreed>() {
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
            case "terrier.norfolk":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterriernorfolk serviceterriernorfolk = retrofit.create(Randomterriernorfolk.class);
                Call<ByBreed> callterriernorfolk = serviceterriernorfolk.getObjectData();
                callterriernorfolk.enqueue(new Callback<ByBreed>() {
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
            case "terrier.norwich":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterriernorwich serviceterriernorwich = retrofit.create(Randomterriernorwich.class);
                Call<ByBreed> callterriernorwich = serviceterriernorwich.getObjectData();
                callterriernorwich.enqueue(new Callback<ByBreed>() {
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
            case "terrier.patterdale":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierpatterdale serviceterrierpatterdale = retrofit.create(Randomterrierpatterdale.class);
                Call<ByBreed> callterrierpatterdale = serviceterrierpatterdale.getObjectData();
                callterrierpatterdale.enqueue(new Callback<ByBreed>() {
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
            case "terrier.russell":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierrussell serviceterrierrussell = retrofit.create(Randomterrierrussell.class);
                Call<ByBreed> callterrierrussell = serviceterrierrussell.getObjectData();
                callterrierrussell.enqueue(new Callback<ByBreed>() {
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
            case "terrier.scottish":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierscottish serviceterrierscottish = retrofit.create(Randomterrierscottish.class);
                Call<ByBreed> callterrierscottish = serviceterrierscottish.getObjectData();
                callterrierscottish.enqueue(new Callback<ByBreed>() {
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
            case "terrier.sealyham":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterriersealyham serviceterriersealyham = retrofit.create(Randomterriersealyham.class);
                Call<ByBreed> callterriersealyham = serviceterriersealyham.getObjectData();
                callterriersealyham.enqueue(new Callback<ByBreed>() {
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
            case "terrier.silky":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterriersilky serviceterriersilky = retrofit.create(Randomterriersilky.class);
                Call<ByBreed> callterriersilky = serviceterriersilky.getObjectData();
                callterriersilky.enqueue(new Callback<ByBreed>() {
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
            case "terrier.tibetan":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterriertibetan serviceterriertibetan = retrofit.create(Randomterriertibetan.class);
                Call<ByBreed> callterriertibetan = serviceterriertibetan.getObjectData();
                callterriertibetan.enqueue(new Callback<ByBreed>() {
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
            case "terrier.toy":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterriertoy serviceterriertoy = retrofit.create(Randomterriertoy.class);
                Call<ByBreed> callterriertoy = serviceterriertoy.getObjectData();
                callterriertoy.enqueue(new Callback<ByBreed>() {
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
            case "terrier.westhighland":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierwesthighland serviceterrierwesthighland = retrofit.create(Randomterrierwesthighland.class);
                Call<ByBreed> callterrierwesthighland = serviceterrierwesthighland.getObjectData();
                callterrierwesthighland.enqueue(new Callback<ByBreed>() {
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
            case "terrier.wheaten":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrierwheaten serviceterrierwheaten = retrofit.create(Randomterrierwheaten.class);
                Call<ByBreed> callterrierwheaten = serviceterrierwheaten.getObjectData();
                callterrierwheaten.enqueue(new Callback<ByBreed>() {
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
            case "terrier.yorkshire":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomterrieryorkshire serviceterrieryorkshire = retrofit.create(Randomterrieryorkshire.class);
                Call<ByBreed> callterrieryorkshire = serviceterrieryorkshire.getObjectData();
                callterrieryorkshire.enqueue(new Callback<ByBreed>() {
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
            case "wolfhound.irish":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Randomwolfhoundirish servicewolfhound = retrofit.create(Randomwolfhoundirish.class);
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
}
