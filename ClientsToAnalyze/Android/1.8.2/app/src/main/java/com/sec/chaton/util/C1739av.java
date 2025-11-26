package com.sec.chaton.util;

import android.os.Handler;

/* compiled from: MultiClickBlocker.java */
/* renamed from: com.sec.chaton.util.av */
/* loaded from: classes.dex */
public class C1739av {

    /* renamed from: a */
    private static boolean f6351a = false;

    /* renamed from: b */
    private static Handler f6352b = new HandlerC1740aw();

    /* renamed from: a */
    public static boolean m5927a() {
        if (f6351a) {
            return true;
        }
        f6351a = true;
        f6352b.sendEmptyMessageDelayed(0, 200L);
        return false;
    }
}
