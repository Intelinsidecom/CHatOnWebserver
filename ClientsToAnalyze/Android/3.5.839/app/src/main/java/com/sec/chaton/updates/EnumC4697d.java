package com.sec.chaton.updates;

/* compiled from: UpdatesAdapter.java */
/* renamed from: com.sec.chaton.updates.d */
/* loaded from: classes.dex */
public enum EnumC4697d {
    NONE("none"),
    POST("post"),
    REACTION("reaction"),
    RECOMMEND("recommend"),
    UPDATE("update"),
    INVITE("invite"),
    JOIN("join");


    /* renamed from: h */
    String f17020h;

    EnumC4697d(String str) {
        this.f17020h = str;
    }

    /* renamed from: a */
    public String m17755a() {
        return this.f17020h;
    }

    /* renamed from: a */
    public static EnumC4697d m17754a(String str) {
        for (EnumC4697d enumC4697d : values()) {
            if (enumC4697d.m17755a().equals(str)) {
                return enumC4697d;
            }
        }
        return NONE;
    }
}
