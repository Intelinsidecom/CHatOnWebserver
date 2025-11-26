package com.sec.chaton.util;

import android.os.Handler;

/* compiled from: MultiClickBlocker.java */
/* renamed from: com.sec.chaton.util.bl */
/* loaded from: classes.dex */
public class C3197bl {

    /* renamed from: a */
    private static boolean f11551a = false;

    /* renamed from: b */
    private static Handler f11552b = new HandlerC3198bm();

    /* renamed from: a */
    public static boolean m11159a() {
        if (f11551a) {
            return true;
        }
        f11551a = true;
        f11552b.sendEmptyMessageDelayed(0, 200L);
        return false;
    }
}
