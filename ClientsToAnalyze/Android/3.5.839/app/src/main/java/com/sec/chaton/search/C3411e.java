package com.sec.chaton.search;

import android.content.Context;
import android.net.Uri;

/* compiled from: SearchRequest.java */
/* renamed from: com.sec.chaton.search.e */
/* loaded from: classes.dex */
public class C3411e {

    /* renamed from: a */
    private final Context f12388a;

    /* renamed from: b */
    private final Uri f12389b;

    /* renamed from: c */
    private InterfaceC3412f f12390c;

    /* renamed from: d */
    private String[] f12391d;

    /* renamed from: e */
    private String f12392e;

    /* renamed from: f */
    private String[] f12393f;

    /* renamed from: g */
    private boolean f12394g;

    /* renamed from: h */
    private EnumC3413g f12395h;

    public C3411e(Context context, Uri uri) {
        this.f12388a = context;
        this.f12389b = uri;
    }

    /* renamed from: a */
    public C3411e m13252a(InterfaceC3412f interfaceC3412f) {
        this.f12390c = interfaceC3412f;
        return this;
    }

    /* renamed from: a */
    public C3411e m13256a(String[] strArr) {
        this.f12391d = strArr;
        return this;
    }

    /* renamed from: a */
    public C3411e m13254a(String str) {
        this.f12392e = str;
        return this;
    }

    /* renamed from: b */
    public C3411e m13257b(String[] strArr) {
        this.f12393f = strArr;
        return this;
    }

    /* renamed from: a */
    public C3411e m13255a(boolean z) {
        this.f12394g = z;
        return this;
    }

    /* renamed from: a */
    public C3411e m13253a(EnumC3413g enumC3413g) {
        this.f12395h = enumC3413g;
        return this;
    }

    /* renamed from: a */
    public C3410d m13251a() {
        return new C3410d(this);
    }
}
