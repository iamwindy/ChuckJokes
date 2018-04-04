package com.example.haihesheng.chuckjokes;

import android.app.Application;

import com.example.haihesheng.chuckjokes.ui.UIModule;

/**
 * Created by Hai on 2018-04-02.
 */

public class JokesApplication extends Application {
    public static ApplicationComponent injector;

    @Override
    public void onCreate(){
        super.onCreate();
        injector = DaggerApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
