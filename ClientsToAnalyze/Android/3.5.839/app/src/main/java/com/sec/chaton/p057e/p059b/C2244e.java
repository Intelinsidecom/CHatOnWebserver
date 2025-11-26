package com.sec.chaton.p057e.p059b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: AsyncCursorCloseTask.java */
/* renamed from: com.sec.chaton.e.b.e */
/* loaded from: classes.dex */
public class C2244e {

    /* renamed from: a */
    private static C2244e f7990a = null;

    /* renamed from: b */
    private HandlerThread f7991b = new HandlerThread("AsyncCursorCloseTask");

    /* renamed from: c */
    private HandlerC2245f f7992c;

    /* renamed from: d */
    private Looper f7993d;

    private C2244e() {
        this.f7991b.start();
        this.f7993d = this.f7991b.getLooper();
        this.f7992c = new HandlerC2245f(this, this.f7993d);
    }

    /* renamed from: a */
    public static C2244e m10103a() {
        if (f7990a == null) {
            f7990a = new C2244e();
        }
        return f7990a;
    }

    /* renamed from: b */
    public Handler m10104b() {
        return this.f7992c;
    }

    /* renamed from: c */
    public Message m10105c() {
        return this.f7992c.obtainMessage();
    }
}
