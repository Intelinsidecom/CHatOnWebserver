package com.sds.coolots.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.IOException;

/* loaded from: classes.dex */
public class Log {

    /* renamed from: b */
    public static final int f3072b = 1;

    /* renamed from: c */
    public static final int f3073c = 2;

    /* renamed from: d */
    public static final int f3074d = 3;

    /* renamed from: e */
    public static final int f3075e = 4;

    /* renamed from: f */
    public static final int f3076f = 5;

    /* renamed from: h */
    private static final String f3078h = "COOLOTS";

    /* renamed from: i */
    private static final boolean f3079i = true;

    /* renamed from: a */
    public static String f3071a = "(UNKNOWN)";

    /* renamed from: g */
    public static int f3077g = 1;

    /* renamed from: d */
    public static int m2952d(Object obj) throws IOException {
        if (f3077g < 4) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + getString(obj));
        return android.util.Log.d("COOLOTS", String.valueOf(f3071a) + getString(obj));
    }

    /* renamed from: d */
    public static int m2953d(Object obj, Throwable th) throws IOException {
        if (f3077g < 4) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + getString(obj));
        return android.util.Log.d("COOLOTS", String.valueOf(f3071a) + getString(obj), th);
    }

    /* renamed from: d */
    public static int m2954d(String str) {
        if (f3077g < 4) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.d("COOLOTS", String.valueOf(f3071a) + str);
    }

    /* renamed from: d */
    public static int m2955d(String str, Throwable th) throws IOException {
        if (f3077g < 4) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.d("COOLOTS", String.valueOf(f3071a) + str, th);
    }

    /* renamed from: e */
    public static int m2956e(Object obj) throws IOException {
        if (f3077g < 1) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + getString(obj));
        return android.util.Log.e("COOLOTS", String.valueOf(f3071a) + getString(obj));
    }

    /* renamed from: e */
    public static int m2957e(Object obj, Throwable th) throws IOException {
        if (f3077g < 1) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + getString(obj));
        return android.util.Log.e("COOLOTS", String.valueOf(f3071a) + getString(obj), th);
    }

    /* renamed from: e */
    public static int m2958e(String str) {
        if (f3077g < 1) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.e("COOLOTS", String.valueOf(f3071a) + str);
    }

    /* renamed from: e */
    public static int m2959e(String str, Throwable th) throws IOException {
        if (f3077g < 1) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.e("COOLOTS", String.valueOf(f3071a) + str, th);
    }

    /* renamed from: e */
    public static int m2960e(Throwable th) throws IOException {
        if (f3077g < 1) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + th);
        return android.util.Log.e("COOLOTS", f3071a, th);
    }

    public static int engine(String str) throws Throwable {
        C1261b.m2996b(" : ENGINE_LOG : " + f3071a + str);
        return 1;
    }

    public static String getStackTraceString(Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    public static String getString(Object obj) {
        return obj instanceof Integer ? Integer.toString(((Integer) obj).intValue()) : obj instanceof Long ? Long.toString(((Long) obj).longValue()) : obj instanceof Float ? Float.toString(((Float) obj).floatValue()) : obj instanceof Double ? Double.toString(((Double) obj).doubleValue()) : obj instanceof Character ? Character.toString(((Character) obj).charValue()) : "";
    }

    /* renamed from: i */
    public static int m2961i(Object obj) throws IOException {
        if (f3077g < 3) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + getString(obj));
        return android.util.Log.i("COOLOTS", String.valueOf(f3071a) + getString(obj));
    }

    /* renamed from: i */
    public static int m2962i(Object obj, Throwable th) throws IOException {
        if (f3077g < 3) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + getString(obj));
        return android.util.Log.i("COOLOTS", String.valueOf(f3071a) + getString(obj), th);
    }

    /* renamed from: i */
    public static int m2963i(String str) {
        if (f3077g < 3) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.i("COOLOTS", String.valueOf(f3071a) + str);
    }

    /* renamed from: i */
    public static int m2964i(String str, Throwable th) throws IOException {
        if (f3077g < 3) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.i("COOLOTS", String.valueOf(f3071a) + str, th);
    }

    public static boolean isLoggable(int i) {
        return android.util.Log.isLoggable("COOLOTS", i);
    }

    public static int println(int i, String str) {
        return android.util.Log.println(i, "COOLOTS", str);
    }

    public static void setLogLevel(int i) {
        f3077g = i;
    }

    public static void setVersionInfo(Context context) throws PackageManager.NameNotFoundException {
        C1261b.m2992a(context);
        try {
            f3071a = "(" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName + ")";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setVersionInfo(String str) {
        f3071a = "(" + str + ")";
    }

    /* renamed from: v */
    public static int m2965v(Object obj) throws IOException {
        if (f3077g < 5) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + getString(obj));
        return android.util.Log.v("COOLOTS", String.valueOf(f3071a) + getString(obj));
    }

    /* renamed from: v */
    public static int m2966v(Object obj, Throwable th) throws IOException {
        if (f3077g < 5) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + getString(obj));
        return android.util.Log.v("COOLOTS", String.valueOf(f3071a) + getString(obj), th);
    }

    /* renamed from: v */
    public static int m2967v(String str) throws IOException {
        if (f3077g < 5) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.v("COOLOTS", String.valueOf(f3071a) + str);
    }

    /* renamed from: v */
    public static int m2968v(String str, Throwable th) throws IOException {
        if (f3077g < 5) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.v("COOLOTS", String.valueOf(f3071a) + str, th);
    }

    /* renamed from: w */
    public static int m2969w(Object obj) throws IOException {
        if (f3077g < 2) {
            return 0;
        }
        C1261b.m2993a(" : " + f3071a + getString(obj));
        return android.util.Log.w("COOLOTS", String.valueOf(f3071a) + getString(obj));
    }

    /* renamed from: w */
    public static int m2970w(Object obj, Throwable th) throws IOException {
        if (f3077g < 2) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + getString(obj));
        return android.util.Log.w("COOLOTS", String.valueOf(f3071a) + getString(obj), th);
    }

    /* renamed from: w */
    public static int m2971w(String str) throws IOException {
        if (f3077g < 2) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.w("COOLOTS", String.valueOf(f3071a) + str);
    }

    /* renamed from: w */
    public static int m2972w(String str, Throwable th) throws IOException {
        if (f3077g < 2) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + str);
        return android.util.Log.w("COOLOTS", String.valueOf(f3071a) + str, th);
    }

    /* renamed from: w */
    public static int m2973w(Throwable th) throws IOException {
        if (f3077g < 2) {
            return 0;
        }
        C1261b.m2993a(" : COOLOTS : " + f3071a + th);
        return android.util.Log.w("COOLOTS", th);
    }
}
