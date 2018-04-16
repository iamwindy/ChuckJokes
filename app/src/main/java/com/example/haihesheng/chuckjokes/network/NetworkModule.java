package com.example.haihesheng.chuckjokes.network;

import android.content.Context;

import com.example.haihesheng.chuckjokes.JokesApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hai on 2018-04-04.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public JokesApi provideJokesApi(Retrofit retrofit) {
        return retrofit.create(JokesApi.class);
    }
}
