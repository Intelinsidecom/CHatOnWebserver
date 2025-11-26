package com.sec.chaton.util;

/* compiled from: ChatONPref.java */
/* renamed from: com.sec.chaton.util.aa */
/* loaded from: classes.dex */
public class C4809aa {

    /* renamed from: a */
    private static C4810ab f17571a = null;

    /* renamed from: a */
    public static synchronized C4810ab m18104a() {
        if (f17571a == null) {
            f17571a = new C4810ab();
        }
        return f17571a;
    }

    /* renamed from: b */
    public static synchronized void m18109b() {
        f17571a = null;
    }

    /* renamed from: a */
    public static void m18108a(String str, String str2) {
        m18104a().m18128b(str, str2);
    }

    /* renamed from: a */
    public static void m18107a(String str, Long l) {
        m18104a().m18124a(str, l);
    }

    /* renamed from: a */
    public static void m18105a(String str, Boolean bool) {
        m18104a().m18125b(str, bool);
    }

    /* renamed from: a */
    public static void m18106a(String str, Integer num) {
        m18104a().m18126b(str, num);
    }
}
