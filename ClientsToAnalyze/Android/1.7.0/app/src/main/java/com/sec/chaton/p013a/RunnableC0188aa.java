package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C1341p;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.a.aa */
/* loaded from: classes.dex */
class RunnableC0188aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0212k f471a;

    /* renamed from: b */
    private Handler f472b;

    public RunnableC0188aa(C0212k c0212k, Handler handler) {
        this.f471a = c0212k;
        this.f472b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0212k c0212k;
        try {
            try {
                boolean zIsPushAvailable = ((IPushClientService) this.f471a.f477b).isPushAvailable();
                if (this.f472b != null) {
                    Message message = new Message();
                    message.what = 1003;
                    message.obj = Boolean.valueOf(zIsPushAvailable);
                    this.f472b.sendMessage(message);
                }
                c0212k = this.f471a;
            } catch (RemoteException e) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e, C0212k.f514c);
                }
                if (this.f472b != null) {
                    Message message2 = new Message();
                    message2.what = 1003;
                    message2.obj = false;
                    this.f472b.sendMessage(message2);
                }
                c0212k = this.f471a;
            }
            c0212k.m738e();
        } catch (Throwable th) {
            this.f471a.m738e();
            throw th;
        }
    }
}
