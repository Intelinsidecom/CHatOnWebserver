package com.sec.chaton.trunk.p118a;

/* compiled from: TrunkMessageControl.java */
/* renamed from: com.sec.chaton.trunk.a.b */
/* loaded from: classes.dex */
public enum EnumC4575b {
    UnreadComment("unreadcommented"),
    Recent("recentadded");


    /* renamed from: c */
    private String f16685c;

    EnumC4575b(String str) {
        this.f16685c = str;
    }

    /* renamed from: a */
    public String m17530a() {
        return this.f16685c;
    }

    /* renamed from: a */
    public static EnumC4575b m17529a(String str) {
        if ("recentadded".equals(str)) {
            return Recent;
        }
        if ("unreadcommented".equals(str)) {
            return UnreadComment;
        }
        return null;
    }
}
