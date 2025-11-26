package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC3092e;
import com.sec.chaton.util.C4904y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ax */
/* loaded from: classes.dex */
class RunnableC2091ax implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2085ar f7601a;

    /* renamed from: b */
    private Handler f7602b;

    public RunnableC2091ax(C2085ar c2085ar, Handler handler) {
        this.f7601a = c2085ar;
        this.f7602b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((InterfaceC3092e) this.f7601a.f7608b).mo12597a("db9fac80131928e1", new BinderC2092ay(this));
        } catch (RemoteException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, C2085ar.f7591c);
            }
            this.f7601a.m9347c();
            if (this.f7602b != null) {
                Message message = new Message();
                message.what = 1001;
                message.obj = false;
                this.f7602b.sendMessage(message);
            }
        }
    }
}
