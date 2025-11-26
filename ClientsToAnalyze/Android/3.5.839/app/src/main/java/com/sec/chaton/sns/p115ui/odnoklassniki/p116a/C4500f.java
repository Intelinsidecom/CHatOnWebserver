package com.sec.chaton.sns.p115ui.odnoklassniki.p116a;

import android.os.Handler;
import android.os.Looper;

/* compiled from: OkThreadUtil.java */
/* renamed from: com.sec.chaton.sns.ui.odnoklassniki.a.f */
/* loaded from: classes.dex */
public class C4500f {

    /* renamed from: a */
    private static Handler f16220a;

    /* renamed from: a */
    public static final Handler m17041a() {
        if (f16220a == null) {
            f16220a = new Handler(Looper.getMainLooper());
        }
        return f16220a;
    }

    /* renamed from: b */
    public static final boolean m17044b() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: a */
    public static final void m17042a(Runnable runnable) {
        if (m17044b()) {
            runnable.run();
        } else {
            m17043a(runnable, 0L);
        }
    }

    /* renamed from: a */
    public static final void m17043a(Runnable runnable, long j) {
        m17041a().postDelayed(runnable, j);
    }
}
