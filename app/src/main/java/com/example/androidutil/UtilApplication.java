package com.example.androidutil;

import android.app.Application;
import android.util.Log;

public class UtilApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("mtest","UtilApplication onCreate "+this.getApplicationContext());
    }
}
