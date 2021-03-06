package com.example.haihesheng.chuckjokes.network;

import com.example.haihesheng.chuckjokes.model.Joke;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hai on 2018-04-04.
 */

public interface JokesApi {
    @GET("random")
    Call<Joke> getJoke(@Query("category") String category);

    @GET("categories")
    Call<List<String>> getCategories();
}