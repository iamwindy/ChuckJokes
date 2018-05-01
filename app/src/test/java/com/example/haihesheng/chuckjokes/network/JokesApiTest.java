package com.example.haihesheng.chuckjokes.network;

import com.example.haihesheng.chuckjokes.model.Joke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

/**
 * Created by Hai on 2018-04-29.
 */
public class JokesApiTest implements JokesApi {

    public static List<Joke> jokes = new ArrayList<>();
    public static List<Joke> newJokes = new ArrayList<>();
    public static CategoryTypes categoryType;
    public static int JokeIndex = 0;

    public static List<String> categories = new ArrayList<>();
    public static Joke joke1 = new Joke("joke1","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke1");
    public static Joke joke2 = new Joke("joke2","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke2");
    public static Joke joke3 = new Joke("joke3","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke3");
    public static Joke joke4 = new Joke("joke4","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke4");
    public static Joke joke5 = new Joke("joke5","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","joke5");
    public static Joke newJoke1 = new Joke("newJoke1","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","newJoke1");
    public static Joke newJoke2 = new Joke("newJoke2","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","newJoke2");
    public static Joke newJoke3 = new Joke("newJoke3","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","newJoke3");
    public static Joke newJoke4 = new Joke("newJoke4","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","newJoke4");
    public static Joke newJoke5 = new Joke("newJoke5","https://assets.chucknorris.host/img/avatar/chuck-norris.png","https://api.chucknorris.io/jokes/e82_skt1twatoavnakhafg","newJoke5");
    public static void seedJokes(CategoryTypes _categoryType){
        jokes = new ArrayList<Joke>();
        newJokes = new ArrayList<Joke>();
        categoryType = _categoryType;
        JokeIndex = 0;
        jokes.add(joke1);
        jokes.add(joke2);
        jokes.add(joke3);
        jokes.add(joke4);
        jokes.add(joke5);
        newJokes.add(newJoke1);
        newJokes.add(newJoke2);
        newJokes.add(newJoke3);
        newJokes.add(newJoke4);
        newJokes.add(newJoke5);
    }

    public static void emptyJokes(){
        jokes = new ArrayList<Joke>();
        newJokes = new ArrayList<Joke>();
        JokeIndex = 0;
    }

    @Override
    public Call<Joke> getJoke(@Query("category") final String category) {
        Call<Joke> call = new Call<Joke>() {
            @Override
            public Response<Joke> execute() throws IOException {
                Response<Joke> response;
                if(category.equals(getStringFromCategory(CategoryTypes.New)) ){
                    response = Response.success(newJokes.get(JokeIndex));
                    if(JokeIndex + 1 < newJokes.size()){
                        JokeIndex++;
                    }
                }else{
                    response = Response.success(jokes.get(JokeIndex));
                    if(JokeIndex + 1 < jokes.size()){
                        JokeIndex++;
                    }
                }

                return response;
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

    public static void seedCategories(){
        categories = new ArrayList<String>();
        categories.add("category1");
        categories.add("category2");
        categories.add("category3");
        categories.add("category4");
        categories.add("category5");
    }

    public static void emptyCategories(){
        categories = new ArrayList<String>();
    }

    @Override
    public Call<List<String>> getCategories() {

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

    public enum CategoryTypes{
        DB,New
    }

    public static String  getStringFromCategory(CategoryTypes _category){
        if(_category == CategoryTypes.New){
            return "new";
        }else{
            return "db";
        }
    }



}