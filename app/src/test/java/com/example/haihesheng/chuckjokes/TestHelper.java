package com.example.haihesheng.chuckjokes;

import com.example.haihesheng.chuckjokes.ui.UIModuleTest;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by Hai on 2018-04-29.
 */

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        JokesApplication application = (JokesApplication) RuntimeEnvironment.application;
        //ApplicationComponent injector = DaggerTestComponent.builder().testModule(new UIModuleTest(application.getApplicationContext())).build();
        //application.injector = injector;

    }
}