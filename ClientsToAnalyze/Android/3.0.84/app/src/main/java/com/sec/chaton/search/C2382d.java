package com.sec.chaton.search;

import android.content.Context;
import android.net.Uri;

/* compiled from: SearchRequest.java */
/* renamed from: com.sec.chaton.search.d */
/* loaded from: classes.dex */
public class C2382d {

    /* renamed from: a */
    private final Context f8848a;

    /* renamed from: b */
    private final Uri f8849b;

    /* renamed from: c */
    private InterfaceC2384f f8850c;

    /* renamed from: d */
    private String[] f8851d;

    /* renamed from: e */
    private String f8852e;

    /* renamed from: f */
    private String[] f8853f;

    /* renamed from: g */
    private boolean f8854g;

    /* renamed from: h */
    private EnumC2385g f8855h;

    /* renamed from: i */
    private String f8856i;

    /* renamed from: j */
    private String f8857j;

    /* renamed from: k */
    private String f8858k;

    /* renamed from: l */
    private String[] f8859l;

    public C2382d(C2383e c2383e) {
        this.f8848a = c2383e.f8860a;
        this.f8849b = c2383e.f8861b;
        this.f8850c = c2383e.f8862c;
        this.f8851d = c2383e.f8863d;
        this.f8852e = c2383e.f8864e;
        this.f8853f = c2383e.f8865f;
        this.f8854g = c2383e.f8866g;
        this.f8855h = c2383e.f8867h;
        m8851a();
        m8852b();
    }

    /* renamed from: a */
    protected void m8851a() {
        if (this.f8849b != null) {
            this.f8858k = this.f8849b.getQueryParameter("limit");
            this.f8856i = this.f8849b.getQueryParameter("stime");
            this.f8857j = this.f8849b.getQueryParameter("etime");
        }
    }

    /* renamed from: b */
    protected void m8852b() {
        if (this.f8849b != null) {
            this.f8859l = new C2379a().m8838a(this.f8849b.getLastPathSegment());
        }
    }

    /* renamed from: c */
    public String[] m8853c() {
        return this.f8859l;
    }

    /* renamed from: d */
    public InterfaceC2384f m8854d() {
        return this.f8850c;
    }

    /* renamed from: e */
    public EnumC2385g m8855e() {
        return this.f8855h;
    }

    /* renamed from: f */
    public String m8856f() {
        return this.f8856i;
    }

    /* renamed from: g */
    public String m8857g() {
        return this.f8857j;
    }

    /* renamed from: h */
    public String m8858h() {
        return this.f8858k;
    }
}
