package com.sec.chaton.control;

import android.os.Handler;
import android.os.RemoteException;
import com.sec.chaton.push.IPushClientService;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.aa */
/* loaded from: classes.dex */
class RunnableC0172aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushControl f1405a;

    /* renamed from: b */
    private Handler f1406b;

    public RunnableC0172aa(PushControl pushControl, Handler handler) {
        this.f1405a = pushControl;
        this.f1406b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ((IPushClientService) this.f1405a.f1352b).mo2851a("db9fac80131928e1", new BinderC0191t(this));
        } catch (RemoteException e) {
            ChatONLogWriter.m3501a(e, getClass().getSimpleName());
            this.f1405a.m1988e();
        }
    }
}
