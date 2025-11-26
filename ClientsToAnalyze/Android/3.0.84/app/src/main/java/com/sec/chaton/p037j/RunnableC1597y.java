package com.sec.chaton.p037j;

import android.os.SystemClock;
import com.sec.chaton.util.C3250y;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.j.y */
/* loaded from: classes.dex */
class RunnableC1597y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f5932a;

    /* renamed from: b */
    final /* synthetic */ long f5933b;

    /* renamed from: c */
    final /* synthetic */ C1596x f5934c;

    RunnableC1597y(C1596x c1596x, long j, long j2) {
        this.f5934c = c1596x;
        this.f5932a = j;
        this.f5933b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (SystemClock.elapsedRealtime() - this.f5932a <= this.f5933b) {
            this.f5934c.m6763g();
        } else {
            C3250y.m11450b("TcpClient.reconnectIMPL().run() - waiting timeout", "TcpClient");
        }
    }
}
