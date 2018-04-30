package com.example.haihesheng.chuckjokes;

import com.example.haihesheng.chuckjokes.interactor.InteractorModule;
import com.example.haihesheng.chuckjokes.network.NetworkModule;
import com.example.haihesheng.chuckjokes.network.NetworkModuleTest;
import com.example.haihesheng.chuckjokes.repository.RepositoryModule;
import com.example.haihesheng.chuckjokes.repository.RepositoryModuleTest;
import com.example.haihesheng.chuckjokes.ui.UIModule;
import com.example.haihesheng.chuckjokes.ui.UIModuleTest;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

import dagger.internal.DaggerCollections;

/**
 * Created by Hai on 2018-04-29.
 */

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        JokesApplication.injector = DaggerApplicationComponentTest.builder()
                .uIModuleTest(new UIModuleTest(RuntimeEnvironment.application.getApplicationContext()))
                .repositoryModuleTest(new RepositoryModuleTest())
                .networkModuleTest(new NetworkModuleTest())
                .build();

    }
}