package com.sec.chaton.trunk.database;

/* compiled from: DatabaseConstant.java */
/* renamed from: com.sec.chaton.trunk.database.e */
/* loaded from: classes.dex */
public enum EnumC1177e {
    Item(1),
    LoadMore(2);


    /* renamed from: c */
    private int f4043c;

    EnumC1177e(int i) {
        this.f4043c = i;
    }

    /* renamed from: a */
    public int m4254a() {
        return this.f4043c;
    }

    /* renamed from: a */
    public static EnumC1177e m4253a(int i) {
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
