package com.sec.chaton.p057e;

/* compiled from: ChatONContract2.java */
/* renamed from: com.sec.chaton.e.bk */
/* loaded from: classes.dex */
public enum EnumC2265bk {
    LIVE("live"),
    SHOP("shop"),
    EVENT("event"),
    TOPIC("topic"),
    UNKNOWN("unknown");


    /* renamed from: f */
    private String f8061f;

    EnumC2265bk(String str) {
        this.f8061f = str;
    }

    /* renamed from: a */
    public String m10125a() {
        return this.f8061f;
    }

    /* renamed from: a */
    public static EnumC2265bk m10124a(String str) {
        if (LIVE.m10125a().equals(str)) {
            return LIVE;
        }
        if (SHOP.m10125a().equals(str)) {
            return SHOP;
        }
        if (EVENT.m10125a().equals(str)) {
            return EVENT;
        }
        if (TOPIC.m10125a().equals(str)) {
            return TOPIC;
        }
        return UNKNOWN;
    }
}
