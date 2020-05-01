package com.seasunny.push.manager;

import android.content.Context;
import android.util.Log;

import com.igexin.sdk.IUserLoggerInterface;
import com.igexin.sdk.PushManager;

public class PushModuleManager {
    private static PushModuleManager sInstance;

    public static PushModuleManager getInstance() {
        if(sInstance == null){
            sInstance = new PushModuleManager();
        }
        return sInstance;
    }

    private PushModuleManager() {

    }

    public void init(Context context){
        PushManager.getInstance().initialize(context);
        PushManager.getInstance().setDebugLogger(context, new IUserLoggerInterface() {
            @Override
            public void log(String s) {
                Log.i("PUSH_LOG",s);
            }
        });
    }
}
