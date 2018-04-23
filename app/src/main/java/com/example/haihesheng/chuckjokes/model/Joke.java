package com.example.haihesheng.chuckjokes.model;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.lang.reflect.Field;

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

    public void setJoke(String id) {
        this.jokeId = id;
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
}

