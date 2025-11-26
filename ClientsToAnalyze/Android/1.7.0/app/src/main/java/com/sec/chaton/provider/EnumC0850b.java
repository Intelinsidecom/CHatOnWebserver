package com.sec.chaton.provider;

/* compiled from: ChatONProvider.java */
/* renamed from: com.sec.chaton.provider.b */
/* loaded from: classes.dex */
public enum EnumC0850b {
    UNKNOWN(-1),
    NORMAL(1),
    CONSTRAINT(2),
    FULL(3),
    DISK_IO(4);


    /* renamed from: f */
    private int f2946f;

    EnumC0850b(int i) {
        this.f2946f = i;
    }

    /* renamed from: a */
    public int m3435a() {
        return this.f2946f;
    }

    /* renamed from: a */
    public static EnumC0850b m3434a(int i) {
        switch (i) {
            case 1:
                return NORMAL;
            case 2:
                return CONSTRAINT;
            case 3:
                return FULL;
            case 4:
                return DISK_IO;
            default:
                return UNKNOWN;
        }
    }
}
