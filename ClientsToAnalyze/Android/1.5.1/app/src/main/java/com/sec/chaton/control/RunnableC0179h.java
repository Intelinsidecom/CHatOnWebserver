package com.sec.chaton.control;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.IPushClientService;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.h */
/* loaded from: classes.dex */
class RunnableC0179h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushControl f1416a;

    /* renamed from: b */
    private Handler f1417b;

    public RunnableC0179h(PushControl pushControl, Handler handler) {
        this.f1416a = pushControl;
        this.f1417b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushControl pushControl;
        try {
            try {
                String strMo2853b = ((IPushClientService) this.f1416a.f1352b).mo2853b("db9fac80131928e1");
                if (this.f1417b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = strMo2853b;
                    this.f1417b.sendMessage(message);
                }
                pushControl = this.f1416a;
            } catch (RemoteException e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                pushControl = this.f1416a;
            }
            pushControl.m1988e();
        } catch (Throwable th) {
            this.f1416a.m1988e();
            throw th;
        }
    }
}
