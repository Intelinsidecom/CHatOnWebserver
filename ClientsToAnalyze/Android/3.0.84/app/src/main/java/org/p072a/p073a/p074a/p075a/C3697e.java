package org.p072a.p073a.p074a.p075a;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* compiled from: CursorableLinkedList.java */
/* renamed from: org.a.a.a.a.e */
/* loaded from: classes.dex */
class C3697e<E> extends C3694a<E> implements List<E> {

    /* renamed from: e */
    protected C3694a<E> f13637e;

    /* renamed from: f */
    protected C3696d<E> f13638f;

    /* renamed from: g */
    protected C3696d<E> f13639g;

    C3697e(C3694a<E> c3694a, int i, int i2) {
        this.f13637e = null;
        this.f13638f = null;
        this.f13639g = null;
        if (i < 0 || c3694a.size() < i2) {
            throw new IndexOutOfBoundsException();
        }
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        this.f13637e = c3694a;
        if (i < c3694a.size()) {
            this.f13624b.m13313a((C3696d) this.f13637e.m13299b(i));
            this.f13638f = this.f13624b.m13312a() == null ? null : this.f13624b.m13312a().m13314b();
        } else {
            this.f13638f = this.f13637e.m13299b(i - 1);
        }
        if (i == i2) {
            this.f13624b.m13313a((C3696d) null);
            this.f13624b.m13315b(null);
            if (i2 < c3694a.size()) {
                this.f13639g = this.f13637e.m13299b(i2);
            } else {
                this.f13639g = null;
            }
        } else {
            this.f13624b.m13315b(this.f13637e.m13299b(i2 - 1));
            this.f13639g = this.f13624b.m13314b().m13312a();
        }
        this.f13623a = i2 - i;
        this.f13625c = this.f13637e.f13625c;
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public void clear() {
        m13317c();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        m13317c();
        return super.iterator();
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public int size() {
        m13317c();
        return super.size();
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public boolean isEmpty() {
        m13317c();
        return super.isEmpty();
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public Object[] toArray() {
        m13317c();
        return super.toArray();
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        m13317c();
        return (T[]) super.toArray(tArr);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        m13317c();
        return super.contains(obj);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        m13317c();
        return super.remove(obj);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a
    /* renamed from: b */
    public E mo13298b() {
        m13317c();
        return (E) super.mo13298b();
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        m13317c();
        return super.addAll(collection);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public boolean add(E e) {
        m13317c();
        return super.add(e);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a
    /* renamed from: a */
    public boolean mo13297a(E e) {
        m13317c();
        return super.mo13297a((C3697e<E>) e);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a
    /* renamed from: b */
    public boolean mo13302b(E e) {
        m13317c();
        return super.mo13302b((C3697e<E>) e);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        m13317c();
        return super.removeAll(collection);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        m13317c();
        return super.containsAll(collection);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        m13317c();
        return super.addAll(i, collection);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public int hashCode() {
        m13317c();
        return super.hashCode();
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        m13317c();
        return super.retainAll(collection);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public E set(int i, E e) {
        m13317c();
        return (E) super.set(i, e);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        m13317c();
        return super.equals(obj);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public E get(int i) {
        m13317c();
        return (E) super.get(i);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public void add(int i, E e) {
        m13317c();
        super.add(i, e);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public ListIterator<E> listIterator(int i) {
        m13317c();
        return super.listIterator(i);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public E remove(int i) {
        m13317c();
        return (E) super.remove(i);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public int indexOf(Object obj) {
        m13317c();
        return super.indexOf(obj);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public int lastIndexOf(Object obj) {
        m13317c();
        return super.lastIndexOf(obj);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public ListIterator<E> listIterator() {
        m13317c();
        return super.listIterator();
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a, java.util.List
    public List<E> subList(int i, int i2) {
        m13317c();
        return super.subList(i, i2);
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a
    /* renamed from: a */
    protected C3696d<E> mo13294a(C3696d<E> c3696d, C3696d<E> c3696d2, E e) {
        this.f13625c++;
        this.f13623a++;
        C3696d<E> c3696dMo13294a = this.f13637e.mo13294a(c3696d == null ? this.f13638f : c3696d, c3696d2 == null ? this.f13639g : c3696d2, e);
        if (this.f13624b.m13312a() == null) {
            this.f13624b.m13313a((C3696d) c3696dMo13294a);
            this.f13624b.m13315b(c3696dMo13294a);
        }
        if (c3696d == this.f13624b.m13314b()) {
            this.f13624b.m13315b(c3696dMo13294a);
        }
        if (c3696d2 == this.f13624b.m13312a()) {
            this.f13624b.m13313a((C3696d) c3696dMo13294a);
        }
        m13304d(c3696dMo13294a);
        return c3696dMo13294a;
    }

    @Override // org.p072a.p073a.p074a.p075a.C3694a
    /* renamed from: a */
    protected void mo13296a(C3696d<E> c3696d) {
        this.f13625c++;
        this.f13623a--;
        if (this.f13624b.m13312a() == c3696d && this.f13624b.m13314b() == c3696d) {
            this.f13624b.m13313a((C3696d) null);
            this.f13624b.m13315b(null);
        }
        if (this.f13624b.m13312a() == c3696d) {
            this.f13624b.m13313a((C3696d) c3696d.m13312a());
        }
        if (this.f13624b.m13314b() == c3696d) {
            this.f13624b.m13315b(c3696d.m13314b());
        }
        this.f13637e.mo13296a((C3696d) c3696d);
        m13303c(c3696d);
    }

    /* renamed from: c */
    protected void m13317c() {
        if (this.f13625c != this.f13637e.f13625c) {
            throw new ConcurrentModificationException();
        }
    }
}
