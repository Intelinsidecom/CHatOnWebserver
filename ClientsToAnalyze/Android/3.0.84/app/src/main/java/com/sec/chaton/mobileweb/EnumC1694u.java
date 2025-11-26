package com.sec.chaton.mobileweb;

import com.sec.chaton.util.EnumC3219cg;

/* compiled from: MobileWebServerType.java */
/* renamed from: com.sec.chaton.mobileweb.u */
/* loaded from: classes.dex */
public enum EnumC1694u {
    LIVE_SERVER(EnumC3219cg.LIVE_MOBILEWEB);


    /* renamed from: b */
    EnumC3219cg f6226b;

    EnumC1694u(EnumC3219cg enumC3219cg) {
        this.f6226b = enumC3219cg;
    }

    /* renamed from: a */
    String m6991a() {
        switch (this) {
            case LIVE_SERVER:
                return C1692s.m6985a();
            default:
                return null;
        }
    }
}
