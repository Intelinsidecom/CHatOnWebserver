package com.sec.chaton.push.p038b;

import android.os.SystemClock;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p039c.C0893e;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C0921g;
import com.sec.chaton.push.util.EnumC0918d;
import com.sec.chaton.push.util.InterfaceC0922h;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.b.k */
/* loaded from: classes.dex */
class RunnableC0878k implements Runnable {

    /* renamed from: a */
    private EnumC0918d f3006a;

    /* renamed from: b */
    private EnumC0918d f3007b;

    public RunnableC0878k(EnumC0918d enumC0918d, EnumC0918d enumC0918d2) {
        this.f3006a = enumC0918d;
        this.f3007b = enumC0918d2;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC0922h c0877j;
        if (C0921g.f3116a) {
            C0921g.m3637a(C0879l.f3008a, "MessageController.onNetworkChanged().");
            C0921g.m3637a(C0879l.f3008a, String.format("OldNetworkInfo: %s, NewNetworkInfo: %s.", this.f3006a, this.f3007b));
        }
        AlarmTimer.m3603a().m3605a(PushClientApplication.m3436a(), "connectivityChanged");
        if (C0921g.f3116a) {
            C0921g.m3637a(C0879l.f3008a, "Stop HeartBeat.");
        }
        HeartBeat.m3576d();
        if (C0921g.f3116a) {
            C0921g.m3637a(C0879l.f3008a, "Try to disconnect provisioning connection and push connection.");
        }
        try {
            PushClientApplication.m3437b().m3441e().mo3457b();
        } catch (C0872e e) {
        }
        try {
            PushClientApplication.m3437b().m3440d().mo3457b();
        } catch (C0872e e2) {
        }
        C0879l.m3463a().m3466a(-2);
        C0893e.m3502a().m3512a(-2);
        if (this.f3007b == EnumC0918d.NoActive) {
            if (C0921g.f3118c) {
                C0921g.m3641c(C0879l.f3008a, String.format("No Active Internet. Stop push module after %d seconds.", 5L));
            }
            c0877j = new C0876i(this);
        } else {
            if (C0921g.f3116a) {
                C0921g.m3637a(C0879l.f3008a, String.format("Start push module after %d seconds.", 5L));
            }
            c0877j = new C0877j(this);
        }
        AlarmTimer.m3603a().m3606a(PushClientApplication.m3436a(), "connectivityChanged", SystemClock.elapsedRealtime() + 5000, c0877j);
    }
}
