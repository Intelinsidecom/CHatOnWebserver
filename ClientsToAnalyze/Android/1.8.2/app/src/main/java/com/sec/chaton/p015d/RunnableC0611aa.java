package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.aa */
/* loaded from: classes.dex */
class RunnableC0611aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0649u f2423a;

    /* renamed from: b */
    private Handler f2424b;

    public RunnableC0611aa(C0649u c0649u, Handler handler) {
        this.f2423a = c0649u;
        this.f2424b = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2423a.f2518e.put(0, this.f2424b);
            ((IPushClientService) this.f2423a.f2464b).registration("db9fac80131928e1", GlobalApplication.m3260b().getPackageName());
        } catch (RemoteException e) {
            if (C1786r.f6455e) {
                C1786r.m6056a(e, C0649u.f2516c);
            }
            this.f2423a.m2843c();
            if (this.f2424b != null) {
                Message message = new Message();
                message.what = 1001;
                message.obj = false;
                this.f2424b.sendMessage(message);
            }
        }
    }
}
