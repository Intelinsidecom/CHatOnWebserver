package com.sec.chaton.push.util;

import android.content.Context;

/* compiled from: PushLog.java */
/* renamed from: com.sec.chaton.push.util.g */
/* loaded from: classes.dex */
public class C3115g {

    /* renamed from: a */
    public static boolean f11458a = true;

    /* renamed from: b */
    public static boolean f11459b = true;

    /* renamed from: c */
    public static boolean f11460c = true;

    /* renamed from: d */
    public static boolean f11461d = true;

    /* renamed from: e */
    public static boolean f11462e = true;

    /* renamed from: f */
    private static AbstractC3109a f11463f;

    /* renamed from: a */
    public static void m12700a(Context context) {
        f11463f = new C3111c();
    }

    /* renamed from: a */
    public static synchronized void m12703a(boolean z, boolean z2, boolean z3, boolean z4) {
        f11458a = z;
        f11459b = z2;
        f11460c = z3;
        f11461d = z4;
        f11463f.m12675a(z, z2, z3, z4);
    }

    /* renamed from: a */
    public static void m12701a(String str, String str2) {
        if (f11463f != null && f11458a) {
            f11463f.m12673a("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: b */
    public static void m12704b(String str, String str2) {
        if (f11463f != null && f11459b) {
            f11463f.m12676b("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: c */
    public static void m12705c(String str, String str2) {
        if (f11463f != null && f11460c) {
            f11463f.m12678c("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }

    /* renamed from: a */
    public static void m12702a(String str, String str2, Throwable th) {
        if (f11463f != null && f11461d) {
            f11463f.m12674a("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2, th);
        }
    }

    /* renamed from: d */
    public static void m12706d(String str, String str2) {
        if (f11463f != null && f11461d) {
            f11463f.m12679d("PushModule", "[" + str + "] (" + Thread.currentThread().getName() + ") " + str2);
        }
    }
}
