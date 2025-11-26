package com.sec.chaton.search;

import android.content.Context;
import android.net.Uri;

/* compiled from: SearchRequest.java */
/* renamed from: com.sec.chaton.search.e */
/* loaded from: classes.dex */
public class C2383e {

    /* renamed from: a */
    private final Context f8860a;

    /* renamed from: b */
    private final Uri f8861b;

    /* renamed from: c */
    private InterfaceC2384f f8862c;

    /* renamed from: d */
    private String[] f8863d;

    /* renamed from: e */
    private String f8864e;

    /* renamed from: f */
    private String[] f8865f;

    /* renamed from: g */
    private boolean f8866g;

    /* renamed from: h */
    private EnumC2385g f8867h;

    public C2383e(Context context, Uri uri) {
        this.f8860a = context;
        this.f8861b = uri;
    }

    /* renamed from: a */
    public C2383e m8868a(InterfaceC2384f interfaceC2384f) {
        this.f8862c = interfaceC2384f;
        return this;
    }

    /* renamed from: a */
    public C2383e m8872a(String[] strArr) {
        this.f8863d = strArr;
        return this;
    }

    /* renamed from: a */
    public C2383e m8870a(String str) {
        this.f8864e = str;
        return this;
    }

    /* renamed from: b */
    public C2383e m8873b(String[] strArr) {
        this.f8865f = strArr;
        return this;
    }

    /* renamed from: a */
    public C2383e m8871a(boolean z) {
        this.f8866g = z;
        return this;
    }

    /* renamed from: a */
    public C2383e m8869a(EnumC2385g enumC2385g) {
        this.f8867h = enumC2385g;
        return this;
    }

    /* renamed from: a */
    public C2382d m8867a() {
        return new C2382d(this);
    }
}
