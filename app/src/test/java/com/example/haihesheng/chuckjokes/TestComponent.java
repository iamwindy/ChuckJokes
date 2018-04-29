package com.example.haihesheng.chuckjokes;

import com.example.haihesheng.chuckjokes.interactor.InteractorModule;
import com.example.haihesheng.chuckjokes.network.NetworkModuleTest;
import com.example.haihesheng.chuckjokes.ui.UIModuleTest;

import javax.inject.Singleton;

import dagger.Component;

import static org.junit.Assert.*;

/**
 * Created by Hai on 2018-04-29.
 */
@Singleton
@Component(modules = {NetworkModuleTest.class, UIModuleTest.class, InteractorModule.class})
public interface TestComponent extends ApplicationComponent{

}