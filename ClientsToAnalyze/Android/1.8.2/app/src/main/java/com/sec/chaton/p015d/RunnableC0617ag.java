package com.sec.chaton.p015d;

import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC1118d;
import com.sec.chaton.util.C1786r;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.ag */
/* loaded from: classes.dex */
class RunnableC0617ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0612ab f2433a;

    /* renamed from: b */
    private String f2434b;

    public RunnableC0617ag(C0612ab c0612ab, String str) {
        this.f2433a = c0612ab;
        this.f2434b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0612ab c0612ab;
        try {
            try {
                ((InterfaceC1118d) this.f2433a.f2464b).mo4207a(this.f2434b);
                c0612ab = this.f2433a;
            } catch (RemoteException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, C0612ab.f2425c);
                }
                c0612ab = this.f2433a;
            }
            c0612ab.m2843c();
        } catch (Throwable th) {
            this.f2433a.m2843c();
            throw th;
        }
    }
}
