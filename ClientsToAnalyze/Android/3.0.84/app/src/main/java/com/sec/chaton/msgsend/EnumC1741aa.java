package com.sec.chaton.msgsend;

/* compiled from: MsgSendStatus.java */
/* renamed from: com.sec.chaton.msgsend.aa */
/* loaded from: classes.dex */
public enum EnumC1741aa {
    UNKNOWN_STATUS(-9999),
    FAILED(-1),
    PENDING(6),
    SENDING(0),
    SENDED(1);


    /* renamed from: f */
    private int f6425f;

    EnumC1741aa(int i) {
        this.f6425f = i;
    }

    /* renamed from: a */
    int m7157a() {
        return this.f6425f;
    }

    /* renamed from: a */
    public static EnumC1741aa m7156a(int i) {
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
