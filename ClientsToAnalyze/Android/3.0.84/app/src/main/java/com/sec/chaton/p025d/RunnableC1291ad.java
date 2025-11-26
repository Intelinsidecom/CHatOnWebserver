package com.sec.chaton.p025d;

import android.os.RemoteException;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.ad */
/* loaded from: classes.dex */
class RunnableC1291ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1348z f4913a;

    /* renamed from: b */
    private String f4914b;

    public RunnableC1291ad(C1348z c1348z, String str) {
        this.f4913a = c1348z;
        this.f4914b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1348z c1348z;
        try {
            try {
                ((IPushClientService) this.f4913a.f4972b).ackNotification(this.f4914b);
                c1348z = this.f4913a;
            } catch (RemoteException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, C1348z.f5083c);
                }
                c1348z = this.f4913a;
            }
            c1348z.m5669c();
        } catch (Throwable th) {
            this.f4913a.m5669c();
            throw th;
        }
    }
}
