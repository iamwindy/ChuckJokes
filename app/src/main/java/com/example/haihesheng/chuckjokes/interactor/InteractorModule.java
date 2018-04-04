package com.example.haihesheng.chuckjokes.interactor;

import com.example.haihesheng.chuckjokes.interactor.jokes.JokesInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hai on 2018-04-04.
 */

@Module
public class InteractorModule {
    @Provides
    public JokesInteractor provideArtistsInteractor() {
        return new JokesInteractor();
    }
}
