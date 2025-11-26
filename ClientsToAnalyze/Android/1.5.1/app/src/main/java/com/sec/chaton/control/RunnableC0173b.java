package com.sec.chaton.control;

import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.spp.push.IPushClientService;

/* renamed from: com.sec.chaton.control.b */
/* loaded from: classes.dex */
class RunnableC0173b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PublicPushControl f1407a;

    /* renamed from: b */
    private Handler f1408b;

    public RunnableC0173b(PublicPushControl publicPushControl, Handler handler) {
        this.f1407a = publicPushControl;
        this.f1408b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1407a.f1383e.put(1, this.f1408b);
            ((IPushClientService) this.f1407a.f1352b).mo3698a("db9fac80131928e1");
        } catch (RemoteException e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
            this.f1407a.m1988e();
        }
    }
}
