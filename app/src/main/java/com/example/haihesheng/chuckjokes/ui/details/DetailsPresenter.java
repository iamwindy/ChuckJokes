package com.example.haihesheng.chuckjokes.ui.details;

import android.util.Log;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.di.Network;
import com.example.haihesheng.chuckjokes.interactor.jokes.JokesInteractor;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.example.haihesheng.chuckjokes.ui.Presenter;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

/**
 * Created by Hai on 2018-04-03.
 */

public class DetailsPresenter extends Presenter<DetailsScreen> {
    @Inject
    JokesInteractor jokesInteractor;
    @Inject
    @Network
    Executor networkExecutor;
    public DetailsPresenter(){
        JokesApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(DetailsScreen screen){
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }

    public void getJoke(final String category){
        if(jokesInteractor == null){
            Log.d("detailspresenter", "getJoke: jokesInteractor is null");
        }else{
            networkExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Joke joke = jokesInteractor.getRandomJoke(category);
                    screen.showJoke(joke);
                }
            });
        }
    }
}
