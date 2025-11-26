package com.sec.chaton.p018c;

import android.os.Handler;
import com.sec.chaton.util.C1341p;

/* compiled from: GarbageConnectionCollector.java */
/* renamed from: com.sec.chaton.c.m */
/* loaded from: classes.dex */
class RunnableC0506m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Handler f1641a;

    /* renamed from: b */
    final /* synthetic */ C0476aa f1642b;

    RunnableC0506m(C0476aa c0476aa, Handler handler) {
        this.f1642b = c0476aa;
        this.f1641a = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0477ab.m2452e();
        C1341p.m4658b("Expired Connection collector", getClass().getSimpleName());
        synchronized (this.f1642b.f1531b) {
            if (!this.f1642b.f1533d) {
                this.f1642b.f1534e = false;
            } else {
                this.f1641a.postDelayed(this, 5000L);
            }
        }
    }
}
