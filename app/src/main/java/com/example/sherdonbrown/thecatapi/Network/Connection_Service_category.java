package com.example.sherdonbrown.thecatapi.Network;

import com.example.sherdonbrown.thecatapi.ModelData.Objects;
import com.example.sherdonbrown.thecatapi.ModelData.Objects_Conteg;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class Connection_Service_category implements Category_Interface{

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public Connection_Service_category() {getConnectionCateg();}

    public static Request_Interface_Conteg getConnectionCateg(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okHttpClient)
                .baseUrl(API_Request.BASE_URL).build();

        return retrofit.create(Request_Interface_Conteg.class);
    }




    @Override
    public Observable<List<Objects_Conteg>> getCategories() {
        return getConnectionCateg().getCategories("",
                "");
    }
}
