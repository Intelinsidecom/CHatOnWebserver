package com.sec.chaton.network;

import android.os.SystemClock;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.network.f */
/* loaded from: classes.dex */
class RunnableC0344f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f2539a;

    /* renamed from: b */
    final /* synthetic */ long f2540b;

    /* renamed from: c */
    final /* synthetic */ TcpEnvelope f2541c;

    /* renamed from: d */
    final /* synthetic */ boolean f2542d;

    /* renamed from: e */
    final /* synthetic */ TcpClient f2543e;

    RunnableC0344f(TcpClient tcpClient, long j, long j2, TcpEnvelope tcpEnvelope, boolean z) {
        this.f2543e = tcpClient;
        this.f2539a = j;
        this.f2540b = j2;
        this.f2541c = tcpEnvelope;
        this.f2542d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (SystemClock.elapsedRealtime() - this.f2539a <= this.f2540b) {
            this.f2543e.m2756a(this.f2541c, this.f2542d);
        } else {
            ChatONLogWriter.m3506b("TcpClient.sendIMPL().run() : waiting timeout. try tcp error callback.", "TcpClient");
            this.f2541c.m2802a(this.f2541c);
        }
    }
}
