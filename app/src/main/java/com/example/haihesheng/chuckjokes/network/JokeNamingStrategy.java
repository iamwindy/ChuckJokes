package com.example.haihesheng.chuckjokes.network;

import com.google.gson.FieldNamingStrategy;

import java.lang.reflect.Field;

/**
 * Created by haihesheng on 2018. 04. 23..
 */

public class JokeNamingStrategy {
    public static FieldNamingStrategy getCustomJokeNamingStrategy(){
        return new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                if (f.getName() == "id") {
                    return "jokeId";
                }
                return f.getName();
            }
        };
    }

}
