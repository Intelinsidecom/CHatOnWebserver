package com.sec.chaton.trunk.database;

/* compiled from: DatabaseConstant.java */
/* renamed from: com.sec.chaton.trunk.database.d */
/* loaded from: classes.dex */
public enum EnumC1588d {
    Item(1),
    LoadMore(2);


    /* renamed from: c */
    private int f5702c;

    EnumC1588d(int i) {
        this.f5702c = i;
    }

    /* renamed from: a */
    public int m5481a() {
        return this.f5702c;
    }

    /* renamed from: a */
    public static EnumC1588d m5480a(int i) {
        switch (i) {
            case 1:
                return Item;
            case 2:
                return LoadMore;
            default:
                throw new IllegalArgumentException("value argument must be Item(1) or LoadMore(2).");
        }
    }
}
