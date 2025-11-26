package com.sec.chaton.p013a;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AbstractServiceWrapper.java */
/* renamed from: com.sec.chaton.a.ad */
/* loaded from: classes.dex */
public abstract class AbstractC0191ad {

    /* renamed from: c */
    private static final String f475c = AbstractC0191ad.class.getSimpleName();

    /* renamed from: a */
    protected String f476a;

    /* renamed from: b */
    protected Object f477b;

    /* renamed from: e */
    private boolean f479e;

    /* renamed from: g */
    private ServiceConnection f481g = new ServiceConnectionC0205d(this);

    /* renamed from: d */
    private List f478d = new ArrayList();

    /* renamed from: f */
    private int f480f = 0;

    /* renamed from: b */
    protected abstract Object mo735b(IBinder iBinder);

    public AbstractC0191ad(String str) {
        this.f476a = str;
    }

    /* renamed from: b */
    private synchronized void m732b() {
        if (!this.f479e || this.f477b == null) {
            this.f479e = true;
            GlobalApplication.m3100a().bindService(new Intent(this.f476a), this.f481g, 1);
        }
    }

    /* renamed from: f */
    private synchronized void m733f() {
        if (this.f477b != null) {
            try {
                GlobalApplication.m3100a().unbindService(this.f481g);
            } catch (Throwable th) {
            }
            this.f477b = null;
        }
    }

    /* renamed from: c */
    protected synchronized void m736c() {
        C1341p.m4658b("Clear lock count", f475c);
        this.f480f = 0;
    }

    /* renamed from: d */
    protected synchronized void m737d() {
        C1341p.m4658b("Lock service. count: " + (this.f480f + 1), f475c);
        this.f480f++;
    }

    /* renamed from: e */
    protected synchronized void m738e() {
        C1341p.m4658b("Release service. count: " + (this.f480f - 1), f475c);
        this.f480f--;
        if (this.f480f < 0) {
            this.f480f = 0;
        }
        if (this.f480f == 0) {
            C1341p.m4658b("Lock count is 0, unbind service", f475c);
            m733f();
        }
    }

    /* renamed from: a */
    protected synchronized void m734a(Runnable runnable) {
        if (this.f477b == null) {
            this.f478d.add(runnable);
            m732b();
        } else {
            m737d();
            runnable.run();
        }
    }
}
