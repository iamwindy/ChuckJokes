package com.example.haihesheng.chuckjokes;

import android.app.Application;

import com.example.haihesheng.chuckjokes.interactor.InteractorModule;
import com.example.haihesheng.chuckjokes.network.NetworkModule;
import com.example.haihesheng.chuckjokes.repository.RepositoryModule;
import com.example.haihesheng.chuckjokes.ui.UIModule;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by Hai on 2018-04-02.
 */

public class JokesApplication extends com.orm.SugarApp {
    public static ApplicationComponent injector;

    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    @Override
    public void onCreate(){
        if (callSuper()) {
            super.onCreate();
        }

        sAnalytics = GoogleAnalytics.getInstance(this);
        sAnalytics.setLocalDispatchPeriod(15);
        injector = DaggerApplicationComponent.builder()
                .uIModule(new UIModule(this))
                .repositoryModule(new RepositoryModule())
                .networkModule(new NetworkModule())
                .interactorModule(new InteractorModule())
                .build();
    }

    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
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
