package com.sec.chaton.util;

import com.samsung.android.sdk.look.Slook;

/* compiled from: HFrameworkUtil.java */
/* renamed from: com.sec.chaton.util.aq */
/* loaded from: classes.dex */
public class C3175aq {

    /* renamed from: a */
    private static volatile Slook f11496a;

    /* renamed from: b */
    private static synchronized Slook m11089b() {
        if (f11496a == null) {
            synchronized (Slook.class) {
                if (f11496a == null) {
                    f11496a = new Slook();
                }
            }
        }
        return f11496a;
    }

    /* renamed from: a */
    public static boolean m11088a() {
        return m11089b().getVersionCode() >= 1;
    }
}
