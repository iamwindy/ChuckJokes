package com.example.haihesheng.chuckjokes;

import com.example.haihesheng.chuckjokes.interactor.InteractorModuleTest;
import com.example.haihesheng.chuckjokes.interactor.jokes.JokesInteractor;
import com.example.haihesheng.chuckjokes.network.NetworkModuleTest;
import com.example.haihesheng.chuckjokes.repository.JokesRepository;
import com.example.haihesheng.chuckjokes.repository.RepositoryModuleTest;
import com.example.haihesheng.chuckjokes.ui.UIModuleTest;
import com.example.haihesheng.chuckjokes.ui.details.DetailsActivity;
import com.example.haihesheng.chuckjokes.ui.details.DetailsPresenter;
import com.example.haihesheng.chuckjokes.ui.favorites.FavoritesActivity;
import com.example.haihesheng.chuckjokes.ui.favorites.FavoritesPresenter;
import com.example.haihesheng.chuckjokes.ui.main.MainActivity;
import com.example.haihesheng.chuckjokes.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

import static org.junit.Assert.*;

/**
 * Created by Hai on 2018-04-29.
 */
@Singleton
@Component(modules = {NetworkModuleTest.class, UIModuleTest.class, InteractorModuleTest.class, RepositoryModuleTest.class})
public interface ApplicationComponentTest extends ApplicationComponent{
}