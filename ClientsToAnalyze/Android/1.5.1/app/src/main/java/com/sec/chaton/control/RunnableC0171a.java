package com.sec.chaton.control;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.IPushClientService;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.a */
/* loaded from: classes.dex */
class RunnableC0171a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushControl f1403a;

    /* renamed from: b */
    private Handler f1404b;

    public RunnableC0171a(PushControl pushControl, Handler handler) {
        this.f1403a = pushControl;
        this.f1404b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushControl pushControl;
        try {
            try {
                boolean zMo2852a = ((IPushClientService) this.f1403a.f1352b).mo2852a();
                if (this.f1404b != null) {
                    Message message = new Message();
                    message.what = 1003;
                    message.obj = Boolean.valueOf(zMo2852a);
                    this.f1404b.sendMessage(message);
                }
                pushControl = this.f1403a;
            } catch (RemoteException e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                pushControl = this.f1403a;
            }
            pushControl.m1988e();
        } catch (Throwable th) {
            this.f1403a.m1988e();
            throw th;
        }
    }
}
