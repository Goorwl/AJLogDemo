package com.goorwl.aopdemo;

import android.app.Activity;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class PermissonManager {

    private static PermissonManager sSingleTest;
    private static Activity         mActivity;

    private PermissonManager() {
    }

    public static PermissonManager getInstance() {
        if (sSingleTest == null) {
            synchronized (PermissonManager.class) {
                if (sSingleTest == null) {
                    sSingleTest = new PermissonManager();
                    mActivity = MainActivity.sActivity;
                }
            }
        }
        return sSingleTest;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void requestPer(String perm) {
        mActivity.requestPermissions(new String[]{perm}, 1002);
    }

}
