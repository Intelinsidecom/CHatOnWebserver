package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: NetTaskHandler.java */
/* renamed from: com.sec.chaton.d.a.de */
/* loaded from: classes.dex */
public class C1231de {

    /* renamed from: a */
    private static C1231de f4770a = null;

    /* renamed from: b */
    private HandlerThread f4771b = new HandlerThread("AsyncNetTask");

    /* renamed from: c */
    private HandlerC1232df f4772c;

    /* renamed from: d */
    private Looper f4773d;

    private C1231de() {
        this.f4771b.start();
        this.f4773d = this.f4771b.getLooper();
        this.f4772c = new HandlerC1232df(this, this.f4773d);
    }

    /* renamed from: a */
    public static C1231de m5555a() {
        if (f4770a == null) {
            f4770a = new C1231de();
        }
        return f4770a;
    }

    /* renamed from: b */
    public Handler m5556b() {
        return this.f4772c;
    }
}
