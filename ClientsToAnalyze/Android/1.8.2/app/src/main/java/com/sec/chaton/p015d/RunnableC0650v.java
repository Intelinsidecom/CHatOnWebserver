package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.util.C1786r;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.v */
/* loaded from: classes.dex */
class RunnableC0650v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0649u f2520a;

    /* renamed from: b */
    private Handler f2521b;

    public RunnableC0650v(C0649u c0649u, Handler handler) {
        this.f2520a = c0649u;
        this.f2521b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2520a.f2518e.put(1, this.f2521b);
            ((IPushClientService) this.f2520a.f2464b).deregistration("db9fac80131928e1");
        } catch (RemoteException e) {
            if (C1786r.f6455e) {
                C1786r.m6056a(e, C0649u.f2516c);
            }
            this.f2520a.m2843c();
            if (this.f2521b != null) {
                Message message = new Message();
                message.what = 1002;
                message.obj = false;
                this.f2521b.sendMessage(message);
            }
        }
    }
}
