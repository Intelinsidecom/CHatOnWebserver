package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC0903g;
import com.sec.chaton.util.C1341p;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.a.a */
/* loaded from: classes.dex */
class RunnableC0123a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0219r f289a;

    /* renamed from: b */
    private Handler f290b;

    public RunnableC0123a(C0219r c0219r, Handler handler) {
        this.f289a = c0219r;
        this.f290b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0219r c0219r;
        try {
            try {
                boolean zMo3446a = ((InterfaceC0903g) this.f289a.f477b).mo3446a();
                if (this.f290b != null) {
                    Message message = new Message();
                    message.what = 1003;
                    message.obj = Boolean.valueOf(zMo3446a);
                    this.f290b.sendMessage(message);
                }
                c0219r = this.f289a;
            } catch (RemoteException e) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e, C0219r.f530c);
                }
                if (this.f290b != null) {
                    Message message2 = new Message();
                    message2.what = 1003;
                    message2.obj = false;
                    this.f290b.sendMessage(message2);
                }
                c0219r = this.f289a;
            }
            c0219r.m738e();
        } catch (Throwable th) {
            this.f289a.m738e();
            throw th;
        }
    }
}
