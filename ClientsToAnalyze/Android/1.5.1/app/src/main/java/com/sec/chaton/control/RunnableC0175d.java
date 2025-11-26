package com.sec.chaton.control;

import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.push.IPushClientService;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.d */
/* loaded from: classes.dex */
class RunnableC0175d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushControl f1410a;

    /* renamed from: b */
    private Handler f1411b;

    public RunnableC0175d(PushControl pushControl, Handler handler) {
        this.f1410a = pushControl;
        this.f1411b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((IPushClientService) this.f1410a.f1352b).mo2850a("db9fac80131928e1", new BinderC0178g(this));
        } catch (RemoteException e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
            this.f1410a.m1988e();
        }
    }
}
