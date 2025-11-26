package com.sec.chaton.push.util;

import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class PushLog {

    /* renamed from: a */
    private static boolean f2789a = false;

    /* renamed from: b */
    private static boolean f2790b = false;

    /* renamed from: c */
    private static boolean f2791c = false;

    /* renamed from: d */
    private static boolean f2792d = false;

    /* renamed from: e */
    private static boolean f2793e = true;

    /* renamed from: f */
    private static boolean f2794f;

    /* renamed from: g */
    private static FileOutputStream f2795g;

    static {
        f2794f = false;
        try {
            if (f2793e && Environment.getExternalStorageState().equals("mounted")) {
                new File(Environment.getExternalStorageDirectory() + File.separator + "push").mkdir();
                f2795g = new FileOutputStream(new File(Environment.getExternalStorageDirectory() + File.separator + "push" + File.separator + "log.txt"), true);
                f2794f = true;
            }
        } catch (Throwable th) {
            Log.e("PushModule", "Can't initialize file logger", th);
        }
    }

    /* renamed from: a */
    public static void m3025a(String str, String str2) {
        if (f2789a) {
            Log.d("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
            if (f2793e) {
                m3032e(str, str2);
            }
        }
    }

    /* renamed from: a */
    public static void m3026a(String str, String str2, Throwable th) {
        if (f2792d) {
            Log.e("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2, th);
            if (f2793e) {
                m3029b(str, str2, th);
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m3027a(boolean z, boolean z2, boolean z3, boolean z4) {
        f2789a = z;
        f2790b = z2;
        f2791c = z3;
        f2792d = z4;
    }

    /* renamed from: b */
    public static void m3028b(String str, String str2) {
        if (f2790b) {
            Log.i("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
            if (f2793e) {
                m3033f(str, str2);
            }
        }
    }

    /* renamed from: b */
    private static synchronized void m3029b(String str, String str2, Throwable th) {
        try {
            if (f2794f) {
                f2795g.write(("[ERROR] " + DateFormat.format("MM/dd/yy hh:mm:ss", System.currentTimeMillis()) + " " + str + " " + str2 + "\n" + Log.getStackTraceString(th) + "\n").getBytes());
                f2795g.flush();
            }
        } catch (Throwable th2) {
            Log.e("PushModule", "Can't writer log to file", th2);
        }
    }

    /* renamed from: c */
    public static void m3030c(String str, String str2) {
        if (f2791c) {
            Log.w("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
            if (f2793e) {
                m3034g(str, str2);
            }
        }
    }

    /* renamed from: d */
    public static void m3031d(String str, String str2) {
        if (f2792d) {
            Log.e("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
            if (f2793e) {
                m3035h(str, str2);
            }
        }
    }

    /* renamed from: e */
    private static synchronized void m3032e(String str, String str2) {
        try {
        } catch (Throwable th) {
            Log.e("PushModule", "Can't writer log to file", th);
        }
        if (f2794f) {
            f2795g.write(("[DEBUG] " + DateFormat.format("MM/dd/yy hh:mm:ss", System.currentTimeMillis()) + " " + str + " " + str2 + "\n").getBytes());
            f2795g.flush();
        }
    }

    /* renamed from: f */
    private static synchronized void m3033f(String str, String str2) {
        try {
        } catch (Throwable th) {
            Log.e("PushModule", "Can't writer log to file", th);
        }
        if (f2794f) {
            f2795g.write(("[INFO] " + DateFormat.format("MM/dd/yy hh:mm:ss", System.currentTimeMillis()) + " " + str + " " + str2 + "\n").getBytes());
            f2795g.flush();
        }
    }

    /* renamed from: g */
    private static synchronized void m3034g(String str, String str2) {
        try {
        } catch (Throwable th) {
            Log.e("PushModule", "Can't writer log to file", th);
        }
        if (f2794f) {
            f2795g.write(("[WARNING] " + DateFormat.format("MM/dd/yy hh:mm:ss", System.currentTimeMillis()) + " " + str + " " + str2 + "\n").getBytes());
            f2795g.flush();
        }
    }

    /* renamed from: h */
    private static synchronized void m3035h(String str, String str2) {
        try {
        } catch (Throwable th) {
            Log.e("PushModule", "Can't writer log to file", th);
        }
        if (f2794f) {
            f2795g.write(("[ERROR] " + DateFormat.format("MM/dd/yy hh:mm:ss", System.currentTimeMillis()) + " " + str + " " + str2 + "\n").getBytes());
            f2795g.flush();
        }
    }
}
