package com.sec.chaton.smsplugin.spam.database;

/* compiled from: SpamMmsSmsProvider.java */
/* renamed from: com.sec.chaton.smsplugin.spam.database.b */
/* loaded from: classes.dex */
public class C4026b {

    /* renamed from: a */
    private static long f14527a;

    /* renamed from: a */
    public static void m15502a() {
        f14527a = System.nanoTime();
    }

    /* renamed from: b */
    public static String m15503b() {
        return String.format("Elapsed time : %.3f ms", Double.valueOf((System.nanoTime() - f14527a) / 1000000.0d));
    }
}
