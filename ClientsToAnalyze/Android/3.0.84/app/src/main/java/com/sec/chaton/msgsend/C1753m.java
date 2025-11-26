package com.sec.chaton.msgsend;

import com.sec.chaton.p037j.EnumC1591s;

/* compiled from: MessageProcessor.java */
/* renamed from: com.sec.chaton.msgsend.m */
/* loaded from: classes.dex */
/* synthetic */ class C1753m {

    /* renamed from: a */
    static final /* synthetic */ int[] f6461a;

    /* renamed from: b */
    static final /* synthetic */ int[] f6462b = new int[EnumC1591s.values().length];

    static {
        try {
            f6462b[EnumC1591s.FAILED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6462b[EnumC1591s.RETRY_WITH_CHANGING_SERVER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6462b[EnumC1591s.RETRY_WITH_TIMEOUT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6462b[EnumC1591s.SUCCESS_ESPECIALLY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f6462b[EnumC1591s.SUCCESS_NORMALLY.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        f6461a = new int[EnumC1762v.values().length];
        try {
            f6461a[EnumC1762v.IS_NOT_VALID_ROOM.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
    }
}
