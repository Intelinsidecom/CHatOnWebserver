package com.sec.chaton.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.util.C2115g;
import com.sec.common.CommonApplication;

/* compiled from: PushClientPreference.java */
/* renamed from: com.sec.chaton.push.k */
/* loaded from: classes.dex */
public class C2099k {

    /* renamed from: a */
    private static final String f8013a = C2099k.class.getSimpleName();

    /* renamed from: b */
    private static final Object f8014b = new Object();

    /* renamed from: c */
    private static final Object f8015c = new Object();

    /* renamed from: d */
    private static final Object f8016d = new Object();

    /* renamed from: e */
    private static SharedPreferences f8017e = CommonApplication.m11493l().getSharedPreferences("com.sec.chaton.push.config", 0);

    /* renamed from: a */
    public static SharedPreferences.Editor m8284a() {
        return f8017e.edit();
    }

    /* renamed from: a */
    public static String m8285a(String str) {
        String string = f8017e.getString("deviceId", null);
        if (C2115g.f8048a) {
            C2115g.m8359a(f8013a, String.format("Saved IMEI: %s.", string));
        }
        if (string == null) {
            Context contextM11493l = CommonApplication.m11493l();
            string = ((TelephonyManager) contextM11493l.getSystemService("phone")).getDeviceId();
            if (string != null) {
                SharedPreferences.Editor editorM8284a = m8284a();
                editorM8284a.putString("deviceId", string);
                editorM8284a.commit();
            } else {
                if (C2115g.f8050c) {
                    C2115g.m8363c(f8013a, "This device has no IMEI. Using MAC address instead of IMEI.");
                }
                string = ((WifiManager) contextM11493l.getSystemService("wifi")).getConnectionInfo().getMacAddress().replace(":", "");
                StringBuffer stringBuffer = new StringBuffer();
                if (string != null) {
                    for (int length = string.length(); length < 14; length++) {
                        stringBuffer.append("M");
                    }
                    string = ((Object) stringBuffer) + string;
                    SharedPreferences.Editor editorM8284a2 = m8284a();
                    editorM8284a2.putString("deviceId", string);
                    editorM8284a2.commit();
                    if (C2115g.f8048a) {
                        C2115g.m8359a(f8013a, String.format("MAC address is %s.", string));
                    }
                } else if (C2115g.f8050c) {
                    C2115g.m8363c(f8013a, "This Device has no Mac Address");
                }
            }
        }
        return string;
    }

    /* renamed from: b */
    public static String m8292b(String str) {
        String string;
        synchronized (f8014b) {
            string = f8017e.getString("deviceToken", str);
        }
        return string;
    }

    /* renamed from: c */
    public static String m8297c(String str) {
        String string;
        synchronized (f8014b) {
            string = f8017e.getString("primaryIp", str);
        }
        return string;
    }

    /* renamed from: a */
    public static int m8283a(int i) {
        int i2;
        synchronized (f8014b) {
            i2 = f8017e.getInt("primaryPort", i);
        }
        return i2;
    }

    /* renamed from: d */
    public static String m8302d(String str) {
        String string;
        synchronized (f8014b) {
            string = f8017e.getString("secondaryIp", str);
        }
        return string;
    }

    /* renamed from: b */
    public static int m8291b(int i) {
        int i2;
        synchronized (f8014b) {
            i2 = f8017e.getInt("secondaryPort", i);
        }
        return i2;
    }

    @Deprecated
    /* renamed from: c */
    public static int m8296c(int i) {
        int i2;
        synchronized (f8014b) {
            i2 = f8017e.getInt("pingInterval", i);
        }
        return i2;
    }

    /* renamed from: d */
    public static int m8301d(int i) {
        int i2;
        synchronized (f8014b) {
            i2 = f8017e.getInt("pingMinInterval", i);
        }
        return i2;
    }

    /* renamed from: e */
    public static int m8305e(int i) {
        int i2;
        synchronized (f8014b) {
            i2 = f8017e.getInt("pingAvgInterval", i);
        }
        return i2;
    }

    /* renamed from: f */
    public static int m8308f(int i) {
        int i2;
        synchronized (f8014b) {
            i2 = f8017e.getInt("pingMaxInterval", i);
        }
        return i2;
    }

    /* renamed from: g */
    public static int m8311g(int i) {
        int i2;
        synchronized (f8014b) {
            i2 = f8017e.getInt("pingIncInterval", i);
        }
        return i2;
    }

    /* renamed from: a */
    public static void m8289a(SharedPreferences.Editor editor, String str) {
        editor.putString("deviceId", str);
    }

    /* renamed from: a */
    public static void m8287a(SharedPreferences.Editor editor) {
        synchronized (f8014b) {
            editor.remove("deviceToken");
        }
    }

    /* renamed from: b */
    public static void m8294b(SharedPreferences.Editor editor) {
        synchronized (f8014b) {
            editor.remove("primaryIp");
        }
    }

    /* renamed from: c */
    public static void m8299c(SharedPreferences.Editor editor) {
        synchronized (f8014b) {
            editor.remove("primaryPort");
        }
    }

    /* renamed from: d */
    public static void m8303d(SharedPreferences.Editor editor) {
        synchronized (f8014b) {
            editor.remove("secondaryIp");
        }
    }

