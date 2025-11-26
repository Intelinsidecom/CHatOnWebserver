package com.sec.chaton.updates;

/* compiled from: UpdatesAdapter.java */
/* renamed from: com.sec.chaton.updates.f */
/* loaded from: classes.dex */
public enum EnumC4699f {
    NONE("none"),
    POSTON("poston"),
    TRUNK("trunk"),
    BUDDY("buddy"),
    PROFILE("profile");


    /* renamed from: f */
    String f17035f;

    EnumC4699f(String str) {
        this.f17035f = str;
    }

    /* renamed from: a */
    public String m17759a() {
        return this.f17035f;
    }

    /* renamed from: a */
    public static EnumC4699f m17758a(String str) {
        for (EnumC4699f enumC4699f : values()) {
            if (enumC4699f.m17759a().equals(str)) {
                return enumC4699f;
            }
        }
        return NONE;
    }
}
