package com.facebook.p008b;

import android.util.Log;
import com.facebook.C0127bu;
import com.facebook.EnumC0070ak;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Logger.java */
/* renamed from: com.facebook.b.m */
/* loaded from: classes.dex */
public class C0099m {

    /* renamed from: a */
    private static final HashMap<String, String> f181a = new HashMap<>();

    /* renamed from: b */
    private final EnumC0070ak f182b;

    /* renamed from: c */
    private final String f183c;

    /* renamed from: d */
    private StringBuilder f184d;

    /* renamed from: e */
    private int f185e = 3;

    /* renamed from: a */
    public static synchronized void m247a(String str, String str2) {
        f181a.put(str, str2);
    }

    /* renamed from: a */
    public static synchronized void m246a(String str) {
        if (!C0127bu.m367a(EnumC0070ak.INCLUDE_ACCESS_TOKENS)) {
            m247a(str, "ACCESS_TOKEN_REMOVED");
        }
    }

    /* renamed from: a */
    public static void m244a(EnumC0070ak enumC0070ak, String str, String str2) {
        m243a(enumC0070ak, 3, str, str2);
    }

    /* renamed from: a */
    public static void m245a(EnumC0070ak enumC0070ak, String str, String str2, Object... objArr) {
        if (C0127bu.m367a(enumC0070ak)) {
            m243a(enumC0070ak, 3, str, String.format(str2, objArr));
        }
    }

    /* renamed from: a */
    public static void m243a(EnumC0070ak enumC0070ak, int i, String str, String str2) {
        if (C0127bu.m367a(enumC0070ak)) {
            String strM249d = m249d(str2);
            if (!str.startsWith("FacebookSDK.")) {
                str = "FacebookSDK." + str;
            }
            Log.println(i, str, strM249d);
        }
    }

    /* renamed from: d */
    private static synchronized String m249d(String str) {
        for (Map.Entry<String, String> entry : f181a.entrySet()) {
            str = str.replace(entry.getKey(), entry.getValue());
        }
        return str;
    }

    public C0099m(EnumC0070ak enumC0070ak, String str) {
        C0106t.m278a(str, "tag");
        this.f182b = enumC0070ak;
        this.f183c = "FacebookSDK." + str;
        this.f184d = new StringBuilder();
    }

    /* renamed from: a */
    public void m250a() {
        m253b(this.f184d.toString());
        this.f184d = new StringBuilder();
    }

    /* renamed from: b */
    public void m253b(String str) {
        m243a(this.f182b, this.f185e, this.f183c, str);
    }

    /* renamed from: c */
    public void m254c(String str) {
        if (m248b()) {
            this.f184d.append(str);
        }
    }

    /* renamed from: a */
    public void m252a(String str, Object... objArr) {
        if (m248b()) {
            this.f184d.append(String.format(str, objArr));
        }
    }

    /* renamed from: a */
    public void m251a(String str, Object obj) {
        m252a("  %s:\t%s\n", str, obj);
    }

    /* renamed from: b */
    private boolean m248b() {
        return C0127bu.m367a(this.f182b);
    }
}
