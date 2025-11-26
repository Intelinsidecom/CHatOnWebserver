package com.sec.chaton.smsplugin.transaction;

import com.sec.google.android.p134a.p135a.C5097t;
import java.io.IOException;

/* compiled from: BackgroundSenderService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.d */
/* loaded from: classes.dex */
class C4068d extends Thread {

    /* renamed from: a */
    final /* synthetic */ C4066b f14667a;

    C4068d(C4066b c4066b) {
        this.f14667a = c4066b;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f14667a.f14656d = C5097t.m19426a(this.f14667a.f14659g);
        if (this.f14667a.f14656d != null) {
            this.f14667a.m15664d();
            if (this.f14667a.f14657e != null) {
                try {
                    this.f14667a.m15662c();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
