package com.sec.chaton.p055d;

import android.os.RemoteException;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.IPushClientService;

/* compiled from: PublicPushControl.java */
/* renamed from: com.sec.chaton.d.ao */
/* loaded from: classes.dex */
class RunnableC2082ao implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2078ak f7586a;

    /* renamed from: b */
    private String f7587b;

    public RunnableC2082ao(C2078ak c2078ak, String str) {
        this.f7586a = c2078ak;
        this.f7587b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2078ak c2078ak;
        try {
            try {
                ((IPushClientService) this.f7586a.f7608b).ackNotification(this.f7587b);
                c2078ak = this.f7586a;
            } catch (RemoteException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, C2078ak.f7576c);
                }
                c2078ak = this.f7586a;
            }
            c2078ak.m9347c();
        } catch (Throwable th) {
            this.f7586a.m9347c();
            throw th;
        }
    }
}
