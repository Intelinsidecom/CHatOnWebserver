package com.sec.chaton.mobileweb;

import com.sec.chaton.util.EnumC4868cf;

/* compiled from: MobileWebServerType.java */
/* renamed from: com.sec.chaton.mobileweb.r */
/* loaded from: classes.dex */
public enum EnumC2604r {
    LIVE_SERVER(EnumC4868cf.LIVE_MOBILEWEB),
    SHOP_SERVER(EnumC4868cf.SHOP),
    GAME_SERVER(EnumC4868cf.GAME);


    /* renamed from: d */
    EnumC4868cf f9306d;

    EnumC2604r(EnumC4868cf enumC4868cf) {
        this.f9306d = enumC4868cf;
    }

    /* renamed from: a */
    String m11024a() {
        switch (C2605s.f9307a[ordinal()]) {
            case 1:
                return C2602p.m11010a();
            case 2:
                return C2602p.m11015b();
            case 3:
                return C2602p.m11020c();
            default:
                return "";
        }
    }
}
