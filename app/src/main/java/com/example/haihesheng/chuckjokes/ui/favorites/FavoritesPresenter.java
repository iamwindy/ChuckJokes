package com.example.haihesheng.chuckjokes.ui.favorites;

import com.example.haihesheng.chuckjokes.JokesApplication;
import com.example.haihesheng.chuckjokes.ui.Presenter;
import com.example.haihesheng.chuckjokes.ui.details.DetailsScreen;

/**
 * Created by Hai on 2018-04-04.
 */

public class FavoritesPresenter extends Presenter<FavoritesScreen> {
    @Override
    public void attachScreen(FavoritesScreen screen){
        super.attachScreen(screen);
        JokesApplication.injector.inject(this);
    }

    @Override
    public void detachScreen(){
        super.detachScreen();
    }
}