    /* renamed from: e */
    public static void m8307e(SharedPreferences.Editor editor) {
        synchronized (f8014b) {
            editor.remove("secondaryPort");
        }
    }

    /* renamed from: f */
    public static void m8310f(SharedPreferences.Editor editor) {
        synchronized (f8014b) {
            editor.remove("pingMinInterval");
        }
    }

    /* renamed from: g */
    public static void m8313g(SharedPreferences.Editor editor) {
        synchronized (f8014b) {
            editor.remove("pingAvgInterval");
        }
    }

    /* renamed from: h */
    public static void m8316h(SharedPreferences.Editor editor) {
        synchronized (f8014b) {
            editor.remove("pingMaxInterval");
        }
    }

    /* renamed from: i */
    public static void m8318i(SharedPreferences.Editor editor) {
        synchronized (f8014b) {
            editor.remove("pingIncInterval");
        }
    }

    /* renamed from: b */
    public static void m8293b() {
        synchronized (f8014b) {
            SharedPreferences.Editor editorM8284a = m8284a();
            m8321l(editorM8284a);
            m8287a(editorM8284a);
            m8294b(editorM8284a);
            m8299c(editorM8284a);
            m8303d(editorM8284a);
            m8307e(editorM8284a);
            m8310f(editorM8284a);
            m8313g(editorM8284a);
            m8316h(editorM8284a);
            m8318i(editorM8284a);
            editorM8284a.commit();
        }
    }

    /* renamed from: a */
    public static void m8290a(String str, String str2, String str3, int i, String str4, int i2, int i3, int i4, int i5, int i6) {
        synchronized (f8014b) {
            SharedPreferences.Editor editorM8284a = m8284a();
            editorM8284a.putString("networkOperator", str);
            editorM8284a.putString("deviceToken", str2);
            editorM8284a.putString("primaryIp", str3);
            editorM8284a.putInt("primaryPort", i);
            editorM8284a.putString("secondaryIp", str4);
            editorM8284a.putInt("secondaryPort", i2);
            editorM8284a.putInt("pingMinInterval", i3);
            editorM8284a.putInt("pingAvgInterval", i4);
            editorM8284a.putInt("pingMaxInterval", i5);
            editorM8284a.putInt("pingIncInterval", i6);
            editorM8284a.commit();
        }
    }

    /* renamed from: b */
    public static void m8295b(SharedPreferences.Editor editor, String str) {
        synchronized (f8015c) {
            editor.putString("appId", str);
        }
    }

    /* renamed from: j */
    public static void m8319j(SharedPreferences.Editor editor) {
        synchronized (f8015c) {
            editor.remove("appId");
        }
    }

    /* renamed from: e */
    public static String m8306e(String str) {
        String string;
        synchronized (f8015c) {
            string = f8017e.getString("appId", str);
        }
        return string;
    }

    /* renamed from: c */
    public static void m8300c(SharedPreferences.Editor editor, String str) {
        synchronized (f8015c) {
            editor.putString("regId", str);
        }
    }

    /* renamed from: k */
    public static void m8320k(SharedPreferences.Editor editor) {
        synchronized (f8015c) {
            editor.remove("regId");
        }
    }

    /* renamed from: f */
    public static String m8309f(String str) {
        String string;
        synchronized (f8015c) {
            string = f8017e.getString("regId", str);
        }
        return string;
    }

    /* renamed from: d */
    public static void m8304d(SharedPreferences.Editor editor, String str) {
        synchronized (f8016d) {
            editor.putString("expireDate", str);
        }
    }

    /* renamed from: g */
    public static String m8312g(String str) {
        String string;
        synchronized (f8016d) {
            string = f8017e.getString("expireDate", str);
        }
        return string;
    }

    /* renamed from: l */
    public static void m8321l(SharedPreferences.Editor editor) {
        synchronized (f8016d) {
            editor.remove("networkOperator");
        }
    }

    /* renamed from: h */
    public static String m8315h(String str) {
        String string;
        synchronized (f8016d) {
            string = f8017e.getString("networkOperator", str);
        }
        return string;
    }

    /* renamed from: a */
    public static void m8288a(SharedPreferences.Editor editor, int i) {
        synchronized (f8016d) {
            editor.putInt("heartbeatFailCount", i);
        }
    }

    /* renamed from: h */
    public static int m8314h(int i) {
        int i2;
        synchronized (f8016d) {
            i2 = f8017e.getInt("heartbeatFailCount", i);
        }
        return i2;
    }

    /* renamed from: i */
    public static int m8317i(int i) {
        int i2;
        synchronized (f8016d) {
            i2 = f8017e.getInt("heartbeatCount", i);
        }
        return i2;
    }

    /* renamed from: a */
    public static void m8286a(int i, int i2) {
        synchronized (f8016d) {
            SharedPreferences.Editor editorM8284a = m8284a();
            editorM8284a.putInt("heartbeatFailCount", i);
            editorM8284a.putInt("heartbeatCount", i2);
            editorM8284a.commit();
        }
    }

    /* renamed from: c */
    public static void m8298c() {
        synchronized (f8016d) {
            SharedPreferences.Editor editorM8284a = m8284a();
            editorM8284a.remove("heartbeatFailCount");
            editorM8284a.remove("heartbeatCount");
            editorM8284a.commit();
        }
    }
}
