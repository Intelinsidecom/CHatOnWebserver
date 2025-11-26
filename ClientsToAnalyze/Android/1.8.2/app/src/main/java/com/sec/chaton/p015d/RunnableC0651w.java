package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C1786r;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.w */
/* loaded from: classes.dex */
class RunnableC0651w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0649u f2522a;

    /* renamed from: b */
    private Handler f2523b;

    public RunnableC0651w(C0649u c0649u, Handler handler) {
        this.f2522a = c0649u;
        this.f2523b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0649u c0649u;
        try {
            try {
                String regId = ((IPushClientService) this.f2522a.f2464b).getRegId("db9fac80131928e1");
                if (this.f2523b != null) {
                    Message message = new Message();
                    message.what = 1004;
                    message.obj = regId;
                    this.f2523b.sendMessage(message);
                }
                c0649u = this.f2522a;
            } catch (RemoteException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, C0649u.f2516c);
                }
                if (this.f2523b != null) {
                    Message message2 = new Message();
                    message2.what = 1004;
                    message2.obj = null;
                    this.f2523b.sendMessage(message2);
                }
                c0649u = this.f2522a;
            }
            c0649u.m2843c();
        } catch (Throwable th) {
            this.f2522a.m2843c();
            throw th;
        }
    }
}
