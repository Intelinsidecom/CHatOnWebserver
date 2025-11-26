package com.sec.common.p132g;

import android.os.Looper;
import android.view.View;
import com.sec.common.C4996f;
import com.sec.common.p124b.C4971b;
import com.sec.common.p124b.InterfaceC4970a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: ResourceDispatcher.java */
/* renamed from: com.sec.common.g.c */
/* loaded from: classes.dex */
public final class C5007c {

    /* renamed from: c */
    private static final String f18269c = C5007c.class.getSimpleName();

    /* renamed from: a */
    protected final Map<View, AbstractRunnableC5005a<?>> f18270a;

    /* renamed from: b */
    protected final HandlerC5009e f18271b;

    /* renamed from: d */
    private final int f18272d;

    /* renamed from: e */
    private final Object f18273e;

    /* renamed from: f */
    private final ExecutorService f18274f;

    /* renamed from: g */
    private final InterfaceC4970a<Object, Object> f18275g;

    /* renamed from: h */
    private InterfaceC5010f f18276h;

    public C5007c() {
        this(new C4971b(), Executors.newSingleThreadExecutor(new ThreadFactoryC5008d()));
    }

    public C5007c(ExecutorService executorService) {
        this(new C4971b(), executorService);
    }

    public C5007c(InterfaceC4970a<Object, Object> interfaceC4970a, ExecutorService executorService) {
        this.f18272d = 60;
        this.f18273e = new Object();
        this.f18270a = new WeakHashMap();
        this.f18275g = interfaceC4970a;
        this.f18274f = executorService;
        this.f18271b = new HandlerC5009e(this, this, Looper.getMainLooper());
    }

    /* renamed from: a */
    public boolean m19022a(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        synchronized (this.f18273e) {
            AbstractRunnableC5005a<?> abstractRunnableC5005a2 = this.f18270a.get(view);
            Future<?> futureM18998l = null;
            if (abstractRunnableC5005a2 != null) {
                futureM18998l = abstractRunnableC5005a2.m18998l();
            }
            Object objM19010b = m19010b(abstractRunnableC5005a);
            if (objM19010b == null) {
                return abstractRunnableC5005a2 != null && abstractRunnableC5005a2.equals(abstractRunnableC5005a);
            }
            if (m19008a(futureM18998l)) {
                futureM18998l.cancel(true);
            } else {
                m19013c(abstractRunnableC5005a2);
            }
            abstractRunnableC5005a.m18991a(this);
            abstractRunnableC5005a.m18990a(view);
            abstractRunnableC5005a.m18992a(objM19010b);
            abstractRunnableC5005a.m18995a(true);
            abstractRunnableC5005a.mo7443a(objM19010b, true);
            if (this.f18276h != null) {
                this.f18276h.mo6860b(view, abstractRunnableC5005a);
            }
            this.f18270a.put(view, abstractRunnableC5005a);
            return true;
        }
    }

    /* renamed from: b */
    public AbstractRunnableC5005a<?> m19023b(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        synchronized (this.f18273e) {
            abstractRunnableC5005a.m18991a(this);
            abstractRunnableC5005a.m18990a(view);
            AbstractRunnableC5005a<?> abstractRunnableC5005aRemove = this.f18270a.remove(view);
            if (abstractRunnableC5005aRemove != null) {
                if (abstractRunnableC5005aRemove.equals(abstractRunnableC5005a)) {
                    abstractRunnableC5005a = abstractRunnableC5005aRemove;
                } else {
                    Future<?> futureM18998l = abstractRunnableC5005aRemove.m18998l();
                    if (m19008a(futureM18998l)) {
                        futureM18998l.cancel(true);
                    } else {
                        m19013c(abstractRunnableC5005aRemove);
                    }
                }
            }
            if (abstractRunnableC5005a.m18998l() == null && !abstractRunnableC5005a.m18999m()) {
                Object objM19010b = m19010b(abstractRunnableC5005a);
                if (objM19010b != null) {
                    abstractRunnableC5005a.m18992a(objM19010b);
                    abstractRunnableC5005a.m18995a(true);
                    abstractRunnableC5005a.mo7443a(objM19010b, true);
                    if (this.f18276h != null) {
                        this.f18276h.mo6860b(view, abstractRunnableC5005a);
                    }
                } else {
                    abstractRunnableC5005a.mo7450m_();
                    abstractRunnableC5005a.m18994a(this.f18274f.submit(abstractRunnableC5005a));
                }
            }
            this.f18270a.put(view, abstractRunnableC5005a);
        }
        return abstractRunnableC5005a;
    }

