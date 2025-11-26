package com.sec.chaton.push.util;

import android.content.Context;

/* compiled from: PushLog.java */
/* renamed from: com.sec.chaton.push.util.g */
/* loaded from: classes.dex */
public class C0921g {

    /* renamed from: a */
    public static boolean f3116a = false;

    /* renamed from: b */
    public static boolean f3117b = false;

    /* renamed from: c */
    public static boolean f3118c = false;

    /* renamed from: d */
    public static boolean f3119d = false;

    /* renamed from: e */
    public static boolean f3120e = true;

    /* renamed from: f */
    private static AbstractC0923i f3121f;

    /* renamed from: a */
    public static void m3636a(Context context) {
        f3121f = new C0917c();
    }

    /* renamed from: a */
    public static synchronized void m3639a(boolean z, boolean z2, boolean z3, boolean z4) {
        f3116a = z;
        f3117b = z2;
        f3118c = z3;
        f3119d = z4;
        f3121f.m3643a(z, z2, z3, z4);
    }

    /* renamed from: a */
    public static void m3637a(String str, String str2) {
        if (f3121f != null && f3116a) {
            f3121f.m3645d("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: b */
    public static void m3640b(String str, String str2) {
        if (f3121f != null && f3117b) {
            f3121f.m3646e("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: c */
    public static void m3641c(String str, String str2) {
        if (f3121f != null && f3118c) {
            f3121f.m3647f("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: a */
    public static void m3638a(String str, String str2, Throwable th) {
        if (f3121f != null && f3119d) {
            f3121f.m3644b("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2, th);
        }
    }

    /* renamed from: d */
    public static void m3642d(String str, String str2) {
        if (f3121f != null && f3119d) {
            f3121f.m3648g("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }
}
