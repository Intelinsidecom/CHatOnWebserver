package com.sec.chaton.control;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractServiceWrapper {

    /* renamed from: c */
    private static final String f1350c = AbstractServiceWrapper.class.getSimpleName();

    /* renamed from: a */
    protected String f1351a;

    /* renamed from: b */
    protected Object f1352b;

    /* renamed from: e */
    private boolean f1354e;

    /* renamed from: g */
    private ServiceConnection f1356g = new ServiceConnectionC0174c(this);

    /* renamed from: d */
    private List f1353d = new ArrayList();

    /* renamed from: f */
    private int f1355f = 0;

    public AbstractServiceWrapper(String str) {
        this.f1351a = str;
    }

    /* renamed from: a */
    private synchronized void m1980a() {
        if (!this.f1354e || this.f1352b == null) {
            this.f1354e = true;
            GlobalApplication.m2387e().bindService(new Intent(this.f1351a), this.f1356g, 1);
        }
    }

    /* renamed from: b */
    private synchronized void m1982b() {
        if (this.f1352b != null) {
            try {
                GlobalApplication.m2387e().unbindService(this.f1356g);
            } catch (Throwable th) {
            }
            this.f1352b = null;
        }
    }

    /* renamed from: a */
    protected synchronized void m1984a(Runnable runnable) {
        if (this.f1352b == null) {
            this.f1353d.add(runnable);
            m1980a();
        } else {
            m1987d();
            runnable.run();
        }
    }

    /* renamed from: b */
    protected abstract Object mo1985b(IBinder iBinder);

    /* renamed from: c */
    protected synchronized void m1986c() {
        ChatONLogWriter.m3506b("Clear lock count", f1350c);
        this.f1355f = 0;
    }

    /* renamed from: d */
    protected synchronized void m1987d() {
        ChatONLogWriter.m3506b("Lock service. count: " + (this.f1355f + 1), f1350c);
        this.f1355f++;
    }

    /* renamed from: e */
    protected synchronized void m1988e() {
        ChatONLogWriter.m3506b("Release service. count: " + (this.f1355f - 1), f1350c);
        this.f1355f--;
        if (this.f1355f < 0) {
            this.f1355f = 0;
        }
        if (this.f1355f == 0) {
            ChatONLogWriter.m3506b("Lock count is 0, unbind service", f1350c);
            m1982b();
        }
    }
}
