package com.sec.chaton.msgsend;

import com.sec.chaton.p057e.EnumC2301u;

/* compiled from: BaseChatONChatRoomEntity.java */
/* renamed from: com.sec.chaton.msgsend.b */
/* loaded from: classes.dex */
/* synthetic */ class C2694b {

    /* renamed from: a */
    static final /* synthetic */ int[] f9674a;

    /* renamed from: b */
    static final /* synthetic */ int[] f9675b = new int[EnumC2692aj.values().length];

    static {
        try {
            f9675b[EnumC2692aj.SENDED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9675b[EnumC2692aj.UNKNOWN_STATUS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9675b[EnumC2692aj.SENDING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9675b[EnumC2692aj.FAILED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f9675b[EnumC2692aj.PENDING.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        f9674a = new int[EnumC2301u.values().length];
        try {
            f9674a[EnumC2301u.LIVE.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f9674a[EnumC2301u.NORMAL.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
    }
}
