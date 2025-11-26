package com.sec.common.p056b.p059c;

import android.os.Looper;
import android.view.View;
import com.sec.common.p056b.C1825d;
import com.sec.common.p056b.p058b.C1818b;
import com.sec.common.p056b.p058b.InterfaceC1817a;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.common.b.c.b */
/* loaded from: classes.dex */
public final class C1821b {

    /* renamed from: c */
    private static final String f6526c = C1821b.class.getSimpleName();

    /* renamed from: a */
    protected final Map f6527a;

    /* renamed from: b */
    protected final HandlerC1823d f6528b;

    /* renamed from: d */
    private final int f6529d;

    /* renamed from: e */
    private final Object f6530e;

    /* renamed from: f */
    private final ExecutorService f6531f;

    /* renamed from: g */
    private final InterfaceC1817a f6532g;

    /* renamed from: h */
    private InterfaceC1824e f6533h;

    public C1821b() {
        this(new C1818b(), Executors.newSingleThreadExecutor(new ThreadFactoryC1822c()));
    }

    public C1821b(ExecutorService executorService) {
        this(new C1818b(), executorService);
    }

    public C1821b(C1818b c1818b, ExecutorService executorService) {
        this.f6529d = 60;
        this.f6530e = new Object();
        this.f6527a = new WeakHashMap();
        this.f6532g = c1818b;
        this.f6531f = executorService;
        this.f6528b = new HandlerC1823d(this, this, Looper.getMainLooper());
    }

    /* renamed from: a */
    public AbstractRunnableC1820a m6190a(View view, AbstractRunnableC1820a abstractRunnableC1820a) {
        synchronized (this.f6530e) {
            abstractRunnableC1820a.m6173a(this);
            abstractRunnableC1820a.m6172a(view);
            AbstractRunnableC1820a abstractRunnableC1820a2 = (AbstractRunnableC1820a) this.f6527a.remove(view);
            if (abstractRunnableC1820a2 != null) {
                Future futureM6180l = abstractRunnableC1820a2.m6180l();
                if (abstractRunnableC1820a2.equals(abstractRunnableC1820a)) {
                    abstractRunnableC1820a = abstractRunnableC1820a2;
                } else if (m6184a(futureM6180l)) {
                    futureM6180l.cancel(true);
                } else {
                    m6189c(abstractRunnableC1820a2);
                }
            }
            if (abstractRunnableC1820a.m6180l() == null) {
                Object objM6186b = m6186b(abstractRunnableC1820a);
                if (objM6186b != null) {
                    abstractRunnableC1820a.m6174a(objM6186b);
                    abstractRunnableC1820a.m6177a(true);
                    abstractRunnableC1820a.mo3767a(objM6186b, true);
                    if (this.f6533h != null) {
                        this.f6533h.mo3702b(view, abstractRunnableC1820a);
                    }
                } else {
                    abstractRunnableC1820a.mo3768b();
                    abstractRunnableC1820a.m6176a((Future) this.f6531f.submit(abstractRunnableC1820a));
                }
            }
            this.f6527a.put(view, abstractRunnableC1820a);
        }
        return abstractRunnableC1820a;
    }

    /* renamed from: a */
    public void m6192a(View view) {
        synchronized (this.f6530e) {
            AbstractRunnableC1820a abstractRunnableC1820a = (AbstractRunnableC1820a) this.f6527a.remove(view);
            if (abstractRunnableC1820a != null) {
                Future futureM6180l = abstractRunnableC1820a.m6180l();
                if (m6184a(futureM6180l)) {
                    futureM6180l.cancel(true);
                } else {
                    m6189c(abstractRunnableC1820a);
                }
            }
        }
    }

    /* renamed from: a */
    public void m6191a() {
        synchronized (this.f6530e) {
            try {
                try {
                    this.f6531f.shutdownNow();
                    if (!this.f6531f.awaitTermination(60L, TimeUnit.SECONDS) && C1825d.f6539a.f6543d) {
                        C1825d.f6539a.m6202b(f6526c, "Thread pool isn't terminated.");
                    }
                    if (this.f6527a.size() > 0) {
                        Iterator it = this.f6527a.values().iterator();
                        while (it.hasNext()) {
                            ((AbstractRunnableC1820a) it.next()).mo3770d();
                        }
                    }
                    this.f6527a.clear();
                    this.f6532g.mo6166a();
                } catch (InterruptedException e) {
                    this.f6531f.shutdownNow();
                    Thread.currentThread().interrupt();
                    if (this.f6527a.size() > 0) {
                        Iterator it2 = this.f6527a.values().iterator();
                        while (it2.hasNext()) {
                            ((AbstractRunnableC1820a) it2.next()).mo3770d();
                        }
                    }
                    this.f6527a.clear();
                    this.f6532g.mo6166a();
                }
            } catch (Throwable th) {
                if (this.f6527a.size() > 0) {
                    Iterator it3 = this.f6527a.values().iterator();
                    while (it3.hasNext()) {
                        ((AbstractRunnableC1820a) it3.next()).mo3770d();
                    }
                }
                this.f6527a.clear();
                this.f6532g.mo6166a();
                throw th;
            }
        }
    }

    /* renamed from: a */
    public void m6195a(InterfaceC1824e interfaceC1824e) {
        this.f6533h = interfaceC1824e;
    }

    /* renamed from: a */
    private boolean m6184a(Future future) {
        return (future == null || future.isCancelled() || future.isDone()) ? false : true;
    }

    /* renamed from: b */
    private Object m6186b(AbstractRunnableC1820a abstractRunnableC1820a) {
        return this.f6532g.mo6165a(abstractRunnableC1820a.m6178j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6189c(AbstractRunnableC1820a abstractRunnableC1820a) {
        if (abstractRunnableC1820a != null && abstractRunnableC1820a.mo3774h() != null && m6186b(abstractRunnableC1820a) == null) {
            abstractRunnableC1820a.mo3770d();
        }
    }

    /* renamed from: a */
    void m6193a(AbstractRunnableC1820a abstractRunnableC1820a) {
        this.f6528b.m6196a(abstractRunnableC1820a, abstractRunnableC1820a.m6181m());
    }

    /* renamed from: a */
    void m6194a(AbstractRunnableC1820a abstractRunnableC1820a, Callable callable) {
        this.f6528b.m6198a(abstractRunnableC1820a, callable);
    }
}
