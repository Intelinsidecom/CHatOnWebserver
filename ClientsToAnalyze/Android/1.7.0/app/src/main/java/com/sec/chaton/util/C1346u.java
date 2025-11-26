package com.sec.chaton.util;

import android.os.Handler;

/* compiled from: MultiClickBlocker.java */
/* renamed from: com.sec.chaton.util.u */
/* loaded from: classes.dex */
public class C1346u {

    /* renamed from: a */
    private static boolean f4586a = false;

    /* renamed from: b */
    private static Handler f4587b = new HandlerC1338m();

    /* renamed from: a */
    public static boolean m4676a() {
        if (f4586a) {
            return true;
        }
        f4586a = true;
        f4587b.sendEmptyMessageDelayed(0, 200L);
        return false;
    }

    /* renamed from: a */
    public static boolean m4677a(long j) {
        if (f4586a) {
            return true;
        }
        f4586a = true;
        f4587b.sendEmptyMessageDelayed(0, j);
        return false;
    }
}
