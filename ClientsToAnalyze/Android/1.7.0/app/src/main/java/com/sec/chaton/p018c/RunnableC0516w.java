package com.sec.chaton.p018c;

import android.os.SystemClock;
import com.sec.chaton.util.C1341p;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.c.w */
/* loaded from: classes.dex */
class RunnableC0516w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f1679a;

    /* renamed from: b */
    final /* synthetic */ long f1680b;

    /* renamed from: c */
    final /* synthetic */ C0477ab f1681c;

    RunnableC0516w(C0477ab c0477ab, long j, long j2) {
        this.f1681c = c0477ab;
        this.f1679a = j;
        this.f1680b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (SystemClock.elapsedRealtime() - this.f1679a <= this.f1680b) {
            this.f1681c.m2454g();
        } else {
            C1341p.m4658b("TcpClient.reconnectIMPL().run() - waiting timeout", "TcpClient");
        }
    }
}
