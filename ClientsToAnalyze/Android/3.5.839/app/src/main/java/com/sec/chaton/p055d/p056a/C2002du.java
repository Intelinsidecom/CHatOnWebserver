package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: NetTaskHandler.java */
/* renamed from: com.sec.chaton.d.a.du */
/* loaded from: classes.dex */
public class C2002du {

    /* renamed from: a */
    private static C2002du f7360a = null;

    /* renamed from: b */
    private HandlerThread f7361b = new HandlerThread("AsyncNetTask");

    /* renamed from: c */
    private HandlerC2003dv f7362c;

    /* renamed from: d */
    private Looper f7363d;

    private C2002du() {
        this.f7361b.start();
        this.f7363d = this.f7361b.getLooper();
        this.f7362c = new HandlerC2003dv(this, this.f7363d);
    }

    /* renamed from: a */
    public static C2002du m9149a() {
        if (f7360a == null) {
            f7360a = new C2002du();
        }
        return f7360a;
    }

    /* renamed from: b */
    public Handler m9150b() {
        return this.f7362c;
    }
}
