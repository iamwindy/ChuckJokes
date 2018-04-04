package com.example.haihesheng.chuckjokes;

import com.example.haihesheng.chuckjokes.ui.UIModule;
import com.example.haihesheng.chuckjokes.ui.details.DetailsActivity;
import com.example.haihesheng.chuckjokes.ui.favorites.FavoritesActivity;
import com.example.haihesheng.chuckjokes.ui.main.MainActivity;


import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hai on 2018-04-02.
 */
@Singleton
@Component(modules={UIModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(DetailsActivity detailsActivity);
    void inject(FavoritesActivity favoritesActivity);
}
