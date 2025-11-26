package com.sec.chaton.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.util.C1139g;

/* compiled from: PushClientPreference.java */
/* renamed from: com.sec.chaton.push.j */
/* loaded from: classes.dex */
public class C1126j {

    /* renamed from: a */
    private static final String f4105a = C1126j.class.getSimpleName();

    /* renamed from: b */
    private static final Object f4106b = new Object();

    /* renamed from: c */
    private static final Object f4107c = new Object();

    /* renamed from: d */
    private static final Object f4108d = new Object();

    /* renamed from: e */
    private static SharedPreferences f4109e = PushClientApplication.m4111g().getSharedPreferences("com.sec.chaton.push.config", 0);

    /* renamed from: a */
    public static SharedPreferences.Editor m4240a() {
        return f4109e.edit();
    }

    /* renamed from: a */
    public static String m4241a(String str) {
        String string = f4109e.getString("deviceId", null);
        if (C1139g.f4142a) {
            C1139g.m4308a(f4105a, String.format("Saved IMEI: %s.", string));
        }
        if (string == null) {
            Context contextM4111g = PushClientApplication.m4111g();
            string = ((TelephonyManager) contextM4111g.getSystemService("phone")).getDeviceId();
            if (string != null) {
                SharedPreferences.Editor editorM4240a = m4240a();
                editorM4240a.putString("deviceId", string);
                editorM4240a.commit();
            } else {
                if (C1139g.f4144c) {
                    C1139g.m4312c(f4105a, "This device has no IMEI. Using MAC address instead of IMEI.");
                }
                string = ((WifiManager) contextM4111g.getSystemService("wifi")).getConnectionInfo().getMacAddress().replace(":", "");
                StringBuffer stringBuffer = new StringBuffer();
                if (string != null) {
                    for (int length = string.length(); length < 14; length++) {
                        stringBuffer.append("M");
                    }
                    string = ((Object) stringBuffer) + string;
                    SharedPreferences.Editor editorM4240a2 = m4240a();
                    editorM4240a2.putString("deviceId", string);
                    editorM4240a2.commit();
                    if (C1139g.f4142a) {
                        C1139g.m4308a(f4105a, String.format("MAC address is %s.", string));
                    }
                } else if (C1139g.f4144c) {
                    C1139g.m4312c(f4105a, "This Device has no Mac Address");
                }
            }
        }
        return string;
    }

    /* renamed from: b */
    public static String m4248b(String str) {
        String string;
        synchronized (f4106b) {
            string = f4109e.getString("deviceToken", str);
        }
        return string;
    }

    /* renamed from: c */
    public static String m4254c(String str) {
        String string;
        synchronized (f4106b) {
            string = f4109e.getString("primaryIp", str);
        }
        return string;
    }

    /* renamed from: a */
    public static int m4239a(int i) {
        int i2;
        synchronized (f4106b) {
            i2 = f4109e.getInt("primaryPort", i);
        }
        return i2;
    }

    /* renamed from: d */
    public static String m4258d(String str) {
        String string;
        synchronized (f4106b) {
            string = f4109e.getString("secondaryIp", str);
        }
        return string;
    }

    /* renamed from: b */
    public static int m4247b(int i) {
        int i2;
        synchronized (f4106b) {
            i2 = f4109e.getInt("secondaryPort", i);
        }
        return i2;
    }

    /* renamed from: c */
    public static int m4253c(int i) {
        int i2;
        synchronized (f4106b) {
            i2 = f4109e.getInt("pingInterval", i);
        }
        return i2;
    }

    /* renamed from: a */
    public static void m4244a(SharedPreferences.Editor editor, String str) {
        editor.putString("deviceId", str);
    }

    /* renamed from: a */
    public static void m4242a(SharedPreferences.Editor editor) {
        synchronized (f4106b) {
            editor.remove("deviceToken");
        }
    }

    /* renamed from: b */
    public static void m4250b(SharedPreferences.Editor editor) {
        synchronized (f4106b) {
            editor.remove("primaryIp");
        }
    }

    /* renamed from: c */
    public static void m4255c(SharedPreferences.Editor editor) {
        synchronized (f4106b) {
            editor.remove("primaryPort");
        }
    }

