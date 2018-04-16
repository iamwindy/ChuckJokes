package com.example.haihesheng.chuckjokes;

import com.example.haihesheng.chuckjokes.interactor.InteractorModule;
import com.example.haihesheng.chuckjokes.interactor.jokes.JokesInteractor;
import com.example.haihesheng.chuckjokes.network.NetworkModule;
import com.example.haihesheng.chuckjokes.repository.JokesRepository;
import com.example.haihesheng.chuckjokes.repository.RepositoryModule;
import com.example.haihesheng.chuckjokes.ui.UIModule;
import com.example.haihesheng.chuckjokes.ui.details.DetailsActivity;
import com.example.haihesheng.chuckjokes.ui.details.DetailsPresenter;
import com.example.haihesheng.chuckjokes.ui.favorites.FavoritesActivity;
import com.example.haihesheng.chuckjokes.ui.favorites.FavoritesPresenter;
import com.example.haihesheng.chuckjokes.ui.main.MainActivity;
import com.example.haihesheng.chuckjokes.ui.main.MainPresenter;


import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hai on 2018-04-02.
 */
@Singleton
@Component(modules={UIModule.class, NetworkModule.class, InteractorModule.class, RepositoryModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
    void inject(DetailsActivity detailsActivity);
    void inject(DetailsPresenter presenter);
    void inject(FavoritesActivity favoritesActivity);
    void inject(FavoritesPresenter favoritesPresenter);
    void inject(JokesInteractor jokesInteractor);
    void inject(JokesRepository jokesRepository);
}
