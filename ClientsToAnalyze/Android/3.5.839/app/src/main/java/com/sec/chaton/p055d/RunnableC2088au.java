package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC3092e;
import com.sec.chaton.util.C4904y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.au */
/* loaded from: classes.dex */
class RunnableC2088au implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2085ar f7595a;

    /* renamed from: b */
    private Handler f7596b;

    public RunnableC2088au(C2085ar c2085ar, Handler handler) {
        this.f7595a = c2085ar;
        this.f7596b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2085ar c2085ar;
        try {
            try {
                String strMo12599b = ((InterfaceC3092e) this.f7595a.f7608b).mo12599b("db9fac80131928e1");
                if (this.f7596b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = strMo12599b;
                    this.f7596b.sendMessage(message);
                }
                c2085ar = this.f7595a;
            } catch (RemoteException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, C2085ar.f7591c);
                }
                if (this.f7596b != null) {
                    Message message2 = new Message();
                    message2.what = 1004;
                    message2.obj = null;
                    this.f7596b.sendMessage(message2);
                }
                c2085ar = this.f7595a;
            }
            c2085ar.m9347c();
        } catch (Throwable th) {
            this.f7595a.m9347c();
            throw th;
        }
    }
}
