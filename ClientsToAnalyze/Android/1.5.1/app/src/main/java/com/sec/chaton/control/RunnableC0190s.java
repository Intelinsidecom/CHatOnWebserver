package com.sec.chaton.control;

import android.os.Handler;
import com.sec.chaton.network.TcpClient;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.s */
/* loaded from: classes.dex */
class RunnableC0190s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Handler f1450a;

    /* renamed from: b */
    final /* synthetic */ MessageControl f1451b;

    RunnableC0190s(MessageControl messageControl, Handler handler) {
        this.f1451b = messageControl;
        this.f1450a = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        TcpClient.m2765e();
        ChatONLogWriter.m3506b("Expired Connection collector", getClass().getSimpleName());
        if (this.f1451b.f1365b) {
            this.f1450a.postDelayed(this, 30000L);
        } else {
            this.f1451b.f1365b = true;
        }
    }
}
