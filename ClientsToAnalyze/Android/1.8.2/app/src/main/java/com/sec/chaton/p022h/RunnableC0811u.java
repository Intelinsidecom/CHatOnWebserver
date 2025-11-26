package com.sec.chaton.p022h;

import android.os.SystemClock;
import com.sec.chaton.util.C1786r;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.h.u */
/* loaded from: classes.dex */
class RunnableC0811u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f2980a;

    /* renamed from: b */
    final /* synthetic */ long f2981b;

    /* renamed from: c */
    final /* synthetic */ C0810t f2982c;

    RunnableC0811u(C0810t c0810t, long j, long j2) {
        this.f2982c = c0810t;
        this.f2980a = j;
        this.f2981b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (SystemClock.elapsedRealtime() - this.f2980a <= this.f2981b) {
            this.f2982c.m3434g();
        } else {
            C1786r.m6061b("TcpClient.reconnectIMPL().run() - waiting timeout", "TcpClient");
        }
    }
}
