package com.sec.chaton.p027e;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.r */
/* loaded from: classes.dex */
public enum EnumC1450r {
    UNKNOWN(-1),
    ONETOONE(0),
    GROUPCHAT(1),
    BROADCAST(2),
    BROADCAST2(3),
    WEB_AUTH(9999);


    /* renamed from: g */
    private int f5389g;

    EnumC1450r(int i) {
        this.f5389g = i;
    }

    /* renamed from: a */
    public int m6342a() {
        return this.f5389g;
    }

    /* renamed from: a */
    public static EnumC1450r m6339a(int i) {
        switch (i) {
            case 0:
                return ONETOONE;
            case 1:
                return GROUPCHAT;
            case 2:
                return BROADCAST;
            case 3:
                return BROADCAST2;
            case 9999:
                return WEB_AUTH;
            default:
                return UNKNOWN;
        }
    }

    /* renamed from: a */
    public static boolean m6340a(EnumC1450r enumC1450r) {
        return enumC1450r == BROADCAST || enumC1450r == BROADCAST2;
    }

    /* renamed from: b */
    public static boolean m6341b(EnumC1450r enumC1450r) {
        return enumC1450r == BROADCAST;
    }
}
