package com.facebook.p033c;

import com.facebook.C0498bu;
import java.util.concurrent.Executor;

/* compiled from: WorkQueue.java */
/* renamed from: com.facebook.c.x */
/* loaded from: classes.dex */
public class C0527x {

    /* renamed from: a */
    static final /* synthetic */ boolean f1324a;

    /* renamed from: b */
    private final Object f1325b;

    /* renamed from: c */
    private C0504aa f1326c;

    /* renamed from: d */
    private final int f1327d;

    /* renamed from: e */
    private final Executor f1328e;

    /* renamed from: f */
    private C0504aa f1329f;

    /* renamed from: g */
    private int f1330g;

    static {
        f1324a = !C0527x.class.desiredAssertionStatus();
    }

    C0527x() {
        this(8);
    }

    C0527x(int i) {
        this(i, C0498bu.m1808a());
    }

    C0527x(int i, Executor executor) {
        this.f1325b = new Object();
        this.f1329f = null;
        this.f1330g = 0;
        this.f1327d = i;
        this.f1328e = executor;
    }

    /* renamed from: a */
    InterfaceC0529z m1916a(Runnable runnable) {
        return m1917a(runnable, true);
    }

    /* renamed from: a */
    InterfaceC0529z m1917a(Runnable runnable, boolean z) {
        C0504aa c0504aa = new C0504aa(this, runnable);
        synchronized (this.f1325b) {
            this.f1326c = c0504aa.m1858a(this.f1326c, z);
        }
        m1910a();
        return c0504aa;
    }

    /* renamed from: a */
    private void m1910a() {
        m1911a((C0504aa) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1911a(C0504aa c0504aa) {
        C0504aa c0504aa2 = null;
        synchronized (this.f1325b) {
            if (c0504aa != null) {
                this.f1329f = c0504aa.m1857a(this.f1329f);
                this.f1330g--;
                if (this.f1330g < this.f1327d && (c0504aa2 = this.f1326c) != null) {
                    this.f1326c = c0504aa2.m1857a(this.f1326c);
                    this.f1329f = c0504aa2.m1858a(this.f1329f, false);
                    this.f1330g++;
                    c0504aa2.m1860a(true);
                }
            } else if (this.f1330g < this.f1327d) {
                this.f1326c = c0504aa2.m1857a(this.f1326c);
                this.f1329f = c0504aa2.m1858a(this.f1329f, false);
                this.f1330g++;
                c0504aa2.m1860a(true);
            }
        }
        if (c0504aa2 != null) {
            m1915b(c0504aa2);
        }
    }

    /* renamed from: b */
    private void m1915b(C0504aa c0504aa) {
        this.f1328e.execute(new RunnableC0528y(this, c0504aa));
    }
}
