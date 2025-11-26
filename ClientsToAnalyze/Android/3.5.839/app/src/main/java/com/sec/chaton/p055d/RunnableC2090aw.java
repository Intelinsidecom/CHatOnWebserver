package com.sec.chaton.p055d;

import android.os.RemoteException;
import com.sec.chaton.push.InterfaceC3092e;
import com.sec.chaton.util.C4904y;

/* compiled from: PushControl.java */
/* renamed from: com.sec.chaton.d.aw */
/* loaded from: classes.dex */
class RunnableC2090aw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2085ar f7599a;

    /* renamed from: b */
    private String f7600b;

    public RunnableC2090aw(C2085ar c2085ar, String str) {
        this.f7599a = c2085ar;
        this.f7600b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2085ar c2085ar;
        try {
            try {
                ((InterfaceC3092e) this.f7599a.f7608b).mo12595a(this.f7600b);
                c2085ar = this.f7599a;
            } catch (RemoteException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, C2085ar.f7591c);
                }
                c2085ar = this.f7599a;
            }
            c2085ar.m9347c();
        } catch (Throwable th) {
            this.f7599a.m9347c();
            throw th;
        }
    }
}
