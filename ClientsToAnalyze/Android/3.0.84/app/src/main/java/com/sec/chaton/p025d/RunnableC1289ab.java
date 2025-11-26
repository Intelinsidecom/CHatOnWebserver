package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.ab */
/* loaded from: classes.dex */
class RunnableC1289ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1348z f4909a;

    /* renamed from: b */
    private Handler f4910b;

    public RunnableC1289ab(C1348z c1348z, Handler handler) {
        this.f4909a = c1348z;
        this.f4910b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1348z c1348z;
        try {
            try {
                String regId = ((IPushClientService) this.f4909a.f4972b).getRegId("db9fac80131928e1");
                if (this.f4910b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = regId;
                    this.f4910b.sendMessage(message);
                }
                c1348z = this.f4909a;
            } catch (RemoteException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, C1348z.f5083c);
                }
                if (this.f4910b != null) {
                    Message message2 = new Message();
                    message2.what = 1004;
                    message2.obj = null;
                    this.f4910b.sendMessage(message2);
                }
                c1348z = this.f4909a;
            }
            c1348z.m5669c();
        } catch (Throwable th) {
            this.f4909a.m5669c();
            throw th;
        }
    }
}
