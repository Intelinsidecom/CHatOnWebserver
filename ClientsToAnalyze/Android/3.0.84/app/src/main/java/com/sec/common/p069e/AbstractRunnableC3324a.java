package com.sec.common.p069e;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: AbstractResourceDispatcherTask.java */
/* renamed from: com.sec.common.e.a */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC3324a<TK> implements Runnable {

    /* renamed from: a */
    private Future<?> f12009a;

    /* renamed from: b */
    private boolean f12010b;

    /* renamed from: c */
    private C3326c f12011c;

    /* renamed from: f */
    protected View f12012f;

    /* renamed from: g */
    protected TK f12013g;

    /* renamed from: h */
    protected Object f12014h;

    /* renamed from: a */
    public abstract void mo4331a(Object obj, boolean z);

    /* renamed from: b */
    public abstract void mo4332b();

    /* renamed from: c */
    public abstract Object mo4333c();

    /* renamed from: d */
    public abstract void mo4334d();

    public AbstractRunnableC3324a(TK tk) {
        this.f12013g = tk;
    }

    /* renamed from: i */
    public TK mo7454i() {
        return this.f12013g;
    }

    /* renamed from: h */
    public View mo4338h() {
        return this.f12012f;
    }

    /* renamed from: a */
    public void m11708a(View view) {
        this.f12012f = view;
    }

    /* renamed from: g */
    public Object mo4337g() {
        return this.f12014h;
    }

    /* renamed from: k */
    public Context m11714k() {
        return this.f12012f.getContext();
    }

    /* renamed from: a */
    public void m11710a(Object obj) {
        this.f12014h = obj;
    }

    /* renamed from: a */
    public void m11709a(C3326c c3326c) {
        this.f12011c = c3326c;
    }

    /* renamed from: l */
    public Future<?> m11715l() {
        return this.f12009a;
    }

    /* renamed from: a */
    public void m11712a(Future<?> future) {
        this.f12009a = future;
    }

    /* renamed from: m */
    public boolean m11716m() {
        return this.f12010b;
    }

    /* renamed from: a */
    void m11713a(boolean z) {
        this.f12010b = z;
    }

    /* renamed from: j */
    public boolean mo7491j() {
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f12014h = mo4333c();
            if (this.f12014h != null && mo7491j()) {
                this.f12010b = true;
            }
            this.f12011c.m11733a((AbstractRunnableC3324a<?>) this);
        } catch (Throwable th) {
            this.f12011c.m11733a((AbstractRunnableC3324a<?>) this);
        }
    }

    /* renamed from: a */
    protected void m11711a(Callable<Void> callable, long j) {
        this.f12011c.m11734a((AbstractRunnableC3324a<?>) this, callable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractRunnableC3324a) && mo7454i().equals(((AbstractRunnableC3324a) obj).mo7454i());
    }
}
