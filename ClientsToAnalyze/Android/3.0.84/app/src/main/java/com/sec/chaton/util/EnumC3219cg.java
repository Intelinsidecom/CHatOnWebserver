package com.sec.chaton.util;

/* compiled from: ServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.cg */
/* loaded from: classes.dex */
public enum EnumC3219cg {
    GLD(false, true),
    CONTACT(true, true),
    FILE(true, true),
    SMS_GATEWAY(true, true),
    ADMIN_MOBILEWEB(true, true),
    LIVE_MOBILEWEB(true, true),
    APPS(false, false),
    BYPASS(false, false),
    SSO(false, false),
    SSO_API(false, false),
    CHATONV(true, false),
    TRANSLATION_AUTH(false, false),
    TRANSLATION(false, false);


    /* renamed from: n */
    boolean f11657n;

    /* renamed from: o */
    boolean f11658o;

    EnumC3219cg(boolean z, boolean z2) {
        this.f11657n = z;
        this.f11658o = z2;
    }

    /* renamed from: a */
    public boolean m11314a() {
        return this.f11657n;
    }

    /* renamed from: b */
    public boolean m11315b() {
        return this.f11658o;
    }
}
