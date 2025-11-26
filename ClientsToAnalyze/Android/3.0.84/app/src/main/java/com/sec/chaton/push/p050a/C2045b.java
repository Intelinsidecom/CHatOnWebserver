package com.sec.chaton.push.p050a;

import com.sec.chaton.push.p051b.p053b.InterfaceC2061a;
import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.p055a.C2074b;
import com.sec.chaton.push.p054c.p055a.C2078f;
import com.sec.chaton.push.receiver.InterfaceC2108b;
import com.sec.chaton.push.util.C2115g;
import com.sec.chaton.push.util.EnumC2114f;
import com.sec.common.CommonApplication;
import java.util.Random;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.b */
/* loaded from: classes.dex */
public class C2045b implements InterfaceC2108b {

    /* renamed from: a */
    private static final String f7887a = C2045b.class.getSimpleName();

    /* renamed from: b */
    private static C2045b f7888b;

    /* renamed from: d */
    private final String f7890d = "provisioningRetryToken";

    /* renamed from: f */
    private final String f7892f = "initializeRetryToken";

    /* renamed from: h */
    private final Object f7894h = new Object();

    /* renamed from: i */
    private final Object f7895i = new Object();

    /* renamed from: j */
    private InterfaceC2061a f7896j = new C2046c(this);

    /* renamed from: k */
    private InterfaceC2061a f7897k = new C2047d(this);

    /* renamed from: c */
    private final Random f7889c = new Random(System.currentTimeMillis());

    /* renamed from: e */
    private int f7891e = 0;

    /* renamed from: g */
    private int f7893g = 0;

    /* renamed from: a */
    public static synchronized C2045b m8162a() {
        if (f7888b == null) {
            f7888b = new C2045b();
        }
        return f7888b;
    }

    private C2045b() {
    }

    /* renamed from: b */
    public void m8167b() {
        C2088i c2088iM8241a = C2088i.m8241a();
        synchronized (this.f7894h) {
            if (c2088iM8241a.m8249a("provisioningRetryToken")) {
                if (C2115g.f8049b) {
                    C2115g.m8362b(f7887a, "The retry provisioning task had been reserved in MessageTaskQueue.");
                }
                return;
            }
            this.f7891e++;
            long jM8163b = m8163b(this.f7891e);
            if (this.f7891e >= Integer.MAX_VALUE) {
                if (C2115g.f8049b) {
                    C2115g.m8362b(f7887a, String.format("Provisioning retry count is over(max count: %d).", Integer.MAX_VALUE));
                }
            } else {
                if (C2115g.f8049b) {
                    C2115g.m8362b(f7887a, String.format("Retry provisioning (retry count: %d) (interval: %d).", Integer.valueOf(this.f7891e), Long.valueOf(jM8163b / 1000)));
                }
                m8168c();
                c2088iM8241a.m8247a(CommonApplication.m11493l(), "provisioningRetryToken", jM8163b, new C2078f(CommonApplication.m11493l()));
            }
        }
    }

    /* renamed from: c */
    public void m8168c() {
        C2088i c2088iM8241a = C2088i.m8241a();
        synchronized (this.f7894h) {
            if (C2115g.f8049b) {
                C2115g.m8362b(f7887a, "Cancel retry provisioning.");
            }
            if (c2088iM8241a.m8249a("provisioningRetryToken")) {
                if (C2115g.f8049b) {
                    C2115g.m8362b(f7887a, "Because the retry provisioning task had been reserved in MessageTaskQueue, decrease retry count by 1.");
                }
                this.f7891e--;
                if (this.f7891e < 0) {
                    this.f7891e = 0;
                }
            }
            c2088iM8241a.m8246a(CommonApplication.m11493l(), "provisioningRetryToken");
        }
    }

    /* renamed from: d */
    public void m8169d() {
        synchronized (this.f7894h) {
            this.f7891e = 0;
        }
    }

    /* renamed from: e */
    public void m8170e() {
        C2088i c2088iM8241a = C2088i.m8241a();
        synchronized (this.f7895i) {
            if (c2088iM8241a.m8249a("initializeRetryToken")) {
                if (C2115g.f8049b) {
                    C2115g.m8362b(f7887a, "The retry initailize task had been reserved in MessageTaskQueue.");
                }
                return;
            }
            this.f7893g++;
            long jM8163b = m8163b(this.f7893g);
            if (this.f7893g >= Integer.MAX_VALUE) {
                if (C2115g.f8049b) {
                    C2115g.m8362b(f7887a, String.format("Initialize retry count is over(max count: %d).", Integer.MAX_VALUE));
                }
            } else {
                if (C2115g.f8049b) {
                    C2115g.m8362b(f7887a, String.format("Retry initialize (retry count: %d) (interval: %d).", Integer.valueOf(this.f7893g), Long.valueOf(jM8163b / 1000)));
                }
                m8171f();
                c2088iM8241a.m8247a(CommonApplication.m11493l(), "initializeRetryToken", jM8163b, new C2074b(CommonApplication.m11493l()));
            }
        }
    }

    /* renamed from: f */
    public void m8171f() {
        C2088i c2088iM8241a = C2088i.m8241a();
        synchronized (this.f7895i) {
            if (C2115g.f8049b) {
                C2115g.m8362b(f7887a, "Cancel retry initalize.");
            }
            if (c2088iM8241a.m8249a("initializeRetryToken")) {
                if (C2115g.f8049b) {
                    C2115g.m8362b(f7887a, "Because the retry initailize task had been reserved in MessageTaskQueue, decrease retry count by 1.");
                }
                this.f7893g--;
                if (this.f7893g < 0) {
                    this.f7893g = 0;
                }
            }
            c2088iM8241a.m8246a(CommonApplication.m11493l(), "initializeRetryToken");
        }
    }

    /* renamed from: g */
    public void m8172g() {
        synchronized (this.f7895i) {
            this.f7893g = 0;
        }
    }

    /* renamed from: b */
    private long m8163b(int i) {
        if (i <= 20) {
            if (C2115g.f8048a) {
                C2115g.m8359a(f7887a, "Using short base retry interval.");
            }
            return (this.f7889c.nextInt(119) + 1) * 1000;
        }
        return 300000 + ((this.f7889c.nextInt(119) + 1) * 1000);
    }

    @Override // com.sec.chaton.push.receiver.InterfaceC2108b
    /* renamed from: a */
    public void mo8166a(EnumC2114f enumC2114f, EnumC2114f enumC2114f2) {
        C2084e.m8219a().m8232b().post(new RunnableC2049f(enumC2114f, enumC2114f2));
    }

    /* renamed from: h */
    public InterfaceC2061a m8173h() {
        return this.f7896j;
    }

    /* renamed from: i */
    public InterfaceC2061a m8174i() {
        return this.f7897k;
    }

    /* renamed from: a */
    public void m8165a(int i) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7887a, "Cancel pending message task.");
        }
        C2088i c2088iM8241a = C2088i.m8241a();
        if (C2115g.f8048a) {
            C2115g.m8359a(f7887a, String.format("Cancel task count: %d.", Integer.valueOf(c2088iM8241a.m8251c())));
        }
        m8162a().m8168c();
        m8162a().m8171f();
        c2088iM8241a.m8245a(CommonApplication.m11493l(), new C2048e(this, i));
    }
}
