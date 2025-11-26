package com.sec.chaton.p025d;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AbstractServiceWrapper.java */
/* renamed from: com.sec.chaton.d.b */
/* loaded from: classes.dex */
public abstract class AbstractC1314b<T> {

    /* renamed from: c */
    private static final String f4970c = AbstractC1314b.class.getSimpleName();

    /* renamed from: a */
    protected String f4971a;

    /* renamed from: b */
    protected T f4972b;

    /* renamed from: e */
    private boolean f4974e;

    /* renamed from: g */
    private ServiceConnection f4976g = new ServiceConnectionC1325c(this);

    /* renamed from: d */
    private List<Runnable> f4973d = new ArrayList();

    /* renamed from: f */
    private int f4975f = 0;

    /* renamed from: a */
    protected abstract T mo5586a(IBinder iBinder);

    public AbstractC1314b(String str) {
        this.f4971a = str;
    }

    /* renamed from: e */
    private synchronized void m5664e() {
        if (!this.f4974e || this.f4972b == null) {
            this.f4974e = true;
            CommonApplication.m11493l().bindService(new Intent(this.f4971a), this.f4976g, 1);
        }
    }

    /* renamed from: f */
    private synchronized void m5665f() {
        if (this.f4972b != null) {
            try {
                CommonApplication.m11493l().unbindService(this.f4976g);
            } catch (Throwable th) {
            }
            this.f4972b = null;
        }
    }

    /* renamed from: a */
    protected synchronized void m5666a() {
        C3250y.m11450b("Clear lock count", f4970c);
        this.f4975f = 0;
    }

    /* renamed from: b */
    protected synchronized void m5668b() {
        C3250y.m11450b("Lock service. count: " + (this.f4975f + 1), f4970c);
        this.f4975f++;
    }

    /* renamed from: c */
    protected synchronized void m5669c() {
        C3250y.m11450b("Release service. count: " + (this.f4975f - 1), f4970c);
        this.f4975f--;
        if (this.f4975f < 0) {
            this.f4975f = 0;
        }
        if (this.f4975f == 0) {
            C3250y.m11450b("Lock count is 0, unbind service", f4970c);
            m5665f();
        }
    }

    /* renamed from: a */
    protected synchronized void m5667a(Runnable runnable) {
        if (this.f4972b == null) {
            this.f4973d.add(runnable);
            m5664e();
        } else {
            m5668b();
            runnable.run();
        }
    }
}
