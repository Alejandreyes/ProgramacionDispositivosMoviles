package com.proyecto.alejandreyes.recuperacion.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.proyecto.alejandreyes.recuperacion.API.AffenpinscherRandom;
import com.proyecto.alejandreyes.recuperacion.API.AfricanRandomApi;
import com.proyecto.alejandreyes.recuperacion.API.AiredaleApi;
import com.proyecto.alejandreyes.recuperacion.API.BulldogRandomApi;
import com.proyecto.alejandreyes.recuperacion.API.RamdomRazas.*;
import com.proyecto.alejandreyes.recuperacion.MODELS.AffenpinscherResult;
import com.proyecto.alejandreyes.recuperacion.MODELS.AfricanResult;
import com.proyecto.alejandreyes.recuperacion.MODELS.AiredaleResult;
import com.proyecto.alejandreyes.recuperacion.MODELS.BulldogResult;
import com.proyecto.alejandreyes.recuperacion.MODELS.RandomResult.*;
import com.proyecto.alejandreyes.recuperacion.MODELS.RazasRecycler;
import com.proyecto.alejandreyes.recuperacion.R;
import com.proyecto.alejandreyes.recuperacion.layout.BreedActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;

public class ListaRazasAdapter extends RecyclerView.Adapter<ListaRazasAdapter.ViewHolder>
{
    private ArrayList<RazasRecycler> todasRazas ;
    private final String TAG = this.getClass().getName();
    private RazasRecycler razaActual;
    private Context context;

    public ListaRazasAdapter(Context context) {
        this.context = context;
        todasRazas = new ArrayList<>();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_razas, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        razaActual = todasRazas.get(i);

        holder.razaActual = razaActual;
        cargarImagen(razaActual.getNombreRaza(),holder);

    }

