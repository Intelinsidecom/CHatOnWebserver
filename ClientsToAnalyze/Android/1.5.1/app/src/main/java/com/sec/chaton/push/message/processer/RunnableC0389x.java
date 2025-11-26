package com.sec.chaton.push.message.processer;

import com.sec.chaton.push.provisioning.ProvisioningManager;

/* renamed from: com.sec.chaton.push.message.processer.x */
/* loaded from: classes.dex */
class RunnableC0389x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0376k f2729a;

    RunnableC0389x(C0376k c0376k) {
        this.f2729a = c0376k;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ProvisioningManager.m2999a(this.f2729a.f2701c.f2623b.m2934g()) || this.f2729a.f2701c.f2623b.m2927b()) {
            return;
        }
        this.f2729a.f2701c.f2623b.m2923a(this.f2729a.f2699a, this.f2729a.f2700b);
    }
}
