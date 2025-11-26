package com.sec.chaton.push.p090a;

import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.util.C3115g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.i */
/* loaded from: classes.dex */
class RunnableC3052i implements Runnable {

    /* renamed from: a */
    private final boolean f11316a;

    /* renamed from: b */
    private final Throwable f11317b;

    public RunnableC3052i(boolean z, Throwable th) {
        this.f11316a = z;
        this.f11317b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C3115g.f11461d) {
            if (this.f11316a) {
                String str = C3045b.f11297a;
                Object[] objArr = new Object[1];
                objArr[0] = this.f11317b == null ? "null" : this.f11317b;
                C3115g.m12706d(str, String.format("Prov. channel is disconnected unexpectedly by %s.", objArr));
            } else {
                C3115g.m12701a(C3045b.f11297a, "Prov. channel is disconnected.");
            }
        }
        if (this.f11316a) {
            C3084e.m12562a().m12573a(-2);
        }
    }
}
