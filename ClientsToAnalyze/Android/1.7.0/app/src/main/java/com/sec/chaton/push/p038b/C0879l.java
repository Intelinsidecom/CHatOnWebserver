package com.sec.chaton.push.p038b;

import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.push.p035a.p036a.InterfaceC0855c;
import com.sec.chaton.push.p039c.C0893e;
import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.p040a.C0882a;
import com.sec.chaton.push.p039c.p040a.C0888g;
import com.sec.chaton.push.receiver.InterfaceC0913b;
import com.sec.chaton.push.util.C0921g;
import com.sec.chaton.push.util.EnumC0918d;
import java.util.Random;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.b.l */
/* loaded from: classes.dex */
public class C0879l implements InterfaceC0913b {

    /* renamed from: a */
    private static final String f3008a = C0879l.class.getSimpleName();

    /* renamed from: b */
    private static C0879l f3009b;

    /* renamed from: d */
    private final String f3011d = "provisioningRetryToken";

    /* renamed from: f */
    private final String f3013f = "initializeRetryToken";

    /* renamed from: h */
    private final Object f3015h = new Object();

    /* renamed from: i */
    private final Object f3016i = new Object();

    /* renamed from: j */
    private InterfaceC0855c f3017j = new C0871d(this);

    /* renamed from: k */
    private InterfaceC0855c f3018k = new C0870c(this);

    /* renamed from: c */
    private Random f3010c = new Random(System.currentTimeMillis());

    /* renamed from: e */
    private int f3012e = 0;

    /* renamed from: g */
    private int f3014g = 0;

    /* renamed from: a */
    public static synchronized C0879l m3463a() {
        if (f3009b == null) {
            f3009b = new C0879l();
        }
        return f3009b;
    }

    private C0879l() {
    }

    /* renamed from: b */
    public void m3468b() {
        C0896h c0896hM3520a = C0896h.m3520a();
        synchronized (this.f3015h) {
            if (c0896hM3520a.m3528a("provisioningRetryToken")) {
                if (C0921g.f3117b) {
                    C0921g.m3640b(f3008a, "The retry provisioning task had been reserved in MessageTaskQueue.");
                }
                return;
            }
            this.f3012e++;
            long jM3464b = m3464b(this.f3012e);
            if (this.f3012e >= Integer.MAX_VALUE) {
                if (C0921g.f3117b) {
                    C0921g.m3640b(f3008a, String.format("Provisioning retry count is over(max count: %d).", Integer.MAX_VALUE));
                }
            } else {
                if (C0921g.f3117b) {
                    C0921g.m3640b(f3008a, String.format("Retry provisioning (retry count: %d) (interval: %d).", Integer.valueOf(this.f3012e), Long.valueOf(jM3464b / 1000)));
                }
                m3469c();
                c0896hM3520a.m3526a(PushClientApplication.m3436a(), "provisioningRetryToken", jM3464b, new C0882a(PushClientApplication.m3436a()));
            }
        }
    }

    /* renamed from: c */
    public void m3469c() {
        C0896h c0896hM3520a = C0896h.m3520a();
        synchronized (this.f3015h) {
            if (C0921g.f3117b) {
                C0921g.m3640b(f3008a, "Cancel retry provisioning.");
            }
            if (c0896hM3520a.m3528a("provisioningRetryToken")) {
                if (C0921g.f3117b) {
                    C0921g.m3640b(f3008a, "Because the retry provisioning task had been reserved in MessageTaskQueue, decrease retry count by 1.");
                }
                this.f3012e--;
                if (this.f3012e < 0) {
                    this.f3012e = 0;
                }
            }
            c0896hM3520a.m3525a(PushClientApplication.m3436a(), "provisioningRetryToken");
        }
    }

    /* renamed from: d */
    public void m3470d() {
        synchronized (this.f3015h) {
            this.f3012e = 0;
        }
    }

    /* renamed from: e */
    public void m3471e() {
        C0896h c0896hM3520a = C0896h.m3520a();
        synchronized (this.f3016i) {
            if (c0896hM3520a.m3528a("initializeRetryToken")) {
                if (C0921g.f3117b) {
                    C0921g.m3640b(f3008a, "The retry initailize task had been reserved in MessageTaskQueue.");
                }
                return;
            }
            this.f3014g++;
            long jM3464b = m3464b(this.f3014g);
            if (this.f3014g >= Integer.MAX_VALUE) {
                if (C0921g.f3117b) {
                    C0921g.m3640b(f3008a, String.format("Initialize retry count is over(max count: %d).", Integer.MAX_VALUE));
                }
            } else {
                if (C0921g.f3117b) {
                    C0921g.m3640b(f3008a, String.format("Retry initialize (retry count: %d) (interval: %d).", Integer.valueOf(this.f3014g), Long.valueOf(jM3464b / 1000)));
                }
                m3472f();
                c0896hM3520a.m3526a(PushClientApplication.m3436a(), "initializeRetryToken", jM3464b, new C0888g(PushClientApplication.m3436a()));
            }
        }
    }

    /* renamed from: f */
    public void m3472f() {
        C0896h c0896hM3520a = C0896h.m3520a();
        synchronized (this.f3016i) {
            if (C0921g.f3117b) {
                C0921g.m3640b(f3008a, "Cancel retry initalize.");
            }
            if (c0896hM3520a.m3528a("initializeRetryToken")) {
                if (C0921g.f3117b) {
                    C0921g.m3640b(f3008a, "Because the retry initailize task had been reserved in MessageTaskQueue, decrease retry count by 1.");
                }
                this.f3014g--;
                if (this.f3014g < 0) {
                    this.f3014g = 0;
                }
            }
            c0896hM3520a.m3525a(PushClientApplication.m3436a(), "initializeRetryToken");
        }
    }

    /* renamed from: g */
    public void m3473g() {
        synchronized (this.f3016i) {
            this.f3014g = 0;
        }
    }

    /* renamed from: b */
    private long m3464b(int i) {
        if (i <= 20) {
            if (C0921g.f3116a) {
                C0921g.m3637a(f3008a, "Using short base retry interval.");
            }
            return (this.f3010c.nextInt(119) + 1) * 1000;
        }
        return 300000 + ((this.f3010c.nextInt(119) + 1) * 1000);
    }

    @Override // com.sec.chaton.push.receiver.InterfaceC0913b
    /* renamed from: a */
    public void mo3467a(EnumC0918d enumC0918d, EnumC0918d enumC0918d2) {
        C0893e.m3502a().m3514b().post(new RunnableC0878k(enumC0918d, enumC0918d2));
    }

    /* renamed from: h */
    public InterfaceC0855c m3474h() {
        return this.f3017j;
    }

    /* renamed from: i */
    public InterfaceC0855c m3475i() {
        return this.f3018k;
    }

    /* renamed from: a */
    public void m3466a(int i) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3008a, "Cancel pending message task.");
        }
        C0896h c0896hM3520a = C0896h.m3520a();
        if (C0921g.f3116a) {
            C0921g.m3637a(f3008a, String.format("Cancel task count: %d.", Integer.valueOf(c0896hM3520a.m3530c())));
        }
        m3463a().m3469c();
        m3463a().m3472f();
        c0896hM3520a.m3524a(PushClientApplication.m3436a(), new C0869b(this, i));
    }
}
