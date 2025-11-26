package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C1786r;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.x */
/* loaded from: classes.dex */
class RunnableC0652x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0649u f2524a;

    /* renamed from: b */
    private Handler f2525b;

    public RunnableC0652x(C0649u c0649u, Handler handler) {
        this.f2524a = c0649u;
        this.f2525b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0649u c0649u;
        try {
            try {
                boolean zIsPushAvailable = ((IPushClientService) this.f2524a.f2464b).isPushAvailable();
                if (this.f2525b != null) {
                    Message message = new Message();
                    message.what = 1003;
                    message.obj = Boolean.valueOf(zIsPushAvailable);
                    this.f2525b.sendMessage(message);
                }
                c0649u = this.f2524a;
            } catch (RemoteException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, C0649u.f2516c);
                }
                if (this.f2525b != null) {
                    Message message2 = new Message();
                    message2.what = 1003;
                    message2.obj = false;
                    this.f2525b.sendMessage(message2);
                }
                c0649u = this.f2524a;
            }
            c0649u.m2843c();
        } catch (Throwable th) {
            this.f2524a.m2843c();
            throw th;
        }
    }
}
