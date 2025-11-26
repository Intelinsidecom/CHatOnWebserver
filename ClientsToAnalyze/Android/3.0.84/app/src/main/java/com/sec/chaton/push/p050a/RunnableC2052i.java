package com.sec.chaton.push.p050a;

import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.util.C2115g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.i */
/* loaded from: classes.dex */
class RunnableC2052i implements Runnable {

    /* renamed from: a */
    private final boolean f7906a;

    /* renamed from: b */
    private final Throwable f7907b;

    public RunnableC2052i(boolean z, Throwable th) {
        this.f7906a = z;
        this.f7907b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C2115g.f8051d) {
            if (this.f7906a) {
                String str = C2045b.f7887a;
                Object[] objArr = new Object[1];
                objArr[0] = this.f7907b == null ? "null" : this.f7907b;
                C2115g.m8364d(str, String.format("Prov. channel is disconnected unexpectedly by %s.", objArr));
            } else {
                C2115g.m8359a(C2045b.f7887a, "Prov. channel is disconnected.");
            }
        }
        if (this.f7906a) {
            C2084e.m8219a().m8230a(-2);
        }
    }
}
