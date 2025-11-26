package com.sds.coolots.common.controller.audiopath;

import android.os.Looper;

/* renamed from: com.sds.coolots.common.controller.audiopath.b */
/* loaded from: classes.dex */
class C1243b extends Thread {

    /* renamed from: a */
    public HandlerC1245d f2968a;

    /* renamed from: b */
    final /* synthetic */ C1242a f2969b;

    /* renamed from: c */
    private Looper f2970c;

    C1243b(C1242a c1242a) {
        this.f2969b = c1242a;
    }

    /* renamed from: a */
    public void m2876a() {
        this.f2970c.quit();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f2970c = Looper.myLooper();
        this.f2968a = new HandlerC1245d(this.f2969b);
        Looper.loop();
    }
}
