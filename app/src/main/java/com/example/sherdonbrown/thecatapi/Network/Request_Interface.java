package com.example.sherdonbrown.thecatapi.Network;


import com.example.sherdonbrown.thecatapi.ModelData.Objects;

import java.util.List;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

public interface Request_Interface {
  //  @Headers("x-api-key: " + "21a418cd-06af-4d27-9d0e-57b9db39d97e")
   // @Headers[“TheCatKey”] = "21a418cd-06af-4d27-9d0e-57b9db39d97e"
    //@GET(API_Request.CAT_URL)
    //@FormUrlEncoded
    //Observable<Objects> getCatList(@Query(value = "1", encoded = true));
  //  Observable<List<Objects>> getCatList();
   // Observable<Objects> getCatList();

    @Headers("x-api-key: " + "21a418cd-06af-4d27-9d0e-57b9db39d97e")
    @GET(API_Request.CAT_URL)
    //Observable<Objects> getListParams();

   // Observable<Objects> getListParams(@Query("category_ids") String id,
    //                                  @Query("limit") String limit,
     //                                 @Query("page") String page);

    Observable<List<Objects>> getListParams(@Query("category_ids") String id);
}//

