package com.traffics_marster.misc.utils;

import android.support.annotation.Nullable;

import com.orhanobut.logger.Logger;
import com.traffics_marster.misc.constants.Constants;

/**
 * Created by Litao-pc on 2016/9/6.
 */
public class LoggerUtils {
    public static void d(@Nullable String clsStr,String args) {
        if (Constants.S_IS_DEBUG) {
            Logger.d(clsStr,  args);
        }
    }



}
