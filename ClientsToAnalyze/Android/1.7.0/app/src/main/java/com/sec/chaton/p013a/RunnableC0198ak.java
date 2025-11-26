package com.sec.chaton.p013a;

import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC0903g;
import com.sec.chaton.util.C1341p;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.a.ak */
/* loaded from: classes.dex */
class RunnableC0198ak implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0219r f489a;

    /* renamed from: b */
    private String f490b;

    public RunnableC0198ak(C0219r c0219r, String str) {
        this.f489a = c0219r;
        this.f490b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0219r c0219r;
        try {
            try {
                ((InterfaceC0903g) this.f489a.f477b).mo3443a(this.f490b);
                c0219r = this.f489a;
            } catch (RemoteException e) {
                if (C1341p.f4581e) {
                    C1341p.m4653a(e, C0219r.f530c);
                }
                c0219r = this.f489a;
            }
            c0219r.m738e();
        } catch (Throwable th) {
            this.f489a.m738e();
            throw th;
        }
    }
}
