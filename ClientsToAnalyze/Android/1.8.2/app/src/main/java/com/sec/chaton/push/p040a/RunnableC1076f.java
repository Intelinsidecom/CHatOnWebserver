package com.sec.chaton.push.p040a;

import android.os.SystemClock;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p044c.C1111e;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.EnumC1138f;
import com.sec.chaton.push.util.InterfaceC1134b;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.f */
/* loaded from: classes.dex */
class RunnableC1076f implements Runnable {

    /* renamed from: a */
    private EnumC1138f f3999a;

    /* renamed from: b */
    private EnumC1138f f4000b;

    public RunnableC1076f(EnumC1138f enumC1138f, EnumC1138f enumC1138f2) {
        this.f3999a = enumC1138f;
        this.f4000b = enumC1138f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC1134b c1078h;
        if (C1139g.f4142a) {
            C1139g.m4308a(C1072b.f3984a, "MessageController.onNetworkChanged().");
            C1139g.m4308a(C1072b.f3984a, String.format("OldNetworkInfo: %s, NewNetworkInfo: %s.", this.f3999a, this.f4000b));
        }
        AlarmTimer.m4276a().m4278a(PushClientApplication.m4111g(), "connectivityChanged");
        if (C1139g.f4142a) {
            C1139g.m4308a(C1072b.f3984a, "Stop HeartBeat.");
        }
        HeartBeat.m4220b();
        if (C1139g.f4142a) {
            C1139g.m4308a(C1072b.f3984a, "Try to disconnect provisioning connection and push connection.");
        }
        try {
            PushClientApplication.m4112h().m4116k().mo4140b();
        } catch (C1071a e) {
        }
        try {
            PushClientApplication.m4112h().m4115j().mo4140b();
        } catch (C1071a e2) {
        }
        C1072b.m4118a().m4121a(-2);
        C1111e.m4174a().m4184a(-2);
        if (this.f4000b == EnumC1138f.NoActive) {
            if (C1139g.f4144c) {
                C1139g.m4312c(C1072b.f3984a, String.format("No Active Internet. Stop push module after %d seconds.", 5L));
            }
            c1078h = new C1077g(this);
        } else {
            if (C1139g.f4142a) {
                C1139g.m4308a(C1072b.f3984a, String.format("Start push module after %d seconds.", 5L));
            }
            c1078h = new C1078h(this);
        }
        AlarmTimer.m4276a().m4279a(PushClientApplication.m4111g(), "connectivityChanged", SystemClock.elapsedRealtime() + 5000, c1078h);
    }
}
