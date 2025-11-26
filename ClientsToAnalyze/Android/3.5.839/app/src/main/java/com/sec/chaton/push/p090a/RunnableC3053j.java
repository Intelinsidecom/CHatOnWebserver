package com.sec.chaton.push.p090a;

import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.p094c.p095a.C3074b;
import com.sec.chaton.push.util.C3115g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.j */
/* loaded from: classes.dex */
class RunnableC3053j implements Runnable {

    /* renamed from: a */
    private boolean f11318a;

    /* renamed from: b */
    private Throwable f11319b;

    public RunnableC3053j(boolean z, Throwable th) {
        this.f11318a = z;
        this.f11319b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C3115g.f11461d) {
            if (!this.f11318a) {
                C3115g.m12701a(C3045b.f11297a, "Push channel is disconnected.");
            } else if (this.f11319b != null) {
                C3115g.m12706d(C3045b.f11297a, String.format("Push channel is disconnected unexpectedly by %s.", this.f11319b));
            } else {
                C3115g.m12706d(C3045b.f11297a, "Push channel is disconnected unexpectedly by server.");
            }
        }
        C3074b.m12545f();
        if (C3115g.f11458a) {
            C3115g.m12701a(C3045b.f11297a, "Cancel all tasks in message task queue.");
        }
        C3084e.m12562a().m12573a(-2);
        C3045b.m12505a().m12508a(-2);
        if (this.f11318a) {
            if (this.f11319b != null) {
                HeartBeat.m12610e();
            }
            if (C3115g.f11458a) {
                C3115g.m12701a(C3045b.f11297a, "Retry initialize.");
            }
            C3045b.m12505a().m12513e();
        }
    }
}
