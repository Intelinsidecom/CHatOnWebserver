package com.sec.chaton.p037j;

import android.os.SystemClock;
import com.sec.chaton.util.C3250y;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.j.aa */
/* loaded from: classes.dex */
class RunnableC1542aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f5661a;

    /* renamed from: b */
    final /* synthetic */ long f5662b;

    /* renamed from: c */
    final /* synthetic */ C1548ag f5663c;

    /* renamed from: d */
    final /* synthetic */ boolean f5664d;

    /* renamed from: e */
    final /* synthetic */ C1596x f5665e;

    RunnableC1542aa(C1596x c1596x, long j, long j2, C1548ag c1548ag, boolean z) {
        this.f5665e = c1596x;
        this.f5661a = j;
        this.f5662b = j2;
        this.f5663c = c1548ag;
        this.f5664d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C3250y.m11450b("sendIMPL - executeTime : " + String.valueOf(jElapsedRealtime), getClass().getSimpleName());
        if (jElapsedRealtime - this.f5661a <= this.f5662b) {
            this.f5665e.m6749a(this.f5663c, this.f5664d);
        } else {
            C3250y.m11450b("TcpClient.sendIMPL().run() : waiting timeout. try tcp error callback.", "TcpClient");
            this.f5663c.m6570a(31, this.f5663c);
        }
    }
}
