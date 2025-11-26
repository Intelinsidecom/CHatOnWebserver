package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC2092e;
import com.sec.chaton.util.C3250y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.am */
/* loaded from: classes.dex */
class RunnableC1300am implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1294ag f4928a;

    /* renamed from: b */
    private Handler f4929b;

    public RunnableC1300am(C1294ag c1294ag, Handler handler) {
        this.f4928a = c1294ag;
        this.f4929b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((InterfaceC2092e) this.f4928a.f4972b).mo8254a("db9fac80131928e1", new BinderC1301an(this));
        } catch (RemoteException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, C1294ag.f4918c);
            }
            this.f4928a.m5669c();
            if (this.f4929b != null) {
                Message message = new Message();
                message.what = 1001;
                message.obj = false;
                this.f4929b.sendMessage(message);
            }
        }
    }
}
