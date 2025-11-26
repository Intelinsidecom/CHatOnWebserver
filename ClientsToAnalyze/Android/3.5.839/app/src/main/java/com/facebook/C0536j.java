package com.facebook;

import java.io.Serializable;
import java.util.List;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.j */
/* loaded from: classes.dex */
class C0536j implements Serializable {

    /* renamed from: a */
    private final transient InterfaceC0546t f1343a;

    /* renamed from: b */
    private EnumC0495br f1344b;

    /* renamed from: c */
    private int f1345c;

    /* renamed from: d */
    private boolean f1346d;

    /* renamed from: e */
    private List<String> f1347e;

    /* renamed from: f */
    private EnumC0494bq f1348f;

    /* renamed from: g */
    private String f1349g;

    /* renamed from: h */
    private String f1350h;

    C0536j(EnumC0495br enumC0495br, int i, boolean z, List<String> list, EnumC0494bq enumC0494bq, String str, String str2, InterfaceC0546t interfaceC0546t) {
        this.f1346d = false;
        this.f1344b = enumC0495br;
        this.f1345c = i;
        this.f1346d = z;
        this.f1347e = list;
        this.f1348f = enumC0494bq;
        this.f1349g = str;
        this.f1350h = str2;
        this.f1343a = interfaceC0546t;
    }

    /* renamed from: a */
    InterfaceC0546t m1922a() {
        return this.f1343a;
    }

    /* renamed from: b */
    List<String> m1924b() {
        return this.f1347e;
    }

    /* renamed from: a */
    void m1923a(List<String> list) {
        this.f1347e = list;
    }

    /* renamed from: c */
    EnumC0495br m1925c() {
        return this.f1344b;
    }

    /* renamed from: d */
    int m1926d() {
        return this.f1345c;
    }

    /* renamed from: e */
    EnumC0494bq m1927e() {
        return this.f1348f;
    }

    /* renamed from: f */
    String m1928f() {
        return this.f1349g;
    }

    /* renamed from: g */
    boolean m1929g() {
        return this.f1346d;
    }

    /* renamed from: h */
    String m1930h() {
        return this.f1350h;
    }

    /* renamed from: i */
    boolean m1931i() {
        return (this.f1350h == null || this.f1346d) ? false : true;
    }
}
