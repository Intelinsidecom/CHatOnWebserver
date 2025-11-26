package com.sec.chaton.push.p040a;

import com.sec.chaton.push.p044c.C1111e;
import com.sec.chaton.push.util.C1139g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.i */
/* loaded from: classes.dex */
class RunnableC1079i implements Runnable {

    /* renamed from: a */
    private boolean f4003a;

    /* renamed from: b */
    private Throwable f4004b;

    public RunnableC1079i(boolean z, Throwable th) {
        this.f4003a = z;
        this.f4004b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C1139g.f4145d) {
            if (this.f4003a) {
                C1139g.m4313d(C1072b.f3984a, String.format("Prov. channel is disconnected unexpectedly by %s.", this.f4004b));
            } else {
                C1139g.m4308a(C1072b.f3984a, "Prov. channel is disconnected.");
            }
        }
        if (this.f4003a) {
            C1111e.m4174a().m4184a(-2);
        }
    }
}
