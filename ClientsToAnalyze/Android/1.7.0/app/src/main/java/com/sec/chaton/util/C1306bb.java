package com.sec.chaton.util;

import com.sec.chaton.p015b.p016a.EnumC0255c;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bb */
/* loaded from: classes.dex */
/* synthetic */ class C1306bb {

    /* renamed from: a */
    static final /* synthetic */ int[] f4516a = new int[EnumC0255c.values().length];

    static {
        try {
            f4516a[EnumC0255c.CHANGE_SERVER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4516a[EnumC0255c.RETRY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4516a[EnumC0255c.BLOCK_RECEIVER.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4516a[EnumC0255c.INVALID_USER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
