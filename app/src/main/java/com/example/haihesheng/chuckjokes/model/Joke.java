package com.example.haihesheng.chuckjokes.model;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by Hai on 2018-04-04.
 */

public class Joke extends SugarRecord<Joke> implements Serializable {

    public Joke(){

    }

    public Joke(String jokeId, String iconUrl, String url, String value){
        this.jokeId = jokeId;
        this.iconUrl = iconUrl;
        this.url = url;
        this.value = value;
    }

    @SerializedName("id")
    @Expose
    private String jokeId;

    @SerializedName("icon_url")
    @Expose
    private String iconUrl;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("value")
    @Expose
    private String value;

    public String getJokeId() {
        return jokeId;
    }

    public void setJokeId(String jokeId) {
        this.jokeId = jokeId;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Joke.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Joke joke = (Joke) obj;
        return joke.getJokeId().equals(jokeId) && joke.getValue().equals(value) && joke.getUrl().equals(url) && joke.getIconUrl().equals(iconUrl);
    }
}

