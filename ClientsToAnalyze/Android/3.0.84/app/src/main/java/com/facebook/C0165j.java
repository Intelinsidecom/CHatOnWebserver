package com.facebook;

import java.io.Serializable;
import java.util.List;

/* compiled from: AuthorizationClient.java */
/* renamed from: com.facebook.j */
/* loaded from: classes.dex */
class C0165j implements Serializable {

    /* renamed from: a */
    private final transient InterfaceC0175t f373a;

    /* renamed from: b */
    private EnumC0124br f374b;

    /* renamed from: c */
    private int f375c;

    /* renamed from: d */
    private boolean f376d;

    /* renamed from: e */
    private List<String> f377e;

    /* renamed from: f */
    private EnumC0123bq f378f;

    /* renamed from: g */
    private String f379g;

    /* renamed from: h */
    private String f380h;

    C0165j(EnumC0124br enumC0124br, int i, boolean z, List<String> list, EnumC0123bq enumC0123bq, String str, String str2, InterfaceC0175t interfaceC0175t) {
        this.f376d = false;
        this.f374b = enumC0124br;
        this.f375c = i;
        this.f376d = z;
        this.f377e = list;
        this.f378f = enumC0123bq;
        this.f379g = str;
        this.f380h = str2;
        this.f373a = interfaceC0175t;
    }

    /* renamed from: a */
    InterfaceC0175t m479a() {
        return this.f373a;
    }

    /* renamed from: b */
    List<String> m481b() {
        return this.f377e;
    }

    /* renamed from: a */
    void m480a(List<String> list) {
        this.f377e = list;
    }

    /* renamed from: c */
    EnumC0124br m482c() {
        return this.f374b;
    }

    /* renamed from: d */
    int m483d() {
        return this.f375c;
    }

    /* renamed from: e */
    EnumC0123bq m484e() {
        return this.f378f;
    }

    /* renamed from: f */
    String m485f() {
        return this.f379g;
    }

    /* renamed from: g */
    boolean m486g() {
        return this.f376d;
    }

    /* renamed from: h */
    String m487h() {
        return this.f380h;
    }

    /* renamed from: i */
    boolean m488i() {
        return (this.f380h == null || this.f376d) ? false : true;
    }
}
