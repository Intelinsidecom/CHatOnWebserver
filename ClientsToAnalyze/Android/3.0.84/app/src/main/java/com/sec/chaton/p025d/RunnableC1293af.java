package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.af */
/* loaded from: classes.dex */
class RunnableC1293af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1348z f4916a;

    /* renamed from: b */
    private Handler f4917b;

    public RunnableC1293af(C1348z c1348z, Handler handler) {
        this.f4916a = c1348z;
        this.f4917b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4916a.f5085e.put(0, this.f4917b);
            ((IPushClientService) this.f4916a.f4972b).registration("db9fac80131928e1", CommonApplication.m11493l().getPackageName());
        } catch (RemoteException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, C1348z.f5083c);
            }
            this.f4916a.m5669c();
            if (this.f4917b != null) {
                Message message = new Message();
                message.what = 1001;
                message.obj = false;
                this.f4917b.sendMessage(message);
            }
        }
    }
}
