package com.sec.chaton.msgsend;

/* compiled from: MsgSendHelper.java */
/* renamed from: com.sec.chaton.msgsend.aa */
/* loaded from: classes.dex */
public enum EnumC2683aa {
    NOT_DETERMINED(-1),
    DISABLED(0),
    ENABLED(1);


    /* renamed from: d */
    private int f9631d;

    EnumC2683aa(int i) {
        this.f9631d = i;
    }

    /* renamed from: a */
    public int m11289a() {
        return this.f9631d;
    }

    /* renamed from: a */
    public static EnumC2683aa m11288a(int i) {
        switch (i) {
            case 0:
                return DISABLED;
            case 1:
                return ENABLED;
            default:
                return NOT_DETERMINED;
        }
    }
}
