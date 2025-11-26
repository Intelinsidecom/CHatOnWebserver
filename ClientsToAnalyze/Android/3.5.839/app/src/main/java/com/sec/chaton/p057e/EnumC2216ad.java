package com.sec.chaton.p057e;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.ad */
/* loaded from: classes.dex */
public enum EnumC2216ad {
    UNDEFINED(-1),
    WITHDRAWING(0),
    WITHDRAW_SUCCESS(1),
    WITHDRAW_FAIL(2);


    /* renamed from: e */
    private final int f7939e;

    EnumC2216ad(int i) {
        this.f7939e = i;
    }

    /* renamed from: a */
    public int m10083a() {
        return this.f7939e;
    }

    /* renamed from: a */
    public static EnumC2216ad m10082a(int i) {
        switch (i) {
            case 0:
                return WITHDRAWING;
            case 1:
                return WITHDRAW_SUCCESS;
            case 2:
                return WITHDRAW_FAIL;
            default:
                return UNDEFINED;
        }
    }
}