    /**
     * MEtodo que se encarga de cargar una imagen random de cualquier raza de perro
     * Por defecto carga en los componentes una imagen de un perro esperando a su dueño observando atravez de una ventana
     * @param nombreRaza
     * @param holder
     */
    private void cargarImagen(String nombreRaza, final ViewHolder  holder) {
        Retrofit retrofit ;
//        final RequestOptions  options = new RequestOptions()
//                .placeholder(R.drawable.perro_esperando)
//                ;
        switch (nombreRaza){
            case "affenpinscher":
                retrofit = new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                AffenpinscherRandom service = retrofit.create(AffenpinscherRandom.class);
                Call<AffenpinscherResult> call = service.getObjectData();
                call.enqueue(new Callback<AffenpinscherResult>() {
                    @Override
                    public void onResponse(Call<AffenpinscherResult> call, Response<AffenpinscherResult> response) {
                        AffenpinscherResult al = response.body();
                        Glide.with(context)
                                .load(al.getMessage())
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<AffenpinscherResult> call, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "bulldog":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                BulldogRandomApi serviceBulldog = retrofit.create(BulldogRandomApi.class);
                Call<BulldogResult> callBulldog = serviceBulldog.getObjectData();
                callBulldog.enqueue(new Callback<BulldogResult>() {
                    @Override
                    public void onResponse(Call<BulldogResult> call2, Response<BulldogResult> response2) {
                        BulldogResult al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<BulldogResult> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "african":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                AfricanRandomApi serviceAfrican = retrofit.create(AfricanRandomApi.class);
                Call<AfricanResult> callAfrican = serviceAfrican.getObjectData();
                callAfrican.enqueue(new Callback<AfricanResult>() {
                    @Override
                    public void onResponse(Call<AfricanResult> call2, Response<AfricanResult> response2) {
                        AfricanResult al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<AfricanResult> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "appenzeller":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RandomAppenzeller serviceAppenzeller = retrofit.create(RandomAppenzeller.class);
                Call<AppenzellerResults> callAppenzeller = serviceAppenzeller.getObjectData();
                callAppenzeller.enqueue(new Callback<AppenzellerResults>() {
                    @Override
                    public void onResponse(Call<AppenzellerResults> call2, Response<AppenzellerResults> response2) {
                        AppenzellerResults al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<AppenzellerResults> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "akita":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RandomAkita serviceAkita = retrofit.create(RandomAkita.class);
                Call<AkitaResults> callAkita = serviceAkita.getObjectData();
                callAkita.enqueue(new Callback<AkitaResults>() {
                    @Override
                    public void onResponse(Call<AkitaResults> call2, Response<AkitaResults> response2) {
                        AkitaResults al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<AkitaResults> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;
            case "airedale":
                retrofit =  new Retrofit.Builder()
                        .baseUrl("https://dog.ceo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                AiredaleApi serviceairedale = retrofit.create(AiredaleApi.class);
                Call<AiredaleResult> callairedale = serviceairedale.getObjectData();
                callairedale.enqueue(new Callback<AiredaleResult>() {
                    @Override
                    public void onResponse(Call<AiredaleResult> call2, Response<AiredaleResult> response2) {
                        AiredaleResult al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<AiredaleResult> call2, Throwable t) {
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
                Call<Resultbasenji> callbasenji = servicebasenji.getObjectData();
                callbasenji.enqueue(new Callback<Resultbasenji>() {
                    @Override
                    public void onResponse(Call<Resultbasenji> call2, Response<Resultbasenji> response2) {
                        Resultbasenji al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultbasenji> call2, Throwable t) {
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
                Call<Resultbeagle> callbeagle = servicebeagle.getObjectData();
                callbeagle.enqueue(new Callback<Resultbeagle>() {
                    @Override
                    public void onResponse(Call<Resultbeagle> call2, Response<Resultbeagle> response2) {
                        Resultbeagle al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultbeagle> call2, Throwable t) {
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
                Call<Resultbluetick> callbluetick = servicebluetick.getObjectData();
                callbluetick.enqueue(new Callback<Resultbluetick>() {
                    @Override
                    public void onResponse(Call<Resultbluetick> call2, Response<Resultbluetick> response2) {
                        Resultbluetick al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultbluetick> call2, Throwable t) {
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
                Call<Resultborzoi> callborzoi = serviceborzoi.getObjectData();
                callborzoi.enqueue(new Callback<Resultborzoi>() {
                    @Override
                    public void onResponse(Call<Resultborzoi> call2, Response<Resultborzoi> response2) {
                        Resultborzoi al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultborzoi> call2, Throwable t) {
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
                Call<Resultbouvier> callbouvier = servicebouvier.getObjectData();
                callbouvier.enqueue(new Callback<Resultbouvier>() {
                    @Override
                    public void onResponse(Call<Resultbouvier> call2, Response<Resultbouvier> response2) {
                        Resultbouvier al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultbouvier> call2, Throwable t) {
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
                Call<Resultboxer> callboxer = serviceboxer.getObjectData();
                callboxer.enqueue(new Callback<Resultboxer>() {
                    @Override
                    public void onResponse(Call<Resultboxer> call2, Response<Resultboxer> response2) {
                        Resultboxer al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultboxer> call2, Throwable t) {
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
                Call<Resultspaniel> callspaniel = servicespaniel.getObjectData();
                callspaniel.enqueue(new Callback<Resultspaniel>() {
                    @Override
                    public void onResponse(Call<Resultspaniel> call2, Response<Resultspaniel> response2) {
                        Resultspaniel al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultspaniel> call2, Throwable t) {
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
                Call<Resultbrabancon> callbrabancon = servicebrabancon.getObjectData();
                callbrabancon.enqueue(new Callback<Resultbrabancon>() {
                    @Override
                    public void onResponse(Call<Resultbrabancon> call2, Response<Resultbrabancon> response2) {
                        Resultbrabancon al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultbrabancon> call2, Throwable t) {
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
                Call<Resultbriard> callbriard = servicebriard.getObjectData();
                callbriard.enqueue(new Callback<Resultbriard>() {
                    @Override
                    public void onResponse(Call<Resultbriard> call2, Response<Resultbriard> response2) {
                        Resultbriard al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultbriard> call2, Throwable t) {
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
                Call<Resultbullterrier> callbullterrier = servicebullterrier.getObjectData();
                callbullterrier.enqueue(new Callback<Resultbullterrier>() {
                    @Override
                    public void onResponse(Call<Resultbullterrier> call2, Response<Resultbullterrier> response2) {
                        Resultbullterrier al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultbullterrier> call2, Throwable t) {
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
                Call<Resultcairn> callcairn = servicecairn.getObjectData();
                callcairn.enqueue(new Callback<Resultcairn>() {
                    @Override
                    public void onResponse(Call<Resultcairn> call2, Response<Resultcairn> response2) {
                        Resultcairn al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultcairn> call2, Throwable t) {
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
                Call<Resultcattledog> callcattledog = servicecattledog.getObjectData();
                callcattledog.enqueue(new Callback<Resultcattledog>() {
                    @Override
                    public void onResponse(Call<Resultcattledog> call2, Response<Resultcattledog> response2) {
                        Resultcattledog al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultcattledog> call2, Throwable t) {
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
                Call<Resultchihuahua> callchihuahua = servicechihuahua.getObjectData();
                callchihuahua.enqueue(new Callback<Resultchihuahua>() {
                    @Override
                    public void onResponse(Call<Resultchihuahua> call2, Response<Resultchihuahua> response2) {
                        Resultchihuahua al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultchihuahua> call2, Throwable t) {
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
                Call<Resultchow> callchow = servicechow.getObjectData();
                callchow.enqueue(new Callback<Resultchow>() {
                    @Override
                    public void onResponse(Call<Resultchow> call2, Response<Resultchow> response2) {
                        Resultchow al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultchow> call2, Throwable t) {
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
                Call<Resultclumber> callclumber = serviceclumber.getObjectData();
                callclumber.enqueue(new Callback<Resultclumber>() {
                    @Override
                    public void onResponse(Call<Resultclumber> call2, Response<Resultclumber> response2) {
                        Resultclumber al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultclumber> call2, Throwable t) {
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
                Call<Resultcockapoo> callcockapoo = servicecockapoo.getObjectData();
                callcockapoo.enqueue(new Callback<Resultcockapoo>() {
                    @Override
                    public void onResponse(Call<Resultcockapoo> call2, Response<Resultcockapoo> response2) {
                        Resultcockapoo al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultcockapoo> call2, Throwable t) {
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
                Call<Resultcollie> callcollie = servicecollie.getObjectData();
                callcollie.enqueue(new Callback<Resultcollie>() {
                    @Override
                    public void onResponse(Call<Resultcollie> call2, Response<Resultcollie> response2) {
                        Resultcollie al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultcollie> call2, Throwable t) {
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
                Call<Resultcoonhound> callcoonhound = servicecoonhound.getObjectData();
                callcoonhound.enqueue(new Callback<Resultcoonhound>() {
                    @Override
                    public void onResponse(Call<Resultcoonhound> call2, Response<Resultcoonhound> response2) {
                        Resultcoonhound al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultcoonhound> call2, Throwable t) {
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
                Call<Resultcorgi> callcorgi = servicecorgi.getObjectData();
                callcorgi.enqueue(new Callback<Resultcorgi>() {
                    @Override
                    public void onResponse(Call<Resultcorgi> call2, Response<Resultcorgi> response2) {
                        Resultcorgi al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultcorgi> call2, Throwable t) {
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
                Call<Resultcotondetulear> callcotondetulear = servicecotondetulear.getObjectData();
                callcotondetulear.enqueue(new Callback<Resultcotondetulear>() {
                    @Override
                    public void onResponse(Call<Resultcotondetulear> call2, Response<Resultcotondetulear> response2) {
                        Resultcotondetulear al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultcotondetulear> call2, Throwable t) {
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
                Call<Resultdachshund> calldachshund = servicedachshund.getObjectData();
                calldachshund.enqueue(new Callback<Resultdachshund>() {
                    @Override
                    public void onResponse(Call<Resultdachshund> call2, Response<Resultdachshund> response2) {
                        Resultdachshund al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultdachshund> call2, Throwable t) {
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
                Call<Resultdalmatian> calldalmatian = servicedalmatian.getObjectData();
                calldalmatian.enqueue(new Callback<Resultdalmatian>() {
                    @Override
                    public void onResponse(Call<Resultdalmatian> call2, Response<Resultdalmatian> response2) {
                        Resultdalmatian al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultdalmatian> call2, Throwable t) {
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
                Call<Resultdane> calldane = servicedane.getObjectData();
                calldane.enqueue(new Callback<Resultdane>() {
                    @Override
                    public void onResponse(Call<Resultdane> call2, Response<Resultdane> response2) {
                        Resultdane al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultdane> call2, Throwable t) {
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
                Call<Resultdeerhound> calldeerhound = servicedeerhound.getObjectData();
                calldeerhound.enqueue(new Callback<Resultdeerhound>() {
                    @Override
                    public void onResponse(Call<Resultdeerhound> call2, Response<Resultdeerhound> response2) {
                        Resultdeerhound al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultdeerhound> call2, Throwable t) {
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
                Call<Resultdhole> calldhole = servicedhole.getObjectData();
                calldhole.enqueue(new Callback<Resultdhole>() {
                    @Override
                    public void onResponse(Call<Resultdhole> call2, Response<Resultdhole> response2) {
                        Resultdhole al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultdhole> call2, Throwable t) {
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
                Call<Resultdingo> calldingo = servicedingo.getObjectData();
                calldingo.enqueue(new Callback<Resultdingo>() {
                    @Override
                    public void onResponse(Call<Resultdingo> call2, Response<Resultdingo> response2) {
                        Resultdingo al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultdingo> call2, Throwable t) {
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
                Call<Resultdoberman> calldoberman = servicedoberman.getObjectData();
                calldoberman.enqueue(new Callback<Resultdoberman>() {
                    @Override
                    public void onResponse(Call<Resultdoberman> call2, Response<Resultdoberman> response2) {
                        Resultdoberman al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultdoberman> call2, Throwable t) {
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
                Call<Resultelkhound> callelkhound = serviceelkhound.getObjectData();
                callelkhound.enqueue(new Callback<Resultelkhound>() {
                    @Override
                    public void onResponse(Call<Resultelkhound> call2, Response<Resultelkhound> response2) {
                        Resultelkhound al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultelkhound> call2, Throwable t) {
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
                Call<Resultentlebucher> callentlebucher = serviceentlebucher.getObjectData();
                callentlebucher.enqueue(new Callback<Resultentlebucher>() {
                    @Override
                    public void onResponse(Call<Resultentlebucher> call2, Response<Resultentlebucher> response2) {
                        Resultentlebucher al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultentlebucher> call2, Throwable t) {
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
                Call<Resulteskimo> calleskimo = serviceeskimo.getObjectData();
                calleskimo.enqueue(new Callback<Resulteskimo>() {
                    @Override
                    public void onResponse(Call<Resulteskimo> call2, Response<Resulteskimo> response2) {
                        Resulteskimo al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resulteskimo> call2, Throwable t) {
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
                Call<Resultfrise> callfrise = servicefrise.getObjectData();
                callfrise.enqueue(new Callback<Resultfrise>() {
                    @Override
                    public void onResponse(Call<Resultfrise> call2, Response<Resultfrise> response2) {
                        Resultfrise al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultfrise> call2, Throwable t) {
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
                Call<Resultgermanshepherd> callgermanshepherd = servicegermanshepherd.getObjectData();
                callgermanshepherd.enqueue(new Callback<Resultgermanshepherd>() {
                    @Override
                    public void onResponse(Call<Resultgermanshepherd> call2, Response<Resultgermanshepherd> response2) {
                        Resultgermanshepherd al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultgermanshepherd> call2, Throwable t) {
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
                Call<Resultgreyhound> callgreyhound = servicegreyhound.getObjectData();
                callgreyhound.enqueue(new Callback<Resultgreyhound>() {
                    @Override
                    public void onResponse(Call<Resultgreyhound> call2, Response<Resultgreyhound> response2) {
                        Resultgreyhound al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultgreyhound> call2, Throwable t) {
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
                Call<Resultgroenendael> callgroenendael = servicegroenendael.getObjectData();
                callgroenendael.enqueue(new Callback<Resultgroenendael>() {
                    @Override
                    public void onResponse(Call<Resultgroenendael> call2, Response<Resultgroenendael> response2) {
                        Resultgroenendael al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultgroenendael> call2, Throwable t) {
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
                Call<Resulthound> callhound = servicehound.getObjectData();
                callhound.enqueue(new Callback<Resulthound>() {
                    @Override
                    public void onResponse(Call<Resulthound> call2, Response<Resulthound> response2) {
                        Resulthound al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resulthound> call2, Throwable t) {
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
                Call<Resulthusky> callhusky = servicehusky.getObjectData();
                callhusky.enqueue(new Callback<Resulthusky>() {
                    @Override
                    public void onResponse(Call<Resulthusky> call2, Response<Resulthusky> response2) {
                        Resulthusky al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resulthusky> call2, Throwable t) {
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
                Call<Resultkeeshond> callkeeshond = servicekeeshond.getObjectData();
                callkeeshond.enqueue(new Callback<Resultkeeshond>() {
                    @Override
                    public void onResponse(Call<Resultkeeshond> call2, Response<Resultkeeshond> response2) {
                        Resultkeeshond al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultkeeshond> call2, Throwable t) {
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
                Call<Resultkelpie> callkelpie = servicekelpie.getObjectData();
                callkelpie.enqueue(new Callback<Resultkelpie>() {
                    @Override
                    public void onResponse(Call<Resultkelpie> call2, Response<Resultkelpie> response2) {
                        Resultkelpie al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultkelpie> call2, Throwable t) {
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
                Call<Resultkomondor> callkomondor = servicekomondor.getObjectData();
                callkomondor.enqueue(new Callback<Resultkomondor>() {
                    @Override
                    public void onResponse(Call<Resultkomondor> call2, Response<Resultkomondor> response2) {
                        Resultkomondor al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultkomondor> call2, Throwable t) {
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
                Call<Resultkuvasz> callkuvasz = servicekuvasz.getObjectData();
                callkuvasz.enqueue(new Callback<Resultkuvasz>() {
                    @Override
                    public void onResponse(Call<Resultkuvasz> call2, Response<Resultkuvasz> response2) {
                        Resultkuvasz al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultkuvasz> call2, Throwable t) {
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
                Call<Resultlabrador> calllabrador = servicelabrador.getObjectData();
                calllabrador.enqueue(new Callback<Resultlabrador>() {
                    @Override
                    public void onResponse(Call<Resultlabrador> call2, Response<Resultlabrador> response2) {
                        Resultlabrador al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultlabrador> call2, Throwable t) {
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
                Call<Resultleonberg> callleonberg = serviceleonberg.getObjectData();
                callleonberg.enqueue(new Callback<Resultleonberg>() {
                    @Override
                    public void onResponse(Call<Resultleonberg> call2, Response<Resultleonberg> response2) {
                        Resultleonberg al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultleonberg> call2, Throwable t) {
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
                Call<Resultlhasa> calllhasa = servicelhasa.getObjectData();
                calllhasa.enqueue(new Callback<Resultlhasa>() {
                    @Override
                    public void onResponse(Call<Resultlhasa> call2, Response<Resultlhasa> response2) {
                        Resultlhasa al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultlhasa> call2, Throwable t) {
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
                Call<Resultmalamute> callmalamute = servicemalamute.getObjectData();
                callmalamute.enqueue(new Callback<Resultmalamute>() {
                    @Override
                    public void onResponse(Call<Resultmalamute> call2, Response<Resultmalamute> response2) {
                        Resultmalamute al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultmalamute> call2, Throwable t) {
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
                Call<Resultmalinois> callmalinois = servicemalinois.getObjectData();
                callmalinois.enqueue(new Callback<Resultmalinois>() {
                    @Override
                    public void onResponse(Call<Resultmalinois> call2, Response<Resultmalinois> response2) {
                        Resultmalinois al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultmalinois> call2, Throwable t) {
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
                Call<Resultmaltese> callmaltese = servicemaltese.getObjectData();
                callmaltese.enqueue(new Callback<Resultmaltese>() {
                    @Override
                    public void onResponse(Call<Resultmaltese> call2, Response<Resultmaltese> response2) {
                        Resultmaltese al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultmaltese> call2, Throwable t) {
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
                Call<Resultmastiff> callmastiff = servicemastiff.getObjectData();
                callmastiff.enqueue(new Callback<Resultmastiff>() {
                    @Override
                    public void onResponse(Call<Resultmastiff> call2, Response<Resultmastiff> response2) {
                        Resultmastiff al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultmastiff> call2, Throwable t) {
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
                Call<Resultmexicanhairless> callmexicanhairless = servicemexicanhairless.getObjectData();
                callmexicanhairless.enqueue(new Callback<Resultmexicanhairless>() {
                    @Override
                    public void onResponse(Call<Resultmexicanhairless> call2, Response<Resultmexicanhairless> response2) {
                        Resultmexicanhairless al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultmexicanhairless> call2, Throwable t) {
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
                Call<Resultmix> callmix = servicemix.getObjectData();
                callmix.enqueue(new Callback<Resultmix>() {
                    @Override
                    public void onResponse(Call<Resultmix> call2, Response<Resultmix> response2) {
                        Resultmix al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultmix> call2, Throwable t) {
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
                Call<Resultmountain> callmountain = servicemountain.getObjectData();
                callmountain.enqueue(new Callback<Resultmountain>() {
                    @Override
                    public void onResponse(Call<Resultmountain> call2, Response<Resultmountain> response2) {
                        Resultmountain al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultmountain> call2, Throwable t) {
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
                Call<Resultnewfoundland> callnewfoundland = servicenewfoundland.getObjectData();
                callnewfoundland.enqueue(new Callback<Resultnewfoundland>() {
                    @Override
                    public void onResponse(Call<Resultnewfoundland> call2, Response<Resultnewfoundland> response2) {
                        Resultnewfoundland al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultnewfoundland> call2, Throwable t) {
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
                Call<Resultotterhound> callotterhound = serviceotterhound.getObjectData();
                callotterhound.enqueue(new Callback<Resultotterhound>() {
                    @Override
                    public void onResponse(Call<Resultotterhound> call2, Response<Resultotterhound> response2) {
                        Resultotterhound al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultotterhound> call2, Throwable t) {
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
                Call<Resultpapillon> callpapillon = servicepapillon.getObjectData();
                callpapillon.enqueue(new Callback<Resultpapillon>() {
                    @Override
                    public void onResponse(Call<Resultpapillon> call2, Response<Resultpapillon> response2) {
                        Resultpapillon al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpapillon> call2, Throwable t) {
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
                Call<Resultpekinese> callpekinese = servicepekinese.getObjectData();
                callpekinese.enqueue(new Callback<Resultpekinese>() {
                    @Override
                    public void onResponse(Call<Resultpekinese> call2, Response<Resultpekinese> response2) {
                        Resultpekinese al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpekinese> call2, Throwable t) {
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
                Call<Resultpembroke> callpembroke = servicepembroke.getObjectData();
                callpembroke.enqueue(new Callback<Resultpembroke>() {
                    @Override
                    public void onResponse(Call<Resultpembroke> call2, Response<Resultpembroke> response2) {
                        Resultpembroke al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpembroke> call2, Throwable t) {
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
                Call<Resultpinscher> callpinscher = servicepinscher.getObjectData();
                callpinscher.enqueue(new Callback<Resultpinscher>() {
                    @Override
                    public void onResponse(Call<Resultpinscher> call2, Response<Resultpinscher> response2) {
                        Resultpinscher al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpinscher> call2, Throwable t) {
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
                Call<Resultpointer> callpointer = servicepointer.getObjectData();
                callpointer.enqueue(new Callback<Resultpointer>() {
                    @Override
                    public void onResponse(Call<Resultpointer> call2, Response<Resultpointer> response2) {
                        Resultpointer al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpointer> call2, Throwable t) {
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
                Call<Resultpomeranian> callpomeranian = servicepomeranian.getObjectData();
                callpomeranian.enqueue(new Callback<Resultpomeranian>() {
                    @Override
                    public void onResponse(Call<Resultpomeranian> call2, Response<Resultpomeranian> response2) {
                        Resultpomeranian al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpomeranian> call2, Throwable t) {
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
                Call<Resultpoodle> callpoodle = servicepoodle.getObjectData();
                callpoodle.enqueue(new Callback<Resultpoodle>() {
                    @Override
                    public void onResponse(Call<Resultpoodle> call2, Response<Resultpoodle> response2) {
                        Resultpoodle al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpoodle> call2, Throwable t) {
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
                Call<Resultpug> callpug = servicepug.getObjectData();
                callpug.enqueue(new Callback<Resultpug>() {
                    @Override
                    public void onResponse(Call<Resultpug> call2, Response<Resultpug> response2) {
                        Resultpug al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpug> call2, Throwable t) {
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
                Call<Resultpuggle> callpuggle = servicepuggle.getObjectData();
                callpuggle.enqueue(new Callback<Resultpuggle>() {
                    @Override
                    public void onResponse(Call<Resultpuggle> call2, Response<Resultpuggle> response2) {
                        Resultpuggle al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpuggle> call2, Throwable t) {
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
                Call<Resultpyrenees> callpyrenees = servicepyrenees.getObjectData();
                callpyrenees.enqueue(new Callback<Resultpyrenees>() {
                    @Override
                    public void onResponse(Call<Resultpyrenees> call2, Response<Resultpyrenees> response2) {
                        Resultpyrenees al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultpyrenees> call2, Throwable t) {
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
                Call<Resultredbone> callredbone = serviceredbone.getObjectData();
                callredbone.enqueue(new Callback<Resultredbone>() {
                    @Override
                    public void onResponse(Call<Resultredbone> call2, Response<Resultredbone> response2) {
                        Resultredbone al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultredbone> call2, Throwable t) {
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
                Call<Resultretriever> callretriever = serviceretriever.getObjectData();
                callretriever.enqueue(new Callback<Resultretriever>() {
                    @Override
                    public void onResponse(Call<Resultretriever> call2, Response<Resultretriever> response2) {
                        Resultretriever al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultretriever> call2, Throwable t) {
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
                Call<Resultridgeback> callridgeback = serviceridgeback.getObjectData();
                callridgeback.enqueue(new Callback<Resultridgeback>() {
                    @Override
                    public void onResponse(Call<Resultridgeback> call2, Response<Resultridgeback> response2) {
                        Resultridgeback al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultridgeback> call2, Throwable t) {
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
                Call<Resultrottweiler> callrottweiler = servicerottweiler.getObjectData();
                callrottweiler.enqueue(new Callback<Resultrottweiler>() {
                    @Override
                    public void onResponse(Call<Resultrottweiler> call2, Response<Resultrottweiler> response2) {
                        Resultrottweiler al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultrottweiler> call2, Throwable t) {
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
                Call<Resultsaluki> callsaluki = servicesaluki.getObjectData();
                callsaluki.enqueue(new Callback<Resultsaluki>() {
                    @Override
                    public void onResponse(Call<Resultsaluki> call2, Response<Resultsaluki> response2) {
                        Resultsaluki al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultsaluki> call2, Throwable t) {
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
                Call<Resultsamoyed> callsamoyed = servicesamoyed.getObjectData();
                callsamoyed.enqueue(new Callback<Resultsamoyed>() {
                    @Override
                    public void onResponse(Call<Resultsamoyed> call2, Response<Resultsamoyed> response2) {
                        Resultsamoyed al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultsamoyed> call2, Throwable t) {
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
                Call<Resultschipperke> callschipperke = serviceschipperke.getObjectData();
                callschipperke.enqueue(new Callback<Resultschipperke>() {
                    @Override
                    public void onResponse(Call<Resultschipperke> call2, Response<Resultschipperke> response2) {
                        Resultschipperke al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultschipperke> call2, Throwable t) {
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
                Call<Resultschnauzer> callschnauzer = serviceschnauzer.getObjectData();
                callschnauzer.enqueue(new Callback<Resultschnauzer>() {
                    @Override
                    public void onResponse(Call<Resultschnauzer> call2, Response<Resultschnauzer> response2) {
                        Resultschnauzer al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultschnauzer> call2, Throwable t) {
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
                Call<Resultsetter> callsetter = servicesetter.getObjectData();
                callsetter.enqueue(new Callback<Resultsetter>() {
                    @Override
                    public void onResponse(Call<Resultsetter> call2, Response<Resultsetter> response2) {
                        Resultsetter al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultsetter> call2, Throwable t) {
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
                Call<Resultsheepdog> callsheepdog = servicesheepdog.getObjectData();
                callsheepdog.enqueue(new Callback<Resultsheepdog>() {
                    @Override
                    public void onResponse(Call<Resultsheepdog> call2, Response<Resultsheepdog> response2) {
                        Resultsheepdog al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultsheepdog> call2, Throwable t) {
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
                Call<Resultshiba> callshiba = serviceshiba.getObjectData();
                callshiba.enqueue(new Callback<Resultshiba>() {
                    @Override
                    public void onResponse(Call<Resultshiba> call2, Response<Resultshiba> response2) {
                        Resultshiba al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultshiba> call2, Throwable t) {
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
                Call<Resultshihtzu> callshihtzu = serviceshihtzu.getObjectData();
                callshihtzu.enqueue(new Callback<Resultshihtzu>() {
                    @Override
                    public void onResponse(Call<Resultshihtzu> call2, Response<Resultshihtzu> response2) {
                        Resultshihtzu al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultshihtzu> call2, Throwable t) {
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
                Call<Resultspringer> callspringer = servicespringer.getObjectData();
                callspringer.enqueue(new Callback<Resultspringer>() {
                    @Override
                    public void onResponse(Call<Resultspringer> call2, Response<Resultspringer> response2) {
                        Resultspringer al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultspringer> call2, Throwable t) {
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
                Call<Resultstbernard> callstbernard = servicestbernard.getObjectData();
                callstbernard.enqueue(new Callback<Resultstbernard>() {
                    @Override
                    public void onResponse(Call<Resultstbernard> call2, Response<Resultstbernard> response2) {
                        Resultstbernard al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultstbernard> call2, Throwable t) {
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
                Call<Resultterrier> callterrier = serviceterrier.getObjectData();
                callterrier.enqueue(new Callback<Resultterrier>() {
                    @Override
                    public void onResponse(Call<Resultterrier> call2, Response<Resultterrier> response2) {
                        Resultterrier al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultterrier> call2, Throwable t) {
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
                Call<Resultvizsla> callvizsla = servicevizsla.getObjectData();
                callvizsla.enqueue(new Callback<Resultvizsla>() {
                    @Override
                    public void onResponse(Call<Resultvizsla> call2, Response<Resultvizsla> response2) {
                        Resultvizsla al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultvizsla> call2, Throwable t) {
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
                Call<Resultweimaraner> callweimaraner = serviceweimaraner.getObjectData();
                callweimaraner.enqueue(new Callback<Resultweimaraner>() {
                    @Override
                    public void onResponse(Call<Resultweimaraner> call2, Response<Resultweimaraner> response2) {
                        Resultweimaraner al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultweimaraner> call2, Throwable t) {
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
                Call<Resultwhippet> callwhippet = servicewhippet.getObjectData();
                callwhippet.enqueue(new Callback<Resultwhippet>() {
                    @Override
                    public void onResponse(Call<Resultwhippet> call2, Response<Resultwhippet> response2) {
                        Resultwhippet al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultwhippet> call2, Throwable t) {
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
                Call<Resultwolfhound> callwolfhound = servicewolfhound.getObjectData();
                callwolfhound.enqueue(new Callback<Resultwolfhound>() {
                    @Override
                    public void onResponse(Call<Resultwolfhound> call2, Response<Resultwolfhound> response2) {
                        Resultwolfhound al2 = response2.body();
                        Glide.with(context)
                                .load(al2.getMessage())
                                //.apply(options)
                                .into(holder.perroRamdon);
                    }
                    @Override
                    public void onFailure(Call<Resultwolfhound> call2, Throwable t) {
                        Log.e(TAG, "onFailure: " );
                    }
                });
                break;

                default:
//                    Glide.with(context)
//                            //.load(R.drawable.perro_esperando)
//                            //.apply(options)
//                            .into(holder.perroRamdon);
                    break ;
        }
    }

    @Override
    public int getItemCount() {
        return todasRazas.size();
    }

    /**
     * Metodo para agregar la base de datos en una forma que pueda ser entendida por el recyclerview
     * @param temporal
     */
    public void setListaRazas(ArrayList<RazasRecycler> temporal) {
        todasRazas = temporal;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public RazasRecycler razaActual;
        private ImageView perroRamdon;
        private CardView tarjetas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            perroRamdon = itemView.findViewById(R.id.imagenRazas);
            //razaPerro = itemView.findViewById(R.id.nombreRazas);
            tarjetas = (CardView) itemView.findViewById(R.id.tarjetas);
            tarjetas.setOnClickListener(this);
        }

        /**
         * Metodo que nos ayuda a controlar el evento de clickear (presionar) una tarjeta
         * nos muetra el nombre de la raza de perro presionada y si tiene o no subrazas,
         * de tener las lista
         * @param v
         */
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tarjetas:
                    Intent intent = new Intent(v.getContext(),BreedActivity.class);
                    intent.putExtra("raza",razaActual.getNombreRaza());
                    intent.putExtra("subrazas",razaActual.getSubrazas());
                    v.getContext().startActivity(intent);
            }

        }
    }
}
