package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC1118d;
import com.sec.chaton.util.C1786r;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ac */
/* loaded from: classes.dex */
class RunnableC0613ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0612ab f2426a;

    /* renamed from: b */
    private Handler f2427b;

    public RunnableC0613ac(C0612ab c0612ab, Handler handler) {
        this.f2426a = c0612ab;
        this.f2427b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((InterfaceC1118d) this.f2426a.f2464b).mo4208a("db9fac80131928e1", new BinderC0614ad(this));
        } catch (RemoteException e) {
            if (C1786r.f6455e) {
                C1786r.m6056a(e, C0612ab.f2425c);
            }
            this.f2426a.m2843c();
            if (this.f2427b != null) {
                Message message = new Message();
                message.what = 1002;
                message.obj = false;
                this.f2427b.sendMessage(message);
            }
        }
    }
}
