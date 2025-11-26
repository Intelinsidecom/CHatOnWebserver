package com.samsung.android.sdk.pen.engine;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
class SpenSLog {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static int CALL_DEPTH = 0;
    private static final boolean CONFIG_LOGCAT_DBG = true;
    private static final boolean CONFIG_LOGFILE_DBG = false;
    private static final String DEFAULT_LOG_FILE;
    private static int DEFAULT_MAX_SIZE = 0;
    private static final String TAG = "SLog:";
    private static int mCall_Depth;
    private static SpenSLog sInstance;
    private BufferedWriter mFout = null;
    private File mFile = null;
    private boolean mSuccessFileCreation = false;
    private long mBefore = 0;

    static {
        $assertionsDisabled = !SpenSLog.class.desiredAssertionStatus();
        DEFAULT_LOG_FILE = Environment.getExternalStorageDirectory() + "/.SPenSDK30/control_log.txt";
        DEFAULT_MAX_SIZE = 10240;
        CALL_DEPTH = 5;
        mCall_Depth = 5;
        sInstance = null;
    }

    private SpenSLog() {
        startLog();
    }

    private static SpenSLog getInstance() {
        if (sInstance == null) {
            sInstance = new SpenSLog();
            sInstance.startLog();
        }
        return sInstance;
    }

    private void startLog() {
    }

    private static String getTag() {
        String str = "SLog:[" + getCallingClassName() + "][" + getCallingMethodName() + "][" + String.valueOf(getCallingLine()) + "]";
        mCall_Depth = CALL_DEPTH;
        return str;
    }

    private static String getMsg(String msg) {
        long current = System.currentTimeMillis();
        long interval = current - getInstance().mBefore;
        getInstance().mBefore = current;
        return "(" + interval + "): " + msg;
    }

    private static String getCallingClassName() {
        return Thread.currentThread().getStackTrace()[mCall_Depth].getClassName().substring(Thread.currentThread().getStackTrace()[mCall_Depth].getClassName().lastIndexOf(46) + 1);
    }

    private static String getCallingMethodName() {
        return Thread.currentThread().getStackTrace()[mCall_Depth].getMethodName();
    }

    private static int getCallingLine() {
        return Thread.currentThread().getStackTrace()[mCall_Depth].getLineNumber();
    }

    private void writeFile(String level, String msg) throws IOException {
        if (this.mSuccessFileCreation) {
            if (this.mFile.length() > DEFAULT_MAX_SIZE) {
                try {
                    this.mFile.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                startLog();
            }
            try {
                this.mFout.append((CharSequence) (String.valueOf(level) + msg + "\r\n"));
                this.mFout.flush();
            } catch (IOException e2) {
                this.mSuccessFileCreation = false;
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: v */
    public static void m140v(String msg) {
        String tempMsg = getMsg(msg);
        String tempTag = getTag();
        Log.v(tempTag, tempMsg);
    }

    /* renamed from: d */
    public static void m134d(String msg) {
        String tempMsg = getMsg(msg);
        String tempTag = getTag();
        Log.d(tempTag, tempMsg);
    }

    /* renamed from: i */
    public static void m138i(String msg) {
        String tempMsg = getMsg(msg);
        String tempTag = getTag();
        Log.i(tempTag, tempMsg);
    }

    /* renamed from: w */
    public static void m142w(String msg) {
        String tempMsg = getMsg(msg);
        String tempTag = getTag();
        Log.w(tempTag, tempMsg);
    }

    /* renamed from: e */
    public static void m136e(String msg) {
        String tempMsg = getMsg(msg);
        String tempTag = getTag();
        Log.e(tempTag, tempMsg);
    }

    /* renamed from: v */
    public static void m141v(boolean enable, String msg) {
        if (enable) {
            mCall_Depth++;
            m140v(msg);
        }
    }

    /* renamed from: d */
    public static void m135d(boolean enable, String msg) {
        if (enable) {
            mCall_Depth++;
            m134d(msg);
        }
    }

    /* renamed from: i */
    public static void m139i(boolean enable, String msg) {
        if (enable) {
            mCall_Depth++;
            m138i(msg);
        }
    }

    /* renamed from: w */
    public static void m143w(boolean enable, String msg) {
        if (enable) {
            mCall_Depth++;
            m142w(msg);
        }
    }

    /* renamed from: e */
    public static void m137e(boolean enable, String msg) {
        if (enable) {
            mCall_Depth++;
            m136e(msg);
        }
    }

    public static void printStackInfo(int... param) {
        if (!$assertionsDisabled && param.length <= 1) {
            throw new AssertionError();
        }
        int count = param.length == 0 ? 2 : param[0];
        StackTraceElement[] stackInfo = new Throwable().getStackTrace();
        for (int i = 2; i < count + 1; i++) {
            m134d(String.valueOf(stackInfo[i].getMethodName()) + "() line :" + stackInfo[i].getLineNumber());
        }
    }
}
