package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.al */
/* loaded from: classes.dex */
class RunnableC2079al implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2078ak f7580a;

    /* renamed from: b */
    private Handler f7581b;

    public RunnableC2079al(C2078ak c2078ak, Handler handler) {
        this.f7580a = c2078ak;
        this.f7581b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f7580a.f7578e.put(1, this.f7581b);
            ((IPushClientService) this.f7580a.f7608b).deregistration("db9fac80131928e1");
        } catch (RemoteException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, C2078ak.f7576c);
            }
            this.f7580a.m9347c();
            if (this.f7581b != null) {
                Message message = new Message();
                message.what = 1002;
                message.obj = false;
                this.f7581b.sendMessage(message);
            }
        }
    }
}
