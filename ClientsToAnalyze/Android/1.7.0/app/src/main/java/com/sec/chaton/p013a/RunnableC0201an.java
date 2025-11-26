package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC0903g;
import com.sec.chaton.util.C1341p;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.a.an */
/* loaded from: classes.dex */
class RunnableC0201an implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0219r f497a;

    /* renamed from: b */
    private Handler f498b;

    public RunnableC0201an(C0219r c0219r, Handler handler) {
        this.f497a = c0219r;
        this.f498b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((InterfaceC0903g) this.f497a.f477b).mo3445a("db9fac80131928e1", new BinderC0190ac(this));
        } catch (RemoteException e) {
            if (C1341p.f4581e) {
                C1341p.m4653a(e, C0219r.f530c);
            }
            this.f497a.m738e();
            if (this.f498b != null) {
                Message message = new Message();
                message.what = 1001;
                message.obj = false;
                this.f498b.sendMessage(message);
            }
        }
    }
}
