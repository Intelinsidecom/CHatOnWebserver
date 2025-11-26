package com.sec.chaton.push.p040a;

import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p044c.C1111e;
import com.sec.chaton.push.p044c.p045a.C1101b;
import com.sec.chaton.push.util.C1139g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.j */
/* loaded from: classes.dex */
class RunnableC1080j implements Runnable {

    /* renamed from: a */
    private boolean f4005a;

    /* renamed from: b */
    private Throwable f4006b;

    public RunnableC1080j(boolean z, Throwable th) {
        this.f4005a = z;
        this.f4006b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C1139g.f4145d) {
            if (!this.f4005a) {
                C1139g.m4308a(C1072b.f3984a, "Push channel is disconnected.");
            } else if (this.f4006b != null) {
                C1139g.m4313d(C1072b.f3984a, String.format("Push channel is disconnected unexpectedly by %s.", this.f4006b));
            } else {
                C1139g.m4313d(C1072b.f3984a, "Push channel is disconnected unexpectedly by server.");
            }
        }
        C1101b.m4157f();
        if (C1139g.f4142a) {
            C1139g.m4308a(C1072b.f3984a, "Cancel all tasks in message task queue.");
        }
        C1111e.m4174a().m4184a(-2);
        C1072b.m4118a().m4121a(-2);
        if (this.f4005a) {
            if (this.f4006b != null) {
                HeartBeat.m4221c();
            }
            if (C1139g.f4142a) {
                C1139g.m4308a(C1072b.f3984a, "Retry initialize.");
            }
            C1072b.m4118a().m4126e();
        }
    }
}
