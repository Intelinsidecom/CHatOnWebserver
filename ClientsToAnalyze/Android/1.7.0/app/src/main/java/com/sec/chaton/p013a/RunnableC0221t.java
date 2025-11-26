package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC0903g;
import com.sec.chaton.util.C1341p;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.a.t */
/* loaded from: classes.dex */
class RunnableC0221t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0219r f532a;

    /* renamed from: b */
    private Handler f533b;

    public RunnableC0221t(C0219r c0219r, Handler handler) {
        this.f532a = c0219r;
        this.f533b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0219r c0219r;
        try {
            try {
                String strMo3447b = ((InterfaceC0903g) this.f532a.f477b).mo3447b("db9fac80131928e1");
                if (this.f533b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = strMo3447b;
                    this.f533b.sendMessage(message);
                }
                c0219r = this.f532a;
            } catch (RemoteException e) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e, C0219r.f530c);
                }
                if (this.f533b != null) {
                    Message message2 = new Message();
                    message2.what = 1004;
                    message2.obj = null;
                    this.f533b.sendMessage(message2);
                }
                c0219r = this.f532a;
            }
            c0219r.m738e();
        } catch (Throwable th) {
            this.f532a.m738e();
            throw th;
        }
    }
}
