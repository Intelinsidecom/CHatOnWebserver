package com.sec.chaton.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.util.C0921g;

/* compiled from: PushClientPreference.java */
/* renamed from: com.sec.chaton.push.h */
/* loaded from: classes.dex */
public class C0904h {

    /* renamed from: a */
    private static final String f3074a = C0904h.class.getSimpleName();

    /* renamed from: b */
    private static final Object f3075b = new Object();

    /* renamed from: c */
    private static final Object f3076c = new Object();

    /* renamed from: d */
    private static final Object f3077d = new Object();

    /* renamed from: e */
    private static SharedPreferences f3078e = PushClientApplication.m3436a().getSharedPreferences("com.sec.chaton.push.config", 0);

    /* renamed from: a */
    public static SharedPreferences.Editor m3538a() {
        return f3078e.edit();
    }

    /* renamed from: a */
    public static String m3539a(String str) {
        String string = f3078e.getString("deviceId", null);
        if (C0921g.f3116a) {
            C0921g.m3637a(f3074a, String.format("Saved IMEI: %s.", string));
        }
        if (string == null) {
            Context contextM3436a = PushClientApplication.m3436a();
            string = ((TelephonyManager) contextM3436a.getSystemService("phone")).getDeviceId();
            if (string != null) {
                SharedPreferences.Editor editorM3538a = m3538a();
                editorM3538a.putString("deviceId", string);
                editorM3538a.commit();
            } else {
                if (C0921g.f3118c) {
                    C0921g.m3641c(f3074a, "This device has no IMEI. Using MAC address instead of IMEI.");
                }
                string = ((WifiManager) contextM3436a.getSystemService("wifi")).getConnectionInfo().getMacAddress().replace(":", "");
                StringBuffer stringBuffer = new StringBuffer();
                if (string != null) {
                    for (int length = string.length(); length < 14; length++) {
                        stringBuffer.append("M");
                    }
                    string = ((Object) stringBuffer) + string;
                    SharedPreferences.Editor editorM3538a2 = m3538a();
                    editorM3538a2.putString("deviceId", string);
                    editorM3538a2.commit();
                    if (C0921g.f3116a) {
                        C0921g.m3637a(f3074a, String.format("MAC address is %s.", string));
                    }
                } else if (C0921g.f3118c) {
                    C0921g.m3641c(f3074a, "This Device has no Mac Address");
                }
            }
        }
        return string;
    }

    /* renamed from: b */
    public static String m3546b(String str) {
        String string;
        synchronized (f3075b) {
            string = f3078e.getString("deviceToken", str);
        }
        return string;
    }

    /* renamed from: c */
    public static String m3552c(String str) {
        String string;
        synchronized (f3075b) {
            string = f3078e.getString("primaryIp", str);
        }
        return string;
    }

    /* renamed from: a */
    public static int m3537a(int i) {
        int i2;
        synchronized (f3075b) {
            i2 = f3078e.getInt("primaryPort", i);
        }
        return i2;
    }

    /* renamed from: d */
    public static String m3556d(String str) {
        String string;
        synchronized (f3075b) {
            string = f3078e.getString("secondaryIp", str);
        }
        return string;
    }

    /* renamed from: b */
    public static int m3545b(int i) {
        int i2;
        synchronized (f3075b) {
            i2 = f3078e.getInt("secondaryPort", i);
        }
        return i2;
    }

    /* renamed from: c */
    public static int m3551c(int i) {
        int i2;
        synchronized (f3075b) {
            i2 = f3078e.getInt("pingInterval", i);
        }
        return i2;
    }

    /* renamed from: a */
    public static void m3542a(SharedPreferences.Editor editor, String str) {
        editor.putString("deviceId", str);
    }

    /* renamed from: a */
    public static void m3540a(SharedPreferences.Editor editor) {
        synchronized (f3075b) {
            editor.remove("deviceToken");
        }
    }

    /* renamed from: b */
    public static void m3548b(SharedPreferences.Editor editor) {
        synchronized (f3075b) {
            editor.remove("primaryIp");
        }
    }

    /* renamed from: c */
    public static void m3553c(SharedPreferences.Editor editor) {
        synchronized (f3075b) {
            editor.remove("primaryPort");
        }
    }

