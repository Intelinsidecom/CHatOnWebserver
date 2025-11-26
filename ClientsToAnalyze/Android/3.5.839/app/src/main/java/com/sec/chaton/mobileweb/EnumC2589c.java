package com.sec.chaton.mobileweb;

/* compiled from: ChatONAction.java */
/* renamed from: com.sec.chaton.mobileweb.c */
/* loaded from: classes.dex */
public enum EnumC2589c {
    M_ACTION_LIVE_CONTENTS("/chat/livecontents", EnumC2590d.FROM_MOBILE_WEB),
    M_ACTION_BUDDY_POPUP("/buddypopup", EnumC2590d.FROM_MOBILE_WEB),
    M_ACTION_LIVE_CHAT("/chat/livechat", EnumC2590d.FROM_MOBILE_WEB),
    M_ACTION_MORE_TAB("/more", EnumC2590d.FROM_MOBILE_WEB),
    M_ACTION_GO_SAMSUNGACCOUNT("/goSamsungAccount", EnumC2590d.FROM_MOBILE_WEB),
    L_ACTION_LIVE_CONTENTS("/livecontents", EnumC2590d.FROM_EXTERNAL_LINK),
    L_ACTION_LIVE_CHAT("/livechat", EnumC2590d.FROM_EXTERNAL_LINK),
    L_ACTION_LIVE_MAIN("/main", EnumC2590d.FROM_EXTERNAL_LINK);


    /* renamed from: i */
    private String f9246i;

    /* renamed from: j */
    private EnumC2590d f9247j;

    /* renamed from: a */
    public static EnumC2589c m10998a(String str, EnumC2590d enumC2590d) {
        for (EnumC2589c enumC2589c : values()) {
            if (enumC2589c.m10999a().equals(str) && enumC2589c.m11000b().equals(enumC2590d)) {
                return enumC2589c;
            }
        }
        return null;
    }

    EnumC2589c(String str, EnumC2590d enumC2590d) {
        this.f9246i = str;
        this.f9247j = enumC2590d;
    }

    /* renamed from: a */
    public String m10999a() {
        return this.f9246i;
    }

    /* renamed from: b */
    public EnumC2590d m11000b() {
        return this.f9247j;
    }

    /* renamed from: c */
    public boolean m11001c() {
        return this.f9247j == EnumC2590d.FROM_EXTERNAL_LINK;
    }
}
