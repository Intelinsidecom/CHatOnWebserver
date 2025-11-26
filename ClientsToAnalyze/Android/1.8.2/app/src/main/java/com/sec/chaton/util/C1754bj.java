package com.sec.chaton.util;

import com.sec.chaton.p007a.p008a.EnumC0104e;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bj */
/* loaded from: classes.dex */
/* synthetic */ class C1754bj {

    /* renamed from: a */
    static final /* synthetic */ int[] f6392a = new int[EnumC0104e.values().length];

    static {
        try {
            f6392a[EnumC0104e.CHANGE_SERVER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6392a[EnumC0104e.RETRY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6392a[EnumC0104e.BLOCK_RECEIVER.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6392a[EnumC0104e.INVALID_USER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
