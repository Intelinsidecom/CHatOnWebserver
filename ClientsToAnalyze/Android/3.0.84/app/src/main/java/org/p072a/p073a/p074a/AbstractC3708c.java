package org.p072a.p073a.p074a;

/* compiled from: BaseObjectPool.java */
/* renamed from: org.a.a.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC3708c<T> implements InterfaceC3711f<T> {

    /* renamed from: a */
    private volatile boolean f13682a = false;

    /* renamed from: a */
    public final boolean m13374a() {
        return this.f13682a;
    }

    /* renamed from: b */
    protected final void m13375b() {
        if (m13374a()) {
            throw new IllegalStateException("Pool not open");
        }
    }
}
