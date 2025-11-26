package com.sec.chaton.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.util.C3115g;
import com.sec.common.CommonApplication;

/* compiled from: PushClientPreference.java */
/* renamed from: com.sec.chaton.push.k */
/* loaded from: classes.dex */
public class C3099k {

    /* renamed from: a */
    private static final String f11423a = C3099k.class.getSimpleName();

    /* renamed from: b */
    private static final Object f11424b = new Object();

    /* renamed from: c */
    private static final Object f11425c = new Object();

    /* renamed from: d */
    private static final Object f11426d = new Object();

    /* renamed from: e */
    private static SharedPreferences f11427e = CommonApplication.m18732r().getSharedPreferences("com.sec.chaton.push.config", 0);

    /* renamed from: a */
    public static SharedPreferences.Editor m12627a() {
        return f11427e.edit();
    }

    /* renamed from: a */
    public static String m12628a(String str) {
        String string = f11427e.getString("deviceId", null);
        if (C3115g.f11458a) {
            C3115g.m12701a(f11423a, String.format("Saved IMEI: %s.", string));
        }
        if (string == null) {
            Context contextM18732r = CommonApplication.m18732r();
            string = ((TelephonyManager) contextM18732r.getSystemService("phone")).getDeviceId();
            if (string != null) {
                SharedPreferences.Editor editorM12627a = m12627a();
                editorM12627a.putString("deviceId", string);
                editorM12627a.commit();
            } else {
                if (C3115g.f11460c) {
                    C3115g.m12705c(f11423a, "This device has no IMEI. Using MAC address instead of IMEI.");
                }
                string = ((WifiManager) contextM18732r.getSystemService("wifi")).getConnectionInfo().getMacAddress().replace(":", "");
                StringBuffer stringBuffer = new StringBuffer();
                if (string != null) {
                    for (int length = string.length(); length < 14; length++) {
                        stringBuffer.append("M");
                    }
                    string = ((Object) stringBuffer) + string;
                    SharedPreferences.Editor editorM12627a2 = m12627a();
                    editorM12627a2.putString("deviceId", string);
                    editorM12627a2.commit();
                    if (C3115g.f11458a) {
                        C3115g.m12701a(f11423a, String.format("MAC address is %s.", string));
                    }
                } else if (C3115g.f11460c) {
                    C3115g.m12705c(f11423a, "This Device has no Mac Address");
                }
            }
        }
        return string;
    }

    /* renamed from: b */
    public static String m12635b(String str) {
        String string;
        synchronized (f11424b) {
            string = f11427e.getString("deviceToken", str);
        }
        return string;
    }

    /* renamed from: c */
    public static String m12640c(String str) {
        String string;
        synchronized (f11424b) {
            string = f11427e.getString("primaryIp", str);
        }
        return string;
    }

    /* renamed from: a */
    public static int m12626a(int i) {
        int i2;
        synchronized (f11424b) {
            i2 = f11427e.getInt("primaryPort", i);
        }
        return i2;
    }

    /* renamed from: d */
    public static String m12645d(String str) {
        String string;
        synchronized (f11424b) {
            string = f11427e.getString("secondaryIp", str);
        }
        return string;
    }

    /* renamed from: b */
    public static int m12634b(int i) {
        int i2;
        synchronized (f11424b) {
            i2 = f11427e.getInt("secondaryPort", i);
        }
        return i2;
    }

    @Deprecated
    /* renamed from: c */
    public static int m12639c(int i) {
        int i2;
        synchronized (f11424b) {
            i2 = f11427e.getInt("pingInterval", i);
        }
        return i2;
    }

    /* renamed from: d */
    public static int m12644d(int i) {
        int i2;
        synchronized (f11424b) {
            i2 = f11427e.getInt("pingMinInterval", i);
        }
        return i2;
    }

    /* renamed from: e */
    public static int m12647e(int i) {
        int i2;
        synchronized (f11424b) {
            i2 = f11427e.getInt("pingAvgInterval", i);
        }
        return i2;
    }

    /* renamed from: f */
    public static int m12650f(int i) {
        int i2;
        synchronized (f11424b) {
            i2 = f11427e.getInt("pingMaxInterval", i);
        }
        return i2;
    }

    /* renamed from: g */
    public static int m12653g(int i) {
        int i2;
        synchronized (f11424b) {
            i2 = f11427e.getInt("pingIncInterval", i);
        }
        return i2;
    }

    /* renamed from: a */
    public static void m12630a(SharedPreferences.Editor editor) {
        synchronized (f11424b) {
            editor.remove("deviceToken");
        }
    }

    /* renamed from: b */
    public static void m12637b(SharedPreferences.Editor editor) {
        synchronized (f11424b) {
            editor.remove("primaryIp");
        }
    }

    /* renamed from: c */
    public static void m12642c(SharedPreferences.Editor editor) {
        synchronized (f11424b) {
            editor.remove("primaryPort");
        }
    }

    /* renamed from: d */
    public static void m12646d(SharedPreferences.Editor editor) {
        synchronized (f11424b) {
            editor.remove("secondaryIp");
        }
    }

    /* renamed from: e */
    public static void m12649e(SharedPreferences.Editor editor) {
        synchronized (f11424b) {
            editor.remove("secondaryPort");
        }
    }

