package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC2092e;
import com.sec.chaton.util.C3250y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.aj */
/* loaded from: classes.dex */
class RunnableC1297aj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1294ag f4922a;

    /* renamed from: b */
    private Handler f4923b;

    public RunnableC1297aj(C1294ag c1294ag, Handler handler) {
        this.f4922a = c1294ag;
        this.f4923b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1294ag c1294ag;
        try {
            try {
                String strMo8256b = ((InterfaceC2092e) this.f4922a.f4972b).mo8256b("db9fac80131928e1");
                if (this.f4923b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = strMo8256b;
                    this.f4923b.sendMessage(message);
                }
                c1294ag = this.f4922a;
            } catch (RemoteException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, C1294ag.f4918c);
                }
                if (this.f4923b != null) {
                    Message message2 = new Message();
                    message2.what = 1004;
                    message2.obj = null;
                    this.f4923b.sendMessage(message2);
                }
                c1294ag = this.f4922a;
            }
            c1294ag.m5669c();
        } catch (Throwable th) {
            this.f4922a.m5669c();
            throw th;
        }
    }
}
