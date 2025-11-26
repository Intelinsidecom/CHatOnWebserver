package com.sec.chaton.p022h;

import android.os.SystemClock;
import com.sec.chaton.util.C1786r;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.h.w */
/* loaded from: classes.dex */
class RunnableC0813w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f2984a;

    /* renamed from: b */
    final /* synthetic */ long f2985b;

    /* renamed from: c */
    final /* synthetic */ C0770ab f2986c;

    /* renamed from: d */
    final /* synthetic */ boolean f2987d;

    /* renamed from: e */
    final /* synthetic */ C0810t f2988e;

    RunnableC0813w(C0810t c0810t, long j, long j2, C0770ab c0770ab, boolean z) {
        this.f2988e = c0810t;
        this.f2984a = j;
        this.f2985b = j2;
        this.f2986c = c0770ab;
        this.f2987d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C1786r.m6061b("sendIMPL - executeTime : " + String.valueOf(jElapsedRealtime), getClass().getSimpleName());
        if (jElapsedRealtime - this.f2984a <= this.f2985b) {
            this.f2988e.m3422a(this.f2986c, this.f2987d);
        } else {
            C1786r.m6061b("TcpClient.sendIMPL().run() : waiting timeout. try tcp error callback.", "TcpClient");
            this.f2986c.m3285a(31, this.f2986c);
        }
    }
}
