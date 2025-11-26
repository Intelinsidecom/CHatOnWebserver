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
import android.view.Display;
import android.view.WindowManager;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import java.lang.reflect.InvocationTargetException;
import java.util.TimeZone;

/* compiled from: DeviceUtils.java */
/* renamed from: com.sec.common.util.i */
/* loaded from: classes.dex */
public class C3347i {

    /* renamed from: a */
    private static int f12080a;

    /* renamed from: b */
    private static int f12081b;

    /* renamed from: a */
    public static long m11774a() {
        return System.currentTimeMillis() - TimeZone.getDefault().getOffset(r0);
    }

    /* renamed from: b */
    public static int m11779b() {
        return ((WindowManager) CommonApplication.m11493l().getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* renamed from: c */
    public static int m11780c() {
        return ((WindowManager) CommonApplication.m11493l().getSystemService("window")).getDefaultDisplay().getHeight();
    }

    /* renamed from: d */
    public static boolean m11781d() {
        return CommonApplication.m11493l().getResources().getDisplayMetrics().densityDpi >= 320;
    }

    /* renamed from: e */
    public static int m11782e() {
        if (f12080a == 0 || f12081b == 0) {
            m11790m();
        }
        return f12080a;
    }

    /* renamed from: f */
    public static int m11783f() {
        if (f12080a == 0 || f12081b == 0) {
            m11790m();
        }
        return f12081b;
    }

    /* renamed from: m */
    private static void m11790m() {
        Display defaultDisplay = ((WindowManager) CommonApplication.m11493l().getSystemService("window")).getDefaultDisplay();
        try {
            f12080a = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            f12081b = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e2) {
        } catch (NoSuchMethodException e3) {
        } catch (InvocationTargetException e4) {
        }
        if (f12080a == 0 || f12081b == 0) {
            f12080a = defaultDisplay.getWidth();
            f12081b = defaultDisplay.getHeight();
        }
        switch (defaultDisplay.getRotation()) {
            case 1:
            case 3:
                int i = f12080a;
                f12080a = f12081b;
                f12081b = i;
                break;
        }
    }

    /* renamed from: g */
    public static boolean m11784g() {
        return ((Integer) Debug.class.getMethod("isProductShip", null).invoke(null, null)).intValue() == 1;
    }

    /* renamed from: a */
    public static boolean m11777a(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("address", "000");
        intent.setType("vnd.android-dir/mms-sms");
        return C3349k.m11798a(context, intent);
    }

    /* renamed from: a */
    public static boolean m11778a(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            if (!C3330f.f12033a.f11972b) {
                return true;
            }
            C3330f.f12033a.m11651a("isApplicationInstalled", C3364o.m11849a(str, " was installed"));
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a("isApplicationInstalled", C3364o.m11849a(str, " was NOT installed"));
            }
            return false;
        }
    }

    /* renamed from: a */
    public static Intent m11775a(String str, String str2) {
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
    public static int m11773a(Activity activity) {
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
    public static long m11785h() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    /* renamed from: i */
    public static long m11786i() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    /* renamed from: a */
    public static String m11776a(long j) {
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
    public static boolean m11787j() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) CommonApplication.m11493l().getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1 && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING);
    }

    /* renamed from: k */
    public static boolean m11788k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) CommonApplication.m11493l().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: l */
    public static String m11789l() {
        boolean zIsConnected;
        String subtypeName;
        boolean zIsConnected2 = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) CommonApplication.m11493l().getSystemService("connectivity");
        String subtypeName2 = "";
        if (connectivityManager == null) {
            return "No network";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        boolean zIsConnected3 = networkInfo != null ? networkInfo.isConnected() : false;
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(6);
        if (networkInfo2 != null) {
            zIsConnected = networkInfo2.isConnected();
            subtypeName2 = networkInfo2.getSubtypeName();
        } else {
            zIsConnected = false;
        }
        NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
        if (networkInfo3 == null) {
            subtypeName = "";
        } else {
            zIsConnected2 = networkInfo3.isConnected();
            subtypeName = networkInfo3.getSubtypeName();
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
}
