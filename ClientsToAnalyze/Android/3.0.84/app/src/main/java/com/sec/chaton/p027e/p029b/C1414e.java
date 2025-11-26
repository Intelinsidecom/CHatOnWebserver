package com.sec.chaton.p027e.p029b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: AsyncCursorCloseTask.java */
/* renamed from: com.sec.chaton.e.b.e */
/* loaded from: classes.dex */
public class C1414e {

    /* renamed from: a */
    private static C1414e f5250a = null;

    /* renamed from: b */
    private HandlerThread f5251b = new HandlerThread("AsyncCursorCloseTask");

    /* renamed from: c */
    private HandlerC1415f f5252c;

    /* renamed from: d */
    private Looper f5253d;

    private C1414e() {
        this.f5251b.start();
        this.f5253d = this.f5251b.getLooper();
        this.f5252c = new HandlerC1415f(this, this.f5253d);
    }

    /* renamed from: a */
    public static C1414e m6265a() {
        if (f5250a == null) {
            f5250a = new C1414e();
        }
        return f5250a;
    }

    /* renamed from: b */
    public Handler m6266b() {
        return this.f5252c;
    }

    /* renamed from: c */
    public Message m6267c() {
        return this.f5252c.obtainMessage();
    }
}
