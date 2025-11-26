package com.sec.chaton.p037j;

import com.sec.chaton.util.C3250y;
import java.util.TimerTask;

/* compiled from: GarbageConnectionCollector.java */
/* renamed from: com.sec.chaton.j.f */
/* loaded from: classes.dex */
class C1578f extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C1577e f5862a;

    C1578f(C1577e c1577e) {
        this.f5862a = c1577e;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        C1596x.m6762e();
        if (C3250y.f11734b) {
            C3250y.m11450b("Expired Connection collector", "GarbageConnectionCollector");
        }
        synchronized (this.f5862a.f5857b) {
            if (!this.f5862a.f5859d) {
                this.f5862a.f5861f.cancel();
                this.f5862a.f5861f.purge();
                this.f5862a.f5861f = null;
                this.f5862a.f5860e = false;
                if (C3250y.f11734b) {
                    C3250y.m11450b("TimerTask was canceled.", "GarbageConnectionCollector");
                }
            }
        }
    }
}
