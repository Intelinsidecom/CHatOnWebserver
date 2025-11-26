package com.sec.chaton.msgsend;

import com.sec.chaton.p067j.EnumC2468s;

/* compiled from: ChatONNormalChatRoomEntity.java */
/* renamed from: com.sec.chaton.msgsend.k */
/* loaded from: classes.dex */
/* synthetic */ class C2703k {

    /* renamed from: a */
    static final /* synthetic */ int[] f9686a;

    /* renamed from: b */
    static final /* synthetic */ int[] f9687b = new int[EnumC2468s.values().length];

    static {
        try {
            f9687b[EnumC2468s.FAILED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9687b[EnumC2468s.RETRY_WITH_CHANGING_SERVER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9687b[EnumC2468s.RETRY_WITH_TIMEOUT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9687b[EnumC2468s.SUCCESS_ESPECIALLY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f9687b[EnumC2468s.SUCCESS_NORMALLY.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        f9686a = new int[EnumC2715w.values().length];
        try {
            f9686a[EnumC2715w.REQUEST_IN_PROGRESS.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f9686a[EnumC2715w.REQUEST_TIMEOUT.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f9686a[EnumC2715w.REQUEST_IDLE.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
    }
}
