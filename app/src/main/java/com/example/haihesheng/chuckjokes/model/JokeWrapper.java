package com.example.haihesheng.chuckjokes.model;

/**
 * Created by Hai on 2018-04-28.
 */

public class JokeWrapper {
    private Joke joke;
    private boolean IsFavorited;


    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public boolean isFavorited() {
        return IsFavorited;
    }

    public void setFavorited(boolean favorited) {
        IsFavorited = favorited;
    }
}
