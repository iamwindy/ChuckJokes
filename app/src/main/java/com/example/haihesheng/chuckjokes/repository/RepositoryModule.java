package com.example.haihesheng.chuckjokes.repository;

import android.content.Context;

import com.example.haihesheng.chuckjokes.network.JokesApi;
import com.example.haihesheng.chuckjokes.network.NetworkConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hai on 2018-04-14.
 */

@Module
public class RepositoryModule {

    private Context context;

    public RepositoryModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public JokesRepository provideJokesRepository() {
        return new JokesRepository();
    }
}
