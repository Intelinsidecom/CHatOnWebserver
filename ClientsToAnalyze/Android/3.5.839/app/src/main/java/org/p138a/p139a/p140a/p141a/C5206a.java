package org.p138a.p139a.p140a.p141a;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: CursorableLinkedList.java */
/* renamed from: org.a.a.a.a.a */
/* loaded from: classes.dex */
class C5206a<E> implements Serializable, List<E> {

    /* renamed from: a */
    protected transient int f18978a = 0;

    /* renamed from: b */
    protected transient C5208d<E> f18979b = new C5208d<>(null, null, null);

    /* renamed from: c */
    protected transient int f18980c = 0;

    /* renamed from: d */
    protected transient List<WeakReference<C5206a<E>.b>> f18981d = new ArrayList();

    C5206a() {
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E e) {
        mo19822a(this.f18979b.m19842b(), null, e);
        return true;
    }

    @Override // java.util.List
    public void add(int i, E e) {
        if (i == this.f18978a) {
            add(e);
        } else {
            if (i < 0 || i > this.f18978a) {
                throw new IndexOutOfBoundsException(String.valueOf(i) + " < 0 or " + String.valueOf(i) + " > " + this.f18978a);
            }
            C5208d<E> c5208dM19827b = isEmpty() ? null : m19827b(i);
            mo19822a(c5208dM19827b != null ? c5208dM19827b.m19842b() : null, c5208dM19827b, e);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            mo19822a(this.f18979b.m19842b(), null, it.next());
        }
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (this.f18978a == i || this.f18978a == 0) {
            return addAll(collection);
        }
        C5208d<E> c5208dM19827b = m19827b(i);
        C5208d<E> c5208dM19842b = c5208dM19827b == null ? null : c5208dM19827b.m19842b();
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            c5208dM19842b = mo19822a(c5208dM19842b, c5208dM19827b, it.next());
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo19825a(E e) {
        mo19822a(null, this.f18979b.m19840a(), e);
        return true;
    }

    /* renamed from: b */
    public boolean mo19830b(E e) {
        mo19822a(this.f18979b.m19842b(), null, e);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        C5208d<E> c5208dM19840a = this.f18979b.m19840a();
        C5208d<E> c5208d = null;
        while (c5208dM19840a != null && c5208d != this.f18979b.m19842b()) {
            if ((obj != null || c5208dM19840a.m19844c() != null) && (obj == null || !obj.equals(c5208dM19840a.m19844c()))) {
                C5208d<E> c5208d2 = c5208dM19840a;
                c5208dM19840a = c5208dM19840a.m19840a();
                c5208d = c5208d2;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public C5206a<E>.b m19820a() {
        return new b(0);
    }

    /* renamed from: a */
    public C5206a<E>.b m19821a(int i) {
        return new b(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        ListIterator<E> listIterator = ((List) obj).listIterator();
        C5208d<E> c5208dM19840a = this.f18979b.m19840a();
        C5208d<E> c5208d = null;
        while (c5208dM19840a != null && c5208d != this.f18979b.m19842b()) {
            if (listIterator.hasNext()) {
                if (c5208dM19840a.m19844c() == null) {
                    if (listIterator.next() == null) {
                        C5208d<E> c5208d2 = c5208dM19840a;
                        c5208dM19840a = c5208dM19840a.m19840a();
                        c5208d = c5208d2;
                    }
                } else if (c5208dM19840a.m19844c().equals(listIterator.next())) {
                    C5208d<E> c5208d22 = c5208dM19840a;
                    c5208dM19840a = c5208dM19840a.m19840a();
                    c5208d = c5208d22;
                }
            }
            return false;
        }
        return !listIterator.hasNext();
    }

    @Override // java.util.List
    public E get(int i) {
        return m19827b(i).m19844c();
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int iHashCode = 1;
        C5208d<E> c5208dM19840a = this.f18979b.m19840a();
        C5208d<E> c5208d = null;
        while (c5208dM19840a != null && c5208d != this.f18979b.m19842b()) {
            iHashCode = (iHashCode * 31) + (c5208dM19840a.m19844c() == null ? 0 : c5208dM19840a.m19844c().hashCode());
            C5208d<E> c5208d2 = c5208dM19840a;
            c5208dM19840a = c5208dM19840a.m19840a();
            c5208d = c5208d2;
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            C5208d<E> c5208dM19840a = this.f18979b.m19840a();
            int i = 0;
            C5208d<E> c5208d = null;
            while (c5208dM19840a != null && c5208d != this.f18979b.m19842b()) {
                if (c5208dM19840a.m19844c() != null) {
                    C5208d<E> c5208d2 = c5208dM19840a;
                    c5208dM19840a = c5208dM19840a.m19840a();
                    i++;
                    c5208d = c5208d2;
                } else {
                    return i;
                }
            }
        } else {
            C5208d<E> c5208dM19840a2 = this.f18979b.m19840a();
            int i2 = 0;
            C5208d<E> c5208d3 = null;
            while (c5208dM19840a2 != null && c5208d3 != this.f18979b.m19842b()) {
                if (!obj.equals(c5208dM19840a2.m19844c())) {
                    C5208d<E> c5208d4 = c5208dM19840a2;
                    c5208dM19840a2 = c5208dM19840a2.m19840a();
                    i2++;
                    c5208d3 = c5208d4;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f18978a == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.f18978a - 1;
        if (obj == null) {
            C5208d<E> c5208dM19842b = this.f18979b.m19842b();
            int i2 = i;
            C5208d<E> c5208d = null;
            while (c5208dM19842b != null && c5208d != this.f18979b.m19840a()) {
                if (c5208dM19842b.m19844c() != null) {
                    C5208d<E> c5208d2 = c5208dM19842b;
                    c5208dM19842b = c5208dM19842b.m19842b();
                    i2--;
                    c5208d = c5208d2;
                } else {
                    return i2;
                }
            }
        } else {
            C5208d<E> c5208dM19842b2 = this.f18979b.m19842b();
            int i3 = i;
            C5208d<E> c5208d3 = null;
            while (c5208dM19842b2 != null && c5208d3 != this.f18979b.m19840a()) {
                if (!obj.equals(c5208dM19842b2.m19844c())) {
                    C5208d<E> c5208d4 = c5208dM19842b2;
                    c5208dM19842b2 = c5208dM19842b2.m19842b();
                    i3--;
                    c5208d3 = c5208d4;
                } else {
                    return i3;
                }
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        if (i < 0 || i > this.f18978a) {
            throw new IndexOutOfBoundsException(i + " < 0 or > " + this.f18978a);
        }
        return new C5207c(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        C5208d<E> c5208dM19840a = this.f18979b.m19840a();
        C5208d<E> c5208d = null;
        while (c5208dM19840a != null && c5208d != this.f18979b.m19842b()) {
            if (obj == null && c5208dM19840a.m19844c() == null) {
                mo19824a((C5208d) c5208dM19840a);
                return true;
            }
            if (obj == null || !obj.equals(c5208dM19840a.m19844c())) {
                C5208d<E> c5208d2 = c5208dM19840a;
                c5208dM19840a = c5208dM19840a.m19840a();
                c5208d = c5208d2;
            } else {
                mo19824a((C5208d) c5208dM19840a);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List
    public E remove(int i) {
        C5208d<E> c5208dM19827b = m19827b(i);
        E eM19844c = c5208dM19827b.m19844c();
        mo19824a((C5208d) c5208dM19827b);
        return eM19844c;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        if (collection.size() != 0 && this.f18978a != 0) {
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public E mo19826b() {
        if (this.f18979b.m19840a() != null) {
            E eM19844c = this.f18979b.m19840a().m19844c();
            mo19824a((C5208d) this.f18979b.m19840a());
            return eM19844c;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.List
    public E set(int i, E e) {
        C5208d<E> c5208dM19827b = m19827b(i);
        E eM19839a = c5208dM19827b.m19839a((C5208d<E>) e);
        m19829b((C5208d) c5208dM19827b);
        return eM19839a;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f18978a;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[this.f18978a];
        int i = 0;
        C5208d<E> c5208d = null;
        for (C5208d<E> c5208dM19840a = this.f18979b.m19840a(); c5208dM19840a != null && c5208d != this.f18979b.m19842b(); c5208dM19840a = c5208dM19840a.m19840a()) {
            objArr[i] = c5208dM19840a.m19844c();
            i++;
            c5208d = c5208dM19840a;
        }
        return objArr;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Object[] objArr = tArr.length < this.f18978a ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f18978a)) : tArr;
        int i = 0;
        C5208d<E> c5208d = null;
        for (C5208d<E> c5208dM19840a = this.f18979b.m19840a(); c5208dM19840a != null && c5208d != this.f18979b.m19842b(); c5208dM19840a = c5208dM19840a.m19840a()) {
            objArr[i] = c5208dM19840a.m19844c();
            i++;
            c5208d = c5208dM19840a;
        }
        if (objArr.length > this.f18978a) {
            objArr[this.f18978a] = null;
        }
        return (T[]) objArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        C5208d<E> c5208dM19840a = this.f18979b.m19840a();
        C5208d<E> c5208d = null;
        while (c5208dM19840a != null && c5208d != this.f18979b.m19842b()) {
            if (this.f18979b.m19840a() != c5208dM19840a) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(c5208dM19840a.m19844c());
            C5208d<E> c5208d2 = c5208dM19840a;
            c5208dM19840a = c5208dM19840a.m19840a();
            c5208d = c5208d2;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        if (i < 0 || i2 > this.f18978a || i > i2) {
            throw new IndexOutOfBoundsException();
        }
        return (i == 0 && i2 == this.f18978a) ? this : new C5209e(this, i, i2);
    }

    /* renamed from: a */
    protected C5208d<E> mo19822a(C5208d<E> c5208d, C5208d<E> c5208d2, E e) {
        this.f18980c++;
        this.f18978a++;
        C5208d<E> c5208d3 = new C5208d<>(c5208d, c5208d2, e);
        if (c5208d != null) {
            c5208d.m19841a((C5208d) c5208d3);
        } else {
            this.f18979b.m19841a((C5208d) c5208d3);
        }
        if (c5208d2 != null) {
            c5208d2.m19843b(c5208d3);
        } else {
            this.f18979b.m19843b(c5208d3);
        }
        m19832d(c5208d3);
        return c5208d3;
    }

    /* renamed from: a */
    protected void mo19824a(C5208d<E> c5208d) {
        this.f18980c++;
        this.f18978a--;
        if (this.f18979b.m19840a() == c5208d) {
            this.f18979b.m19841a((C5208d) c5208d.m19840a());
        }
        if (c5208d.m19840a() != null) {
            c5208d.m19840a().m19843b(c5208d.m19842b());
        }
        if (this.f18979b.m19842b() == c5208d) {
            this.f18979b.m19843b(c5208d.m19842b());
        }
        if (c5208d.m19842b() != null) {
            c5208d.m19842b().m19841a((C5208d) c5208d.m19840a());
        }
        m19831c(c5208d);
    }

    /* renamed from: b */
    protected C5208d<E> m19827b(int i) {
        C5208d<E> c5208dM19842b;
        if (i < 0 || i >= this.f18978a) {
            throw new IndexOutOfBoundsException(String.valueOf(i) + " < 0 or " + String.valueOf(i) + " >= " + this.f18978a);
        }
        if (i <= this.f18978a / 2) {
            c5208dM19842b = this.f18979b.m19840a();
            int i2 = 0;
            while (i2 < i) {
                i2++;
                c5208dM19842b = c5208dM19842b.m19840a();
            }
        } else {
            c5208dM19842b = this.f18979b.m19842b();
            int i3 = this.f18978a - 1;
            while (i3 > i) {
                i3--;
                c5208dM19842b = c5208dM19842b.m19842b();
            }
        }
        return c5208dM19842b;
    }

    /* renamed from: a */
    protected void m19823a(C5206a<E>.b bVar) {
        Iterator<WeakReference<C5206a<E>.b>> it = this.f18981d.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
        this.f18981d.add(new WeakReference<>(bVar));
    }

    /* renamed from: b */
    protected void m19828b(C5206a<E>.b bVar) {
        Iterator<WeakReference<C5206a<E>.b>> it = this.f18981d.iterator();
        while (it.hasNext()) {
            WeakReference<C5206a<E>.b> next = it.next();
            b bVar2 = next.get();
            if (bVar2 == null) {
                it.remove();
            } else if (bVar2 == bVar) {
                next.clear();
                it.remove();
                return;
            }
        }
    }

    /* renamed from: b */
    protected void m19829b(C5208d<E> c5208d) {
        Iterator<WeakReference<C5206a<E>.b>> it = this.f18981d.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.m19837c(c5208d);
            }
        }
    }

    /* renamed from: c */
    protected void m19831c(C5208d<E> c5208d) {
        Iterator<WeakReference<C5206a<E>.b>> it = this.f18981d.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.m19834a(c5208d);
            }
        }
    }

    /* renamed from: d */
    protected void m19832d(C5208d<E> c5208d) {
        Iterator<WeakReference<C5206a<E>.b>> it = this.f18981d.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.m19836b(c5208d);
            }
        }
    }

    /* compiled from: CursorableLinkedList.java */
    /* renamed from: org.a.a.a.a.b */
    public class b extends C5206a<E>.C5207c implements ListIterator<E> {

        /* renamed from: a */
        boolean f18982a;

        @Override // java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ boolean hasNext() {
            return super.hasNext();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ boolean hasPrevious() {
            return super.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return super.next();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ Object previous() {
            return super.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            super.set(obj);
        }

        b(int i) {
            super(C5206a.this, i);
            this.f18982a = false;
            this.f18982a = true;
            C5206a.this.m19823a(this);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            m19833a();
            C5208d<E> c5208dMo19822a = C5206a.this.mo19822a(this.c.m19842b(), this.c.m19840a(), e);
            this.c.m19843b(c5208dMo19822a);
            this.c.m19841a((C5208d) c5208dMo19822a.m19840a());
            this.d = null;
            this.f++;
            this.e++;
        }

        /* renamed from: a */
        protected void m19834a(C5208d<E> c5208d) {
            if (C5206a.this.f18979b.m19842b() == null) {
                this.c.m19841a((C5208d) null);
            } else if (this.c.m19840a() == c5208d) {
                this.c.m19841a((C5208d) c5208d.m19840a());
            }
            if (C5206a.this.f18979b.m19840a() == null) {
                this.c.m19843b(null);
            } else if (this.c.m19842b() == c5208d) {
                this.c.m19843b(c5208d.m19842b());
            }
            if (this.d == c5208d) {
                this.d = null;
            }
        }

        /* renamed from: b */
        protected void m19836b(C5208d<E> c5208d) {
            if ((this.c.m19840a() == null && this.c.m19842b() == null) || this.c.m19842b() == c5208d.m19842b()) {
                this.c.m19841a((C5208d) c5208d);
            }
            if (this.c.m19840a() == c5208d.m19840a()) {
                this.c.m19843b(c5208d);
            }
            if (this.d == c5208d) {
                this.d = null;
            }
        }

        /* renamed from: c */
        protected void m19837c(C5208d<E> c5208d) {
            if (this.d == c5208d) {
                this.d = null;
            }
        }

        /* renamed from: a */
        protected void m19833a() {
            if (!this.f18982a) {
                throw new ConcurrentModificationException();
            }
        }

        /* renamed from: b */
        public void m19835b() {
            if (this.f18982a) {
                this.f18982a = false;
                C5206a.this.m19828b(this);
            }
        }
    }
}
