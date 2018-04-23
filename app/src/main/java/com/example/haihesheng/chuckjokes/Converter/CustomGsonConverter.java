package com.example.haihesheng.chuckjokes.Converter;

import com.example.haihesheng.chuckjokes.network.JokeNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by haihesheng on 2018. 04. 23..
 */

public class CustomGsonConverter {
    public static Gson getCustomGsonConverter(){
        Gson gson = new GsonBuilder()
                .setFieldNamingStrategy(JokeNamingStrategy.getCustomJokeNamingStrategy())
                .create();
        return gson;
    }

}
