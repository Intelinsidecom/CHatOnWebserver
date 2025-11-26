package com.sec.chaton.push.util;

import android.content.Context;

/* compiled from: PushLog.java */
/* renamed from: com.sec.chaton.push.util.g */
/* loaded from: classes.dex */
public class C2115g {

    /* renamed from: a */
    public static boolean f8048a = true;

    /* renamed from: b */
    public static boolean f8049b = true;

    /* renamed from: c */
    public static boolean f8050c = true;

    /* renamed from: d */
    public static boolean f8051d = true;

    /* renamed from: e */
    public static boolean f8052e = true;

    /* renamed from: f */
    private static AbstractC2109a f8053f;

    /* renamed from: a */
    public static void m8358a(Context context) {
        f8053f = new C2111c();
    }

    /* renamed from: a */
    public static synchronized void m8361a(boolean z, boolean z2, boolean z3, boolean z4) {
        f8048a = z;
        f8049b = z2;
        f8050c = z3;
        f8051d = z4;
        f8053f.m8333a(z, z2, z3, z4);
    }

    /* renamed from: a */
    public static void m8359a(String str, String str2) {
        if (f8053f != null && f8048a) {
            f8053f.m8331a("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: b */
    public static void m8362b(String str, String str2) {
        if (f8053f != null && f8049b) {
            f8053f.m8334b("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: c */
    public static void m8363c(String str, String str2) {
        if (f8053f != null && f8050c) {
            f8053f.m8336c("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: a */
    public static void m8360a(String str, String str2, Throwable th) {
        if (f8053f != null && f8051d) {
            f8053f.m8332a("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2, th);
        }
    }

    /* renamed from: d */
    public static void m8364d(String str, String str2) {
        if (f8053f != null && f8051d) {
            f8053f.m8337d("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }
}
