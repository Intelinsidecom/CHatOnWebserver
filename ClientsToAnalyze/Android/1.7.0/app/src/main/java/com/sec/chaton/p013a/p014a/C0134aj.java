package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: NetTaskHandler.java */
/* renamed from: com.sec.chaton.a.a.aj */
/* loaded from: classes.dex */
public class C0134aj {

    /* renamed from: a */
    private static C0134aj f317a = null;

    /* renamed from: b */
    private HandlerThread f318b = new HandlerThread("AsyncNetTask");

    /* renamed from: c */
    private HandlerC0173l f319c;

    /* renamed from: d */
    private Looper f320d;

    private C0134aj() {
        this.f318b.start();
        this.f320d = this.f318b.getLooper();
        this.f319c = new HandlerC0173l(this, this.f320d);
    }

    /* renamed from: a */
    public static C0134aj m678a() {
        if (f317a == null) {
            f317a = new C0134aj();
        }
        return f317a;
    }

    /* renamed from: b */
    public Handler m679b() {
        return this.f319c;
    }
}
