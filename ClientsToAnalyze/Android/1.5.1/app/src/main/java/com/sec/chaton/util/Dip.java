package com.sec.chaton.util;

import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class Dip {
    /* renamed from: a */
    public static float m3571a(float f) {
        return GlobalApplication.m2388f().getDisplayMetrics().density * f;
    }

    /* renamed from: b */
    public static float m3572b(float f) {
        return f / GlobalApplication.m2388f().getDisplayMetrics().density;
    }
}
