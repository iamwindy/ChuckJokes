package com.example.haihesheng.chuckjokes.repository;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.orm.query.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hai on 2018-04-14.
 */

public class JokesRepository {
    public JokesRepository(){
        JokesApplication.injector.inject(this);
    }
    public List<Joke> GetJokes(){
        return Select.from(Joke.class).orderBy("ID Desc").list();
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

    public Joke findJokeByJokeId(String jokeId){
        List<Joke> jokes = Joke.find(Joke.class,"JOKE_ID = ?", jokeId);
        if(jokes.size() > 0){
            return jokes.get(0);
        }else{
            return null;
        }
    }

}
