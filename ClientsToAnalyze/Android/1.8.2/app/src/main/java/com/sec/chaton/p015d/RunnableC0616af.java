package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC1118d;
import com.sec.chaton.util.C1786r;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.af */
/* loaded from: classes.dex */
class RunnableC0616af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0612ab f2431a;

    /* renamed from: b */
    private Handler f2432b;

    public RunnableC0616af(C0612ab c0612ab, Handler handler) {
        this.f2431a = c0612ab;
        this.f2432b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0612ab c0612ab;
        try {
            try {
                boolean zMo4210a = ((InterfaceC1118d) this.f2431a.f2464b).mo4210a();
                if (this.f2432b != null) {
                    Message message = new Message();
                    message.what = 1003;
                    message.obj = Boolean.valueOf(zMo4210a);
                    this.f2432b.sendMessage(message);
                }
                c0612ab = this.f2431a;
            } catch (RemoteException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, C0612ab.f2425c);
                }
                if (this.f2432b != null) {
                    Message message2 = new Message();
                    message2.what = 1003;
                    message2.obj = false;
                    this.f2432b.sendMessage(message2);
                }
                c0612ab = this.f2431a;
            }
            c0612ab.m2843c();
        } catch (Throwable th) {
            this.f2431a.m2843c();
            throw th;
        }
    }
}
