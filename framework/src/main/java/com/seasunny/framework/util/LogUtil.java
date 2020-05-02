package com.seasunny.framework.util;

import android.text.TextUtils;
import android.util.Log;

import com.seasunny.framework.BuildConfig;

public class LogUtil {

    public static void d(String tag, String text){
        if(BuildConfig.LOG_DEBUG){
            if(!TextUtils.isEmpty(text)){
                Log.e(tag, text);
            }
        }
    }

    public static void i(String tag, String text){
        if(BuildConfig.LOG_DEBUG){
            if(!TextUtils.isEmpty(text)){
                Log.i(tag, text);
            }
        }
    }

    public static void e(String tag, String text){
        if(BuildConfig.LOG_DEBUG){
            if(!TextUtils.isEmpty(text)){
                Log.e(tag, text);
            }
        }
    }

}
