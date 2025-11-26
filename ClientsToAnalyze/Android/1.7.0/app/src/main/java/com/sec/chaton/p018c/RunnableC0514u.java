package com.sec.chaton.p018c;

import android.os.SystemClock;
import com.sec.chaton.util.C1341p;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.c.u */
/* loaded from: classes.dex */
class RunnableC0514u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f1673a;

    /* renamed from: b */
    final /* synthetic */ long f1674b;

    /* renamed from: c */
    final /* synthetic */ C0510q f1675c;

    /* renamed from: d */
    final /* synthetic */ boolean f1676d;

    /* renamed from: e */
    final /* synthetic */ C0477ab f1677e;

    RunnableC0514u(C0477ab c0477ab, long j, long j2, C0510q c0510q, boolean z) {
        this.f1677e = c0477ab;
        this.f1673a = j;
        this.f1674b = j2;
        this.f1675c = c0510q;
        this.f1676d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C1341p.m4658b("sendIMPL - executeTime : " + String.valueOf(jElapsedRealtime), getClass().getSimpleName());
        if (jElapsedRealtime - this.f1673a <= this.f1674b) {
            this.f1677e.m2443a(this.f1675c, this.f1676d);
        } else {
            C1341p.m4658b("TcpClient.sendIMPL().run() : waiting timeout. try tcp error callback.", "TcpClient");
            this.f1675c.m2569a(31, this.f1675c);
        }
    }
}
