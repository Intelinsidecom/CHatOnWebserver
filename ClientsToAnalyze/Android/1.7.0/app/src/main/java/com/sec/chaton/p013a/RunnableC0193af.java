package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C1341p;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.a.af */
/* loaded from: classes.dex */
class RunnableC0193af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0212k f484a;

    /* renamed from: b */
    private Handler f485b;

    public RunnableC0193af(C0212k c0212k, Handler handler) {
        this.f484a = c0212k;
        this.f485b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0212k c0212k;
        try {
            try {
                String regId = ((IPushClientService) this.f484a.f477b).getRegId("db9fac80131928e1");
                if (this.f485b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = regId;
                    this.f485b.sendMessage(message);
                }
                c0212k = this.f484a;
            } catch (RemoteException e) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e, C0212k.f514c);
                }
                if (this.f485b != null) {
                    Message message2 = new Message();
                    message2.what = 1004;
                    message2.obj = null;
                    this.f485b.sendMessage(message2);
                }
                c0212k = this.f484a;
            }
            c0212k.m738e();
        } catch (Throwable th) {
            this.f484a.m738e();
            throw th;
        }
    }
}
