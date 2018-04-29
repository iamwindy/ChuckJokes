package com.example.haihesheng.chuckjokes.ui;

import android.content.Context;

import com.example.haihesheng.chuckjokes.di.Network;
import com.example.haihesheng.chuckjokes.ui.details.DetailsPresenter;
import com.example.haihesheng.chuckjokes.ui.favorites.FavoritesPresenter;
import com.example.haihesheng.chuckjokes.ui.main.MainPresenter;
import com.example.haihesheng.chuckjokes.utils.UIExecutor;

import org.junit.Test;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.junit.Assert.*;

/**
 * Created by Hai on 2018-04-29.
 */
@Module
public class UIModuleTest {
    private Context context;

    public UIModuleTest(Context context) {
        this.context = context;
    }

    @Test
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }

    @Provides
    @Singleton
    public FavoritesPresenter provideFavoritesPresenter() {
        return new FavoritesPresenter();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() throws Exception {
        return new UIExecutor();
    }

}