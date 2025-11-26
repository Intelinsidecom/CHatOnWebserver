package com.sec.chaton.mobileweb;

/* compiled from: SchemeType.java */
/* renamed from: com.sec.chaton.mobileweb.u */
/* loaded from: classes.dex */
public enum EnumC2607u {
    INTENT("intent:"),
    HTTP("http:"),
    HTTPS("https:"),
    FILE("file:"),
    CHATON_DEEP_LINK("chaton:"),
    UNKNOWN("");


    /* renamed from: g */
    String f9316g;

    EnumC2607u(String str) {
        this.f9316g = str;
    }

    /* renamed from: a */
    static EnumC2607u m11025a(String str) {
        for (EnumC2607u enumC2607u : values()) {
            if (str.startsWith(enumC2607u.f9316g)) {
                return enumC2607u;
            }
        }
        return UNKNOWN;
    }
}
