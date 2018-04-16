package com.example.haihesheng.chuckjokes.ui.main;

import android.util.Log;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.di.Network;
import com.example.haihesheng.chuckjokes.interactor.jokes.JokesInteractor;
import com.example.haihesheng.chuckjokes.ui.Presenter;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

/**
 * Created by Hai on 2018-04-02.
 */

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    JokesInteractor jokesInteractor;
    @Inject
    @Network
    Executor networkExecutor;


    public MainPresenter(){
        JokesApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(MainScreen screen){
        super.attachScreen(screen);

    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }

    public void refreshCategories(){
        if(jokesInteractor == null){
            Log.d("mainpresenter", "refreshCategories: jokesInteractor is null");
        }else{
            networkExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    List<String> categories = jokesInteractor.getCategories();
                    screen.showJokeCategories(categories);
                }
            });
        }

    }
}
