package com.sec.chaton.util;

/* compiled from: ServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.cf */
/* loaded from: classes.dex */
public enum EnumC4868cf {
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
    SHOP(true, true),
    TRANSLATION_AUTH(true, true),
    TRANSLATION(false, false),
    QMLOG(false, false),
    GAME(true, true),
    HUGE_FILE(true, true),
    AUTH(true, true);


    /* renamed from: s */
    boolean f17777s;

    /* renamed from: t */
    boolean f17778t;

    EnumC4868cf(boolean z, boolean z2) {
        this.f17777s = z;
        this.f17778t = z2;
    }

    /* renamed from: a */
    public boolean m18486a() {
        return this.f17777s;
    }

    /* renamed from: b */
    public boolean m18487b() {
        return this.f17778t;
    }
}
