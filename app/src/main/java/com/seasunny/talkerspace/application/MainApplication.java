package com.seasunny.talkerspace.application;

import android.app.Application;

import com.seasunny.talkerspace.bugly.BuglySdkManager;
import com.seasunny.talkerspace.getui.manager.GetuiSdkManager;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // getui push SDK
        GetuiSdkManager.getInstance().init(this);

        // bugly SDK
        BuglySdkManager.getInstance().init(this);

    }
}
