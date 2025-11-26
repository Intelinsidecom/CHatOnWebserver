package com.sec.chaton.hugefiletransfer;

/* compiled from: HugeFileConstants.java */
/* renamed from: com.sec.chaton.hugefiletransfer.b */
/* loaded from: classes.dex */
public enum EnumC2388b {
    UPLOADING(0),
    CANCEL(1),
    FAIL(2),
    SUCCESS(3);


    /* renamed from: e */
    private final int f8497e;

    EnumC2388b(int i) {
        this.f8497e = i;
    }

    /* renamed from: a */
    public int m10385a() {
        return this.f8497e;
    }

    /* renamed from: a */
    public static EnumC2388b m10384a(int i) {
        switch (i) {
            case 0:
                return UPLOADING;
            case 1:
                return CANCEL;
            case 2:
                return FAIL;
            case 3:
                return SUCCESS;
            default:
                return FAIL;
        }
    }
}
