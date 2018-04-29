package com.example.haihesheng.chuckjokes.network;

import com.example.haihesheng.chuckjokes.model.Joke;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

import static org.junit.Assert.*;

/**
 * Created by Hai on 2018-04-29.
 */
public class JokesApiTest implements JokesApi {


    @Override
    public Call<Joke> getJoke(@Query("category") String category) {
        final Joke joke = new Joke();
        joke.setValue("Chuck Norris did not \"lose\" his virginity, he stalked it and then destroyed it with extreme prejudice.");
        joke.setUrl("https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg");
        joke.setJokeId("e82_skt1twatoavnakhafg");
        joke.setIconUrl("https://assets.chucknorris.host/img/avatar/chuck-norris.png");
        Call<Joke> call = new Call<Joke>() {
            @Override
            public Response<Joke> execute() throws IOException {
                return Response.success(joke);
            }

            @Override
            public void enqueue(Callback<Joke> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Joke> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
        return call;
    }

    @Test
    public Call<List<String>> getCategories() {
        final List<String> categories = new ArrayList<String>();
        categories.add("category1");
        categories.add("category2");
        categories.add("category3");
        categories.add("category4");
        categories.add("category5");

        Call<List<String>> call = new Call<List<String>>() {

            @Override
            public Response<List<String>> execute() throws IOException {
                return Response.success(categories);
            }

            @Override
            public void enqueue(Callback<List<String>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<String>> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
        return call;
    }


}