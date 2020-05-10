package com.seasunny.talkerspace.umeng;

import android.content.Context;
import android.content.pm.PackageManager;

import com.seasunny.framework.util.LogUtil;
import com.seasunny.statistics.channel.Channel;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

public class UmengSdkManager {

    private static UmengSdkManager sInstance;

    public static UmengSdkManager getInstance(){
        if(sInstance == null){
            sInstance = new UmengSdkManager();
        }
        return sInstance;
    }

    public void init(Context context){
        try {
            String appKey = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA).metaData.getString("UMENG_APP_KEY");
            UMConfigure.init(context,appKey, Channel.channel, UMConfigure.DEVICE_TYPE_PHONE,"");
            UMConfigure.setLogEnabled(true);
            String[] testDeviceInfo = getTestDeviceInfo(context);
            //{"device_id":"","mac":""}
            LogUtil.e(getClass(), testDeviceInfo[0] + " " + testDeviceInfo[1]);
        }catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static String[] getTestDeviceInfo(Context context){
        String[] deviceInfo = new String[2];
        try {
            if(context != null){
                deviceInfo[0] = DeviceConfig.getDeviceIdForGeneral(context);
                deviceInfo[1] = DeviceConfig.getMac(context);
            }
        } catch (Exception e){
        }
        return deviceInfo;
    }


}
