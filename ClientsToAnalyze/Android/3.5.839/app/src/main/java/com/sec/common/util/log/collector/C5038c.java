package com.sec.common.util.log.collector;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import com.sec.spp.push.dlc.api.IDlcService;

/* compiled from: LogCollectorManager.java */
/* renamed from: com.sec.common.util.log.collector.c */
/* loaded from: classes.dex */
public class C5038c {

    /* renamed from: j */
    private static IDlcService f18371j;

    /* renamed from: a */
    private static final String f18362a = C5038c.class.getName();

    /* renamed from: b */
    private static String f18363b = "";

    /* renamed from: c */
    private static String f18364c = "";

    /* renamed from: d */
    private static String f18365d = "";

    /* renamed from: e */
    private static String f18366e = "";

    /* renamed from: f */
    private static String f18367f = "";

    /* renamed from: g */
    private static String f18368g = "";

    /* renamed from: h */
    private static boolean f18369h = false;

    /* renamed from: i */
    private static boolean f18370i = false;

    /* renamed from: k */
    private static ServiceConnection f18372k = new ServiceConnectionC5039d();

    /* renamed from: a */
    public static String m19143a() {
        try {
            return CommonApplication.m18732r().getPackageManager().getPackageInfo(Config.CHATON_PACKAGE_NAME, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "1.1.1";
        }
    }

    /* renamed from: b */
    public static boolean m19150b() {
        return f18370i;
    }

    /* renamed from: a */
    public static void m19146a(boolean z) {
        f18370i = z;
    }

    /* renamed from: c */
    public static IDlcService m19151c() {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18893g(f18362a, "service :: " + f18371j.toString());
        }
        return f18371j;
    }

    /* renamed from: d */
    public static IDlcService m19154d() {
        return f18371j;
    }

    /* renamed from: a */
    public static void m19144a(IDlcService iDlcService) {
        f18371j = iDlcService;
        if (C4996f.f18229a.f18171c) {
            if (iDlcService == null) {
                f18371j = null;
                C4996f.f18229a.m18893g(f18362a, "setService NULL");
            } else {
                C4996f.f18229a.m18893g(f18362a, "setService :: " + f18371j.toString());
            }
        }
    }

    /* renamed from: e */
    public static String m19156e() {
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m18732r().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                try {
                    return simOperator.substring(0, 3);
                } catch (StringIndexOutOfBoundsException e) {
                }
            }
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            try {
                return networkOperator.substring(0, 3);
            } catch (StringIndexOutOfBoundsException e2) {
            }
        }
        return "";
    }

    /* renamed from: f */
    public static String m19157f() {
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m18732r().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                try {
                    return simOperator.substring(3);
                } catch (StringIndexOutOfBoundsException e) {
                }
            }
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            try {
                return networkOperator.substring(3);
            } catch (StringIndexOutOfBoundsException e2) {
            }
        }
        return "";
    }

    /* renamed from: g */
    public static String m19158g() {
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

    /* renamed from: h */
    public static void m19159h() {
        f18367f = m19157f();
    }

    /* renamed from: i */
    public static String m19160i() {
        if (TextUtils.isEmpty(f18367f)) {
            f18367f = m19157f();
        }
        return f18367f;
    }

    /* renamed from: j */
    public static void m19161j() {
        f18366e = m19156e();
    }

    /* renamed from: k */
    public static String m19162k() {
        if (TextUtils.isEmpty(f18366e)) {
            f18366e = m19156e();
        }
        return f18366e;
    }

    /* renamed from: a */
    public static void m19145a(String str) {
        f18368g = str;
    }

    /* renamed from: l */
    public static String m19163l() {
        if (TextUtils.isEmpty(f18368g)) {
            m19145a(m19158g());
        }
        return f18368g;
    }

    /* renamed from: b */
    public static void m19148b(String str) {
        f18364c = str;
    }

    /* renamed from: m */
    public static String m19164m() {
        return f18364c;
    }

    /* renamed from: c */
    public static void m19152c(String str) {
        f18365d = str;
    }

    /* renamed from: n */
    public static String m19165n() {
        return f18365d;
    }

    /* renamed from: d */
    public static void m19155d(String str) {
        f18363b = str;
    }

    /* renamed from: o */
    public static String m19166o() {
        return f18363b;
    }

    /* renamed from: p */
    public static boolean m19167p() {
        return CommonApplication.m18732r().getSharedPreferences("common_library_prefs", 0).getBoolean("log_collector_registered", false);
    }

    /* renamed from: b */
    public static void m19149b(boolean z) {
        SharedPreferences.Editor editorEdit = CommonApplication.m18732r().getSharedPreferences("common_library_prefs", 0).edit();
        editorEdit.putBoolean("log_collector_registered", z);
        editorEdit.commit();
    }

    /* renamed from: a */
    public static boolean m19147a(long j) {
        boolean z = false;
        SharedPreferences sharedPreferences = CommonApplication.m18732r().getSharedPreferences("common_library_prefs", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (sharedPreferences.contains("last_excute_time") && j - sharedPreferences.getLong("last_excute_time", 0L) > 172800000) {
            z = true;
        }
        editorEdit.putLong("last_excute_time", j);
        editorEdit.commit();
        return z;
    }

    /* renamed from: q */
    public static boolean m19168q() {
        return CommonApplication.m18732r().getSharedPreferences("common_library_prefs", 0).getBoolean("log_collector_enabled", false);
    }

    /* renamed from: c */
    public static void m19153c(boolean z) {
        SharedPreferences.Editor editorEdit = CommonApplication.m18732r().getSharedPreferences("common_library_prefs", 0).edit();
        editorEdit.putBoolean("log_collector_enabled", z);
        editorEdit.commit();
    }

    /* renamed from: r */
    public static void m19169r() {
        if (m19167p()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.sec.spp.push", "com.sec.spp.push.dlc.writer.WriterService"));
            if (!CommonApplication.m18732r().bindService(intent, f18372k, 1) && C4996f.f18229a.f18172d) {
                C4996f.f18229a.m18893g("bind service failed", f18362a);
            }
        }
    }

    /* renamed from: s */
    public static void m19170s() {
        if (m19151c() != null) {
            CommonApplication.m18732r().unbindService(f18372k);
            m19144a((IDlcService) null);
            m19146a(false);
            if (C4996f.f18229a.f18172d) {
                C4996f.f18229a.m18893g("LogCollectorService is disconnected", f18362a);
            }
        }
    }

    /* renamed from: t */
    public static void m19171t() {
        if (m19168q()) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18362a, "LogCollect closeDatabae()");
            }
            C5036a.m19120a().close();
        }
    }
}
