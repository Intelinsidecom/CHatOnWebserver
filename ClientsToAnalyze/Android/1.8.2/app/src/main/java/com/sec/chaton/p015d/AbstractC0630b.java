package com.sec.chaton.p015d;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AbstractServiceWrapper.java */
/* renamed from: com.sec.chaton.d.b */
/* loaded from: classes.dex */
public abstract class AbstractC0630b {

    /* renamed from: c */
    private static final String f2462c = AbstractC0630b.class.getSimpleName();

    /* renamed from: a */
    protected String f2463a;

    /* renamed from: b */
    protected Object f2464b;

    /* renamed from: e */
    private boolean f2466e;

    /* renamed from: g */
    private ServiceConnection f2468g = new ServiceConnectionC0631c(this);

    /* renamed from: d */
    private List f2465d = new ArrayList();

    /* renamed from: f */
    private int f2467f = 0;

    /* renamed from: a */
    protected abstract Object mo2796a(IBinder iBinder);

    public AbstractC0630b(String str) {
        this.f2463a = str;
    }

    /* renamed from: e */
    private synchronized void m2838e() {
        if (!this.f2466e || this.f2464b == null) {
            this.f2466e = true;
            GlobalApplication.m3260b().bindService(new Intent(this.f2463a), this.f2468g, 1);
        }
    }

    /* renamed from: f */
    private synchronized void m2839f() {
        if (this.f2464b != null) {
            try {
                GlobalApplication.m3260b().unbindService(this.f2468g);
            } catch (Throwable th) {
            }
            this.f2464b = null;
        }
    }

    /* renamed from: a */
    protected synchronized void m2840a() {
        C1786r.m6061b("Clear lock count", f2462c);
        this.f2467f = 0;
    }

    /* renamed from: b */
    protected synchronized void m2842b() {
        C1786r.m6061b("Lock service. count: " + (this.f2467f + 1), f2462c);
        this.f2467f++;
    }

    /* renamed from: c */
    protected synchronized void m2843c() {
        C1786r.m6061b("Release service. count: " + (this.f2467f - 1), f2462c);
        this.f2467f--;
        if (this.f2467f < 0) {
            this.f2467f = 0;
        }
        if (this.f2467f == 0) {
            C1786r.m6061b("Lock count is 0, unbind service", f2462c);
            m2839f();
        }
    }

    /* renamed from: a */
    protected synchronized void m2841a(Runnable runnable) {
        if (this.f2464b == null) {
            this.f2465d.add(runnable);
            m2838e();
        } else {
            m2842b();
            runnable.run();
        }
    }
}
