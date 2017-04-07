package com.example.nhungnguyen.firstproject.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copy right asiantech
 * Created by asiantech on 4/5/17.
 */

public class RetrofitClient {
    private static Retrofit retrofit=null;
    static Retrofit getClient(String baseUrl){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
