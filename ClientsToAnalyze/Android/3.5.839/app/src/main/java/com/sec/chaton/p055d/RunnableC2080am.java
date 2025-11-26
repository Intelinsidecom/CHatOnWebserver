package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.am */
/* loaded from: classes.dex */
class RunnableC2080am implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2078ak f7582a;

    /* renamed from: b */
    private Handler f7583b;

    public RunnableC2080am(C2078ak c2078ak, Handler handler) {
        this.f7582a = c2078ak;
        this.f7583b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2078ak c2078ak;
        try {
            try {
                String regId = ((IPushClientService) this.f7582a.f7608b).getRegId("db9fac80131928e1");
                if (this.f7583b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = regId;
                    this.f7583b.sendMessage(message);
                }
                c2078ak = this.f7582a;
            } catch (RemoteException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, C2078ak.f7576c);
                }
                if (this.f7583b != null) {
                    Message message2 = new Message();
                    message2.what = 1004;
                    message2.obj = null;
                    this.f7583b.sendMessage(message2);
                }
                c2078ak = this.f7582a;
            }
            c2078ak.m9347c();
        } catch (Throwable th) {
            this.f7582a.m9347c();
            throw th;
        }
    }
}
