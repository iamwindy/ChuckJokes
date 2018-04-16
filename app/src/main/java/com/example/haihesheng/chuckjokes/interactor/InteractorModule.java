package com.example.haihesheng.chuckjokes.interactor;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.haihesheng.chuckjokes.interactor.jokes.JokesInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hai on 2018-04-04.
 */

@Module
public class InteractorModule {

    @Provides
    @Singleton
    public JokesInteractor provideJokesInteractor() {
        return new JokesInteractor();
    }
}
