package com.sec.chaton.control;

import android.os.RemoteException;
import com.sec.chaton.push.IPushClientService;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.control.y */
/* loaded from: classes.dex */
class RunnableC0210y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushControl f1705a;

    /* renamed from: b */
    private String f1706b;

    public RunnableC0210y(PushControl pushControl, String str) {
        this.f1705a = pushControl;
        this.f1706b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushControl pushControl;
        try {
            try {
                ((IPushClientService) this.f1705a.f1352b).mo2849a(this.f1706b);
                pushControl = this.f1705a;
            } catch (RemoteException e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                pushControl = this.f1705a;
            }
            pushControl.m1988e();
        } catch (Throwable th) {
            this.f1705a.m1988e();
            throw th;
        }
    }
}
