package com.example.haihesheng.chuckjokes.ui;

/**
 * Created by Hai on 2018-04-02.
 */

public abstract class Presenter<S> {
    protected S screen;
    public void attachScreen(S screen){
        this.screen = screen;
    }

    public void detachScreen(){
        this.screen = null;
    }
}
