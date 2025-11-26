package com.sec.chaton.p067j;

import com.sec.chaton.util.C4904y;
import java.util.TimerTask;

/* compiled from: GarbageConnectionCollector.java */
/* renamed from: com.sec.chaton.j.j */
/* loaded from: classes.dex */
class C2459j extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C2458i f8830a;

    C2459j(C2458i c2458i) {
        this.f8830a = c2458i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        C2417af.m10460e();
        if (C4904y.f17872b) {
            C4904y.m18639b("Expired Connection collector", "GarbageConnectionCollector");
        }
        synchronized (this.f8830a.f8825b) {
            if (!this.f8830a.f8827d) {
                this.f8830a.f8829f.cancel();
                this.f8830a.f8829f.purge();
                this.f8830a.f8829f = null;
                this.f8830a.f8828e = false;
                if (C4904y.f17872b) {
                    C4904y.m18639b("TimerTask was canceled.", "GarbageConnectionCollector");
                }
            }
        }
    }
}
