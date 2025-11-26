package com.sec.chaton.network;

import android.os.SystemClock;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.network.h */
/* loaded from: classes.dex */
class RunnableC0346h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f2545a;

    /* renamed from: b */
    final /* synthetic */ long f2546b;

    /* renamed from: c */
    final /* synthetic */ TcpClient f2547c;

    RunnableC0346h(TcpClient tcpClient, long j, long j2) {
        this.f2547c = tcpClient;
        this.f2545a = j;
        this.f2546b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (SystemClock.elapsedRealtime() - this.f2545a > this.f2546b) {
            ChatONLogWriter.m3506b("TcpClient.reconnectIMPL().run() - waiting timeout", "TcpClient");
        } else {
            this.f2547c.m2767g();
        }
    }
}
