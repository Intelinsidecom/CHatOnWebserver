package com.sec.common.p132g;

import android.content.Context;
import android.view.View;
import com.sec.common.CommonApplication;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: AbstractResourceDispatcherTask.java */
/* renamed from: com.sec.common.g.a */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC5005a<TK> implements Runnable {

    /* renamed from: a */
    private Future<?> f18258a;

    /* renamed from: b */
    private boolean f18259b;

    /* renamed from: c */
    private C5007c f18260c;

    /* renamed from: f */
    protected WeakReference<View> f18261f;

    /* renamed from: g */
    protected TK f18262g;

    /* renamed from: h */
    protected Object f18263h;

    /* renamed from: a */
    public abstract void mo7443a(Object obj, boolean z);

    /* renamed from: c */
    public abstract Object mo7444c();

    /* renamed from: d */
    public abstract void mo7445d();

    /* renamed from: m_ */
    public abstract void mo7450m_();

    public AbstractRunnableC5005a(TK tk) {
        this.f18262g = tk;
    }

    /* renamed from: j */
    public TK m18996j() {
        return this.f18262g;
    }

    /* renamed from: h */
    public View mo7449h() {
        if (this.f18261f != null) {
            return this.f18261f.get();
        }
        return null;
    }

    /* renamed from: a */
    public void m18990a(View view) {
        this.f18261f = new WeakReference<>(view);
    }

    /* renamed from: g */
    public Object mo7448g() {
        return this.f18263h;
    }

    /* renamed from: k */
    public Context m18997k() {
        return CommonApplication.m18732r();
    }

    /* renamed from: a */
    public void m18992a(Object obj) {
        this.f18263h = obj;
    }

    /* renamed from: a */
    public void m18991a(C5007c c5007c) {
        this.f18260c = c5007c;
    }

    /* renamed from: l */
    public Future<?> m18998l() {
        return this.f18258a;
    }

    /* renamed from: a */
    public void m18994a(Future<?> future) {
        this.f18258a = future;
    }

    /* renamed from: m */
    public boolean m18999m() {
        return this.f18259b;
    }

    /* renamed from: a */
    void m18995a(boolean z) {
        this.f18259b = z;
    }

    /* renamed from: i */
    public boolean mo11696i() {
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f18263h = mo7444c();
            if (this.f18263h != null && mo11696i()) {
                this.f18259b = true;
            }
            this.f18260c.m19017a((AbstractRunnableC5005a<?>) this);
        } catch (Throwable th) {
            this.f18260c.m19017a((AbstractRunnableC5005a<?>) this);
        }
    }

    /* renamed from: a */
    protected void m18993a(Callable<Void> callable, long j) {
        this.f18260c.m19018a((AbstractRunnableC5005a<?>) this, callable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractRunnableC5005a) && m18996j().equals(((AbstractRunnableC5005a) obj).m18996j());
    }

    public int hashCode() {
        TK tkM18996j = m18996j();
        return tkM18996j == null ? super.hashCode() : tkM18996j.hashCode();
    }
}
