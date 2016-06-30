package org.zakariya.stickyheadersapp;

import android.app.Application;

import com.lifeofcoding.cacheutlislibrary.CacheUtils;

import org.zakariya.stickyheadersapp.api.RandomUserLoader;

public class CTCIApplication extends Application {

    RandomUserLoader randomUserLoader;
    @Override
    public void onCreate() {
        super.onCreate();
        // configure CacheUtilsLibrary
        CacheUtils.configureCache(this);
        randomUserLoader = new RandomUserLoader();
    }

    public RandomUserLoader getRandomUserLoader() {
        return randomUserLoader;
    }
}