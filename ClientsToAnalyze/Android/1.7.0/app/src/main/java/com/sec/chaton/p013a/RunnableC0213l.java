package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1341p;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.a.l */
/* loaded from: classes.dex */
class RunnableC0213l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0212k f518a;

    /* renamed from: b */
    private Handler f519b;

    public RunnableC0213l(C0212k c0212k, Handler handler) {
        this.f518a = c0212k;
        this.f519b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f518a.f516e.put(0, this.f519b);
            ((IPushClientService) this.f518a.f477b).registration("db9fac80131928e1", GlobalApplication.m3100a().getPackageName());
        } catch (RemoteException e) {
            if (C1341p.f4581e) {
                C1341p.m4653a(e, C0212k.f514c);
            }
            this.f518a.m738e();
            if (this.f519b != null) {
                Message message = new Message();
                message.what = 1001;
                message.obj = false;
                this.f519b.sendMessage(message);
            }
        }
    }
}
