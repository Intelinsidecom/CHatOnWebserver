package com.sec.chaton.msgsend;

/* compiled from: MsgSendStatus.java */
/* renamed from: com.sec.chaton.msgsend.aj */
/* loaded from: classes.dex */
public enum EnumC2692aj {
    UNKNOWN_STATUS(-9999),
    FAILED(-1),
    PENDING(6),
    SENDING(0),
    SENDED(1);


    /* renamed from: f */
    private int f9669f;

    EnumC2692aj(int i) {
        this.f9669f = i;
    }

    /* renamed from: a */
    int m11302a() {
        return this.f9669f;
    }

    /* renamed from: a */
    public static EnumC2692aj m11301a(int i) {
        switch (i) {
            case -1:
                return FAILED;
            case 0:
                return SENDING;
            case 1:
                return SENDED;
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                return UNKNOWN_STATUS;
            case 6:
                return PENDING;
        }
    }
}
