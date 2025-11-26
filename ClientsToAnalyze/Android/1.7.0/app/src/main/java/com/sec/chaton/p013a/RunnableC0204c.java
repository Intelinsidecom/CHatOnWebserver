package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C1341p;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.a.c */
/* loaded from: classes.dex */
class RunnableC0204c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0212k f501a;

    /* renamed from: b */
    private Handler f502b;

    public RunnableC0204c(C0212k c0212k, Handler handler) {
        this.f501a = c0212k;
        this.f502b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f501a.f516e.put(1, this.f502b);
            ((IPushClientService) this.f501a.f477b).deregistration("db9fac80131928e1");
        } catch (RemoteException e) {
            if (C1341p.f4581e) {
                C1341p.m4653a(e, C0212k.f514c);
            }
            this.f501a.m738e();
            if (this.f502b != null) {
                Message message = new Message();
                message.what = 1002;
                message.obj = false;
                this.f502b.sendMessage(message);
            }
        }
    }
}
