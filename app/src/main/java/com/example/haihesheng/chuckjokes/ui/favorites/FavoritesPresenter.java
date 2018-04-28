package com.example.haihesheng.chuckjokes.ui.favorites;

import android.util.Log;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.di.Network;
import com.example.haihesheng.chuckjokes.interactor.jokes.JokesInteractor;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.example.haihesheng.chuckjokes.model.JokeWrapper;
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

    private List<Joke> currentJokes;

    private int currentJokeIndex;


    public void Initialize(){
        currentJokes = jokesInteractor.getJokes();
        currentJokeIndex = -1;

    }

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

    public void showNextJoke(){
        if(currentJokes.size() == 0){
            screen.showJoke(createEmptyJoke());
        }
        else if(currentJokeIndex + 1 >= currentJokes.size()){
            screen.showJoke(currentJokes.get(currentJokeIndex));
        }else{
            currentJokeIndex++;
            screen.showJoke(currentJokes.get(currentJokeIndex));
        }
    }

    public void showPreviousJoke(){
        if(currentJokes.size() == 0){
            screen.showJoke(createEmptyJoke());
        }
        else if(currentJokeIndex > 0){
            currentJokeIndex--;
            screen.showJoke(currentJokes.get(currentJokeIndex));
        }else{
            currentJokeIndex = 0;
            screen.showJoke(currentJokes.get(currentJokeIndex));
        }
    }

    public void deleteJoke(){
        if(currentJokes.size() == 0){
            screen.showJoke(createEmptyJoke());
        }else if (currentJokeIndex <= -1){
            screen.showJoke(createEmptyJoke());
        }else{
            Joke joke = currentJokes.get(currentJokeIndex);
            joke.delete();
            currentJokes.remove(currentJokeIndex);
            currentJokeIndex--;
            if(currentJokeIndex < 0){
                if(currentJokes.size() > 0){
                    currentJokeIndex = 0;
                    screen.showJoke(currentJokes.get(currentJokeIndex));
                }else{
                    screen.showJoke(createEmptyJoke());
                }
            }else{
                screen.showJoke(currentJokes.get(currentJokeIndex));
            }
        }


    }

    private Joke createEmptyJoke(){
        Joke jokeEmpty = new Joke();
        jokeEmpty.setValue("No more Jokes in favorites, check out more jokes on the main menu");
        return jokeEmpty;
    }
}
