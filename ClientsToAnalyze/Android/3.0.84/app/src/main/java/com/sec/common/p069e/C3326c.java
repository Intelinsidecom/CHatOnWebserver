package com.sec.common.p069e;

import android.os.Looper;
import android.view.View;
import com.sec.common.C3330f;
import com.sec.common.p064b.C3309b;
import com.sec.common.p064b.InterfaceC3308a;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.common.e.c */
/* loaded from: classes.dex */
public final class C3326c {

    /* renamed from: c */
    private static final String f12020c = C3326c.class.getSimpleName();

    /* renamed from: a */
    protected final Map<View, AbstractRunnableC3324a<?>> f12021a;

    /* renamed from: b */
    protected final HandlerC3328e f12022b;

    /* renamed from: d */
    private final int f12023d;

    /* renamed from: e */
    private final Object f12024e;

    /* renamed from: f */
    private final ExecutorService f12025f;

    /* renamed from: g */
    private final InterfaceC3308a<Object, Object> f12026g;

    /* renamed from: h */
    private InterfaceC3329f f12027h;

    public C3326c() {
        this(new C3309b(), Executors.newSingleThreadExecutor(new ThreadFactoryC3327d()));
    }

    public C3326c(ExecutorService executorService) {
        this(new C3309b(), executorService);
    }

    public C3326c(C3309b<Object, Object> c3309b, ExecutorService executorService) {
        this.f12023d = 60;
        this.f12024e = new Object();
        this.f12021a = new WeakHashMap();
        this.f12026g = c3309b;
        this.f12025f = executorService;
        this.f12022b = new HandlerC3328e(this, this, Looper.getMainLooper());
    }

    /* renamed from: a */
    public AbstractRunnableC3324a<?> m11730a(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        synchronized (this.f12024e) {
            abstractRunnableC3324a.m11709a(this);
            abstractRunnableC3324a.m11708a(view);
            AbstractRunnableC3324a<?> abstractRunnableC3324aRemove = this.f12021a.remove(view);
            if (abstractRunnableC3324aRemove != null) {
                Future<?> futureM11715l = abstractRunnableC3324aRemove.m11715l();
                if (abstractRunnableC3324aRemove.equals(abstractRunnableC3324a)) {
                    abstractRunnableC3324a = abstractRunnableC3324aRemove;
                } else if (m11724a(futureM11715l)) {
                    futureM11715l.cancel(true);
                } else {
                    m11729c(abstractRunnableC3324aRemove);
                }
            }
            if (abstractRunnableC3324a.m11715l() == null) {
                Object objM11726b = m11726b(abstractRunnableC3324a);
                if (objM11726b != null) {
                    abstractRunnableC3324a.m11710a(objM11726b);
                    abstractRunnableC3324a.m11713a(true);
                    abstractRunnableC3324a.mo4331a(objM11726b, true);
                    if (this.f12027h != null) {
                        this.f12027h.mo3722b(view, abstractRunnableC3324a);
                    }
                } else {
                    abstractRunnableC3324a.mo4332b();
                    abstractRunnableC3324a.m11712a(this.f12025f.submit(abstractRunnableC3324a));
                }
            }
            this.f12021a.put(view, abstractRunnableC3324a);
        }
        return abstractRunnableC3324a;
    }

    /* renamed from: a */
    public void m11732a(View view) {
        synchronized (this.f12024e) {
            AbstractRunnableC3324a<?> abstractRunnableC3324aRemove = this.f12021a.remove(view);
            if (abstractRunnableC3324aRemove != null) {
                Future<?> futureM11715l = abstractRunnableC3324aRemove.m11715l();
                if (m11724a(futureM11715l)) {
                    futureM11715l.cancel(true);
                } else {
                    m11729c(abstractRunnableC3324aRemove);
                }
            }
        }
    }

    /* renamed from: a */
    public void m11731a() {
        synchronized (this.f12024e) {
            try {
                try {
                    this.f12025f.shutdownNow();
                    if (!this.f12025f.awaitTermination(60L, TimeUnit.SECONDS) && C3330f.f12033a.f11974d) {
                        C3330f.f12033a.m11656c(f12020c, "Thread pool isn't terminated.");
                    }
                } finally {
                    if (this.f12021a.size() > 0) {
                        Iterator<AbstractRunnableC3324a<?>> it = this.f12021a.values().iterator();
                        while (it.hasNext()) {
                            it.next().mo4334d();
                        }
                    }
                    this.f12021a.clear();
                    this.f12026g.mo11649a();
                }
            } catch (InterruptedException e) {
                this.f12025f.shutdownNow();
                Thread.currentThread().interrupt();
                if (this.f12021a.size() > 0) {
                    Iterator<AbstractRunnableC3324a<?>> it2 = this.f12021a.values().iterator();
                    while (it2.hasNext()) {
                        it2.next().mo4334d();
                    }
                }
                this.f12021a.clear();
                this.f12026g.mo11649a();
            }
        }
    }

    /* renamed from: a */
    public void m11735a(InterfaceC3329f interfaceC3329f) {
        synchronized (this.f12024e) {
            this.f12027h = interfaceC3329f;
        }
    }

    /* renamed from: a */
    private boolean m11724a(Future<?> future) {
        return (future == null || future.isCancelled() || future.isDone()) ? false : true;
    }

    /* renamed from: b */
    private Object m11726b(AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        Object objMo11648a;
        synchronized (this.f12024e) {
            objMo11648a = this.f12026g.mo11648a(abstractRunnableC3324a.mo7454i());
        }
        return objMo11648a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11729c(AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        if (abstractRunnableC3324a != null && abstractRunnableC3324a.mo4337g() != null && m11726b(abstractRunnableC3324a) == null) {
            abstractRunnableC3324a.mo4334d();
        }
    }

    /* renamed from: a */
    void m11733a(AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        this.f12022b.m11736a((AbstractRunnableC3324a<?>) abstractRunnableC3324a, abstractRunnableC3324a.m11716m());
    }

    /* renamed from: a */
    void m11734a(AbstractRunnableC3324a<?> abstractRunnableC3324a, Callable<Void> callable) {
        this.f12022b.m11738a(abstractRunnableC3324a, callable);
    }
}
