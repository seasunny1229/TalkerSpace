package com.seasunny.framework.util;

import android.text.TextUtils;
import android.util.Log;

import com.seasunny.framework.BuildConfig;

public class LogUtil {

    public static void lifecycle(Class clazz, String text){
        i(clazz, text);
    }

    public static void d(Class clazz, String text){
        d(getClassTag(clazz), text);
    }

    public static void d(String tag, String text){
        log(Log.DEBUG, tag, text);
    }

    public static void i(Class clazz, String text){
        i(getClassTag(clazz), text);
    }

    public static void i(String tag, String text){
        log(Log.INFO, tag, text);
    }

    public static void e(Class clazz, String text){
        e(getClassTag(clazz), text);
    }

    public static void e(String tag, String text){
        log(Log.ERROR, tag, text);
    }

    private static String getClassTag(Class clazz){
        return clazz.getSimpleName();
    }

    private static void log(int priority, String tag, String msg){
        if(!BuildConfig.LOG_DEBUG){
            return;
        }

        if(TextUtils.isEmpty(msg)){
           return;
        }

        switch (priority){
            case Log.VERBOSE:
                Log.v(tag, msg);
                break;
            case Log.DEBUG:
                Log.d(tag, msg);
                break;
            case Log.INFO:
                Log.i(tag, msg);
                break;
            case Log.WARN:
                Log.w(tag, msg);
                break;
            case Log.ERROR:
                Log.e(tag, msg);
                break;
            default:
                break;
        }

    }

}
