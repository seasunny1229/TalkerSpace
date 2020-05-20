package com.seasunny.framework.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.seasunny.framework.util.LogUtil;

public class BaseService extends Service {

    // region lifecycle
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.lifecycle(getClass(), "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.lifecycle(getClass(), "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.lifecycle(getClass(), "onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtil.lifecycle(getClass(), "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        LogUtil.lifecycle(getClass(), "onUnbind");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.lifecycle(getClass(), "onDestroy");
    }

    // endregion

}
