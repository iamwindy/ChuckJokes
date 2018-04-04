package com.example.haihesheng.chuckjokes.ui;

import android.content.Context;

import com.example.haihesheng.chuckjokes.ui.details.DetailsPresenter;
import com.example.haihesheng.chuckjokes.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hai on 2018-04-02.
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context){
        this.context = context;
    }

    @Provides
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
}
