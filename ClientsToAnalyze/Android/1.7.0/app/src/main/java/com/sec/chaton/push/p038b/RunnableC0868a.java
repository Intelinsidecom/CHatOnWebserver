package com.sec.chaton.push.p038b;

import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p039c.C0893e;
import com.sec.chaton.push.p039c.p040a.C0888g;
import com.sec.chaton.push.util.C0921g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.b.a */
/* loaded from: classes.dex */
class RunnableC0868a implements Runnable {

    /* renamed from: a */
    private boolean f2996a;

    /* renamed from: b */
    private Throwable f2997b;

    public RunnableC0868a(boolean z, Throwable th) {
        this.f2996a = z;
        this.f2997b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C0921g.f3119d) {
            if (!this.f2996a) {
                C0921g.m3637a(C0879l.f3008a, "Push channel is disconnected.");
            } else if (this.f2997b != null) {
                C0921g.m3642d(C0879l.f3008a, String.format("Push channel is disconnected unexpectedly by %s.", this.f2997b));
            } else {
                C0921g.m3642d(C0879l.f3008a, "Push channel is disconnected unexpectedly by server.");
            }
        }
        C0888g.m3498g();
        if (C0921g.f3116a) {
            C0921g.m3637a(C0879l.f3008a, "Cancel all tasks in message task queue.");
        }
        C0893e.m3502a().m3512a(-2);
        C0879l.m3463a().m3466a(-2);
        if (this.f2996a) {
            if (this.f2997b != null) {
                HeartBeat.m3577e();
            }
            if (C0921g.f3116a) {
                C0921g.m3637a(C0879l.f3008a, "Retry initialize.");
            }
            C0879l.m3463a().m3471e();
        }
    }
}