    /* renamed from: d */
    public static void m4259d(SharedPreferences.Editor editor) {
        synchronized (f4106b) {
            editor.remove("secondaryIp");
        }
    }

    /* renamed from: e */
    public static void m4263e(SharedPreferences.Editor editor) {
        synchronized (f4106b) {
            editor.remove("secondaryPort");
        }
    }

    /* renamed from: f */
    public static void m4265f(SharedPreferences.Editor editor) {
        synchronized (f4106b) {
            editor.remove("pingInterval");
        }
    }

    /* renamed from: b */
    public static void m4249b() {
        synchronized (f4106b) {
            SharedPreferences.Editor editorM4240a = m4240a();
            m4242a(editorM4240a);
            m4250b(editorM4240a);
            m4255c(editorM4240a);
            m4259d(editorM4240a);
            m4263e(editorM4240a);
            m4265f(editorM4240a);
            editorM4240a.commit();
        }
    }

    /* renamed from: a */
    public static void m4246a(String str, String str2, int i, String str3, int i2, int i3) {
        synchronized (f4106b) {
            SharedPreferences.Editor editorM4240a = m4240a();
            editorM4240a.putString("deviceToken", str);
            editorM4240a.putString("primaryIp", str2);
            editorM4240a.putInt("primaryPort", i);
            editorM4240a.putString("secondaryIp", str3);
            editorM4240a.putInt("secondaryPort", i2);
            editorM4240a.putInt("pingInterval", i3);
            editorM4240a.commit();
        }
    }

    /* renamed from: b */
    public static void m4252b(SharedPreferences.Editor editor, String str) {
        synchronized (f4107c) {
            editor.putString("appId", str);
        }
    }

    /* renamed from: g */
    public static void m4267g(SharedPreferences.Editor editor) {
        synchronized (f4107c) {
            editor.remove("appId");
        }
    }

    /* renamed from: e */
    public static String m4262e(String str) {
        String string;
        synchronized (f4107c) {
            string = f4109e.getString("appId", str);
        }
        return string;
    }

    /* renamed from: c */
    public static void m4256c(SharedPreferences.Editor editor, String str) {
        synchronized (f4107c) {
            editor.putString("regId", str);
        }
    }

    /* renamed from: h */
    public static void m4269h(SharedPreferences.Editor editor) {
        synchronized (f4107c) {
            editor.remove("regId");
        }
    }

    /* renamed from: f */
    public static String m4264f(String str) {
        String string;
        synchronized (f4107c) {
            string = f4109e.getString("regId", str);
        }
        return string;
    }

    /* renamed from: d */
    public static void m4260d(SharedPreferences.Editor editor, String str) {
        synchronized (f4108d) {
            editor.putString("expireDate", str);
        }
    }

    /* renamed from: g */
    public static String m4266g(String str) {
        String string;
        synchronized (f4108d) {
            string = f4109e.getString("expireDate", str);
        }
        return string;
    }

    /* renamed from: h */
    public static String m4268h(String str) {
        String string;
        synchronized (f4108d) {
            string = f4109e.getString("networkOperator", str);
        }
        return string;
    }

    /* renamed from: a */
    public static void m4243a(SharedPreferences.Editor editor, int i) {
        synchronized (f4108d) {
            editor.putInt("failCount", i);
        }
    }

    /* renamed from: d */
    public static int m4257d(int i) {
        int i2;
        synchronized (f4108d) {
            i2 = f4109e.getInt("failCount", i);
        }
        return i2;
    }

    /* renamed from: b */
    public static void m4251b(SharedPreferences.Editor editor, int i) {
        synchronized (f4108d) {
            editor.putInt("topBaseCount", i);
        }
    }

    /* renamed from: e */
    public static int m4261e(int i) {
        int i2;
        synchronized (f4108d) {
            i2 = f4109e.getInt("topBaseCount", i);
        }
        return i2;
    }

    /* renamed from: a */
    public static void m4245a(String str, int i, int i2) {
        synchronized (f4108d) {
            SharedPreferences.Editor editorM4240a = m4240a();
            editorM4240a.putString("networkOperator", str);
            editorM4240a.putInt("failCount", i);
            editorM4240a.putInt("topBaseCount", i2);
            editorM4240a.commit();
        }
    }
}
