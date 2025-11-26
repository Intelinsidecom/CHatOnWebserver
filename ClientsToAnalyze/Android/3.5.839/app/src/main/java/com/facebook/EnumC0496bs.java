package com.facebook;

/* compiled from: SessionState.java */
/* renamed from: com.facebook.bs */
/* loaded from: classes.dex */
public enum EnumC0496bs {
    CREATED(EnumC0497bt.CREATED_CATEGORY),
    CREATED_TOKEN_LOADED(EnumC0497bt.CREATED_CATEGORY),
    OPENING(EnumC0497bt.CREATED_CATEGORY),
    OPENED(EnumC0497bt.OPENED_CATEGORY),
    OPENED_TOKEN_UPDATED(EnumC0497bt.OPENED_CATEGORY),
    CLOSED_LOGIN_FAILED(EnumC0497bt.CLOSED_CATEGORY),
    CLOSED(EnumC0497bt.CLOSED_CATEGORY);


    /* renamed from: h */
    private final EnumC0497bt f1234h;

    EnumC0496bs(EnumC0497bt enumC0497bt) {
        this.f1234h = enumC0497bt;
    }

    /* renamed from: a */
    public boolean m1805a() {
        return this.f1234h == EnumC0497bt.OPENED_CATEGORY;
    }

    /* renamed from: b */
    public boolean m1806b() {
        return this.f1234h == EnumC0497bt.CLOSED_CATEGORY;
    }
}
