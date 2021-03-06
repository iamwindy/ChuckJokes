package com.example.haihesheng.chuckjokes;

import android.app.Application;

import com.example.haihesheng.chuckjokes.interactor.InteractorModule;
import com.example.haihesheng.chuckjokes.network.NetworkModule;
import com.example.haihesheng.chuckjokes.repository.RepositoryModule;
import com.example.haihesheng.chuckjokes.ui.UIModule;

/**
 * Created by Hai on 2018-04-02.
 */

public class JokesApplication extends com.orm.SugarApp {
    public static ApplicationComponent injector;

    @Override
    public void onCreate(){
        if (callSuper()) {
            super.onCreate();
        }
        injector = DaggerApplicationComponent.builder()
                .uIModule(new UIModule(this))
                .repositoryModule(new RepositoryModule())
                .networkModule(new NetworkModule())
                .interactorModule(new InteractorModule())
                .build();
    }


    @Override
    public void onTerminate() {
        if (callSuperFalse()) {
            super.onTerminate();
        }
    }

    protected boolean callSuper() {
        return true; // Super is executed by default
    }
    protected boolean callSuperFalse() {
        return false; // Super is executed by default
    }
}
