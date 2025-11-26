package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC0903g;
import com.sec.chaton.util.C1341p;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.a.f */
/* loaded from: classes.dex */
class RunnableC0207f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0219r f508a;

    /* renamed from: b */
    private Handler f509b;

    public RunnableC0207f(C0219r c0219r, Handler handler) {
        this.f508a = c0219r;
        this.f509b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((InterfaceC0903g) this.f508a.f477b).mo3444a("db9fac80131928e1", new BinderC0220s(this));
        } catch (RemoteException e) {
            if (C1341p.f4581e) {
                C1341p.m4653a(e, C0219r.f530c);
            }
            this.f508a.m738e();
            if (this.f509b != null) {
                Message message = new Message();
                message.what = 1002;
                message.obj = false;
                this.f509b.sendMessage(message);
            }
        }
    }
}
