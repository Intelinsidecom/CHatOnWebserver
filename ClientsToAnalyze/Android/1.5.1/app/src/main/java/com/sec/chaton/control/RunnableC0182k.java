package com.sec.chaton.control;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.spp.push.IPushClientService;

/* renamed from: com.sec.chaton.control.k */
/* loaded from: classes.dex */
class RunnableC0182k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PublicPushControl f1421a;

    /* renamed from: b */
    private Handler f1422b;

    public RunnableC0182k(PublicPushControl publicPushControl, Handler handler) {
        this.f1421a = publicPushControl;
        this.f1422b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        PublicPushControl publicPushControl;
        try {
            try {
                boolean zMo3700a = ((IPushClientService) this.f1421a.f1352b).mo3700a();
                if (this.f1422b != null) {
                    Message message = new Message();
                    message.what = 1003;
                    message.obj = Boolean.valueOf(zMo3700a);
                    this.f1422b.sendMessage(message);
                }
                publicPushControl = this.f1421a;
            } catch (RemoteException e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                publicPushControl = this.f1421a;
            }
            publicPushControl.m1988e();
        } catch (Throwable th) {
            this.f1421a.m1988e();
            throw th;
        }
    }
}
