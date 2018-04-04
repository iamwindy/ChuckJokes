package com.example.haihesheng.chuckjokes.network;

import com.example.haihesheng.chuckjokes.model.JokeResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hai on 2018-04-04.
 */

public interface JokesApi {
    @GET("random")
    Call<JokeResult> getJoke(@Query("category") String category);

    @GET("categories")
    Call<List<String>> getCategories();

    @GET("search")
    Call<List<String>> searchJoke(@Query("query") String query);
}