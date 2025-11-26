package org.p072a.p073a.p074a;

/* compiled from: BaseKeyedObjectPool.java */
/* renamed from: org.a.a.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC3693a<K, V> {

    /* renamed from: a */
    private volatile boolean f13622a = false;

    /* renamed from: a */
    public void mo13286a(K k) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public int mo13285a() {
        return -1;
    }

    /* renamed from: b */
    public int mo13287b() {
        return -1;
    }

    /* renamed from: c */
    public void mo13288c() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: d */
    public void mo13289d() {
        this.f13622a = true;
    }

    /* renamed from: e */
    protected final boolean m13290e() {
        return this.f13622a;
    }

    /* renamed from: f */
    protected final void m13291f() {
        if (m13290e()) {
            throw new IllegalStateException("Pool not open");
        }
    }
}
