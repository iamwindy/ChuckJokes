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


    private String category;

    public DetailsPresenter(){
        JokesApplication.injector.inject(this);
    }

    public void initialize(String category){
        currentJokes = new ArrayList<JokeWrapper>();
        currentJokeIndex = -1;
        this.category = category;
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
                    Joke dbJokeFound = jokesInteractor.findJokeByJokeId(joke.getJokeId());
                    JokeWrapper wrapperJoke = new JokeWrapper();
                    if(dbJokeFound != null){
                        wrapperJoke.setFavorited(true);
                        wrapperJoke.setJoke(dbJokeFound);
                    }else{
                        wrapperJoke.setFavorited(false);
                        wrapperJoke.setJoke(joke);
                    }
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
            currentJokeIndex = 0;
            screen.showJoke(currentJokes.get(currentJokeIndex));
        }
    }

    public void toggleSaveJoke(){
        if(currentJokes.get(currentJokeIndex).isFavorited()){
            JokeWrapper jokeWrapper =currentJokes.get(currentJokeIndex);
            jokeWrapper.setFavorited(false);
            String jokeId = jokeWrapper.getJoke().getJokeId();
            Joke foundJoke = jokesInteractor.findJokeByJokeId(jokeId);
            if(foundJoke != null){
                foundJoke.delete();
            }
        }else{
            JokeWrapper jokeWrapper =currentJokes.get(currentJokeIndex);
            String jokeId = jokeWrapper.getJoke().getJokeId();
            Joke foundJoke = jokesInteractor.findJokeByJokeId(jokeId);
            JokeWrapper wrapperJoke = new JokeWrapper();
            if(foundJoke != null){
                wrapperJoke.setJoke(foundJoke);
            }else{
                long id = jokesInteractor.saveJoke(currentJokes.get(currentJokeIndex).getJoke());
                wrapperJoke.setJoke(jokesInteractor.getJoke(id));
            }
            wrapperJoke.setFavorited(true);
            currentJokes.set(currentJokeIndex,wrapperJoke);

        }
        screen.showJoke(currentJokes.get(currentJokeIndex));
    }

}
