package com.sec.chaton.msgsend;

/* compiled from: MsgSendHelper.java */
/* renamed from: com.sec.chaton.msgsend.r */
/* loaded from: classes.dex */
public enum EnumC1758r {
    NOT_DETERMINED(-1),
    DISABLED(0),
    ENABLED(1);


    /* renamed from: d */
    private int f6482d;

    EnumC1758r(int i) {
        this.f6482d = i;
    }

    /* renamed from: a */
    public int m7259a() {
        return this.f6482d;
    }

    /* renamed from: a */
    public static EnumC1758r m7258a(int i) {
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
