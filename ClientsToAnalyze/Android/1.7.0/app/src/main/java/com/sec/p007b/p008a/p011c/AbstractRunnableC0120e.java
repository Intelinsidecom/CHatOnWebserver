package com.sec.p007b.p008a.p011c;

import android.view.View;
import java.io.IOException;
import java.util.concurrent.Future;

/* compiled from: AbstractResourceDispatcherTask.java */
/* renamed from: com.sec.b.a.c.e */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC0120e implements Runnable {

    /* renamed from: a */
    protected View f229a;

    /* renamed from: b */
    protected Object f230b;

    /* renamed from: c */
    protected Object f231c;

    /* renamed from: d */
    private Future f232d;

    /* renamed from: e */
    private boolean f233e;

    /* renamed from: f */
    private C0119d f234f;

    /* renamed from: a */
    public abstract void mo605a();

    /* renamed from: a */
    public abstract void mo608a(Object obj, boolean z);

    /* renamed from: b */
    public abstract Object mo610b();

    /* renamed from: c */
    public abstract void mo611c();

    public AbstractRunnableC0120e(Object obj) {
        this.f230b = obj;
    }

    /* renamed from: f */
    public Object m613f() {
        return this.f230b;
    }

    /* renamed from: e */
    public View mo612e() {
        return this.f229a;
    }

    /* renamed from: a */
    public void m606a(View view) {
        this.f229a = view;
    }

    /* renamed from: g */
    public Object m614g() {
        return this.f231c;
    }

    /* renamed from: a */
    public void m607a(C0119d c0119d) {
        this.f234f = c0119d;
    }

    /* renamed from: h */
    public Future m615h() {
        return this.f232d;
    }

    /* renamed from: a */
    public void m609a(Future future) {
        this.f232d = future;
    }

    /* renamed from: i */
    public boolean m616i() {
        return this.f233e;
    }

    /* renamed from: j */
    public boolean m617j() {
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f231c = mo610b();
            if (this.f231c != null && m617j()) {
                this.f233e = true;
            }
            this.f234f.m604a(this);
        } catch (IOException e) {
            this.f234f.m604a(this);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractRunnableC0120e) && m613f().equals(((AbstractRunnableC0120e) obj).m613f());
    }
}
