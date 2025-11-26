package com.sec.chaton.trunk.p048b;

/* compiled from: TrunkMessageControl.java */
/* renamed from: com.sec.chaton.trunk.b.b */
/* loaded from: classes.dex */
public enum EnumC1551b {
    UnreadComment("unreadcommented"),
    Recent("recentadded");


    /* renamed from: c */
    private String f5613c;

    EnumC1551b(String str) {
        this.f5613c = str;
    }

    /* renamed from: a */
    public String m5406a() {
        return this.f5613c;
    }

    /* renamed from: a */
    public static EnumC1551b m5405a(String str) {
        if ("recentadded".equals(str)) {
            return Recent;
        }
        if ("unreadcommented".equals(str)) {
            return UnreadComment;
        }
        return null;
    }
}
