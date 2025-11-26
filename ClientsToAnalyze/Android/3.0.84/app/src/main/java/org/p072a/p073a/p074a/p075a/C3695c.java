package org.p072a.p073a.p074a.p075a;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: CursorableLinkedList.java */
/* renamed from: org.a.a.a.a.c */
/* loaded from: classes.dex */
class C3695c<E> implements ListIterator<E> {

    /* renamed from: c */
    C3696d<E> f13629c;

    /* renamed from: d */
    C3696d<E> f13630d = null;

    /* renamed from: e */
    int f13631e;

    /* renamed from: f */
    int f13632f;

    /* renamed from: g */
    final /* synthetic */ C3694a f13633g;

    C3695c(C3694a c3694a, int i) {
        this.f13633g = c3694a;
        this.f13629c = null;
        this.f13631e = this.f13633g.f13625c;
        this.f13632f = 0;
        if (i == 0) {
            this.f13629c = new C3696d<>(null, c3694a.f13624b.m13312a(), null);
            this.f13632f = 0;
        } else if (i == c3694a.f13623a) {
            this.f13629c = new C3696d<>(c3694a.f13624b.m13314b(), null, null);
            this.f13632f = c3694a.f13623a;
        } else {
            C3696d<E> c3696dM13299b = c3694a.m13299b(i);
            this.f13629c = new C3696d<>(c3696dM13299b.m13314b(), c3696dM13299b, null);
            this.f13632f = i;
        }
    }

    @Override // java.util.ListIterator
    public E previous() {
        m13310a();
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        E eM13316c = this.f13629c.m13314b().m13316c();
        this.f13630d = this.f13629c.m13314b();
        this.f13629c.m13313a((C3696d) this.f13629c.m13314b());
        this.f13629c.m13315b(this.f13629c.m13314b().m13314b());
        this.f13632f--;
        return eM13316c;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        m13310a();
        return (this.f13629c.m13312a() == null || this.f13629c.m13314b() == this.f13633g.f13624b.m13314b()) ? false : true;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        m13310a();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E eM13316c = this.f13629c.m13312a().m13316c();
        this.f13630d = this.f13629c.m13312a();
        this.f13629c.m13315b(this.f13629c.m13312a());
        this.f13629c.m13313a((C3696d) this.f13629c.m13312a().m13312a());
        this.f13632f++;
        return eM13316c;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        m13310a();
        if (hasPrevious()) {
            return this.f13632f - 1;
        }
        return -1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        m13310a();
        return (this.f13629c.m13314b() == null || this.f13629c.m13312a() == this.f13633g.f13624b.m13312a()) ? false : true;
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        m13310a();
        try {
            this.f13630d.m13311a((C3696d<E>) e);
        } catch (NullPointerException e2) {
            throw new IllegalStateException();
        }
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        m13310a();
        return !hasNext() ? this.f13633g.size() : this.f13632f;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        m13310a();
        if (this.f13630d == null) {
            throw new IllegalStateException();
        }
        this.f13629c.m13313a((C3696d) (this.f13630d == this.f13633g.f13624b.m13314b() ? null : this.f13630d.m13312a()));
        this.f13629c.m13315b(this.f13630d == this.f13633g.f13624b.m13312a() ? null : this.f13630d.m13314b());
        this.f13633g.mo13296a((C3696d) this.f13630d);
        this.f13630d = null;
        this.f13632f--;
        this.f13631e++;
    }

    @Override // java.util.ListIterator
    public void add(E e) {
        m13310a();
        this.f13629c.m13315b(this.f13633g.mo13294a(this.f13629c.m13314b(), this.f13629c.m13312a(), e));
        this.f13630d = null;
        this.f13632f++;
        this.f13631e++;
    }

    /* renamed from: a */
    protected void m13310a() {
        if (this.f13631e != this.f13633g.f13625c) {
            throw new ConcurrentModificationException();
        }
    }
}
