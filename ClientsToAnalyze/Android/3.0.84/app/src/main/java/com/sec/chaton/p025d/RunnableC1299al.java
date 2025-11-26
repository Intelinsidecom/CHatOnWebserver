package com.sec.chaton.p025d;

import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC2092e;
import com.sec.chaton.util.C3250y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.al */
/* loaded from: classes.dex */
class RunnableC1299al implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1294ag f4926a;

    /* renamed from: b */
    private String f4927b;

    public RunnableC1299al(C1294ag c1294ag, String str) {
        this.f4926a = c1294ag;
        this.f4927b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1294ag c1294ag;
        try {
            try {
                ((InterfaceC2092e) this.f4926a.f4972b).mo8252a(this.f4927b);
                c1294ag = this.f4926a;
            } catch (RemoteException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, C1294ag.f4918c);
                }
                c1294ag = this.f4926a;
            }
            c1294ag.m5669c();
        } catch (Throwable th) {
            this.f4926a.m5669c();
            throw th;
        }
    }
}
