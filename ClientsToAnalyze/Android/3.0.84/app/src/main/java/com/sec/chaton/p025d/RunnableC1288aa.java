package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.aa */
/* loaded from: classes.dex */
class RunnableC1288aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1348z f4907a;

    /* renamed from: b */
    private Handler f4908b;

    public RunnableC1288aa(C1348z c1348z, Handler handler) {
        this.f4907a = c1348z;
        this.f4908b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4907a.f5085e.put(1, this.f4908b);
            ((IPushClientService) this.f4907a.f4972b).deregistration("db9fac80131928e1");
        } catch (RemoteException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, C1348z.f5083c);
            }
            this.f4907a.m5669c();
            if (this.f4908b != null) {
                Message message = new Message();
                message.what = 1002;
                message.obj = false;
                this.f4908b.sendMessage(message);
            }
        }
    }
}
