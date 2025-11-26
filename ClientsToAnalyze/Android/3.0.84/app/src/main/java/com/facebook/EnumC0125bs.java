package com.facebook;

/* compiled from: SessionState.java */
/* renamed from: com.facebook.bs */
/* loaded from: classes.dex */
public enum EnumC0125bs {
    CREATED(EnumC0126bt.CREATED_CATEGORY),
    CREATED_TOKEN_LOADED(EnumC0126bt.CREATED_CATEGORY),
    OPENING(EnumC0126bt.CREATED_CATEGORY),
    OPENED(EnumC0126bt.OPENED_CATEGORY),
    OPENED_TOKEN_UPDATED(EnumC0126bt.OPENED_CATEGORY),
    CLOSED_LOGIN_FAILED(EnumC0126bt.CLOSED_CATEGORY),
    CLOSED(EnumC0126bt.CLOSED_CATEGORY);


    /* renamed from: h */
    private final EnumC0126bt f265h;

    EnumC0125bs(EnumC0126bt enumC0126bt) {
        this.f265h = enumC0126bt;
    }

    /* renamed from: a */
    public boolean m362a() {
        return this.f265h == EnumC0126bt.OPENED_CATEGORY;
    }

    /* renamed from: b */
    public boolean m363b() {
        return this.f265h == EnumC0126bt.CLOSED_CATEGORY;
    }
}
