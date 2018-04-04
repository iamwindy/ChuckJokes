package com.example.haihesheng.chuckjokes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hai on 2018-04-04.
 */

public class Joke {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("icon_url")
    @Expose
    private String iconUrl;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("value")
    @Expose
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
