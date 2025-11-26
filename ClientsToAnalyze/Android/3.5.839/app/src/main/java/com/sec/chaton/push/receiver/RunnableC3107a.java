package com.sec.chaton.push.receiver;

import android.content.Context;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.p095a.C3074b;
import com.sec.chaton.push.util.C3115g;

/* compiled from: AutoRestartReceiver.java */
/* renamed from: com.sec.chaton.push.receiver.a */
/* loaded from: classes.dex */
class RunnableC3107a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f11440a;

    /* renamed from: b */
    final /* synthetic */ AutoRestartReceiver f11441b;

    RunnableC3107a(AutoRestartReceiver autoRestartReceiver, Context context) {
        this.f11441b = autoRestartReceiver;
        this.f11440a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!C3074b.m12543d()) {
            if (C3115g.f11459b) {
                C3115g.m12704b(AutoRestartReceiver.f11435a, "PushModule is started but isn't initialized yet. Execute initialize.");
            }
            try {
                C3088i.m12584a().m12591a(new C3074b(this.f11440a));
            } catch (InterruptedException e) {
                if (C3115g.f11461d) {
                    C3115g.m12702a(AutoRestartReceiver.f11435a, e.getMessage(), e);
                }
            }
        }
    }
}
