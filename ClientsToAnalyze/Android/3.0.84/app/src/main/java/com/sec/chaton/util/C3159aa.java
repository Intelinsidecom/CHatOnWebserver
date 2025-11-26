package com.sec.chaton.util;

/* compiled from: ChatONPref.java */
/* renamed from: com.sec.chaton.util.aa */
/* loaded from: classes.dex */
public class C3159aa {

    /* renamed from: a */
    private static C3160ab f11470a = null;

    /* renamed from: a */
    public static synchronized C3160ab m10962a() {
        if (f11470a == null) {
            f11470a = new C3160ab();
        }
        return f11470a;
    }

    /* renamed from: b */
    public static synchronized void m10967b() {
        f11470a = null;
    }

    /* renamed from: a */
    public static void m10966a(String str, String str2) {
        m10962a().m10986b(str, str2);
    }

    /* renamed from: a */
    public static void m10965a(String str, Long l) {
        m10962a().m10982a(str, l);
    }

    /* renamed from: a */
    public static void m10963a(String str, Boolean bool) {
        m10962a().m10983b(str, bool);
    }

    /* renamed from: a */
    public static void m10964a(String str, Integer num) {
        m10962a().m10984b(str, num);
    }
}
