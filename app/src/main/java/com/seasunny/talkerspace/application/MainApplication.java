package com.seasunny.talkerspace.application;

import android.app.Application;

import com.seasunny.talkerspace.getui.manager.GetuiSdkManager;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // getui push SDK
        GetuiSdkManager.getInstance().init(this);
    }
}
