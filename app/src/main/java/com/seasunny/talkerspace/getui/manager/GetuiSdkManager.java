package com.seasunny.talkerspace.getui.manager;

import android.content.Context;
import android.util.Log;

import com.igexin.sdk.IUserLoggerInterface;
import com.igexin.sdk.PushManager;

public class GetuiSdkManager {
    private static GetuiSdkManager sInstance;

    public static GetuiSdkManager getInstance(){
        if(sInstance == null){
            sInstance = new GetuiSdkManager();
        }
        return sInstance;
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
