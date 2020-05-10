package com.seasunny.talkerspace.bugly;

import android.content.Context;
import android.content.pm.PackageManager;

import com.seasunny.talkerspace.BuildConfig;
import com.tencent.bugly.crashreport.CrashReport;

public class BuglySdkManager {
    private static BuglySdkManager sInstance;

    public static BuglySdkManager getInstance(){
        if(sInstance == null){
            sInstance = new BuglySdkManager();
        }
        return sInstance;
    }

    public void init(Context context){
        try {
            String appKey = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData.getString("BUGLY_APPID");
            CrashReport.initCrashReport(context, appKey, BuildConfig.DEBUG);
            //CrashReport.testJavaCrash();
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
    }
}