    /* renamed from: d */
    public static void m3557d(SharedPreferences.Editor editor) {
        synchronized (f3075b) {
            editor.remove("secondaryIp");
        }
    }

    /* renamed from: e */
    public static void m3561e(SharedPreferences.Editor editor) {
        synchronized (f3075b) {
            editor.remove("secondaryPort");
        }
    }

    /* renamed from: f */
    public static void m3563f(SharedPreferences.Editor editor) {
        synchronized (f3075b) {
            editor.remove("pingInterval");
        }
    }

    /* renamed from: b */
    public static void m3547b() {
        synchronized (f3075b) {
            SharedPreferences.Editor editorM3538a = m3538a();
            m3540a(editorM3538a);
            m3548b(editorM3538a);
            m3553c(editorM3538a);
            m3557d(editorM3538a);
            m3561e(editorM3538a);
            m3563f(editorM3538a);
            editorM3538a.commit();
        }
    }

    /* renamed from: a */
    public static void m3544a(String str, String str2, int i, String str3, int i2, int i3) {
        synchronized (f3075b) {
            SharedPreferences.Editor editorM3538a = m3538a();
            editorM3538a.putString("deviceToken", str);
            editorM3538a.putString("primaryIp", str2);
            editorM3538a.putInt("primaryPort", i);
            editorM3538a.putString("secondaryIp", str3);
            editorM3538a.putInt("secondaryPort", i2);
            editorM3538a.putInt("pingInterval", i3);
            editorM3538a.commit();
        }
    }

    /* renamed from: b */
    public static void m3550b(SharedPreferences.Editor editor, String str) {
        synchronized (f3076c) {
            editor.putString("appId", str);
        }
    }

    /* renamed from: g */
    public static void m3565g(SharedPreferences.Editor editor) {
        synchronized (f3076c) {
            editor.remove("appId");
        }
    }

    /* renamed from: e */
    public static String m3560e(String str) {
        String string;
        synchronized (f3076c) {
            string = f3078e.getString("appId", str);
        }
        return string;
    }

    /* renamed from: c */
    public static void m3554c(SharedPreferences.Editor editor, String str) {
        synchronized (f3076c) {
            editor.putString("regId", str);
        }
    }

    /* renamed from: h */
    public static void m3567h(SharedPreferences.Editor editor) {
        synchronized (f3076c) {
            editor.remove("regId");
        }
    }

    /* renamed from: f */
    public static String m3562f(String str) {
        String string;
        synchronized (f3076c) {
            string = f3078e.getString("regId", str);
        }
        return string;
    }

    /* renamed from: d */
    public static void m3558d(SharedPreferences.Editor editor, String str) {
        synchronized (f3077d) {
            editor.putString("expireDate", str);
        }
    }

    /* renamed from: g */
    public static String m3564g(String str) {
        String string;
        synchronized (f3077d) {
            string = f3078e.getString("expireDate", str);
        }
        return string;
    }

    /* renamed from: h */
    public static String m3566h(String str) {
        String string;
        synchronized (f3077d) {
            string = f3078e.getString("networkOperator", str);
        }
        return string;
    }

    /* renamed from: a */
    public static void m3541a(SharedPreferences.Editor editor, int i) {
        synchronized (f3077d) {
            editor.putInt("failCount", i);
        }
    }

    /* renamed from: d */
    public static int m3555d(int i) {
        int i2;
        synchronized (f3077d) {
            i2 = f3078e.getInt("failCount", i);
        }
        return i2;
    }

    /* renamed from: b */
    public static void m3549b(SharedPreferences.Editor editor, int i) {
        synchronized (f3077d) {
            editor.putInt("topBaseCount", i);
        }
    }

    /* renamed from: e */
    public static int m3559e(int i) {
        int i2;
        synchronized (f3077d) {
            i2 = f3078e.getInt("topBaseCount", i);
        }
        return i2;
    }

    /* renamed from: a */
    public static void m3543a(String str, int i, int i2) {
        synchronized (f3077d) {
            SharedPreferences.Editor editorM3538a = m3538a();
            editorM3538a.putString("networkOperator", str);
            editorM3538a.putInt("failCount", i);
            editorM3538a.putInt("topBaseCount", i2);
            editorM3538a.commit();
        }
    }
}
