package com.example.haihesheng.chuckjokes.repository;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.model.Joke;

import java.util.List;

/**
 * Created by Hai on 2018-04-14.
 */

public class JokesRepository {
    public JokesRepository(){
        JokesApplication.injector.inject(this);
    }
    public List<Joke> GetJokes(){
        return Joke.listAll(Joke.class);
    }

    public Joke getJoke(long id){
        return Joke.findById(Joke.class,id);
    }

    public long saveJoke(Joke joke){
        joke.save();
        return joke.getId();
    }

    public void deleteJoke(long id){
        Joke joke = Joke.findById(Joke.class,id);
        joke.delete();
    }

}
