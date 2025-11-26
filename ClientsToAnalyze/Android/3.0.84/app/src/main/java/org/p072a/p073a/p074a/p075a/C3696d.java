package org.p072a.p073a.p074a.p075a;

import java.io.Serializable;

/* compiled from: CursorableLinkedList.java */
/* renamed from: org.a.a.a.a.d */
/* loaded from: classes.dex */
class C3696d<E> implements Serializable {

    /* renamed from: a */
    private C3696d<E> f13634a;

    /* renamed from: b */
    private C3696d<E> f13635b;

    /* renamed from: c */
    private E f13636c;

    C3696d(C3696d<E> c3696d, C3696d<E> c3696d2, E e) {
        this.f13634a = null;
        this.f13635b = null;
        this.f13636c = null;
        this.f13634a = c3696d;
        this.f13635b = c3696d2;
        this.f13636c = e;
    }

    /* renamed from: a */
    C3696d<E> m13312a() {
        return this.f13635b;
    }

    /* renamed from: b */
    C3696d<E> m13314b() {
        return this.f13634a;
    }

    /* renamed from: c */
    E m13316c() {
        return this.f13636c;
    }

    /* renamed from: a */
    void m13313a(C3696d<E> c3696d) {
        this.f13635b = c3696d;
    }

    /* renamed from: b */
    void m13315b(C3696d<E> c3696d) {
        this.f13634a = c3696d;
    }

    /* renamed from: a */
    E m13311a(E e) {
        E e2 = this.f13636c;
        this.f13636c = e;
        return e2;
    }
}
