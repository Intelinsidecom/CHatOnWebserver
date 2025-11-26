package com.sec.chaton.trunk.p043c;

/* compiled from: TrunkMessageControl.java */
/* renamed from: com.sec.chaton.trunk.c.a */
/* loaded from: classes.dex */
public enum EnumC1152a {
    UnreadComment("unreadcommented"),
    Recent("recentadded");


    /* renamed from: c */
    private String f3995c;

    EnumC1152a(String str) {
        this.f3995c = str;
    }

    /* renamed from: a */
    public String m4192a() {
        return this.f3995c;
    }

    /* renamed from: a */
    public static EnumC1152a m4191a(String str) {
        if ("recentadded".equals(str)) {
            return Recent;
        }
        if ("unreadcommented".equals(str)) {
            return UnreadComment;
        }
        return null;
    }
}
