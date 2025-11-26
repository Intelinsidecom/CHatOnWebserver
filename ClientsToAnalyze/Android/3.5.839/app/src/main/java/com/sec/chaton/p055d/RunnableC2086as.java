package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC3092e;
import com.sec.chaton.util.C4904y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.as */
/* loaded from: classes.dex */
class RunnableC2086as implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2085ar f7592a;

    /* renamed from: b */
    private Handler f7593b;

    public RunnableC2086as(C2085ar c2085ar, Handler handler) {
        this.f7592a = c2085ar;
        this.f7593b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((InterfaceC3092e) this.f7592a.f7608b).mo12596a("db9fac80131928e1", new BinderC2087at(this));
        } catch (RemoteException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, C2085ar.f7591c);
            }
            this.f7592a.m9347c();
            if (this.f7593b != null) {
                Message message = new Message();
                message.what = 1002;
                message.obj = false;
                this.f7593b.sendMessage(message);
            }
        }
    }
}
