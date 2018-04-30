package com.example.haihesheng.chuckjokes.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.junit.Assert.*;

/**
 * Created by Hai on 2018-04-29.
 */
@Module
public class RepositoryModuleTest {

    @Provides
    @Singleton
    public JokesRepository provideJokesRepository() {
        return new JokesRepositoryTest();
    }
}