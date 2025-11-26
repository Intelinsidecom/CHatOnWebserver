package com.facebook;

/* compiled from: SessionLoginBehavior.java */
/* renamed from: com.facebook.br */
/* loaded from: classes.dex */
public enum EnumC0495br {
    SSO_WITH_FALLBACK(true, true),
    SSO_ONLY(true, false),
    SUPPRESS_SSO(false, true);


    /* renamed from: d */
    private final boolean f1224d;

    /* renamed from: e */
    private final boolean f1225e;

    EnumC0495br(boolean z, boolean z2) {
        this.f1224d = z;
        this.f1225e = z2;
    }

    /* renamed from: a */
    boolean m1803a() {
        return this.f1224d;
    }

    /* renamed from: b */
    boolean m1804b() {
        return this.f1225e;
    }
}
