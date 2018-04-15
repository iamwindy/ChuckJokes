package com.example.haihesheng.chuckjokes;

import android.app.Application;

import com.example.haihesheng.chuckjokes.interactor.InteractorModule;
import com.example.haihesheng.chuckjokes.network.NetworkModule;
import com.example.haihesheng.chuckjokes.repository.RepositoryModule;
import com.example.haihesheng.chuckjokes.ui.UIModule;

/**
 * Created by Hai on 2018-04-02.
 */

public class JokesApplication extends Application {
    public static ApplicationComponent injector;

    @Override
    public void onCreate(){
        super.onCreate();
        injector = DaggerApplicationComponent.builder()
                .uIModule(new UIModule(this))
                .repositoryModule(new RepositoryModule(this))
                .networkModule(new NetworkModule(this))
                .interactorModule(new InteractorModule(this))
                .build();
    }
}
