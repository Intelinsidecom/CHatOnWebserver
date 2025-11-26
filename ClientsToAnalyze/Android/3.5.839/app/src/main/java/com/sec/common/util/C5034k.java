package com.sec.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: DeviceUtils.java */
/* renamed from: com.sec.common.util.k */
/* loaded from: classes.dex */
public class C5034k {

    /* renamed from: a */
    private static final Calendar f18345a = Calendar.getInstance();

    /* renamed from: b */
    private static final Calendar f18346b = Calendar.getInstance();

    /* renamed from: c */
    private static int f18347c;

    /* renamed from: d */
    private static int f18348d;

    /* renamed from: a */
    public static long m19090a() {
        return System.currentTimeMillis() - TimeZone.getDefault().getOffset(r0);
    }

    /* renamed from: b */
    public static int m19096b() {
        return ((WindowManager) CommonApplication.m18732r().getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* renamed from: c */
    public static int m19098c() {
        return ((WindowManager) CommonApplication.m18732r().getSystemService("window")).getDefaultDisplay().getHeight();
    }

    /* renamed from: d */
    public static boolean m19099d() {
        return CommonApplication.m18732r().getResources().getDisplayMetrics().densityDpi >= 320;
    }

    /* renamed from: e */
    public static int m19100e() {
        if (f18347c == 0 || f18348d == 0) {
            m19108m();
        }
        return f18347c;
    }

    /* renamed from: f */
    public static int m19101f() {
        if (f18347c == 0 || f18348d == 0) {
            m19108m();
        }
        return f18348d;
    }

    /* renamed from: m */
    private static void m19108m() {
        Display defaultDisplay = ((WindowManager) CommonApplication.m18732r().getSystemService("window")).getDefaultDisplay();
        try {
            f18347c = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            f18348d = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e2) {
        } catch (NoSuchMethodException e3) {
        } catch (InvocationTargetException e4) {
        }
        if (f18347c == 0 || f18348d == 0) {
            f18347c = defaultDisplay.getWidth();
            f18348d = defaultDisplay.getHeight();
        }
        switch (defaultDisplay.getRotation()) {
            case 1:
            case 3:
                int i = f18347c;
                f18347c = f18348d;
                f18348d = i;
                break;
        }
    }

    /* renamed from: g */
    public static boolean m19102g() {
        return ((Integer) Debug.class.getMethod("isProductShip", null).invoke(null, null)).intValue() == 1;
    }

    /* renamed from: a */
    public static boolean m19094a(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("address", "000");
        intent.setType("vnd.android-dir/mms-sms");
        return C5047m.m19188a(context, intent);
    }

    /* renamed from: a */
    public static boolean m19095a(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            if (!C4996f.f18229a.f18171c) {
                return true;
            }
            C4996f.f18229a.m18892f("isApplicationInstalled", C5052r.m19199a(str, " was installed"));
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f("isApplicationInstalled", C5052r.m19199a(str, " was NOT installed"));
            }
            return false;
        }
    }

    /* renamed from: a */
    public static Intent m19091a(String str, String str2) {
        Intent intent = new Intent();
        if (TextUtils.isEmpty(str)) {
            intent.setAction("android.intent.action.SEND").setType("text/plain");
        } else {
            intent.setAction("android.intent.action.SENDTO").setData(Uri.parse("smsto:" + str));
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("sms_body", str2);
        }
        return intent;
    }

    /* renamed from: a */
    public static int m19089a(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        switch (rotation) {
            case 0:
                if (i2 <= i) {
                    break;
                }
                break;
            case 1:
                if (i2 <= i) {
                    break;
                } else {
                    break;
                }
            case 2:
                if (i2 <= i) {
                    break;
                } else {
                    break;
                }
            case 3:
                if (i2 <= i) {
                    break;
                }
                break;
        }
        return 1;
    }

