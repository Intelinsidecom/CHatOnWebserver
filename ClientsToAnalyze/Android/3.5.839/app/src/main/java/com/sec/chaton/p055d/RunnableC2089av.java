package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC3092e;
import com.sec.chaton.util.C4904y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.av */
/* loaded from: classes.dex */
class RunnableC2089av implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2085ar f7597a;

    /* renamed from: b */
    private Handler f7598b;

    public RunnableC2089av(C2085ar c2085ar, Handler handler) {
        this.f7597a = c2085ar;
        this.f7598b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2085ar c2085ar;
        try {
            try {
                boolean zMo12598a = ((InterfaceC3092e) this.f7597a.f7608b).mo12598a();
                if (this.f7598b != null) {
                    Message message = new Message();
                    message.what = 1003;
                    message.obj = Boolean.valueOf(zMo12598a);
                    this.f7598b.sendMessage(message);
                }
                c2085ar = this.f7597a;
            } catch (RemoteException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, C2085ar.f7591c);
                }
                if (this.f7598b != null) {
                    Message message2 = new Message();
                    message2.what = 1003;
                    message2.obj = false;
                    this.f7598b.sendMessage(message2);
                }
                c2085ar = this.f7597a;
            }
            c2085ar.m9347c();
        } catch (Throwable th) {
            this.f7597a.m9347c();
            throw th;
        }
    }
}
