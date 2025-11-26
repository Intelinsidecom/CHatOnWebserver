package com.sec.chaton.settings;

/* compiled from: FragmentChatView2.java */
/* renamed from: com.sec.chaton.settings.ed */
/* loaded from: classes.dex */
public enum EnumC3594ed {
    System("sizeSystem"),
    Tiny("size50"),
    Small("size70"),
    Normal("size100"),
    Large("size150"),
    Huge("size200");


    /* renamed from: g */
    String f13122g;

    /* renamed from: a */
    public static EnumC3594ed m13898a(int i) {
        return values()[i];
    }

    /* renamed from: a */
    public static EnumC3594ed m13899a(String str) {
        for (EnumC3594ed enumC3594ed : values()) {
            if (enumC3594ed.m13900a().equals(str)) {
                return enumC3594ed;
            }
        }
        throw new IllegalArgumentException();
    }

    EnumC3594ed(String str) {
        this.f13122g = str;
    }

    /* renamed from: a */
    public String m13900a() {
        return this.f13122g;
    }
}
