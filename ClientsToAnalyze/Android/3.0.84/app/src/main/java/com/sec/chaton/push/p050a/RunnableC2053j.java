package com.sec.chaton.push.p050a;

import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.p054c.p055a.C2074b;
import com.sec.chaton.push.util.C2115g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.j */
/* loaded from: classes.dex */
class RunnableC2053j implements Runnable {

    /* renamed from: a */
    private boolean f7908a;

    /* renamed from: b */
    private Throwable f7909b;

    public RunnableC2053j(boolean z, Throwable th) {
        this.f7908a = z;
        this.f7909b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C2115g.f8051d) {
            if (!this.f7908a) {
                C2115g.m8359a(C2045b.f7887a, "Push channel is disconnected.");
            } else if (this.f7909b != null) {
                C2115g.m8364d(C2045b.f7887a, String.format("Push channel is disconnected unexpectedly by %s.", this.f7909b));
            } else {
                C2115g.m8364d(C2045b.f7887a, "Push channel is disconnected unexpectedly by server.");
            }
        }
        C2074b.m8202f();
        if (C2115g.f8048a) {
            C2115g.m8359a(C2045b.f7887a, "Cancel all tasks in message task queue.");
        }
        C2084e.m8219a().m8230a(-2);
        C2045b.m8162a().m8165a(-2);
        if (this.f7908a) {
            if (this.f7909b != null) {
                HeartBeat.m8267e();
            }
            if (C2115g.f8048a) {
                C2115g.m8359a(C2045b.f7887a, "Retry initialize.");
            }
            C2045b.m8162a().m8170e();
        }
    }
}
