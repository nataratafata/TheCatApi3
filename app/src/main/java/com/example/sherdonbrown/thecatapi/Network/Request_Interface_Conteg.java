package com.example.sherdonbrown.thecatapi.Network;

import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

public interface Request_Interface_Conteg {
    @Headers("x-api-key: " + "21a418cd-06af-4d27-9d0e-57b9db39d97e")
    @GET(API_Request.CAT_URL_Cateogri)

    Observable<List<Objects_Conteg>>getCategories(@Query("name") String name,
                                                  @Query("category_ids") String id);
}

