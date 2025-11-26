package com.sec.chaton.push.util;

import android.content.Context;

/* compiled from: PushLog.java */
/* renamed from: com.sec.chaton.push.util.g */
/* loaded from: classes.dex */
public class C1139g {

    /* renamed from: a */
    public static boolean f4142a = false;

    /* renamed from: b */
    public static boolean f4143b = false;

    /* renamed from: c */
    public static boolean f4144c = false;

    /* renamed from: d */
    public static boolean f4145d = false;

    /* renamed from: e */
    public static boolean f4146e = true;

    /* renamed from: f */
    private static AbstractC1133a f4147f;

    /* renamed from: a */
    public static void m4307a(Context context) {
        f4147f = new C1135c();
    }

    /* renamed from: a */
    public static synchronized void m4310a(boolean z, boolean z2, boolean z3, boolean z4) {
        f4142a = z;
        f4143b = z2;
        f4144c = z3;
        f4145d = z4;
        f4147f.m4282a(z, z2, z3, z4);
    }

    /* renamed from: a */
    public static void m4308a(String str, String str2) {
        if (f4147f != null && f4142a) {
            f4147f.m4280a("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: b */
    public static void m4311b(String str, String str2) {
        if (f4147f != null && f4143b) {
            f4147f.m4283b("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: c */
    public static void m4312c(String str, String str2) {
        if (f4147f != null && f4144c) {
            f4147f.m4285c("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: a */
    public static void m4309a(String str, String str2, Throwable th) {
        if (f4147f != null && f4145d) {
            f4147f.m4281a("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2, th);
        }
    }

    /* renamed from: d */
    public static void m4313d(String str, String str2) {
        if (f4147f != null && f4145d) {
            f4147f.m4286d("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }
}
