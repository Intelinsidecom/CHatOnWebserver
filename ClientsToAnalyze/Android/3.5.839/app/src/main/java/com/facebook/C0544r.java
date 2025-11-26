package com.facebook;

import java.io.Serializable;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.r */
/* loaded from: classes.dex */
class C0544r implements Serializable {

    /* renamed from: a */
    final EnumC0545s f1358a;

    /* renamed from: b */
    final C0424a f1359b;

    /* renamed from: c */
    final String f1360c;

    private C0544r(EnumC0545s enumC0545s, C0424a c0424a, String str) {
        this.f1359b = c0424a;
        this.f1360c = str;
        this.f1358a = enumC0545s;
    }

    /* renamed from: a */
    static C0544r m1936a(C0424a c0424a) {
        return new C0544r(EnumC0545s.SUCCESS, c0424a, null);
    }

    /* renamed from: a */
    static C0544r m1937a(String str) {
        return new C0544r(EnumC0545s.CANCEL, null, str);
    }

    /* renamed from: a */
    static C0544r m1938a(String str, String str2) {
        if (str2 != null) {
            str = str + ": " + str2;
        }
        return new C0544r(EnumC0545s.ERROR, null, str);
    }
}
