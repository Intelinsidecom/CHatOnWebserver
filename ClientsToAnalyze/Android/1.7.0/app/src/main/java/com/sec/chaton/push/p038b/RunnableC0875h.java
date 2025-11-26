package com.sec.chaton.push.p038b;

import com.sec.chaton.push.p039c.C0893e;
import com.sec.chaton.push.util.C0921g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.b.h */
/* loaded from: classes.dex */
class RunnableC0875h implements Runnable {

    /* renamed from: a */
    private boolean f3002a;

    /* renamed from: b */
    private Throwable f3003b;

    public RunnableC0875h(boolean z, Throwable th) {
        this.f3002a = z;
        this.f3003b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C0921g.f3119d) {
            if (this.f3002a) {
                C0921g.m3642d(C0879l.f3008a, String.format("Prov. channel is disconnected unexpectedly by %s.", this.f3003b));
            } else {
                C0921g.m3637a(C0879l.f3008a, "Prov. channel is disconnected.");
            }
        }
        if (this.f3002a) {
            C0893e.m3502a().m3512a(-2);
        }
    }
}
