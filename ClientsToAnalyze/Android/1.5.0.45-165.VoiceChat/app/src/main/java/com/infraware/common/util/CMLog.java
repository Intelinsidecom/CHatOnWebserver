package com.infraware.common.util;

import android.os.SystemClock;

/* loaded from: classes.dex */
public class CMLog {
    static final boolean DEBUG_EXTRACT = false;
    static final String TAG = "[EvUI]";

    /* renamed from: d */
    public static void m6d(String tag, String msg) {
    }

    /* renamed from: e */
    public static void m7e(String tag, String msg) {
    }

    /* renamed from: e */
    public static void m8e(String tag, String msg, Throwable tr) {
    }

    /* renamed from: v */
    public static void m10v(String tag, String msg) {
    }

    /* renamed from: i */
    public static void m9i(String tag, String msg) {
    }

    public static void debugStackTrace() throws Exception {
        try {
            throw new Exception("[" + SystemClock.uptimeMillis() + "][debug stack trace]");
        } catch (Exception e) {
            m8e("DocViewer_d", e.getMessage(), e);
        }
    }

    public static long startTimeTrace(String tag) {
        return 0L;
    }

    public static void endTimeTrace(String tag, long startTime) {
    }
}
