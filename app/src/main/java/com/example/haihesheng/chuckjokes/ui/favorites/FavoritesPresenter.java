package com.example.haihesheng.chuckjokes.ui.favorites;

import android.util.Log;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.di.Network;
import com.example.haihesheng.chuckjokes.interactor.jokes.JokesInteractor;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.example.haihesheng.chuckjokes.ui.Presenter;
import com.example.haihesheng.chuckjokes.ui.details.DetailsScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

/**
 * Created by Hai on 2018-04-04.
 */

public class FavoritesPresenter extends Presenter<FavoritesScreen> {
    @Inject
    JokesInteractor jokesInteractor;

    public FavoritesPresenter() {
        JokesApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(FavoritesScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getJokes() {
        if (jokesInteractor == null) {
            Log.d("mainpresenter", "refreshCategories: jokesInteractor is null");
        } else {
            List<Joke> jokes = jokesInteractor.getJokes();
            screen.showJokes(jokes);
        }
    }
}
