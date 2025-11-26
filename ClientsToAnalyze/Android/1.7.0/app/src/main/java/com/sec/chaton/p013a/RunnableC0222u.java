package com.sec.chaton.p013a;

import android.os.RemoteException;
import com.sec.chaton.util.C1341p;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.a.u */
/* loaded from: classes.dex */
class RunnableC0222u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0212k f534a;

    /* renamed from: b */
    private String f535b;

    public RunnableC0222u(C0212k c0212k, String str) {
        this.f534a = c0212k;
        this.f535b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0212k c0212k;
        try {
            try {
                ((IPushClientService) this.f534a.f477b).ackNotification(this.f535b);
                c0212k = this.f534a;
            } catch (RemoteException e) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e, C0212k.f514c);
                }
                c0212k = this.f534a;
            }
            c0212k.m738e();
        } catch (Throwable th) {
            this.f534a.m738e();
            throw th;
        }
    }
}
