package com.example.haihesheng.chuckjokes.network;

import com.example.haihesheng.chuckjokes.Converter.CustomGsonConverter;

import org.junit.Test;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * Created by Hai on 2018-04-29.
 */
@Module
public class NetworkModuleTest {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create(CustomGsonConverter.getCustomGsonConverter()))
                .build();
    }

    @Provides
    @Singleton
    public JokesApi provideJokesApi(Retrofit retrofit) {
        return new JokesApiTest();
    }

}