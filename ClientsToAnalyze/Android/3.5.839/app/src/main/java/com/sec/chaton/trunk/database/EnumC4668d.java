package com.sec.chaton.trunk.database;

/* compiled from: DatabaseConstant.java */
/* renamed from: com.sec.chaton.trunk.database.d */
/* loaded from: classes.dex */
public enum EnumC4668d {
    Item(1),
    LoadMore(2);


    /* renamed from: c */
    private int f16905c;

    EnumC4668d(int i) {
        this.f16905c = i;
    }

    /* renamed from: a */
    public int m17667a() {
        return this.f16905c;
    }

    /* renamed from: a */
    public static EnumC4668d m17666a(int i) {
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
