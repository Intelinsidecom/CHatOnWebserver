package com.sec.chaton.control;

import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.spp.push.IPushClientService;

/* renamed from: com.sec.chaton.control.e */
/* loaded from: classes.dex */
class RunnableC0176e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PublicPushControl f1412a;

    /* renamed from: b */
    private Handler f1413b;

    public RunnableC0176e(PublicPushControl publicPushControl, Handler handler) {
        this.f1412a = publicPushControl;
        this.f1413b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1412a.f1383e.put(0, this.f1413b);
            ((IPushClientService) this.f1412a.f1352b).mo3699a("db9fac80131928e1", GlobalApplication.m2387e().getPackageName());
        } catch (RemoteException e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
            this.f1412a.m1988e();
        }
    }
}