    /* renamed from: h */
    public static long m19103h() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    /* renamed from: i */
    public static long m19104i() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    /* renamed from: a */
    public static String m19092a(long j) {
        String str = null;
        double d = j;
        if (d >= 1024.0d) {
            str = "KB";
            d /= 1024.0d;
            if (d >= 1024.0d) {
                str = "MB";
                d /= 1024.0d;
                if (d >= 1024.0d) {
                    str = "GB";
                    d /= 1024.0d;
                }
            }
        }
        StringBuilder sb = new StringBuilder(String.format("%.2f", Double.valueOf(d)));
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    /* renamed from: j */
    public static boolean m19105j() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) CommonApplication.m18732r().getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1 && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING);
    }

    /* renamed from: k */
    public static boolean m19106k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.m18732r().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: l */
    public static String m19107l() {
        boolean zIsConnected;
        String subtypeName;
        boolean zIsConnected2 = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) CommonApplication.m18732r().getSystemService("connectivity");
        String subtypeName2 = "";
        if (connectivityManager == null) {
            return "No network";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        boolean zIsConnected3 = networkInfo != null ? networkInfo.isConnected() : false;
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(6);
        if (networkInfo2 != null) {
            zIsConnected = networkInfo2.isConnected();
            try {
                subtypeName2 = networkInfo2.getSubtypeName();
            } catch (NullPointerException e) {
            }
        } else {
            zIsConnected = false;
        }
        NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
        if (networkInfo3 == null) {
            subtypeName = "";
        } else {
            zIsConnected2 = networkInfo3.isConnected();
            try {
                subtypeName = networkInfo3.getSubtypeName();
            } catch (NullPointerException e2) {
                subtypeName = "";
            }
        }
        if (zIsConnected3) {
            return "WIFI";
        }
        if (zIsConnected) {
            return "WIMAX(" + subtypeName2 + ")";
        }
        if (zIsConnected2) {
            return "Mobile(" + subtypeName + ")";
        }
        return "No network";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean m19093a(long r5, long r7) {
        /*
            r0 = 1
            java.lang.Class<com.sec.common.util.k> r1 = com.sec.common.util.C5034k.class
            monitor-enter(r1)
            java.util.Calendar r2 = com.sec.common.util.C5034k.f18345a     // Catch: java.lang.Throwable -> L41
            r2.setTimeInMillis(r5)     // Catch: java.lang.Throwable -> L41
            java.util.Calendar r2 = com.sec.common.util.C5034k.f18346b     // Catch: java.lang.Throwable -> L41
            r2.setTimeInMillis(r7)     // Catch: java.lang.Throwable -> L41
            java.util.Calendar r2 = com.sec.common.util.C5034k.f18345a     // Catch: java.lang.Throwable -> L41
            r3 = 1
            int r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L41
            java.util.Calendar r3 = com.sec.common.util.C5034k.f18346b     // Catch: java.lang.Throwable -> L41
            r4 = 1
            int r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L41
            if (r2 != r3) goto L3e
            java.util.Calendar r2 = com.sec.common.util.C5034k.f18345a     // Catch: java.lang.Throwable -> L41
            r3 = 2
            int r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L41
            java.util.Calendar r3 = com.sec.common.util.C5034k.f18346b     // Catch: java.lang.Throwable -> L41
            r4 = 2
            int r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L41
            if (r2 != r3) goto L3e
            java.util.Calendar r2 = com.sec.common.util.C5034k.f18345a     // Catch: java.lang.Throwable -> L41
            r3 = 5
            int r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L41
            java.util.Calendar r3 = com.sec.common.util.C5034k.f18346b     // Catch: java.lang.Throwable -> L41
            r4 = 5
            int r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L41
            if (r2 == r3) goto L3f
        L3e:
            r0 = 0
        L3f:
            monitor-exit(r1)
            return r0
        L41:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.util.C5034k.m19093a(long, long):boolean");
    }

    /* renamed from: a */
    public static float m19088a(float f) {
        return TypedValue.applyDimension(1, f, CommonApplication.m18732r().getResources().getDisplayMetrics());
    }

    /* renamed from: b */
    public static int m19097b(float f) {
        return (int) ((f / CommonApplication.m18732r().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
