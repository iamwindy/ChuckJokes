package com.example.haihesheng.chuckjokes.interactor.jokes;

import android.content.Context;
import android.util.Log;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.model.Joke;
import com.example.haihesheng.chuckjokes.network.JokesApi;
import com.example.haihesheng.chuckjokes.repository.JokesRepository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Hai on 2018-04-04.
 */

public class JokesInteractor {

    @Inject
    JokesApi jokesApi;

    @Inject
    JokesRepository jokesRepository;

    public JokesInteractor() {
        JokesApplication.injector.inject(this);
    }

    public Joke getRandomJoke(String category) {
        Call<Joke> artistsQueryCall = jokesApi.getJoke(category);
        try {
            Response<Joke> response = artistsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            return response.body();
        } catch (Exception e) {
            Log.d("JokesInteractor","error on querying joke");
            return null;
        }
    }

    public List<String> getCategories() {
        Call<List<String>> artistsQueryCall = jokesApi.getCategories();
        try {
            Response<List<String>> response = artistsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            return response.body();
        } catch (Exception e) {
            Log.d("JokesInteractor",e.toString());
            return null;
        }
    }

    public long saveJoke(Joke joke){
        return jokesRepository.saveJoke(joke);
    }

    public void deleteJoke(long id){
        jokesRepository.deleteJoke(id);
    }

    public Joke getJoke(long id){
        return jokesRepository.getJoke(id);
    }
}
