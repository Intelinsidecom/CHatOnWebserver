package com.facebook.p032b;

import android.util.Log;
import com.facebook.C0498bu;
import com.facebook.EnumC0441ak;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Logger.java */
/* renamed from: com.facebook.b.m */
/* loaded from: classes.dex */
public class C0470m {

    /* renamed from: a */
    private static final HashMap<String, String> f1150a = new HashMap<>();

    /* renamed from: b */
    private final EnumC0441ak f1151b;

    /* renamed from: c */
    private final String f1152c;

    /* renamed from: d */
    private StringBuilder f1153d;

    /* renamed from: e */
    private int f1154e = 3;

    /* renamed from: a */
    public static synchronized void m1691a(String str, String str2) {
        f1150a.put(str, str2);
    }

    /* renamed from: a */
    public static synchronized void m1690a(String str) {
        if (!C0498bu.m1810a(EnumC0441ak.INCLUDE_ACCESS_TOKENS)) {
            m1691a(str, "ACCESS_TOKEN_REMOVED");
        }
    }

    /* renamed from: a */
    public static void m1688a(EnumC0441ak enumC0441ak, String str, String str2) {
        m1687a(enumC0441ak, 3, str, str2);
    }

    /* renamed from: a */
    public static void m1689a(EnumC0441ak enumC0441ak, String str, String str2, Object... objArr) {
        if (C0498bu.m1810a(enumC0441ak)) {
            m1687a(enumC0441ak, 3, str, String.format(str2, objArr));
        }
    }

    /* renamed from: a */
    public static void m1687a(EnumC0441ak enumC0441ak, int i, String str, String str2) {
        if (C0498bu.m1810a(enumC0441ak)) {
            String strM1693d = m1693d(str2);
            if (!str.startsWith("FacebookSDK.")) {
                str = "FacebookSDK." + str;
            }
            Log.println(i, str, strM1693d);
        }
    }

    /* renamed from: d */
    private static synchronized String m1693d(String str) {
        for (Map.Entry<String, String> entry : f1150a.entrySet()) {
            str = str.replace(entry.getKey(), entry.getValue());
        }
        return str;
    }

    public C0470m(EnumC0441ak enumC0441ak, String str) {
        C0477t.m1722a(str, "tag");
        this.f1151b = enumC0441ak;
        this.f1152c = "FacebookSDK." + str;
        this.f1153d = new StringBuilder();
    }

    /* renamed from: a */
    public void m1694a() {
        m1697b(this.f1153d.toString());
        this.f1153d = new StringBuilder();
    }

    /* renamed from: b */
    public void m1697b(String str) {
        m1687a(this.f1151b, this.f1154e, this.f1152c, str);
    }

    /* renamed from: c */
    public void m1698c(String str) {
        if (m1692b()) {
            this.f1153d.append(str);
        }
    }

    /* renamed from: a */
    public void m1696a(String str, Object... objArr) {
        if (m1692b()) {
            this.f1153d.append(String.format(str, objArr));
        }
    }

    /* renamed from: a */
    public void m1695a(String str, Object obj) {
        m1696a("  %s:\t%s\n", str, obj);
    }

    /* renamed from: b */
    private boolean m1692b() {
        return C0498bu.m1810a(this.f1151b);
    }
}
