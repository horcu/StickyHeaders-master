package org.zakariya.stickyheadersapp;

import android.app.Application;

import com.lifeofcoding.cacheutlislibrary.CacheUtils;

public class CTCIApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // configure CacheUtilsLibrary
        CacheUtils.configureCache(this);
    }
}