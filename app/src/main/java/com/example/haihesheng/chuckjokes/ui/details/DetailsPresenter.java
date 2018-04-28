package com.example.haihesheng.chuckjokes.ui.details;

import android.util.Log;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.di.Network;
import com.example.haihesheng.chuckjokes.interactor.jokes.JokesInteractor;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.example.haihesheng.chuckjokes.model.JokeWrapper;
import com.example.haihesheng.chuckjokes.ui.Presenter;

import java.util.ArrayList;
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

    private List<JokeWrapper> currentJokes;

    private int currentJokeIndex;

    private boolean isFavorite;

    private String category;

    public DetailsPresenter(){
        JokesApplication.injector.inject(this);
    }

    public void Initialize(String category){
        currentJokes = new ArrayList<JokeWrapper>();
        currentJokeIndex = -1;
        this.category = category;
        this.isFavorite = this.category == "favorites";
    }

    @Override
    public void attachScreen(DetailsScreen screen){
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }

    public void fetchNextJoke(){
        if(jokesInteractor == null){
            Log.d("detailspresenter", "getJoke: jokesInteractor is null");
        }else{
            Log.d("detailsPresenter", "fetchNextJoke: getting next one");
            if(currentJokeIndex + 1 >= currentJokes.size()){
                networkExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("networkexecutor", "fetchNextJoke: getting next one");
                    Joke joke = jokesInteractor.getRandomJoke(category);
                    JokeWrapper wrapperJoke = new JokeWrapper();
                    wrapperJoke.setFavorited(false);
                    wrapperJoke.setJoke(joke);
                    currentJokes.add(wrapperJoke);
                    currentJokeIndex++;
                    screen.showJoke(currentJokes.get(currentJokeIndex));
                    }
                });
            }else{
                Log.d("next one", "fetchNextJoke: getting next one");
                currentJokeIndex++;
                screen.showJoke(currentJokes.get(currentJokeIndex));
            }


        }
    }

    public void fetchPreviousJoke(){
        if(currentJokeIndex > 0){
            currentJokeIndex--;
            screen.showJoke(currentJokes.get(currentJokeIndex));
        }else{
            screen.showJoke(currentJokes.get(0));
        }
    }

    public boolean toggleSaveJoke(){
        if(currentJokes.get(currentJokeIndex).isFavorited()){

            return false;
        }else{
            long id = jokesInteractor.saveJoke(currentJokes.get(currentJokeIndex).getJoke());
            JokeWrapper wrapperJoke = new JokeWrapper();
            wrapperJoke.setFavorited(true);
            wrapperJoke.setJoke(jokesInteractor.getJoke(id));
            currentJokes.set(currentJokeIndex,wrapperJoke);
            return true;
        }

    }

}
