package com.sec.chaton.push;

import com.sec.chaton.push.p090a.C3045b;
import com.sec.chaton.push.p091b.p092a.C3059c;
import com.sec.chaton.push.p091b.p092a.C3060d;
import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.p094c.InterfaceC3082c;
import com.sec.chaton.push.p094c.p095a.C3076d;
import com.sec.chaton.push.receiver.SystemStateMoniter;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.C3117i;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class PushClientApplication extends CommonApplication {

    /* renamed from: a */
    private static final String f11289a = PushClientApplication.class.getSimpleName();

    /* renamed from: b */
    private static PushClientApplication f11290b;

    /* renamed from: c */
    private boolean f11291c;

    /* renamed from: d */
    private C3060d f11292d;

    /* renamed from: e */
    private C3059c f11293e;

    /* renamed from: n */
    public static PushClientApplication m12499n() {
        return f11290b;
    }

    /* renamed from: o */
    public boolean m12501o() {
        return this.f11291c;
    }

    /* renamed from: a */
    public void m12500a(boolean z) {
        this.f11291c = z;
    }

    /* renamed from: p */
    public C3060d m12502p() {
        return this.f11292d;
    }

    /* renamed from: q */
    public C3059c m12503q() {
        return this.f11293e;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f11290b = this;
        this.f11291c = false;
        C3115g.m12700a(this);
        if (C3115g.f11458a) {
            C3115g.m12701a(f11289a, "PushClientApplication.onCreate()");
        }
        if (C3115g.f11459b) {
            C3115g.m12704b(f11289a, String.format("PushModule version: %s", "0.9.01.12"));
        }
        if (C3117i.m12712a(this)) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11289a, "Discovered public push client. disable in app push client.");
            }
            C3117i.m12710a(this, false);
            return;
        }
        if (C3115g.f11458a) {
            C3115g.m12701a(f11289a, "Couldn't discover public push client. enable in app push client.");
        }
        C3117i.m12713b(this, false);
        this.f11293e = new C3059c(this);
        this.f11292d = new C3060d(this);
        AlarmTimer.m12669a().m12670a(getApplicationContext());
        SystemStateMoniter.m12668a(C3045b.m12505a());
        SystemStateMoniter.m12667a();
        C3084e.m12562a();
        C3084e.m12562a().m12574a((InterfaceC3082c) new C3076d(this));
    }
}
