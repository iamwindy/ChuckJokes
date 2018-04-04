package com.example.haihesheng.chuckjokes.interactor.jokes;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.network.JokesApi;

import javax.inject.Inject;

/**
 * Created by Hai on 2018-04-04.
 */

public class JokesInteractor {

    @Inject
    JokesApi artistsApi;

    public JokesInteractor() {
        JokesApplication.injector.inject(this);
    }
}
