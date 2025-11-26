package com.sec.chaton.trunk.p058a;

/* compiled from: TrunkMessageControl.java */
/* renamed from: com.sec.chaton.trunk.a.b */
/* loaded from: classes.dex */
public enum EnumC2959b {
    UnreadComment("unreadcommented"),
    Recent("recentadded");


    /* renamed from: c */
    private String f10739c;

    EnumC2959b(String str) {
        this.f10739c = str;
    }

    /* renamed from: a */
    public String m10434a() {
        return this.f10739c;
    }

    /* renamed from: a */
    public static EnumC2959b m10433a(String str) {
        if ("recentadded".equals(str)) {
            return Recent;
        }
        if ("unreadcommented".equals(str)) {
            return UnreadComment;
        }
        return null;
    }
}
