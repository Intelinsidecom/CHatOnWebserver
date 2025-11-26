package com.sec.chaton.util;

import android.util.TypedValue;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: Dip.java */
/* renamed from: com.sec.chaton.util.an */
/* loaded from: classes.dex */
public class C3172an {
    /* renamed from: a */
    public static float m11085a(float f) {
        return GlobalApplication.m6451b().getDisplayMetrics().density * f;
    }

    /* renamed from: b */
    public static float m11086b(float f) {
        return TypedValue.applyDimension(1, f, GlobalApplication.m6451b().getDisplayMetrics());
    }

    /* renamed from: c */
    public static int m11087c(float f) {
        return (int) ((f / GlobalApplication.m6451b().getDisplayMetrics().density) + 0.5f);
    }
}
