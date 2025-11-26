package org.p138a.p139a.p140a;

/* compiled from: BaseKeyedObjectPool.java */
/* renamed from: org.a.a.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC5205a<K, V> {

    /* renamed from: a */
    private volatile boolean f18977a = false;

    /* renamed from: a */
    public void mo19814a(K k) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public int mo19813a() {
        return -1;
    }

    /* renamed from: b */
    public int mo19815b() {
        return -1;
    }

    /* renamed from: c */
    public void mo19816c() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: d */
    public void mo19817d() {
        this.f18977a = true;
    }

    /* renamed from: e */
    protected final boolean m19818e() {
        return this.f18977a;
    }

    /* renamed from: f */
    protected final void m19819f() {
        if (m19818e()) {
            throw new IllegalStateException("Pool not open");
        }
    }
}
