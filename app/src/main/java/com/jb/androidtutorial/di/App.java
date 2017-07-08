package com.jb.androidtutorial.di;

import android.app.Application;
import android.support.multidex.MultiDex;

public class App extends Application {

    private Components appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);

        appComponent = DaggerComponents.builder()
                .modules(new Modules(this))
                .build();
    }


    public Components getEdccComponents() {
        return appComponent;
    }

}
