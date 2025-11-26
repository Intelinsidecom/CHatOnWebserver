package com.sec.chaton.push;

import android.app.Application;
import android.content.Context;
import com.sec.chaton.push.p040a.C1072b;
import com.sec.chaton.push.p041b.p042a.C1086c;
import com.sec.chaton.push.p041b.p042a.C1087d;
import com.sec.chaton.push.p044c.C1111e;
import com.sec.chaton.push.p044c.InterfaceC1109c;
import com.sec.chaton.push.p044c.p045a.C1103d;
import com.sec.chaton.push.receiver.SystemStateMoniter;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.C1141i;

/* loaded from: classes.dex */
public class PushClientApplication extends Application {

    /* renamed from: a */
    private static final String f3976a = PushClientApplication.class.getSimpleName();

    /* renamed from: b */
    private static PushClientApplication f3977b;

    /* renamed from: c */
    private static Context f3978c;

    /* renamed from: d */
    private boolean f3979d;

    /* renamed from: e */
    private C1087d f3980e;

    /* renamed from: f */
    private C1086c f3981f;

    /* renamed from: g */
    public static Context m4111g() {
        return f3978c;
    }

    /* renamed from: h */
    public static PushClientApplication m4112h() {
        return f3977b;
    }

    /* renamed from: i */
    public boolean m4114i() {
        return this.f3979d;
    }

    /* renamed from: a */
    public void m4113a(boolean z) {
        this.f3979d = z;
    }

    /* renamed from: j */
    public C1087d m4115j() {
        return this.f3980e;
    }

    /* renamed from: k */
    public C1086c m4116k() {
        return this.f3981f;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f3977b = this;
        this.f3979d = false;
        f3978c = getApplicationContext();
        C1139g.m4307a(this);
        if (C1139g.f4142a) {
            C1139g.m4308a(f3976a, "PushClientApplication.onCreate()");
        }
        if (C1139g.f4143b) {
            C1139g.m4311b(f3976a, String.format("PushModule version: %s", "0.7.8.2"));
        }
        if (C1141i.m4319a(this)) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f3976a, "Discovered public push client. disable in app push client.");
            }
            C1141i.m4317a(this, false);
            return;
        }
        if (C1139g.f4142a) {
            C1139g.m4308a(f3976a, "Couldn't discover public push client. enable in app push client.");
        }
        C1141i.m4320b(this, false);
        this.f3981f = new C1086c(this);
        this.f3980e = new C1087d(this);
        AlarmTimer.m4276a().m4277a(getApplicationContext());
        SystemStateMoniter.m4273a(C1072b.m4118a());
        SystemStateMoniter.m4272a();
        C1111e.m4174a().m4188d();
        C1111e.m4174a().m4185a((InterfaceC1109c) new C1103d(this));
    }
}
