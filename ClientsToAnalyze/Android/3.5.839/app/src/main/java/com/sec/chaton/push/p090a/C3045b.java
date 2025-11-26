package com.sec.chaton.push.p090a;

import com.sec.chaton.push.p091b.p093b.InterfaceC3061a;
import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.p095a.C3074b;
import com.sec.chaton.push.p094c.p095a.C3078f;
import com.sec.chaton.push.receiver.InterfaceC3108b;
import com.sec.chaton.push.util.C3115g;
import com.sec.chaton.push.util.EnumC3114f;
import com.sec.common.CommonApplication;
import java.util.Random;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.b */
/* loaded from: classes.dex */
public class C3045b implements InterfaceC3108b {

    /* renamed from: a */
    private static final String f11297a = C3045b.class.getSimpleName();

    /* renamed from: b */
    private static C3045b f11298b;

    /* renamed from: d */
    private final String f11300d = "provisioningRetryToken";

    /* renamed from: f */
    private final String f11302f = "initializeRetryToken";

    /* renamed from: h */
    private final Object f11304h = new Object();

    /* renamed from: i */
    private final Object f11305i = new Object();

    /* renamed from: j */
    private InterfaceC3061a f11306j = new C3046c(this);

    /* renamed from: k */
    private InterfaceC3061a f11307k = new C3047d(this);

    /* renamed from: c */
    private final Random f11299c = new Random(System.currentTimeMillis());

    /* renamed from: e */
    private int f11301e = 0;

    /* renamed from: g */
    private int f11303g = 0;

    /* renamed from: a */
    public static synchronized C3045b m12505a() {
        if (f11298b == null) {
            f11298b = new C3045b();
        }
        return f11298b;
    }

    private C3045b() {
    }

    /* renamed from: b */
    public void m12510b() {
        C3088i c3088iM12584a = C3088i.m12584a();
        synchronized (this.f11304h) {
            if (c3088iM12584a.m12592a("provisioningRetryToken")) {
                if (C3115g.f11459b) {
                    C3115g.m12704b(f11297a, "The retry provisioning task had been reserved in MessageTaskQueue.");
                }
                return;
            }
            this.f11301e++;
            long jM12506b = m12506b(this.f11301e);
            if (this.f11301e >= Integer.MAX_VALUE) {
                if (C3115g.f11459b) {
                    C3115g.m12704b(f11297a, String.format("Provisioning retry count is over(max count: %d).", Integer.MAX_VALUE));
                }
            } else {
                if (C3115g.f11459b) {
                    C3115g.m12704b(f11297a, String.format("Retry provisioning (retry count: %d) (interval: %d).", Integer.valueOf(this.f11301e), Long.valueOf(jM12506b / 1000)));
                }
                m12511c();
                c3088iM12584a.m12590a(CommonApplication.m18732r(), "provisioningRetryToken", jM12506b, new C3078f(CommonApplication.m18732r()));
            }
        }
    }

    /* renamed from: c */
    public void m12511c() {
        C3088i c3088iM12584a = C3088i.m12584a();
        synchronized (this.f11304h) {
            if (C3115g.f11459b) {
                C3115g.m12704b(f11297a, "Cancel retry provisioning.");
            }
            if (c3088iM12584a.m12592a("provisioningRetryToken")) {
                if (C3115g.f11459b) {
                    C3115g.m12704b(f11297a, "Because the retry provisioning task had been reserved in MessageTaskQueue, decrease retry count by 1.");
                }
                this.f11301e--;
                if (this.f11301e < 0) {
                    this.f11301e = 0;
                }
            }
            c3088iM12584a.m12589a(CommonApplication.m18732r(), "provisioningRetryToken");
        }
    }

    /* renamed from: d */
    public void m12512d() {
        synchronized (this.f11304h) {
            this.f11301e = 0;
        }
    }

    /* renamed from: e */
    public void m12513e() {
        C3088i c3088iM12584a = C3088i.m12584a();
        synchronized (this.f11305i) {
            if (c3088iM12584a.m12592a("initializeRetryToken")) {
                if (C3115g.f11459b) {
                    C3115g.m12704b(f11297a, "The retry initailize task had been reserved in MessageTaskQueue.");
                }
                return;
            }
            this.f11303g++;
            long jM12506b = m12506b(this.f11303g);
            if (this.f11303g >= Integer.MAX_VALUE) {
                if (C3115g.f11459b) {
                    C3115g.m12704b(f11297a, String.format("Initialize retry count is over(max count: %d).", Integer.MAX_VALUE));
                }
            } else {
                if (C3115g.f11459b) {
                    C3115g.m12704b(f11297a, String.format("Retry initialize (retry count: %d) (interval: %d).", Integer.valueOf(this.f11303g), Long.valueOf(jM12506b / 1000)));
                }
                m12514f();
                c3088iM12584a.m12590a(CommonApplication.m18732r(), "initializeRetryToken", jM12506b, new C3074b(CommonApplication.m18732r()));
            }
        }
    }

    /* renamed from: f */
    public void m12514f() {
        C3088i c3088iM12584a = C3088i.m12584a();
        synchronized (this.f11305i) {
            if (C3115g.f11459b) {
                C3115g.m12704b(f11297a, "Cancel retry initalize.");
            }
            if (c3088iM12584a.m12592a("initializeRetryToken")) {
                if (C3115g.f11459b) {
                    C3115g.m12704b(f11297a, "Because the retry initailize task had been reserved in MessageTaskQueue, decrease retry count by 1.");
                }
                this.f11303g--;
                if (this.f11303g < 0) {
                    this.f11303g = 0;
                }
            }
            c3088iM12584a.m12589a(CommonApplication.m18732r(), "initializeRetryToken");
        }
    }

    /* renamed from: g */
    public void m12515g() {
        synchronized (this.f11305i) {
            this.f11303g = 0;
        }
    }

    /* renamed from: b */
    private long m12506b(int i) {
        if (i <= 20) {
            if (C3115g.f11458a) {
                C3115g.m12701a(f11297a, "Using short base retry interval.");
            }
            return (this.f11299c.nextInt(119) + 1) * 1000;
        }
        return 300000 + ((this.f11299c.nextInt(119) + 1) * 1000);
    }

    @Override // com.sec.chaton.push.receiver.InterfaceC3108b
    /* renamed from: a */
    public void mo12509a(EnumC3114f enumC3114f, EnumC3114f enumC3114f2) {
        C3084e.m12562a().m12575b().post(new RunnableC3049f(enumC3114f, enumC3114f2));
    }

    /* renamed from: h */
    public InterfaceC3061a m12516h() {
        return this.f11306j;
    }

    /* renamed from: i */
    public InterfaceC3061a m12517i() {
        return this.f11307k;
    }

    /* renamed from: a */
    public void m12508a(int i) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11297a, "Cancel pending message task.");
        }
        C3088i c3088iM12584a = C3088i.m12584a();
        if (C3115g.f11458a) {
            C3115g.m12701a(f11297a, String.format("Cancel task count: %d.", Integer.valueOf(c3088iM12584a.m12594c())));
        }
        m12505a().m12511c();
        m12505a().m12514f();
        c3088iM12584a.m12588a(CommonApplication.m18732r(), new C3048e(this, i));
    }
}