    /* renamed from: f */
    public static void m12652f(SharedPreferences.Editor editor) {
        synchronized (f11424b) {
            editor.remove("pingMinInterval");
        }
    }

    /* renamed from: g */
    public static void m12655g(SharedPreferences.Editor editor) {
        synchronized (f11424b) {
            editor.remove("pingAvgInterval");
        }
    }

    /* renamed from: h */
    public static void m12658h(SharedPreferences.Editor editor) {
        synchronized (f11424b) {
            editor.remove("pingMaxInterval");
        }
    }

    /* renamed from: i */
    public static void m12660i(SharedPreferences.Editor editor) {
        synchronized (f11424b) {
            editor.remove("pingIncInterval");
        }
    }

    /* renamed from: b */
    public static void m12636b() {
        synchronized (f11424b) {
            SharedPreferences.Editor editorM12627a = m12627a();
            m12663l(editorM12627a);
            m12630a(editorM12627a);
            m12637b(editorM12627a);
            m12642c(editorM12627a);
            m12646d(editorM12627a);
            m12649e(editorM12627a);
            m12652f(editorM12627a);
            m12655g(editorM12627a);
            m12658h(editorM12627a);
            m12660i(editorM12627a);
            editorM12627a.commit();
        }
    }

    /* renamed from: a */
    public static void m12633a(String str, String str2, String str3, int i, String str4, int i2, int i3, int i4, int i5, int i6) {
        synchronized (f11424b) {
            SharedPreferences.Editor editorM12627a = m12627a();
            editorM12627a.putString("networkOperator", str);
            editorM12627a.putString("deviceToken", str2);
            editorM12627a.putString("primaryIp", str3);
            editorM12627a.putInt("primaryPort", i);
            editorM12627a.putString("secondaryIp", str4);
            editorM12627a.putInt("secondaryPort", i2);
            editorM12627a.putInt("pingMinInterval", i3);
            editorM12627a.putInt("pingAvgInterval", i4);
            editorM12627a.putInt("pingMaxInterval", i5);
            editorM12627a.putInt("pingIncInterval", i6);
            editorM12627a.commit();
        }
    }

    /* renamed from: a */
    public static void m12632a(SharedPreferences.Editor editor, String str) {
        synchronized (f11425c) {
            editor.putString("appId", str);
        }
    }

    /* renamed from: j */
    public static void m12661j(SharedPreferences.Editor editor) {
        synchronized (f11425c) {
            editor.remove("appId");
        }
    }

    /* renamed from: e */
    public static String m12648e(String str) {
        String string;
        synchronized (f11425c) {
            string = f11427e.getString("appId", str);
        }
        return string;
    }

    /* renamed from: b */
    public static void m12638b(SharedPreferences.Editor editor, String str) {
        synchronized (f11425c) {
            editor.putString("regId", str);
        }
    }

    /* renamed from: k */
    public static void m12662k(SharedPreferences.Editor editor) {
        synchronized (f11425c) {
            editor.remove("regId");
        }
    }

    /* renamed from: f */
    public static String m12651f(String str) {
        String string;
        synchronized (f11425c) {
            string = f11427e.getString("regId", str);
        }
        return string;
    }

    /* renamed from: c */
    public static void m12643c(SharedPreferences.Editor editor, String str) {
        synchronized (f11426d) {
            editor.putString("expireDate", str);
        }
    }

    /* renamed from: g */
    public static String m12654g(String str) {
        String string;
        synchronized (f11426d) {
            string = f11427e.getString("expireDate", str);
        }
        return string;
    }

    /* renamed from: l */
    public static void m12663l(SharedPreferences.Editor editor) {
        synchronized (f11426d) {
            editor.remove("networkOperator");
        }
    }

    /* renamed from: h */
    public static String m12657h(String str) {
        String string;
        synchronized (f11426d) {
            string = f11427e.getString("networkOperator", str);
        }
        return string;
    }

    /* renamed from: a */
    public static void m12631a(SharedPreferences.Editor editor, int i) {
        synchronized (f11426d) {
            editor.putInt("heartbeatFailCount", i);
        }
    }

    /* renamed from: h */
    public static int m12656h(int i) {
        int i2;
        synchronized (f11426d) {
            i2 = f11427e.getInt("heartbeatFailCount", i);
        }
        return i2;
    }

    /* renamed from: i */
    public static int m12659i(int i) {
        int i2;
        synchronized (f11426d) {
            i2 = f11427e.getInt("heartbeatCount", i);
        }
        return i2;
    }

    /* renamed from: a */
    public static void m12629a(int i, int i2) {
        synchronized (f11426d) {
            SharedPreferences.Editor editorM12627a = m12627a();
            editorM12627a.putInt("heartbeatFailCount", i);
            editorM12627a.putInt("heartbeatCount", i2);
            editorM12627a.commit();
        }
    }

    /* renamed from: c */
    public static void m12641c() {
        synchronized (f11426d) {
            SharedPreferences.Editor editorM12627a = m12627a();
            editorM12627a.remove("heartbeatFailCount");
            editorM12627a.remove("heartbeatCount");
            editorM12627a.commit();
        }
    }
}
