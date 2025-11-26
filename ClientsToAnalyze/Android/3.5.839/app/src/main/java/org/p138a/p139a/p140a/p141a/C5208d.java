package org.p138a.p139a.p140a.p141a;

import java.io.Serializable;

/* compiled from: CursorableLinkedList.java */
/* renamed from: org.a.a.a.a.d */
/* loaded from: classes.dex */
class C5208d<E> implements Serializable {

    /* renamed from: a */
    private C5208d<E> f18989a;

    /* renamed from: b */
    private C5208d<E> f18990b;

    /* renamed from: c */
    private E f18991c;

    C5208d(C5208d<E> c5208d, C5208d<E> c5208d2, E e) {
        this.f18989a = null;
        this.f18990b = null;
        this.f18991c = null;
        this.f18989a = c5208d;
        this.f18990b = c5208d2;
        this.f18991c = e;
    }

    /* renamed from: a */
    C5208d<E> m19840a() {
        return this.f18990b;
    }

    /* renamed from: b */
    C5208d<E> m19842b() {
        return this.f18989a;
    }

    /* renamed from: c */
    E m19844c() {
        return this.f18991c;
    }

    /* renamed from: a */
    void m19841a(C5208d<E> c5208d) {
        this.f18990b = c5208d;
    }

    /* renamed from: b */
    void m19843b(C5208d<E> c5208d) {
        this.f18989a = c5208d;
    }

    /* renamed from: a */
    E m19839a(E e) {
        E e2 = this.f18991c;
        this.f18991c = e;
        return e2;
    }
}
