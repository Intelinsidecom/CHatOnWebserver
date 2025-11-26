package com.sec.chaton.push;

import com.sec.chaton.push.p050a.C2045b;
import com.sec.chaton.push.p051b.p052a.C2059c;
import com.sec.chaton.push.p051b.p052a.C2060d;
import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.p054c.InterfaceC2082c;
import com.sec.chaton.push.p054c.p055a.C2076d;
import com.sec.chaton.push.receiver.SystemStateMoniter;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.C2117i;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class PushClientApplication extends CommonApplication {

    /* renamed from: a */
    private static final String f7879a = PushClientApplication.class.getSimpleName();

    /* renamed from: b */
    private static PushClientApplication f7880b;

    /* renamed from: c */
    private boolean f7881c;

    /* renamed from: d */
    private C2060d f7882d;

    /* renamed from: e */
    private C2059c f7883e;

    /* renamed from: h */
    public static PushClientApplication m8156h() {
        return f7880b;
    }

    /* renamed from: i */
    public boolean m8158i() {
        return this.f7881c;
    }

    /* renamed from: a */
    public void m8157a(boolean z) {
        this.f7881c = z;
    }

    /* renamed from: j */
    public C2060d m8159j() {
        return this.f7882d;
    }

    /* renamed from: k */
    public C2059c m8160k() {
        return this.f7883e;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f7880b = this;
        this.f7881c = false;
        C2115g.m8358a(this);
        if (C2115g.f8048a) {
            C2115g.m8359a(f7879a, "PushClientApplication.onCreate()");
        }
        if (C2115g.f8049b) {
            C2115g.m8362b(f7879a, String.format("PushModule version: %s", "0.9.01.12"));
        }
        if (C2117i.m8370a(this)) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7879a, "Discovered public push client. disable in app push client.");
            }
            C2117i.m8368a(this, false);
            return;
        }
        if (C2115g.f8048a) {
            C2115g.m8359a(f7879a, "Couldn't discover public push client. enable in app push client.");
        }
        C2117i.m8371b(this, false);
        this.f7883e = new C2059c(this);
        this.f7882d = new C2060d(this);
        AlarmTimer.m8327a().m8328a(getApplicationContext());
        SystemStateMoniter.m8326a(C2045b.m8162a());
        SystemStateMoniter.m8325a();
        C2084e.m8219a();
        C2084e.m8219a().m8231a((InterfaceC2082c) new C2076d(this));
    }
}
