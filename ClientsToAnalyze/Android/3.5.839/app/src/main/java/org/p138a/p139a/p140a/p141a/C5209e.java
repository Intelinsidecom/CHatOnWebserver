package org.p138a.p139a.p140a.p141a;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* compiled from: CursorableLinkedList.java */
/* renamed from: org.a.a.a.a.e */
/* loaded from: classes.dex */
class C5209e<E> extends C5206a<E> implements List<E> {

    /* renamed from: e */
    protected C5206a<E> f18992e;

    /* renamed from: f */
    protected C5208d<E> f18993f;

    /* renamed from: g */
    protected C5208d<E> f18994g;

    C5209e(C5206a<E> c5206a, int i, int i2) {
        this.f18992e = null;
        this.f18993f = null;
        this.f18994g = null;
        if (i < 0 || c5206a.size() < i2) {
            throw new IndexOutOfBoundsException();
        }
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        this.f18992e = c5206a;
        if (i < c5206a.size()) {
            this.f18979b.m19841a((C5208d) this.f18992e.m19827b(i));
            this.f18993f = this.f18979b.m19840a() == null ? null : this.f18979b.m19840a().m19842b();
        } else {
            this.f18993f = this.f18992e.m19827b(i - 1);
        }
        if (i == i2) {
            this.f18979b.m19841a((C5208d) null);
            this.f18979b.m19843b(null);
            if (i2 < c5206a.size()) {
                this.f18994g = this.f18992e.m19827b(i2);
            } else {
                this.f18994g = null;
            }
        } else {
            this.f18979b.m19843b(this.f18992e.m19827b(i2 - 1));
            this.f18994g = this.f18979b.m19842b().m19840a();
        }
        this.f18978a = i2 - i;
        this.f18980c = this.f18992e.f18980c;
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public void clear() {
        m19845c();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        m19845c();
        return super.iterator();
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public int size() {
        m19845c();
        return super.size();
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public boolean isEmpty() {
        m19845c();
        return super.isEmpty();
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public Object[] toArray() {
        m19845c();
        return super.toArray();
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        m19845c();
        return (T[]) super.toArray(tArr);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        m19845c();
        return super.contains(obj);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        m19845c();
        return super.remove(obj);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a
    /* renamed from: b */
    public E mo19826b() {
        m19845c();
        return (E) super.mo19826b();
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        m19845c();
        return super.addAll(collection);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public boolean add(E e) {
        m19845c();
        return super.add(e);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a
    /* renamed from: a */
    public boolean mo19825a(E e) {
        m19845c();
        return super.mo19825a((C5209e<E>) e);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a
    /* renamed from: b */
    public boolean mo19830b(E e) {
        m19845c();
        return super.mo19830b((C5209e<E>) e);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        m19845c();
        return super.removeAll(collection);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        m19845c();
        return super.containsAll(collection);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        m19845c();
        return super.addAll(i, collection);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public int hashCode() {
        m19845c();
        return super.hashCode();
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        m19845c();
        return super.retainAll(collection);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public E set(int i, E e) {
        m19845c();
        return (E) super.set(i, e);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        m19845c();
        return super.equals(obj);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public E get(int i) {
        m19845c();
        return (E) super.get(i);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public void add(int i, E e) {
        m19845c();
        super.add(i, e);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public ListIterator<E> listIterator(int i) {
        m19845c();
        return super.listIterator(i);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public E remove(int i) {
        m19845c();
        return (E) super.remove(i);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public int indexOf(Object obj) {
        m19845c();
        return super.indexOf(obj);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public int lastIndexOf(Object obj) {
        m19845c();
        return super.lastIndexOf(obj);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public ListIterator<E> listIterator() {
        m19845c();
        return super.listIterator();
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a, java.util.List
    public List<E> subList(int i, int i2) {
        m19845c();
        return super.subList(i, i2);
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a
    /* renamed from: a */
    protected C5208d<E> mo19822a(C5208d<E> c5208d, C5208d<E> c5208d2, E e) {
        this.f18980c++;
        this.f18978a++;
        C5208d<E> c5208dMo19822a = this.f18992e.mo19822a(c5208d == null ? this.f18993f : c5208d, c5208d2 == null ? this.f18994g : c5208d2, e);
        if (this.f18979b.m19840a() == null) {
            this.f18979b.m19841a((C5208d) c5208dMo19822a);
            this.f18979b.m19843b(c5208dMo19822a);
        }
        if (c5208d == this.f18979b.m19842b()) {
            this.f18979b.m19843b(c5208dMo19822a);
        }
        if (c5208d2 == this.f18979b.m19840a()) {
            this.f18979b.m19841a((C5208d) c5208dMo19822a);
        }
        m19832d(c5208dMo19822a);
        return c5208dMo19822a;
    }

    @Override // org.p138a.p139a.p140a.p141a.C5206a
    /* renamed from: a */
    protected void mo19824a(C5208d<E> c5208d) {
        this.f18980c++;
        this.f18978a--;
        if (this.f18979b.m19840a() == c5208d && this.f18979b.m19842b() == c5208d) {
            this.f18979b.m19841a((C5208d) null);
            this.f18979b.m19843b(null);
        }
        if (this.f18979b.m19840a() == c5208d) {
            this.f18979b.m19841a((C5208d) c5208d.m19840a());
        }
        if (this.f18979b.m19842b() == c5208d) {
            this.f18979b.m19843b(c5208d.m19842b());
        }
        this.f18992e.mo19824a((C5208d) c5208d);
        m19831c(c5208d);
    }

    /* renamed from: c */
    protected void m19845c() {
        if (this.f18980c != this.f18992e.f18980c) {
            throw new ConcurrentModificationException();
        }
    }
}
