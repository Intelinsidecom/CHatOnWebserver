package org.p138a.p139a.p140a.p141a;

import java.util.NoSuchElementException;
import java.util.Stack;
import org.p138a.p139a.p140a.AbstractC5220c;
import org.p138a.p139a.p140a.C5224g;
import org.p138a.p139a.p140a.InterfaceC5223f;
import org.p138a.p139a.p140a.InterfaceC5225h;

/* compiled from: StackObjectPool.java */
/* renamed from: org.a.a.a.a.p */
/* loaded from: classes.dex */
public class C5218p<T> extends AbstractC5220c<T> implements InterfaceC5223f<T> {

    /* renamed from: a */
    @Deprecated
    protected Stack<T> f19033a;

    /* renamed from: b */
    @Deprecated
    protected InterfaceC5225h<T> f19034b;

    /* renamed from: c */
    @Deprecated
    protected int f19035c;

    /* renamed from: d */
    @Deprecated
    protected int f19036d;

    @Deprecated
    public C5218p() {
        this(null, 8, 4);
    }

    public C5218p(InterfaceC5225h<T> interfaceC5225h) {
        this(interfaceC5225h, 8, 4);
    }

    public C5218p(InterfaceC5225h<T> interfaceC5225h, int i, int i2) {
        this.f19033a = null;
        this.f19034b = null;
        this.f19035c = 8;
        this.f19036d = 0;
        this.f19034b = interfaceC5225h;
        this.f19035c = i < 0 ? 8 : i;
        i2 = i2 < 1 ? 4 : i2;
        this.f19033a = new Stack<>();
        this.f19033a.ensureCapacity(i2 > this.f19035c ? this.f19035c : i2);
    }

    @Override // org.p138a.p139a.p140a.InterfaceC5223f
    /* renamed from: c */
    public synchronized T mo19898c() {
        T tMo19178b;
        boolean z;
        m19903b();
        boolean z2 = false;
        tMo19178b = null;
        while (tMo19178b == null) {
            if (!this.f19033a.empty()) {
                tMo19178b = this.f19033a.pop();
                z = z2;
            } else {
                if (this.f19034b == null) {
                    throw new NoSuchElementException();
                }
                tMo19178b = this.f19034b.mo19178b();
                z = true;
                if (tMo19178b == null) {
                    throw new NoSuchElementException("PoolableObjectFactory.makeObject() returned null.");
                }
            }
            if (this.f19034b == null || tMo19178b == null) {
                z2 = z;
            } else {
                try {
                    this.f19034b.mo19906d(tMo19178b);
                } catch (Throwable th) {
                    C5224g.m19907a(th);
                    try {
                        this.f19034b.mo19904b(tMo19178b);
                    } catch (Throwable th2) {
                        C5224g.m19907a(th2);
                    }
                    if (z) {
                        throw new NoSuchElementException("Could not create a validated object, cause: " + th.getMessage());
                    }
                    z2 = z;
                    tMo19178b = null;
                }
                if (!this.f19034b.mo19905c(tMo19178b)) {
                    throw new Exception("ValidateObject failed");
                }
                z2 = z;
            }
        }
        this.f19036d++;
        return tMo19178b;
    }

    @Override // org.p138a.p139a.p140a.InterfaceC5223f
    /* renamed from: a */
    public synchronized void mo19897a(T t) {
        synchronized (this) {
            boolean z = !m19902a();
            if (this.f19034b != null) {
                if (this.f19034b.mo19905c(t)) {
                    try {
                        this.f19034b.mo19177a(t);
                    } catch (Exception e) {
                        z = false;
                    }
                } else {
                    z = false;
                }
            }
            boolean z2 = z ? false : true;
            this.f19036d--;
            if (z) {
                T tRemove = null;
                if (this.f19033a.size() >= this.f19035c) {
                    tRemove = this.f19033a.remove(0);
                    z2 = true;
                }
                this.f19033a.push(t);
                t = tRemove;
            }
            notifyAll();
            if (z2) {
                try {
                    this.f19034b.mo19904b(t);
                } catch (Exception e2) {
                }
            }
        }
    }
}
