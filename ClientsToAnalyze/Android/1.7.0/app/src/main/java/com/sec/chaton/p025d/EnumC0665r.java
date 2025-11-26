package com.sec.chaton.p025d;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.r */
/* loaded from: classes.dex */
public enum EnumC0665r {
    UNKNOWN(-1),
    ONETOONE(0),
    GROUPCHAT(1),
    BROADCAST(2),
    WEB_AUTH(9999);


    /* renamed from: f */
    private int f2305f;

    EnumC0665r(int i) {
        this.f2305f = i;
    }

    /* renamed from: a */
    public int m3012a() {
        return this.f2305f;
    }

    /* renamed from: a */
    public static EnumC0665r m3011a(int i) {
        switch (i) {
            case 0:
                return ONETOONE;
            case 1:
                return GROUPCHAT;
            case 2:
                return BROADCAST;
            case 9999:
                return WEB_AUTH;
            default:
                return UNKNOWN;
        }
    }
}
