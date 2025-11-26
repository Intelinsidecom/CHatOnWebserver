package com.sec.chaton.settings;

/* compiled from: FragmentChatView2.java */
/* renamed from: com.sec.chaton.settings.dk */
/* loaded from: classes.dex */
public enum EnumC2504dk {
    System("sizeSystem"),
    Tiny("size50"),
    Small("size70"),
    Normal("size100"),
    Large("size150"),
    Huge("size200");


    /* renamed from: g */
    String f9401g;

    /* renamed from: a */
    public static EnumC2504dk m9258a(int i) {
        return values()[i];
    }

    /* renamed from: a */
    public static EnumC2504dk m9259a(String str) {
        for (EnumC2504dk enumC2504dk : values()) {
            if (enumC2504dk.m9260a().equals(str)) {
                return enumC2504dk;
            }
        }
        throw new IllegalArgumentException();
    }

    EnumC2504dk(String str) {
        this.f9401g = str;
    }

    /* renamed from: a */
    public String m9260a() {
        return this.f9401g;
    }
}
