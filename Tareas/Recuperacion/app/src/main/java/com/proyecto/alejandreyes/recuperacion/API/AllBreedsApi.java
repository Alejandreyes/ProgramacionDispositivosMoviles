package com.proyecto.alejandreyes.recuperacion.API;

import com.proyecto.alejandreyes.recuperacion.MODELS.AllBreeds;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllBreedsApi {
    @GET("api/breeds/list/all")
    Call<AllBreeds> getObjectData();
}
