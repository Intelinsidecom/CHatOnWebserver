package com.sec.chaton.util;

import com.samsung.android.sdk.look.Slook;

/* compiled from: HFrameworkUtil.java */
/* renamed from: com.sec.chaton.util.aq */
/* loaded from: classes.dex */
public class C4825aq {

    /* renamed from: a */
    private static volatile Slook f17611a;

    /* renamed from: b */
    private static synchronized Slook m18260b() {
        if (f17611a == null) {
            synchronized (Slook.class) {
                if (f17611a == null) {
                    f17611a = new Slook();
                }
            }
        }
        return f17611a;
    }

    /* renamed from: a */
    public static boolean m18259a() {
        return m18260b().getVersionCode() >= 1;
    }
}
