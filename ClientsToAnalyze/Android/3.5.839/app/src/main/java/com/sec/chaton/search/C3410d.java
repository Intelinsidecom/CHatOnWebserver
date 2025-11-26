package com.sec.chaton.search;

import android.content.Context;
import android.net.Uri;

/* compiled from: SearchRequest.java */
/* renamed from: com.sec.chaton.search.d */
/* loaded from: classes.dex */
public class C3410d {

    /* renamed from: a */
    private final Context f12376a;

    /* renamed from: b */
    private final Uri f12377b;

    /* renamed from: c */
    private InterfaceC3412f f12378c;

    /* renamed from: d */
    private String[] f12379d;

    /* renamed from: e */
    private String f12380e;

    /* renamed from: f */
    private String[] f12381f;

    /* renamed from: g */
    private boolean f12382g;

    /* renamed from: h */
    private EnumC3413g f12383h;

    /* renamed from: i */
    private String f12384i;

    /* renamed from: j */
    private String f12385j;

    /* renamed from: k */
    private String f12386k;

    /* renamed from: l */
    private String[] f12387l;

    public C3410d(C3411e c3411e) {
        this.f12376a = c3411e.f12388a;
        this.f12377b = c3411e.f12389b;
        this.f12378c = c3411e.f12390c;
        this.f12379d = c3411e.f12391d;
        this.f12380e = c3411e.f12392e;
        this.f12381f = c3411e.f12393f;
        this.f12382g = c3411e.f12394g;
        this.f12383h = c3411e.f12395h;
        m13235a();
        m13236b();
    }

    /* renamed from: a */
    protected void m13235a() {
        if (this.f12377b != null) {
            this.f12386k = this.f12377b.getQueryParameter("limit");
            this.f12384i = this.f12377b.getQueryParameter("stime");
            this.f12385j = this.f12377b.getQueryParameter("etime");
        }
    }

    /* renamed from: b */
    protected void m13236b() {
        if (this.f12377b != null) {
            this.f12387l = new C3407a().m13219a(this.f12377b.getLastPathSegment());
        }
    }

    /* renamed from: c */
    public String[] m13237c() {
        return this.f12387l;
    }

    /* renamed from: d */
    public InterfaceC3412f m13238d() {
        return this.f12378c;
    }

    /* renamed from: e */
    public EnumC3413g m13239e() {
        return this.f12383h;
    }

    /* renamed from: f */
    public String m13240f() {
        return this.f12384i;
    }

    /* renamed from: g */
    public String m13241g() {
        return this.f12385j;
    }

    /* renamed from: h */
    public String m13242h() {
        return this.f12386k;
    }
}
