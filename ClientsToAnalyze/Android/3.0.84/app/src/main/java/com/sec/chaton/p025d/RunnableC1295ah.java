package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC2092e;
import com.sec.chaton.util.C3250y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ah */
/* loaded from: classes.dex */
class RunnableC1295ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1294ag f4919a;

    /* renamed from: b */
    private Handler f4920b;

    public RunnableC1295ah(C1294ag c1294ag, Handler handler) {
        this.f4919a = c1294ag;
        this.f4920b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((InterfaceC2092e) this.f4919a.f4972b).mo8253a("db9fac80131928e1", new BinderC1296ai(this));
        } catch (RemoteException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, C1294ag.f4918c);
            }
            this.f4919a.m5669c();
            if (this.f4920b != null) {
                Message message = new Message();
                message.what = 1002;
                message.obj = false;
                this.f4920b.sendMessage(message);
            }
        }
    }
}
