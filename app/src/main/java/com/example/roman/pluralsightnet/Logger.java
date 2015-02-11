package com.example.roman.pluralsightnet;

import android.app.Activity;
import android.util.Log;


public class Logger {

    public final static String LOG_TAG = "ACTIVITY_EVENT"; //why make it final

    public static void LogCallBack(Activity activity, String callbackName){
        String logMsg = String.format("Activity:%s; Callback:%s",activity.getClass().getSimpleName(), callbackName);
        Log.d(LOG_TAG,logMsg);
                
    }
}
