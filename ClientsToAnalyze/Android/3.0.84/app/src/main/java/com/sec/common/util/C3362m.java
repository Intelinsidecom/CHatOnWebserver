package com.sec.common.util;

/* compiled from: IoUtils.java */
/* renamed from: com.sec.common.util.m */
/* loaded from: classes.dex */
/* synthetic */ class C3362m {

    /* renamed from: a */
    static final /* synthetic */ int[] f12111a = new int[EnumC3363n.values().length];

    static {
        try {
            f12111a[EnumC3363n.INTERNAL_ONLY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f12111a[EnumC3363n.USE_BOTH_EXTERNAL_FIRST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f12111a[EnumC3363n.USE_BOTH_INTERNAL_FIRST.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
