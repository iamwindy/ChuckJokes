package com.example.haihesheng.chuckjokes.repository;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.orm.query.Select;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Hai on 2018-04-29.
 */
public class JokesRepositoryTest extends JokesRepository {
    public static List<Joke> jokes = new ArrayList<>();
    public static Joke joke1 = new Joke("joke1","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke1");
    public static Joke joke2 = new Joke("joke2","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke2");
    public static Joke joke3 = new Joke("joke3","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke3");
    public static Joke joke4 = new Joke("joke4","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke4");
    public static Joke joke5 = new Joke("joke5","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke5");
    public JokesRepositoryTest(){
        JokesApplication.injector.inject(this);

    }

    public static void seedJokes(){
        jokes = new ArrayList<Joke>();

        Integer id = 1;
        joke1.setId(id.longValue());
        id = 2;
        joke2.setId(id.longValue());
        id =3;
        joke3.setId(id.longValue());
        id = 4;
        joke4.setId(id.longValue());
        id = 5;
        joke5.setId(id.longValue());
        jokes.add(joke1);
        jokes.add(joke2);
        jokes.add(joke3);
        jokes.add(joke4);
        jokes.add(joke5);
    }

    public static void emptyJokes(){
        jokes = new ArrayList<Joke>();
    }


    public List<Joke> GetJokes(){
        return jokes;
    }

    public Joke getJoke(long id){
        for(Joke joke: jokes){
            if(joke.getId() == id){
                return joke;
            }
        }
        return null;
    }

    public long saveJoke(Joke joke){
        joke.setId(getMaxId() + 1);
        jokes.add(joke);
        return joke.getId();
    }

    private long getMaxId(){
        long id = 0;
        if(jokes != null && jokes.size() > 0){
            for(Joke joke : jokes){
                if(joke.getId() > id){
                    id = joke.getId();
                }
            }
        }
        return id;
    }

    public void deleteJoke(long id){
        if(jokes != null && jokes.size() > 0){
            for(Joke joke : jokes){
                if(joke.getId() == id){
                    jokes.remove(joke);
                    break;
                }
            }
        }
    }

    public Joke findJokeByJokeId(String jokeId){
        if(jokes != null && jokes.size() > 0){
            for(Joke joke : jokes){
                if(joke.getJokeId().equals(jokeId)){
                    return joke;
                }
            }
        }
        return null;
    }
}