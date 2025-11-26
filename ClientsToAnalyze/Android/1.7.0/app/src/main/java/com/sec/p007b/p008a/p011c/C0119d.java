package com.sec.p007b.p008a.p011c;

import android.os.Looper;
import android.view.View;
import com.sec.p007b.p008a.C0111b;
import com.sec.p007b.p008a.p009a.C0109a;
import com.sec.p007b.p008a.p009a.InterfaceC0110b;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.b.a.c.d */
/* loaded from: classes.dex */
public final class C0119d {

    /* renamed from: c */
    private static final String f220c = C0119d.class.getSimpleName();

    /* renamed from: a */
    protected final Map f221a;

    /* renamed from: b */
    protected final HandlerC0117b f222b;

    /* renamed from: d */
    private final int f223d;

    /* renamed from: e */
    private final Object f224e;

    /* renamed from: f */
    private final ThreadFactory f225f;

    /* renamed from: g */
    private final ExecutorService f226g;

    /* renamed from: h */
    private final InterfaceC0110b f227h;

    /* renamed from: i */
    private InterfaceC0116a f228i;

    public C0119d() {
        this(new C0109a());
    }

    public C0119d(C0109a c0109a) {
        this.f223d = 60;
        this.f224e = new Object();
        this.f221a = new WeakHashMap();
        this.f227h = c0109a;
        this.f225f = new ThreadFactoryC0118c(this);
        this.f226g = Executors.newSingleThreadExecutor(this.f225f);
        this.f222b = new HandlerC0117b(this, this, Looper.getMainLooper());
    }

    /* renamed from: a */
    public void m603a(View view, AbstractRunnableC0120e abstractRunnableC0120e) {
        synchronized (this.f224e) {
            abstractRunnableC0120e.m607a(this);
            abstractRunnableC0120e.m606a(view);
            AbstractRunnableC0120e abstractRunnableC0120e2 = (AbstractRunnableC0120e) this.f221a.remove(view);
            if (abstractRunnableC0120e2 != null) {
                Future futureM615h = abstractRunnableC0120e2.m615h();
                if (abstractRunnableC0120e2.equals(abstractRunnableC0120e)) {
                    abstractRunnableC0120e.m609a(futureM615h);
                } else if (m595a(futureM615h)) {
                    futureM615h.cancel(true);
                }
            }
            if (abstractRunnableC0120e.m615h() == null) {
                Object objM597b = m597b(abstractRunnableC0120e);
                if (objM597b != null) {
                    abstractRunnableC0120e.mo608a(objM597b, true);
                    if (this.f228i != null) {
                        this.f228i.m590b(view, abstractRunnableC0120e);
                    }
                } else {
                    m600c(abstractRunnableC0120e2);
                    abstractRunnableC0120e.mo605a();
                    abstractRunnableC0120e.m609a(this.f226g.submit(abstractRunnableC0120e));
                }
            }
            this.f221a.put(view, abstractRunnableC0120e);
        }
    }

    /* renamed from: a */
    public void m602a(View view) {
        synchronized (this.f224e) {
            AbstractRunnableC0120e abstractRunnableC0120e = (AbstractRunnableC0120e) this.f221a.remove(view);
            if (abstractRunnableC0120e != null) {
                Future futureM615h = abstractRunnableC0120e.m615h();
                if (m595a(futureM615h)) {
                    futureM615h.cancel(true);
                }
            }
        }
    }

    /* renamed from: a */
    public void m601a() {
        synchronized (this.f224e) {
            try {
                try {
                    this.f226g.shutdownNow();
                    if (!this.f226g.awaitTermination(60L, TimeUnit.SECONDS) && C0111b.f208a.f212d) {
                        C0111b.f208a.m586d(f220c, "Thread pool isn't terminated.");
                    }
                } finally {
                    if (this.f221a.size() > 0) {
                        Iterator it = this.f221a.values().iterator();
                        while (it.hasNext()) {
                            ((AbstractRunnableC0120e) it.next()).mo611c();
                        }
                    }
                    this.f221a.clear();
                    this.f227h.mo580a();
                }
            } catch (InterruptedException e) {
                this.f226g.shutdownNow();
                Thread.currentThread().interrupt();
                if (this.f221a.size() > 0) {
                    Iterator it2 = this.f221a.values().iterator();
                    while (it2.hasNext()) {
                        ((AbstractRunnableC0120e) it2.next()).mo611c();
                    }
                }
                this.f221a.clear();
                this.f227h.mo580a();
            }
        }
    }

    /* renamed from: a */
    private boolean m595a(Future future) {
        return (future == null || future.isCancelled() || future.isDone()) ? false : true;
    }

    /* renamed from: b */
    private Object m597b(AbstractRunnableC0120e abstractRunnableC0120e) {
        return this.f227h.mo579a(abstractRunnableC0120e.m613f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m600c(AbstractRunnableC0120e abstractRunnableC0120e) {
        if (abstractRunnableC0120e != null && abstractRunnableC0120e.m614g() != null && m597b(abstractRunnableC0120e) == null) {
            abstractRunnableC0120e.mo611c();
        }
    }

    /* renamed from: a */
    void m604a(AbstractRunnableC0120e abstractRunnableC0120e) {
        this.f222b.m592a(abstractRunnableC0120e, abstractRunnableC0120e.m616i());
    }
}
