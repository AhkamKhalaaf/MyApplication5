package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient {
    private static final String BASE_URL = "http://api.themoviedb.org/3/search/";
    private static Retrofitclient mInstance;
    private Retrofit retrofit;
    private Retrofitclient ()
    {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }
    public static synchronized Retrofitclient getInsatance()
    {
        if (mInstance ==null)
        {
            mInstance = new Retrofitclient();
        }
        return mInstance;
    }

    public Api getApi()
    {
        return retrofit.create(Api.class);
    }
}
