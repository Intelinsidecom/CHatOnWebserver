package com.sec.chaton.push.p050a;

import android.os.SystemClock;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.EnumC2114f;
import com.sec.chaton.push.util.InterfaceC2110b;
import com.sec.common.CommonApplication;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.f */
/* loaded from: classes.dex */
class RunnableC2049f implements Runnable {

    /* renamed from: a */
    private EnumC2114f f7902a;

    /* renamed from: b */
    private EnumC2114f f7903b;

    public RunnableC2049f(EnumC2114f enumC2114f, EnumC2114f enumC2114f2) {
        this.f7902a = enumC2114f;
        this.f7903b = enumC2114f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC2110b c2051h;
        if (C2115g.f8048a) {
            C2115g.m8359a(C2045b.f7887a, "MessageController.onNetworkChanged().");
            C2115g.m8359a(C2045b.f7887a, String.format("OldNetworkInfo: %s, NewNetworkInfo: %s.", this.f7902a, this.f7903b));
        }
        AlarmTimer.m8327a().m8329a(CommonApplication.m11493l(), "connectivityChanged");
        if (C2115g.f8048a) {
            C2115g.m8359a(C2045b.f7887a, "Stop HeartBeat.");
        }
        HeartBeat.m8266d();
        if (C2115g.f8048a) {
            C2115g.m8359a(C2045b.f7887a, "Try to disconnect provisioning connection and push connection.");
        }
        try {
            PushClientApplication.m8156h().m8160k().mo8184b();
        } catch (C2044a e) {
        }
        try {
            PushClientApplication.m8156h().m8159j().mo8184b();
        } catch (C2044a e2) {
        }
        C2045b.m8162a().m8165a(-2);
        C2084e.m8219a().m8230a(-2);
        if (this.f7903b == EnumC2114f.NoActive) {
            if (C2115g.f8050c) {
                C2115g.m8363c(C2045b.f7887a, String.format("No Active Internet. Stop push module after %d seconds.", 5L));
            }
            c2051h = new C2050g(this);
        } else {
            if (C2115g.f8048a) {
                C2115g.m8359a(C2045b.f7887a, String.format("Start push module after %d seconds.", 5L));
            }
            c2051h = new C2051h(this);
        }
        AlarmTimer.m8327a().m8330a(CommonApplication.m11493l(), "connectivityChanged", SystemClock.elapsedRealtime() + 5000, c2051h);
    }
}
