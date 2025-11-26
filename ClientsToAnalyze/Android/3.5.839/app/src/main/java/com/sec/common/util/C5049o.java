package com.sec.common.util;

/* compiled from: IoUtils.java */
/* renamed from: com.sec.common.util.o */
/* loaded from: classes.dex */
/* synthetic */ class C5049o {

    /* renamed from: a */
    static final /* synthetic */ int[] f18387a = new int[EnumC5050p.values().length];

    static {
        try {
            f18387a[EnumC5050p.INTERNAL_ONLY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f18387a[EnumC5050p.USE_BOTH_EXTERNAL_FIRST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f18387a[EnumC5050p.USE_BOTH_INTERNAL_FIRST.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