    /* renamed from: a */
    public void m19015a(View view) {
        m19016a(view, false);
    }

    /* renamed from: a */
    public void m19016a(View view, boolean z) {
        synchronized (this.f18273e) {
            AbstractRunnableC5005a<?> abstractRunnableC5005aRemove = this.f18270a.remove(view);
            if (abstractRunnableC5005aRemove != null) {
                Future<?> futureM18998l = abstractRunnableC5005aRemove.m18998l();
                if (m19008a(futureM18998l)) {
                    futureM18998l.cancel(true);
                } else {
                    m19013c(abstractRunnableC5005aRemove);
                }
                if (z) {
                    this.f18275g.mo18890b(abstractRunnableC5005aRemove.f18262g);
                }
            }
        }
    }

    /* renamed from: a */
    public void m19020a(Object obj) {
        m19021a(obj, false);
    }

    /* renamed from: a */
    public void m19021a(Object obj, boolean z) {
        synchronized (this.f18273e) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<View, AbstractRunnableC5005a<?>> entry : this.f18270a.entrySet()) {
                if (entry.getValue().m18996j().equals(obj)) {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m19016a((View) it.next(), z);
            }
        }
    }

    /* renamed from: a */
    public void m19014a() {
        synchronized (this.f18273e) {
            try {
                try {
                    this.f18274f.shutdownNow();
                    if (!this.f18274f.awaitTermination(60L, TimeUnit.SECONDS) && C4996f.f18229a.f18173e) {
                        C4996f.f18229a.m18894h(f18269c, "Thread pool isn't terminated.");
                    }
                } finally {
                    if (this.f18270a.size() > 0) {
                        Iterator<AbstractRunnableC5005a<?>> it = this.f18270a.values().iterator();
                        while (it.hasNext()) {
                            it.next().mo7445d();
                        }
                    }
                    this.f18270a.clear();
                    this.f18275g.mo18888a();
                }
            } catch (InterruptedException e) {
                this.f18274f.shutdownNow();
                Thread.currentThread().interrupt();
                if (this.f18270a.size() > 0) {
                    Iterator<AbstractRunnableC5005a<?>> it2 = this.f18270a.values().iterator();
                    while (it2.hasNext()) {
                        it2.next().mo7445d();
                    }
                }
                this.f18270a.clear();
                this.f18275g.mo18888a();
            }
        }
    }

    /* renamed from: a */
    public void m19019a(InterfaceC5010f interfaceC5010f) {
        synchronized (this.f18273e) {
            this.f18276h = interfaceC5010f;
        }
    }

    /* renamed from: a */
    private boolean m19008a(Future<?> future) {
        return (future == null || future.isCancelled() || future.isDone()) ? false : true;
    }

    /* renamed from: b */
    private Object m19010b(AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        Object objMo18887a;
        synchronized (this.f18273e) {
            objMo18887a = this.f18275g.mo18887a(abstractRunnableC5005a.m18996j());
        }
        return objMo18887a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m19013c(AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        if (abstractRunnableC5005a != null && abstractRunnableC5005a.mo7448g() != null && m19010b(abstractRunnableC5005a) == null) {
            abstractRunnableC5005a.mo7445d();
        }
    }

    /* renamed from: a */
    void m19017a(AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        this.f18271b.m19024a((AbstractRunnableC5005a<?>) abstractRunnableC5005a, abstractRunnableC5005a.m18999m());
    }

    /* renamed from: a */
    void m19018a(AbstractRunnableC5005a<?> abstractRunnableC5005a, Callable<Void> callable) {
        this.f18271b.m19026a(abstractRunnableC5005a, callable);
    }
}
