package com.sec.chaton.p015d;

import android.os.RemoteException;
import com.sec.chaton.util.C1786r;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.y */
/* loaded from: classes.dex */
class RunnableC0653y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0649u f2526a;

    /* renamed from: b */
    private String f2527b;

    public RunnableC0653y(C0649u c0649u, String str) {
        this.f2526a = c0649u;
        this.f2527b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0649u c0649u;
        try {
            try {
                ((IPushClientService) this.f2526a.f2464b).ackNotification(this.f2527b);
                c0649u = this.f2526a;
            } catch (RemoteException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, C0649u.f2516c);
                }
                c0649u = this.f2526a;
            }
            c0649u.m2843c();
        } catch (Throwable th) {
            this.f2526a.m2843c();
            throw th;
        }
    }
}
