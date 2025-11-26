package com.sec.chaton.trunk.database;

/* compiled from: DatabaseConstant.java */
/* renamed from: com.sec.chaton.trunk.database.d */
/* loaded from: classes.dex */
public enum EnumC3048d {
    Item(1),
    LoadMore(2);


    /* renamed from: c */
    private int f10956c;

    EnumC3048d(int i) {
        this.f10956c = i;
    }

    /* renamed from: a */
    public int m10573a() {
        return this.f10956c;
    }

    /* renamed from: a */
    public static EnumC3048d m10572a(int i) {
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
