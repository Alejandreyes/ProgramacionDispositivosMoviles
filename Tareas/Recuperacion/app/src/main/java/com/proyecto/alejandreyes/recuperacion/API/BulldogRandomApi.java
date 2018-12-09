package com.proyecto.alejandreyes.recuperacion.API;

import com.proyecto.alejandreyes.recuperacion.MODELS.BulldogResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BulldogRandomApi {
    @GET("api/breed/bulldog/images/random")
    Call<BulldogResult> getObjectData();
}
