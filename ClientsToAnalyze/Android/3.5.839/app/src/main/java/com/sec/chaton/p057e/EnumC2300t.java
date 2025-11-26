package com.sec.chaton.p057e;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.t */
/* loaded from: classes.dex */
public enum EnumC2300t {
    UNKNOWN(-1),
    ONETOONE(0),
    GROUPCHAT(1),
    BROADCAST(2),
    BROADCAST2(3),
    MONOLOGUE(4),
    TOPIC(5),
    WEB_AUTH(9999);


    /* renamed from: i */
    private final int f8219i;

    EnumC2300t(int i) {
        this.f8219i = i;
    }

    /* renamed from: a */
    public int m10210a() {
        return this.f8219i;
    }

    /* renamed from: a */
    public static EnumC2300t m10207a(int i) {
        switch (i) {
            case 0:
                return ONETOONE;
            case 1:
                return GROUPCHAT;
            case 2:
                return BROADCAST;
            case 3:
                return BROADCAST2;
            case 4:
                return MONOLOGUE;
            case 5:
                return TOPIC;
            case 9999:
                return WEB_AUTH;
            default:
                return UNKNOWN;
        }
    }

    /* renamed from: a */
    public static boolean m10208a(EnumC2300t enumC2300t) {
        return enumC2300t == BROADCAST || enumC2300t == BROADCAST2;
    }

    /* renamed from: b */
    public static boolean m10209b(EnumC2300t enumC2300t) {
        return enumC2300t == BROADCAST;
    }
}
