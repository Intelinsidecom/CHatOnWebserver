package com.sec.chaton.p017e;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.j */
/* loaded from: classes.dex */
public enum EnumC0695j {
    UNKNOWN(-1),
    ONETOONE(0),
    GROUPCHAT(1),
    BROADCAST(2),
    WEB_AUTH(9999);


    /* renamed from: f */
    private int f2623f;

    EnumC0695j(int i) {
        this.f2623f = i;
    }

    /* renamed from: a */
    public int m3146a() {
        return this.f2623f;
    }

    /* renamed from: a */
    public static EnumC0695j m3145a(int i) {
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
