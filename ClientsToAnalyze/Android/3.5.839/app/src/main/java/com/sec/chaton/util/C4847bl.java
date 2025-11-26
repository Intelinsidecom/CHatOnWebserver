package com.sec.chaton.util;

import android.os.Handler;

/* compiled from: MultiClickBlocker.java */
/* renamed from: com.sec.chaton.util.bl */
/* loaded from: classes.dex */
public class C4847bl {

    /* renamed from: a */
    private static boolean f17666a = false;

    /* renamed from: b */
    private static Handler f17667b = new HandlerC4848bm();

    /* renamed from: a */
    public static boolean m18333a() {
        if (f17666a) {
            return true;
        }
        f17666a = true;
        f17667b.sendEmptyMessageDelayed(0, 200L);
        return false;
    }

    /* renamed from: a */
    public static boolean m18334a(long j) {
        if (f17666a) {
            return true;
        }
        f17666a = true;
        f17667b.sendEmptyMessageDelayed(0, j);
        return false;
    }
}
