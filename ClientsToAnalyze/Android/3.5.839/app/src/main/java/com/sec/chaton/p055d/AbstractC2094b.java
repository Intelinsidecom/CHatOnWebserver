package com.sec.chaton.p055d;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AbstractServiceWrapper.java */
/* renamed from: com.sec.chaton.d.b */
/* loaded from: classes.dex */
public abstract class AbstractC2094b<T> {

    /* renamed from: c */
    private static final String f7606c = AbstractC2094b.class.getSimpleName();

    /* renamed from: a */
    protected String f7607a;

    /* renamed from: b */
    protected T f7608b;

    /* renamed from: e */
    private boolean f7610e;

    /* renamed from: g */
    private ServiceConnection f7612g = new ServiceConnectionC2121c(this);

    /* renamed from: d */
    private List<Runnable> f7609d = new ArrayList();

    /* renamed from: f */
    private int f7611f = 0;

    /* renamed from: a */
    protected abstract T mo9327a(IBinder iBinder);

    public AbstractC2094b(String str) {
        this.f7607a = str;
    }

    /* renamed from: e */
    private synchronized void m9342e() {
        if (!this.f7610e || this.f7608b == null) {
            this.f7610e = true;
            CommonApplication.m18732r().bindService(new Intent(this.f7607a), this.f7612g, 1);
        }
    }

    /* renamed from: f */
    private synchronized void m9343f() {
        if (this.f7608b != null) {
            try {
                CommonApplication.m18732r().unbindService(this.f7612g);
            } catch (Throwable th) {
            }
            this.f7608b = null;
        }
    }

    /* renamed from: a */
    protected synchronized void m9344a() {
        C4904y.m18639b("Clear lock count", f7606c);
        this.f7611f = 0;
    }

    /* renamed from: b */
    protected synchronized void m9346b() {
        C4904y.m18639b("Lock service. count: " + (this.f7611f + 1), f7606c);
        this.f7611f++;
    }

    /* renamed from: c */
    protected synchronized void m9347c() {
        C4904y.m18639b("Release service. count: " + (this.f7611f - 1), f7606c);
        this.f7611f--;
        if (this.f7611f < 0) {
            this.f7611f = 0;
        }
        if (this.f7611f == 0) {
            C4904y.m18639b("Lock count is 0, unbind service", f7606c);
            m9343f();
        }
    }

    /* renamed from: a */
    protected synchronized void m9345a(Runnable runnable) {
        if (this.f7608b == null) {
            this.f7609d.add(runnable);
            m9342e();
        } else {
            m9346b();
            runnable.run();
        }
    }
}
