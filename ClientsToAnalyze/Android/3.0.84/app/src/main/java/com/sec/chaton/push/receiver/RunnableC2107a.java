package com.sec.chaton.push.receiver;

import android.content.Context;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.p055a.C2074b;
import com.sec.chaton.push.util.C2115g;

/* compiled from: AutoRestartReceiver.java */
/* renamed from: com.sec.chaton.push.receiver.a */
/* loaded from: classes.dex */
class RunnableC2107a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f8030a;

    /* renamed from: b */
    final /* synthetic */ AutoRestartReceiver f8031b;

    RunnableC2107a(AutoRestartReceiver autoRestartReceiver, Context context) {
        this.f8031b = autoRestartReceiver;
        this.f8030a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!C2074b.m8200d()) {
            if (C2115g.f8049b) {
                C2115g.m8362b(AutoRestartReceiver.f8025a, "PushModule is started but isn't initialized yet. Execute initialize.");
            }
            try {
                C2088i.m8241a().m8248a(new C2074b(this.f8030a));
            } catch (InterruptedException e) {
                if (C2115g.f8051d) {
                    C2115g.m8360a(AutoRestartReceiver.f8025a, e.getMessage(), e);
                }
            }
        }
    }
}
