package com.proyecto.alejandreyes.recuperacion.API;

import com.proyecto.alejandreyes.recuperacion.MODELS.AffenpinscherResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AffenpinscherRandom {
    @GET("api/breed/affenpinscher/images/random")
    Call<AffenpinscherResult> getObjectData();
}
