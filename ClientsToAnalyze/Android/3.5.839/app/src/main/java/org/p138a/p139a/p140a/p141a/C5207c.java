package org.p138a.p139a.p140a.p141a;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: CursorableLinkedList.java */
/* renamed from: org.a.a.a.a.c */
/* loaded from: classes.dex */
class C5207c<E> implements ListIterator<E> {

    /* renamed from: c */
    C5208d<E> f18984c;

    /* renamed from: d */
    C5208d<E> f18985d = null;

    /* renamed from: e */
    int f18986e;

    /* renamed from: f */
    int f18987f;

    /* renamed from: g */
    final /* synthetic */ C5206a f18988g;

    C5207c(C5206a c5206a, int i) {
        this.f18988g = c5206a;
        this.f18984c = null;
        this.f18986e = this.f18988g.f18980c;
        this.f18987f = 0;
        if (i == 0) {
            this.f18984c = new C5208d<>(null, c5206a.f18979b.m19840a(), null);
            this.f18987f = 0;
        } else if (i == c5206a.f18978a) {
            this.f18984c = new C5208d<>(c5206a.f18979b.m19842b(), null, null);
            this.f18987f = c5206a.f18978a;
        } else {
            C5208d<E> c5208dM19827b = c5206a.m19827b(i);
            this.f18984c = new C5208d<>(c5208dM19827b.m19842b(), c5208dM19827b, null);
            this.f18987f = i;
        }
    }

    @Override // java.util.ListIterator
    public E previous() {
        m19838a();
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        E eM19844c = this.f18984c.m19842b().m19844c();
        this.f18985d = this.f18984c.m19842b();
        this.f18984c.m19841a((C5208d) this.f18984c.m19842b());
        this.f18984c.m19843b(this.f18984c.m19842b().m19842b());
        this.f18987f--;
        return eM19844c;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        m19838a();
        return (this.f18984c.m19840a() == null || this.f18984c.m19842b() == this.f18988g.f18979b.m19842b()) ? false : true;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        m19838a();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E eM19844c = this.f18984c.m19840a().m19844c();
        this.f18985d = this.f18984c.m19840a();
        this.f18984c.m19843b(this.f18984c.m19840a());
        this.f18984c.m19841a((C5208d) this.f18984c.m19840a().m19840a());
        this.f18987f++;
        return eM19844c;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        m19838a();
        if (hasPrevious()) {
            return this.f18987f - 1;
        }
        return -1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        m19838a();
        return (this.f18984c.m19842b() == null || this.f18984c.m19840a() == this.f18988g.f18979b.m19840a()) ? false : true;
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        m19838a();
        try {
            this.f18985d.m19839a((C5208d<E>) e);
        } catch (NullPointerException e2) {
            throw new IllegalStateException();
        }
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        m19838a();
        return !hasNext() ? this.f18988g.size() : this.f18987f;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        m19838a();
        if (this.f18985d == null) {
            throw new IllegalStateException();
        }
        this.f18984c.m19841a((C5208d) (this.f18985d == this.f18988g.f18979b.m19842b() ? null : this.f18985d.m19840a()));
        this.f18984c.m19843b(this.f18985d == this.f18988g.f18979b.m19840a() ? null : this.f18985d.m19842b());
        this.f18988g.mo19824a((C5208d) this.f18985d);
        this.f18985d = null;
        this.f18987f--;
        this.f18986e++;
    }

    @Override // java.util.ListIterator
    public void add(E e) {
        m19838a();
        this.f18984c.m19843b(this.f18988g.mo19822a(this.f18984c.m19842b(), this.f18984c.m19840a(), e));
        this.f18985d = null;
        this.f18987f++;
        this.f18986e++;
    }

    /* renamed from: a */
    protected void m19838a() {
        if (this.f18986e != this.f18988g.f18980c) {
            throw new ConcurrentModificationException();
        }
    }
}
