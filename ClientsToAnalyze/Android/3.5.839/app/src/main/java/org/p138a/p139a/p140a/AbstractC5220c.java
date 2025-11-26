package org.p138a.p139a.p140a;

/* compiled from: BaseObjectPool.java */
/* renamed from: org.a.a.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC5220c<T> implements InterfaceC5223f<T> {

    /* renamed from: a */
    private volatile boolean f19037a = false;

    /* renamed from: a */
    public final boolean m19902a() {
        return this.f19037a;
    }

    /* renamed from: b */
    protected final void m19903b() {
        if (m19902a()) {
            throw new IllegalStateException("Pool not open");
        }
    }
}
