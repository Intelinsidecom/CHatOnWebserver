package com.sec.chaton.mobileweb;

/* compiled from: GeneralWebFragment.java */
/* renamed from: com.sec.chaton.mobileweb.i */
/* loaded from: classes.dex */
/* synthetic */ class C2595i {

    /* renamed from: a */
    static final /* synthetic */ int[] f9255a;

    /* renamed from: b */
    static final /* synthetic */ int[] f9256b = new int[EnumC2598l.values().length];

    static {
        try {
            f9256b[EnumC2598l.HANDSHAKE_V2.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f9256b[EnumC2598l.GOPAGE_V1.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f9256b[EnumC2598l.GOPAGE_V2.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f9256b[EnumC2598l.GOPAGE_V3.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f9255a = new int[EnumC2589c.values().length];
        try {
            f9255a[EnumC2589c.M_ACTION_BUDDY_POPUP.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f9255a[EnumC2589c.M_ACTION_LIVE_CONTENTS.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f9255a[EnumC2589c.M_ACTION_LIVE_CHAT.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}
