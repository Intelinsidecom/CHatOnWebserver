package com.facebook;

import java.io.Serializable;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.r */
/* loaded from: classes.dex */
class C0173r implements Serializable {

    /* renamed from: a */
    final EnumC0174s f388a;

    /* renamed from: b */
    final C0053a f389b;

    /* renamed from: c */
    final String f390c;

    private C0173r(EnumC0174s enumC0174s, C0053a c0053a, String str) {
        this.f389b = c0053a;
        this.f390c = str;
        this.f388a = enumC0174s;
    }

    /* renamed from: a */
    static C0173r m493a(C0053a c0053a) {
        return new C0173r(EnumC0174s.SUCCESS, c0053a, null);
    }

    /* renamed from: a */
    static C0173r m494a(String str) {
        return new C0173r(EnumC0174s.CANCEL, null, str);
    }

    /* renamed from: a */
    static C0173r m495a(String str, String str2) {
        if (str2 != null) {
            str = str + ": " + str2;
        }
        return new C0173r(EnumC0174s.ERROR, null, str);
    }
}
