package com.sec.chaton.push.p040a;

import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p041b.p043b.InterfaceC1088a;
import com.sec.chaton.push.p044c.C1111e;
import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.p045a.C1101b;
import com.sec.chaton.push.p044c.p045a.C1105f;
import com.sec.chaton.push.receiver.InterfaceC1132c;
import com.sec.chaton.push.util.C1139g;
import com.sec.chaton.push.util.EnumC1138f;
import java.util.Random;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.b */
/* loaded from: classes.dex */
public class C1072b implements InterfaceC1132c {

    /* renamed from: a */
    private static final String f3984a = C1072b.class.getSimpleName();

    /* renamed from: b */
    private static C1072b f3985b;

    /* renamed from: d */
    private final String f3987d = "provisioningRetryToken";

    /* renamed from: f */
    private final String f3989f = "initializeRetryToken";

    /* renamed from: h */
    private final Object f3991h = new Object();

    /* renamed from: i */
    private final Object f3992i = new Object();

    /* renamed from: j */
    private InterfaceC1088a f3993j = new C1073c(this);

    /* renamed from: k */
    private InterfaceC1088a f3994k = new C1074d(this);

    /* renamed from: c */
    private Random f3986c = new Random(System.currentTimeMillis());

    /* renamed from: e */
    private int f3988e = 0;

    /* renamed from: g */
    private int f3990g = 0;

    /* renamed from: a */
    public static synchronized C1072b m4118a() {
        if (f3985b == null) {
            f3985b = new C1072b();
        }
        return f3985b;
    }

    private C1072b() {
    }

    /* renamed from: b */
    public void m4123b() {
        C1115i c1115iM4196a = C1115i.m4196a();
        synchronized (this.f3991h) {
            if (c1115iM4196a.m4204a("provisioningRetryToken")) {
                if (C1139g.f4143b) {
                    C1139g.m4311b(f3984a, "The retry provisioning task had been reserved in MessageTaskQueue.");
                }
                return;
            }
            this.f3988e++;
            long jM4119b = m4119b(this.f3988e);
            if (this.f3988e >= Integer.MAX_VALUE) {
                if (C1139g.f4143b) {
                    C1139g.m4311b(f3984a, String.format("Provisioning retry count is over(max count: %d).", Integer.MAX_VALUE));
                }
            } else {
                if (C1139g.f4143b) {
                    C1139g.m4311b(f3984a, String.format("Retry provisioning (retry count: %d) (interval: %d).", Integer.valueOf(this.f3988e), Long.valueOf(jM4119b / 1000)));
                }
                m4124c();
                c1115iM4196a.m4202a(PushClientApplication.m4111g(), "provisioningRetryToken", jM4119b, new C1105f(PushClientApplication.m4111g()));
            }
        }
    }

    /* renamed from: c */
    public void m4124c() {
        C1115i c1115iM4196a = C1115i.m4196a();
        synchronized (this.f3991h) {
            if (C1139g.f4143b) {
                C1139g.m4311b(f3984a, "Cancel retry provisioning.");
            }
            if (c1115iM4196a.m4204a("provisioningRetryToken")) {
                if (C1139g.f4143b) {
                    C1139g.m4311b(f3984a, "Because the retry provisioning task had been reserved in MessageTaskQueue, decrease retry count by 1.");
                }
                this.f3988e--;
                if (this.f3988e < 0) {
                    this.f3988e = 0;
                }
            }
            c1115iM4196a.m4201a(PushClientApplication.m4111g(), "provisioningRetryToken");
        }
    }

    /* renamed from: d */
    public void m4125d() {
        synchronized (this.f3991h) {
            this.f3988e = 0;
        }
    }

    /* renamed from: e */
    public void m4126e() {
        C1115i c1115iM4196a = C1115i.m4196a();
        synchronized (this.f3992i) {
            if (c1115iM4196a.m4204a("initializeRetryToken")) {
                if (C1139g.f4143b) {
                    C1139g.m4311b(f3984a, "The retry initailize task had been reserved in MessageTaskQueue.");
                }
                return;
            }
            this.f3990g++;
            long jM4119b = m4119b(this.f3990g);
            if (this.f3990g >= Integer.MAX_VALUE) {
                if (C1139g.f4143b) {
                    C1139g.m4311b(f3984a, String.format("Initialize retry count is over(max count: %d).", Integer.MAX_VALUE));
                }
            } else {
                if (C1139g.f4143b) {
                    C1139g.m4311b(f3984a, String.format("Retry initialize (retry count: %d) (interval: %d).", Integer.valueOf(this.f3990g), Long.valueOf(jM4119b / 1000)));
                }
                m4127f();
                c1115iM4196a.m4202a(PushClientApplication.m4111g(), "initializeRetryToken", jM4119b, new C1101b(PushClientApplication.m4111g()));
            }
        }
    }

    /* renamed from: f */
    public void m4127f() {
        C1115i c1115iM4196a = C1115i.m4196a();
        synchronized (this.f3992i) {
            if (C1139g.f4143b) {
                C1139g.m4311b(f3984a, "Cancel retry initalize.");
            }
            if (c1115iM4196a.m4204a("initializeRetryToken")) {
                if (C1139g.f4143b) {
                    C1139g.m4311b(f3984a, "Because the retry initailize task had been reserved in MessageTaskQueue, decrease retry count by 1.");
                }
                this.f3990g--;
                if (this.f3990g < 0) {
                    this.f3990g = 0;
                }
            }
            c1115iM4196a.m4201a(PushClientApplication.m4111g(), "initializeRetryToken");
        }
    }

    /* renamed from: g */
    public void m4128g() {
        synchronized (this.f3992i) {
            this.f3990g = 0;
        }
    }

    /* renamed from: b */
    private long m4119b(int i) {
        if (i <= 20) {
            if (C1139g.f4142a) {
                C1139g.m4308a(f3984a, "Using short base retry interval.");
            }
            return 60000 + (this.f3986c.nextInt(121) * 1000);
        }
        return 600000 + (this.f3986c.nextInt(121) * 1000);
    }

    @Override // com.sec.chaton.push.receiver.InterfaceC1132c
    /* renamed from: a */
    public void mo4122a(EnumC1138f enumC1138f, EnumC1138f enumC1138f2) {
        C1111e.m4174a().m4186b().post(new RunnableC1076f(enumC1138f, enumC1138f2));
    }

    /* renamed from: h */
    public InterfaceC1088a m4129h() {
        return this.f3993j;
    }

    /* renamed from: i */
    public InterfaceC1088a m4130i() {
        return this.f3994k;
    }

    /* renamed from: a */
    public void m4121a(int i) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f3984a, "Cancel pending message task.");
        }
        C1115i c1115iM4196a = C1115i.m4196a();
        if (C1139g.f4142a) {
            C1139g.m4308a(f3984a, String.format("Cancel task count: %d.", Integer.valueOf(c1115iM4196a.m4206c())));
        }
        m4118a().m4124c();
        m4118a().m4127f();
        c1115iM4196a.m4200a(PushClientApplication.m4111g(), new C1075e(this, i));
    }
}
