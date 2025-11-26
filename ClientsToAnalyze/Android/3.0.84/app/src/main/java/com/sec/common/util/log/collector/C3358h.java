package com.sec.common.util.log.collector;

import com.sec.common.C3330f;
import com.sec.common.util.C3364o;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.p072a.p073a.p074a.InterfaceC3711f;
import org.p072a.p073a.p074a.p075a.C3706p;

/* compiled from: LogWriter.java */
/* renamed from: com.sec.common.util.log.collector.h */
/* loaded from: classes.dex */
public class C3358h {

    /* renamed from: a */
    private static final String f12103a = C3358h.class.getSimpleName();

    /* renamed from: b */
    private static C3358h f12104b;

    /* renamed from: c */
    private ExecutorService f12105c = Executors.newFixedThreadPool(1, new ThreadFactoryC3359i(this));

    /* renamed from: d */
    private InterfaceC3711f<C3360j> f12106d = new C3706p(new C3361k(this, null));

    /* renamed from: a */
    public static synchronized C3358h m11842a() {
        if (f12104b == null) {
            f12104b = new C3358h();
        }
        return f12104b;
    }

    private C3358h() {
    }

    /* renamed from: a */
    public void m11846a(String str) {
        m11847a(str, null);
    }

    /* renamed from: a */
    public void m11847a(String str, String str2) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f12103a, C3364o.m11849a("Requested writing log message. pageId = ", str, " actionId = ", str2));
        }
        try {
            C3352b c3352bM11836a = C3355e.m11836a();
            if (c3352bM11836a != null) {
                c3352bM11836a.m11827c(str);
                c3352bM11836a.m11829d(str2);
                C3360j c3360jMo13370c = this.f12106d.mo13370c();
                c3360jMo13370c.f12108a = c3352bM11836a;
                this.f12105c.submit(c3360jMo13370c);
            }
        } catch (Exception e) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f12103a, e.getMessage(), e);
            }
        }
    }

    /* renamed from: a */
    public void m11845a(C3352b c3352b) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f12103a, C3364o.m11849a("Requested writing log message. pageId=", c3352b.f12095b, ", actionId=", c3352b.f12096c));
        }
        try {
            C3360j c3360jMo13370c = this.f12106d.mo13370c();
            c3360jMo13370c.f12108a = c3352b;
            this.f12105c.submit(c3360jMo13370c);
        } catch (Exception e) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f12103a, e.getMessage(), e);
            }
        }
    }
}
