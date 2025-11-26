package com.facebook;

/* compiled from: SessionLoginBehavior.java */
/* renamed from: com.facebook.br */
/* loaded from: classes.dex */
public enum EnumC0124br {
    SSO_WITH_FALLBACK(true, true),
    SSO_ONLY(true, false),
    SUPPRESS_SSO(false, true);


    /* renamed from: d */
    private final boolean f255d;

    /* renamed from: e */
    private final boolean f256e;

    EnumC0124br(boolean z, boolean z2) {
        this.f255d = z;
        this.f256e = z2;
    }

    /* renamed from: a */
    boolean m360a() {
        return this.f255d;
    }

    /* renamed from: b */
    boolean m361b() {
        return this.f256e;
    }
}
