package com.sec.chaton.push.p090a;

import android.os.SystemClock;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.EnumC3114f;
import com.sec.chaton.push.util.InterfaceC3110b;
import com.sec.common.CommonApplication;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.f */
/* loaded from: classes.dex */
class RunnableC3049f implements Runnable {

    /* renamed from: a */
    private EnumC3114f f11312a;

    /* renamed from: b */
    private EnumC3114f f11313b;

    public RunnableC3049f(EnumC3114f enumC3114f, EnumC3114f enumC3114f2) {
        this.f11312a = enumC3114f;
        this.f11313b = enumC3114f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC3110b c3051h;
        if (C3115g.f11458a) {
            C3115g.m12701a(C3045b.f11297a, "MessageController.onNetworkChanged().");
            C3115g.m12701a(C3045b.f11297a, String.format("OldNetworkInfo: %s, NewNetworkInfo: %s.", this.f11312a, this.f11313b));
        }
        AlarmTimer.m12669a().m12671a(CommonApplication.m18732r(), "connectivityChanged");
        if (C3115g.f11458a) {
            C3115g.m12701a(C3045b.f11297a, "Stop HeartBeat.");
        }
        HeartBeat.m12609d();
        if (C3115g.f11458a) {
            C3115g.m12701a(C3045b.f11297a, "Try to disconnect provisioning connection and push connection.");
        }
        try {
            PushClientApplication.m12499n().m12503q().mo12527b();
        } catch (C3044a e) {
        }
        try {
            PushClientApplication.m12499n().m12502p().mo12527b();
        } catch (C3044a e2) {
        }
        C3045b.m12505a().m12508a(-2);
        C3084e.m12562a().m12573a(-2);
        if (this.f11313b == EnumC3114f.NoActive) {
            if (C3115g.f11460c) {
                C3115g.m12705c(C3045b.f11297a, String.format("No Active Internet. Stop push module after %d seconds.", 5L));
            }
            c3051h = new C3050g(this);
        } else {
            if (C3115g.f11458a) {
                C3115g.m12701a(C3045b.f11297a, String.format("Start push module after %d seconds.", 5L));
            }
            c3051h = new C3051h(this);
        }
        AlarmTimer.m12669a().m12672a(CommonApplication.m18732r(), "connectivityChanged", SystemClock.elapsedRealtime() + 5000, c3051h);
    }
}
