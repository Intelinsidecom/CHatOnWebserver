package com.sec.chaton.settings;

/* compiled from: FragmentChatView2.java */
/* renamed from: com.sec.chaton.settings.z */
/* loaded from: classes.dex */
public enum EnumC1094z {
    Tiny("size50"),
    Small("size70"),
    Normal("size100"),
    Large("size150"),
    Huge("size200");


    /* renamed from: f */
    String f3746f;

    /* renamed from: a */
    public static EnumC1094z m3955a(int i) {
        return values()[i];
    }

    /* renamed from: a */
    public static EnumC1094z m3956a(String str) {
        for (EnumC1094z enumC1094z : values()) {
            if (enumC1094z.m3957a().equals(str)) {
                return enumC1094z;
            }
        }
        throw new IllegalArgumentException();
    }

    EnumC1094z(String str) {
        this.f3746f = str;
    }

    /* renamed from: a */
    public String m3957a() {
        return this.f3746f;
    }
}
