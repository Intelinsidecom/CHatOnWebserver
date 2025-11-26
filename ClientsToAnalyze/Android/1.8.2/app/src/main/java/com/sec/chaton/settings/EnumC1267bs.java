package com.sec.chaton.settings;

/* compiled from: FragmentChatView2.java */
/* renamed from: com.sec.chaton.settings.bs */
/* loaded from: classes.dex */
public enum EnumC1267bs {
    Tiny("size50"),
    Small("size70"),
    Normal("size100"),
    Large("size150"),
    Huge("size200");


    /* renamed from: f */
    String f4814f;

    /* renamed from: a */
    public static EnumC1267bs m4743a(int i) {
        return values()[i];
    }

    /* renamed from: a */
    public static EnumC1267bs m4744a(String str) {
        for (EnumC1267bs enumC1267bs : values()) {
            if (enumC1267bs.m4745a().equals(str)) {
                return enumC1267bs;
            }
        }
        throw new IllegalArgumentException();
    }

    EnumC1267bs(String str) {
        this.f4814f = str;
    }

    /* renamed from: a */
    public String m4745a() {
        return this.f4814f;
    }
}
