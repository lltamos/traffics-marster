package com.traffics_marster;

import android.app.Application;
import android.content.Context;

import com.lody.turbodex.TurboDex;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public class SynopsisObj extends Application {
    public static SynopsisObj app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Logger.init()
                .setMethodCount(3)
                .hideThreadInfo()
                .setLogLevel(LogLevel.FULL);
    }

    @Override
    protected void attachBaseContext(Context base) {
        TurboDex.enableTurboDex();
        super.attachBaseContext(base);
    }
}
