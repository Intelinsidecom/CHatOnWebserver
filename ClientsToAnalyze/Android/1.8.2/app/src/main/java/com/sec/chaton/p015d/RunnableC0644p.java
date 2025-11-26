package com.sec.chaton.p015d;

import android.os.Handler;
import com.sec.chaton.p022h.C0810t;
import com.sec.chaton.util.C1786r;

/* compiled from: MessageControl.java */
/* renamed from: com.sec.chaton.d.p */
/* loaded from: classes.dex */
class RunnableC0644p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Handler f2508a;

    /* renamed from: b */
    final /* synthetic */ C0639k f2509b;

    RunnableC0644p(C0639k c0639k, Handler handler) {
        this.f2509b = c0639k;
        this.f2508a = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0810t.m3432e();
        C1786r.m6061b("Expired Connection collector", getClass().getSimpleName());
        if (this.f2509b.f2484b) {
            this.f2508a.postDelayed(this, 5000L);
        } else {
            this.f2509b.f2484b = true;
        }
    }
}
