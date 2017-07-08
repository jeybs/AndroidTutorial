package com.jb.androidtutorial.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules =  {Modules.class})
public interface Components {

}
