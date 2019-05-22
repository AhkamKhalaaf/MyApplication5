package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("movie")
    Call<ApimoviesResponse> getdata(
            @Query("api_key") String api_key,

            @Query("query") String query,

                                    @Query("page") int page );
}
