package com.proyecto.alejandreyes.recuperacion.API;

import com.proyecto.alejandreyes.recuperacion.MODELS.AiredaleResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AiredaleApi {
    @GET("api/breed/airedale/images/random")
    Call<AiredaleResult> getObjectData();
}
