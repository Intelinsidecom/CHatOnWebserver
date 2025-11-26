package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC1118d;
import com.sec.chaton.util.C1786r;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ah */
/* loaded from: classes.dex */
class RunnableC0618ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0612ab f2435a;

    /* renamed from: b */
    private Handler f2436b;

    public RunnableC0618ah(C0612ab c0612ab, Handler handler) {
        this.f2435a = c0612ab;
        this.f2436b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((InterfaceC1118d) this.f2435a.f2464b).mo4209a("db9fac80131928e1", new BinderC0619ai(this));
        } catch (RemoteException e) {
            if (C1786r.f6455e) {
                C1786r.m6056a(e, C0612ab.f2425c);
            }
            this.f2435a.m2843c();
            if (this.f2436b != null) {
                Message message = new Message();
                message.what = 1001;
                message.obj = false;
                this.f2436b.sendMessage(message);
            }
        }
    }
}
