package com.example.haihesheng.chuckjokes.model;

/**
 * Created by Hai on 2018-04-28.
 */

public class JokeWrapper {
    private Joke joke;
    private boolean isFavorited;


    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!JokeWrapper.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final JokeWrapper jokeWrapper = (JokeWrapper) obj;
        return jokeWrapper.getJoke().equals(getJoke()) && jokeWrapper.isFavorited() == isFavorited;
    }
}
