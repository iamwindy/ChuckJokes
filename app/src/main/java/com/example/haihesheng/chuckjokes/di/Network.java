package com.example.haihesheng.chuckjokes.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Hai on 2018-04-15.
 */

@Qualifier
@Retention(RUNTIME) // not needed
public @interface Network {
}