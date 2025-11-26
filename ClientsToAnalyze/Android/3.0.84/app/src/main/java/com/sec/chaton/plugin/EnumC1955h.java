package com.sec.chaton.plugin;

/* compiled from: PlugInManager.java */
/* renamed from: com.sec.chaton.plugin.h */
/* loaded from: classes.dex */
public enum EnumC1955h {
    ChatONV(C1948a.class, "com.coolots.chaton", "com.coolots.chatonforcanada"),
    CommonPush(C1949b.class, "com.sec.spp.push"),
    STranslator(C1956i.class, "com.sec.android.app.translator");


    /* renamed from: d */
    String[] f7482d;

    /* renamed from: e */
    Class<? extends InterfaceC1951d> f7483e;

    EnumC1955h(Class cls, String... strArr) {
        this.f7482d = strArr;
        this.f7483e = cls;
    }

    /* renamed from: a */
    public static EnumC1955h m7919a(String str) {
        for (EnumC1955h enumC1955h : values()) {
            for (String str2 : enumC1955h.f7482d) {
                if (str2.equals(str)) {
                    return enumC1955h;
                }
            }
        }
        return null;
    }
}
