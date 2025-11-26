package com.sec.chaton.updates;

/* compiled from: UpdatesAdapter.java */
/* renamed from: com.sec.chaton.updates.g */
/* loaded from: classes.dex */
public enum EnumC4700g {
    NORMAL("normal"),
    DEREGISTERED("dereg"),
    BLOCKED("block");


    /* renamed from: d */
    String f17040d;

    EnumC4700g(String str) {
        this.f17040d = str;
    }

    /* renamed from: a */
    public String m17761a() {
        return this.f17040d;
    }

    /* renamed from: a */
    public static EnumC4700g m17760a(String str) {
        for (EnumC4700g enumC4700g : values()) {
            if (enumC4700g.m17761a().equals(str)) {
                return enumC4700g;
            }
        }
        return NORMAL;
    }
}
