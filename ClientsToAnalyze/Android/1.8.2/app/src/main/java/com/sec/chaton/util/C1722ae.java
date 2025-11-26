package com.sec.chaton.util;

import com.sec.chaton.global.GlobalApplication;

/* compiled from: Dip.java */
/* renamed from: com.sec.chaton.util.ae */
/* loaded from: classes.dex */
public class C1722ae {
    /* renamed from: a */
    public static float m5894a(float f) {
        return GlobalApplication.m3262c().getDisplayMetrics().density * f;
    }

    /* renamed from: b */
    public static float m5895b(float f) {
        return f / GlobalApplication.m3262c().getDisplayMetrics().density;
    }

    /* renamed from: c */
    public static int m5896c(float f) {
        return (int) ((f / GlobalApplication.m3262c().getDisplayMetrics().density) + 0.5f);
    }
}
