package com.sec.chaton.p022h;

import android.os.Handler;
import com.sec.chaton.util.C1786r;

/* compiled from: GarbageConnectionCollector.java */
/* renamed from: com.sec.chaton.h.f */
/* loaded from: classes.dex */
class RunnableC0796f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Handler f2928a;

    /* renamed from: b */
    final /* synthetic */ C0795e f2929b;

    RunnableC0796f(C0795e c0795e, Handler handler) {
        this.f2929b = c0795e;
        this.f2928a = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0810t.m3432e();
        C1786r.m6061b("Expired Connection collector", getClass().getSimpleName());
        synchronized (this.f2929b.f2924b) {
            if (!this.f2929b.f2926d) {
                this.f2929b.f2927e = false;
            } else {
                this.f2928a.postDelayed(this, 5000L);
            }
        }
    }
}
