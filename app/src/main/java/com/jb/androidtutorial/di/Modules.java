package com.jb.androidtutorial.di;

import android.app.Application;

import dagger.Module;

@Module
public class Modules {

    final Application application;

    public Modules(Application application) {
        this.application = application;
    }
}
