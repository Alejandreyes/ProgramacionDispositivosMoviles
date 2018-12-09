package com.proyecto.alejandreyes.recuperacion.API;

import com.proyecto.alejandreyes.recuperacion.MODELS.AfricanResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AfricanRandomApi {
    @GET("api/breed/african/images/random")
    Call<AfricanResult> getObjectData();
}
