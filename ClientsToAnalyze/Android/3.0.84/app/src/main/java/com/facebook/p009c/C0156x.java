package com.facebook.p009c;

import com.facebook.C0127bu;
import java.util.concurrent.Executor;

/* compiled from: WorkQueue.java */
/* renamed from: com.facebook.c.x */
/* loaded from: classes.dex */
public class C0156x {

    /* renamed from: a */
    static final /* synthetic */ boolean f354a;

    /* renamed from: b */
    private final Object f355b;

    /* renamed from: c */
    private C0133aa f356c;

    /* renamed from: d */
    private final int f357d;

    /* renamed from: e */
    private final Executor f358e;

    /* renamed from: f */
    private C0133aa f359f;

    /* renamed from: g */
    private int f360g;

    static {
        f354a = !C0156x.class.desiredAssertionStatus();
    }

    C0156x() {
        this(8);
    }

    C0156x(int i) {
        this(i, C0127bu.m365a());
    }

    C0156x(int i, Executor executor) {
        this.f355b = new Object();
        this.f359f = null;
        this.f360g = 0;
        this.f357d = i;
        this.f358e = executor;
    }

    /* renamed from: a */
    InterfaceC0158z m473a(Runnable runnable) {
        return m474a(runnable, true);
    }

    /* renamed from: a */
    InterfaceC0158z m474a(Runnable runnable, boolean z) {
        C0133aa c0133aa = new C0133aa(this, runnable);
        synchronized (this.f355b) {
            this.f356c = c0133aa.m415a(this.f356c, z);
        }
        m467a();
        return c0133aa;
    }

    /* renamed from: a */
    private void m467a() {
        m468a((C0133aa) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m468a(C0133aa c0133aa) {
        C0133aa c0133aa2 = null;
        synchronized (this.f355b) {
            if (c0133aa != null) {
                this.f359f = c0133aa.m414a(this.f359f);
                this.f360g--;
                if (this.f360g < this.f357d && (c0133aa2 = this.f356c) != null) {
                    this.f356c = c0133aa2.m414a(this.f356c);
                    this.f359f = c0133aa2.m415a(this.f359f, false);
                    this.f360g++;
                    c0133aa2.m417a(true);
                }
            } else if (this.f360g < this.f357d) {
                this.f356c = c0133aa2.m414a(this.f356c);
                this.f359f = c0133aa2.m415a(this.f359f, false);
                this.f360g++;
                c0133aa2.m417a(true);
            }
        }
        if (c0133aa2 != null) {
            m472b(c0133aa2);
        }
    }

    /* renamed from: b */
    private void m472b(C0133aa c0133aa) {
        this.f358e.execute(new RunnableC0157y(this, c0133aa));
    }
}
