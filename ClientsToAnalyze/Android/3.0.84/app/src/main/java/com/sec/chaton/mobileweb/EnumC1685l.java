package com.sec.chaton.mobileweb;

/* compiled from: ChatONAction.java */
/* renamed from: com.sec.chaton.mobileweb.l */
/* loaded from: classes.dex */
public enum EnumC1685l {
    LIVE_CONTENTS("/chat/livecontents"),
    BUDDY_POPUP("/buddypopup"),
    LIVE_CHAT("/chat/livechat");


    /* renamed from: d */
    private String f6200d;

    /* renamed from: a */
    public static EnumC1685l m6975a(String str) {
        for (EnumC1685l enumC1685l : values()) {
            if (enumC1685l.m6976a().equals(str)) {
                return enumC1685l;
            }
        }
        return null;
    }

    EnumC1685l(String str) {
        this.f6200d = str;
    }

    /* renamed from: a */
    public String m6976a() {
        return this.f6200d;
    }
}
