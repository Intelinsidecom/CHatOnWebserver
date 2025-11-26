package com.sec.common.p056b.p059c;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: AbstractResourceDispatcherTask.java */
/* renamed from: com.sec.common.b.c.a */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1820a implements Runnable {

    /* renamed from: a */
    private Future f6520a;

    /* renamed from: b */
    private boolean f6521b;

    /* renamed from: c */
    protected View f6522c;

    /* renamed from: d */
    protected Object f6523d;

    /* renamed from: e */
    protected Object f6524e;

    /* renamed from: f */
    private C1821b f6525f;

    /* renamed from: a */
    public abstract void mo3767a(Object obj, boolean z);

    /* renamed from: b */
    public abstract void mo3768b();

    /* renamed from: c */
    public abstract Object mo3769c();

    /* renamed from: d */
    public abstract void mo3770d();

    public AbstractRunnableC1820a(Object obj) {
        this.f6523d = obj;
    }

    /* renamed from: j */
    public Object m6178j() {
        return this.f6523d;
    }

    /* renamed from: i */
    public View mo3775i() {
        return this.f6522c;
    }

    /* renamed from: a */
    public void m6172a(View view) {
        this.f6522c = view;
    }

    /* renamed from: h */
    public Object mo3774h() {
        return this.f6524e;
    }

    /* renamed from: k */
    public Context m6179k() {
        return this.f6522c.getContext();
    }

    /* renamed from: a */
    public void m6174a(Object obj) {
        this.f6524e = obj;
    }

    /* renamed from: a */
    public void m6173a(C1821b c1821b) {
        this.f6525f = c1821b;
    }

    /* renamed from: l */
    public Future m6180l() {
        return this.f6520a;
    }

    /* renamed from: a */
    public void m6176a(Future future) {
        this.f6520a = future;
    }

    /* renamed from: m */
    public boolean m6181m() {
        return this.f6521b;
    }

    /* renamed from: a */
    void m6177a(boolean z) {
        this.f6521b = z;
    }

    /* renamed from: g */
    public boolean mo3773g() {
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f6524e = mo3769c();
            if (this.f6524e != null && mo3773g()) {
                this.f6521b = true;
            }
            this.f6525f.m6193a(this);
        } catch (Throwable th) {
            this.f6525f.m6193a(this);
        }
    }

    /* renamed from: a */
    protected void m6175a(Callable callable, long j) {
        this.f6525f.m6194a(this, callable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractRunnableC1820a) && m6178j().equals(((AbstractRunnableC1820a) obj).m6178j());
    }
}
