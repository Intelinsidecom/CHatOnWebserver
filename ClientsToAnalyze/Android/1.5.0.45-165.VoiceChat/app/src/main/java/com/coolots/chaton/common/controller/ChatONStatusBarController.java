package com.coolots.chaton.common.controller;

import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ChatONStatusBarController {
    private static final String CLASSNAME = "[ChatONStatusBarController]";
    public static int mDefaultNone;
    private static int mFlag;
    private static Object mLock = new Object();

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public static void init(int defaultNone) {
        synchronized (mLock) {
            mFlag = defaultNone;
        }
        mDefaultNone = defaultNone;
    }

    public static int setFlag(int flag, boolean isSet) {
        logI("setFlag(" + Integer.toHexString(flag) + ") mFlag: " + Integer.toHexString(mFlag));
        synchronized (mLock) {
            if (isSet) {
                mFlag |= flag;
            } else {
                mFlag &= flag ^ (-1);
            }
        }
        logI("==> " + Integer.toHexString(mFlag));
        return mFlag;
    }

    public static int clearFlag() {
        logI("clearFlag() mFlag: " + Integer.toHexString(mFlag) + " => " + mDefaultNone);
        synchronized (mLock) {
            mFlag = mDefaultNone;
        }
        return mFlag;
    }
}
