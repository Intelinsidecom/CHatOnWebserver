package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC1118d;
import com.sec.chaton.util.C1786r;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ae */
/* loaded from: classes.dex */
class RunnableC0615ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0612ab f2429a;

    /* renamed from: b */
    private Handler f2430b;

    public RunnableC0615ae(C0612ab c0612ab, Handler handler) {
        this.f2429a = c0612ab;
        this.f2430b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0612ab c0612ab;
        try {
            try {
                String strMo4211b = ((InterfaceC1118d) this.f2429a.f2464b).mo4211b("db9fac80131928e1");
                if (this.f2430b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = strMo4211b;
                    this.f2430b.sendMessage(message);
                }
                c0612ab = this.f2429a;
            } catch (RemoteException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, C0612ab.f2425c);
                }
                if (this.f2430b != null) {
                    Message message2 = new Message();
                    message2.what = 1004;
                    message2.obj = null;
                    this.f2430b.sendMessage(message2);
                }
                c0612ab = this.f2429a;
            }
            c0612ab.m2843c();
        } catch (Throwable th) {
            this.f2429a.m2843c();
            throw th;
        }
    }
}
