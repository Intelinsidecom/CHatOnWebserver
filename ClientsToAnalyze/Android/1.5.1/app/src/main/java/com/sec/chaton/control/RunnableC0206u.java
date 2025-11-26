package com.sec.chaton.control;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.spp.push.IPushClientService;

/* renamed from: com.sec.chaton.control.u */
/* loaded from: classes.dex */
class RunnableC0206u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PublicPushControl f1699a;

    /* renamed from: b */
    private Handler f1700b;

    public RunnableC0206u(PublicPushControl publicPushControl, Handler handler) {
        this.f1699a = publicPushControl;
        this.f1700b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        PublicPushControl publicPushControl;
        try {
            try {
                String strMo3701b = ((IPushClientService) this.f1699a.f1352b).mo3701b("db9fac80131928e1");
                if (this.f1700b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = strMo3701b;
                    this.f1700b.sendMessage(message);
                }
                publicPushControl = this.f1699a;
            } catch (RemoteException e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                publicPushControl = this.f1699a;
            }
            publicPushControl.m1988e();
        } catch (Throwable th) {
            this.f1699a.m1988e();
            throw th;
        }
    }
}
