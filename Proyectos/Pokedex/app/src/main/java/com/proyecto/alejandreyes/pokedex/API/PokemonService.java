package com.proyecto.alejandreyes.pokedex.API;

import com.proyecto.alejandreyes.pokedex.modelo.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Pride on 16/11/2018.
 */

public interface PokemonService {
    @GET("pokemon")
    //Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit")int limit, @Query("offset")int offset);
    Call<PokemonRespuesta> obtenerListaPokemon();
}
