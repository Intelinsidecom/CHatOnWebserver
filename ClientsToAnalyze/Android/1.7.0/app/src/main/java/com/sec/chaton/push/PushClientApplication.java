package com.sec.chaton.push;

import android.app.Application;
import android.content.Context;
import com.sec.chaton.push.p035a.p037b.C0864b;
import com.sec.chaton.push.p035a.p037b.C0866d;
import com.sec.chaton.push.p038b.C0879l;
import com.sec.chaton.push.p039c.C0893e;
import com.sec.chaton.push.p039c.InterfaceC0895g;
import com.sec.chaton.push.p039c.p040a.C0887f;
import com.sec.chaton.push.receiver.SystemStateMoniter;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C0915a;
import com.sec.chaton.push.util.C0921g;

/* loaded from: classes.dex */
public class PushClientApplication extends Application {

    /* renamed from: a */
    private static final String f2954a = PushClientApplication.class.getSimpleName();

    /* renamed from: b */
    private static PushClientApplication f2955b;

    /* renamed from: c */
    private static Context f2956c;

    /* renamed from: d */
    private boolean f2957d;

    /* renamed from: e */
    private C0866d f2958e;

    /* renamed from: f */
    private C0864b f2959f;

    /* renamed from: a */
    public static Context m3436a() {
        return f2956c;
    }

    /* renamed from: b */
    public static PushClientApplication m3437b() {
        return f2955b;
    }

    /* renamed from: c */
    public boolean m3439c() {
        return this.f2957d;
    }

    /* renamed from: a */
    public void m3438a(boolean z) {
        this.f2957d = z;
    }

    /* renamed from: d */
    public C0866d m3440d() {
        return this.f2958e;
    }

    /* renamed from: e */
    public C0864b m3441e() {
        return this.f2959f;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f2955b = this;
        this.f2957d = false;
        f2956c = getApplicationContext();
        C0921g.m3636a(this);
        if (C0921g.f3116a) {
            C0921g.m3637a(f2954a, "PushClientApplication.onCreate()");
        }
        if (C0921g.f3117b) {
            C0921g.m3640b(f2954a, String.format("PushModule version: %s", "0.7.8.5"));
        }
        if (C0915a.m3609a(this)) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f2954a, "Discovered public push client. disable in app push client.");
            }
            C0915a.m3607a(this, false);
            return;
        }
        if (C0921g.f3116a) {
            C0921g.m3637a(f2954a, "Couldn't discover public push client. enable in app push client.");
        }
        C0915a.m3610b(this, false);
        this.f2959f = new C0864b(this);
        this.f2958e = new C0866d(this);
        AlarmTimer.m3603a().m3604a(getApplicationContext());
        SystemStateMoniter.m3600a(C0879l.m3463a());
        SystemStateMoniter.m3599a();
        C0893e.m3502a().m3516d();
        C0893e.m3502a().m3513a((InterfaceC0895g) new C0887f(this));
    }
}
