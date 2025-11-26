package com.sec.chaton.control;

import android.os.RemoteException;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.spp.push.IPushClientService;

/* renamed from: com.sec.chaton.control.i */
/* loaded from: classes.dex */
class RunnableC0180i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PublicPushControl f1418a;

    /* renamed from: b */
    private String f1419b;

    public RunnableC0180i(PublicPushControl publicPushControl, String str) {
        this.f1418a = publicPushControl;
        this.f1419b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        PublicPushControl publicPushControl;
        try {
            try {
                ((IPushClientService) this.f1418a.f1352b).mo3703c(this.f1419b);
                publicPushControl = this.f1418a;
            } catch (RemoteException e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                publicPushControl = this.f1418a;
            }
            publicPushControl.m1988e();
        } catch (Throwable th) {
            this.f1418a.m1988e();
            throw th;
        }
    }
}
