package com.example.haihesheng.chuckjokes.ui.details;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.ui.Presenter;

/**
 * Created by Hai on 2018-04-03.
 */

public class DetailsPresenter extends Presenter<DetailsScreen> {
    public DetailsPresenter(){
        JokesApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(DetailsScreen screen){
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }
}
