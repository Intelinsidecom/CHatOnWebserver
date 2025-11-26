package com.sec.chaton.plugin;

/* compiled from: PlugInManager.java */
/* renamed from: com.sec.chaton.plugin.i */
/* loaded from: classes.dex */
public enum EnumC2949i {
    ChatONV(C2923b.class, "com.coolots.chaton", "com.coolots.chatonforcanada"),
    CommonPush(C2933c.class, "com.sec.spp.push"),
    STranslator(C2951k.class, "com.sec.android.app.translator"),
    SStream(C2950j.class, "sstream.app"),
    Animessage(C2921a.class, "com.sec.animessage");


    /* renamed from: f */
    String[] f10860f;

    /* renamed from: g */
    Class<? extends InterfaceC2941e> f10861g;

    EnumC2949i(Class cls, String... strArr) {
        this.f10860f = strArr;
        this.f10861g = cls;
    }

    /* renamed from: a */
    public static EnumC2949i m12193a(String str) {
        for (EnumC2949i enumC2949i : values()) {
            for (String str2 : enumC2949i.f10860f) {
                if (str2.equals(str)) {
                    return enumC2949i;
                }
            }
        }
        return null;
    }
}
