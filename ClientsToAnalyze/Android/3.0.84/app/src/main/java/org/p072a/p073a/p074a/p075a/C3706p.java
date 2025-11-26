package org.p072a.p073a.p074a.p075a;

import java.util.NoSuchElementException;
import java.util.Stack;
import org.p072a.p073a.p074a.AbstractC3708c;
import org.p072a.p073a.p074a.C3712g;
import org.p072a.p073a.p074a.InterfaceC3711f;
import org.p072a.p073a.p074a.InterfaceC3713h;

/* compiled from: StackObjectPool.java */
/* renamed from: org.a.a.a.a.p */
/* loaded from: classes.dex */
public class C3706p<T> extends AbstractC3708c<T> implements InterfaceC3711f<T> {

    /* renamed from: a */
    @Deprecated
    protected Stack<T> f13678a;

    /* renamed from: b */
    @Deprecated
    protected InterfaceC3713h<T> f13679b;

    /* renamed from: c */
    @Deprecated
    protected int f13680c;

    /* renamed from: d */
    @Deprecated
    protected int f13681d;

    @Deprecated
    public C3706p() {
        this(null, 8, 4);
    }

    public C3706p(InterfaceC3713h<T> interfaceC3713h) {
        this(interfaceC3713h, 8, 4);
    }

    public C3706p(InterfaceC3713h<T> interfaceC3713h, int i, int i2) {
        this.f13678a = null;
        this.f13679b = null;
        this.f13680c = 8;
        this.f13681d = 0;
        this.f13679b = interfaceC3713h;
        this.f13680c = i < 0 ? 8 : i;
        i2 = i2 < 1 ? 4 : i2;
        this.f13678a = new Stack<>();
        this.f13678a.ensureCapacity(i2 > this.f13680c ? this.f13680c : i2);
    }

    @Override // org.p072a.p073a.p074a.InterfaceC3711f
    /* renamed from: c */
    public synchronized T mo13370c() {
        T tMo11841b;
        boolean z;
        m13375b();
        boolean z2 = false;
        tMo11841b = null;
        while (tMo11841b == null) {
            if (!this.f13678a.empty()) {
                tMo11841b = this.f13678a.pop();
                z = z2;
            } else {
                if (this.f13679b == null) {
                    throw new NoSuchElementException();
                }
                tMo11841b = this.f13679b.mo11841b();
                z = true;
                if (tMo11841b == null) {
                    throw new NoSuchElementException("PoolableObjectFactory.makeObject() returned null.");
                }
            }
            if (this.f13679b == null || tMo11841b == null) {
                z2 = z;
            } else {
                try {
                    this.f13679b.mo13378d(tMo11841b);
                } catch (Throwable th) {
                    C3712g.m13379a(th);
                    try {
                        this.f13679b.mo13376b(tMo11841b);
                    } catch (Throwable th2) {
                        C3712g.m13379a(th2);
                    }
                    if (z) {
                        throw new NoSuchElementException("Could not create a validated object, cause: " + th.getMessage());
                    }
                    z2 = z;
                    tMo11841b = null;
                }
                if (!this.f13679b.mo13377c(tMo11841b)) {
                    throw new Exception("ValidateObject failed");
                }
                z2 = z;
            }
        }
        this.f13681d++;
        return tMo11841b;
    }

    @Override // org.p072a.p073a.p074a.InterfaceC3711f
    /* renamed from: a */
    public synchronized void mo13369a(T t) {
        synchronized (this) {
            boolean z = !m13374a();
            if (this.f13679b != null) {
                if (this.f13679b.mo13377c(t)) {
                    try {
                        this.f13679b.mo11840a(t);
                    } catch (Exception e) {
                        z = false;
                    }
                } else {
                    z = false;
                }
            }
            boolean z2 = z ? false : true;
            this.f13681d--;
            if (z) {
                T tRemove = null;
                if (this.f13678a.size() >= this.f13680c) {
                    tRemove = this.f13678a.remove(0);
                    z2 = true;
                }
                this.f13678a.push(t);
                t = tRemove;
            }
            notifyAll();
            if (z2) {
                try {
                    this.f13679b.mo13376b(t);
                } catch (Exception e2) {
                }
            }
        }
    }
}
