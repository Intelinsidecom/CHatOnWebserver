package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: NetTaskHandler.java */
/* renamed from: com.sec.chaton.d.a.bj */
/* loaded from: classes.dex */
public class C0569bj {

    /* renamed from: a */
    private static C0569bj f2282a = null;

    /* renamed from: b */
    private HandlerThread f2283b = new HandlerThread("AsyncNetTask");

    /* renamed from: c */
    private HandlerC0570bk f2284c;

    /* renamed from: d */
    private Looper f2285d;

    private C0569bj() {
        this.f2283b.start();
        this.f2285d = this.f2283b.getLooper();
        this.f2284c = new HandlerC0570bk(this, this.f2285d);
    }

    /* renamed from: a */
    public static C0569bj m2760a() {
        if (f2282a == null) {
            f2282a = new C0569bj();
        }
        return f2282a;
    }

    /* renamed from: b */
    public Handler m2761b() {
        return this.f2284c;
    }
}
