package org.p072a.p073a.p074a.p075a;

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
class C3694a<E> implements Serializable, List<E> {

    /* renamed from: a */
    protected transient int f13623a = 0;

    /* renamed from: b */
    protected transient C3696d<E> f13624b = new C3696d<>(null, null, null);

    /* renamed from: c */
    protected transient int f13625c = 0;

    /* renamed from: d */
    protected transient List<WeakReference<C3694a<E>.b>> f13626d = new ArrayList();

    C3694a() {
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E e) {
        mo13294a(this.f13624b.m13314b(), null, e);
        return true;
    }

    @Override // java.util.List
    public void add(int i, E e) {
        if (i == this.f13623a) {
            add(e);
        } else {
            if (i < 0 || i > this.f13623a) {
                throw new IndexOutOfBoundsException(String.valueOf(i) + " < 0 or " + String.valueOf(i) + " > " + this.f13623a);
            }
            C3696d<E> c3696dM13299b = isEmpty() ? null : m13299b(i);
            mo13294a(c3696dM13299b != null ? c3696dM13299b.m13314b() : null, c3696dM13299b, e);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            mo13294a(this.f13624b.m13314b(), null, it.next());
        }
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (this.f13623a == i || this.f13623a == 0) {
            return addAll(collection);
        }
        C3696d<E> c3696dM13299b = m13299b(i);
        C3696d<E> c3696dM13314b = c3696dM13299b == null ? null : c3696dM13299b.m13314b();
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            c3696dM13314b = mo13294a(c3696dM13314b, c3696dM13299b, it.next());
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo13297a(E e) {
        mo13294a(null, this.f13624b.m13312a(), e);
        return true;
    }

    /* renamed from: b */
    public boolean mo13302b(E e) {
        mo13294a(this.f13624b.m13314b(), null, e);
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
        C3696d<E> c3696dM13312a = this.f13624b.m13312a();
        C3696d<E> c3696d = null;
        while (c3696dM13312a != null && c3696d != this.f13624b.m13314b()) {
            if ((obj != null || c3696dM13312a.m13316c() != null) && (obj == null || !obj.equals(c3696dM13312a.m13316c()))) {
                C3696d<E> c3696d2 = c3696dM13312a;
                c3696dM13312a = c3696dM13312a.m13312a();
                c3696d = c3696d2;
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
    public C3694a<E>.b m13292a() {
        return new b(0);
    }

    /* renamed from: a */
    public C3694a<E>.b m13293a(int i) {
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
        C3696d<E> c3696dM13312a = this.f13624b.m13312a();
        C3696d<E> c3696d = null;
        while (c3696dM13312a != null && c3696d != this.f13624b.m13314b()) {
            if (listIterator.hasNext()) {
                if (c3696dM13312a.m13316c() == null) {
                    if (listIterator.next() == null) {
                        C3696d<E> c3696d2 = c3696dM13312a;
                        c3696dM13312a = c3696dM13312a.m13312a();
                        c3696d = c3696d2;
                    }
                } else if (c3696dM13312a.m13316c().equals(listIterator.next())) {
                    C3696d<E> c3696d22 = c3696dM13312a;
                    c3696dM13312a = c3696dM13312a.m13312a();
                    c3696d = c3696d22;
                }
            }
            return false;
        }
        return !listIterator.hasNext();
    }

    @Override // java.util.List
    public E get(int i) {
        return m13299b(i).m13316c();
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int iHashCode = 1;
        C3696d<E> c3696dM13312a = this.f13624b.m13312a();
        C3696d<E> c3696d = null;
        while (c3696dM13312a != null && c3696d != this.f13624b.m13314b()) {
            iHashCode = (iHashCode * 31) + (c3696dM13312a.m13316c() == null ? 0 : c3696dM13312a.m13316c().hashCode());
            C3696d<E> c3696d2 = c3696dM13312a;
            c3696dM13312a = c3696dM13312a.m13312a();
            c3696d = c3696d2;
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            C3696d<E> c3696dM13312a = this.f13624b.m13312a();
            int i = 0;
            C3696d<E> c3696d = null;
            while (c3696dM13312a != null && c3696d != this.f13624b.m13314b()) {
                if (c3696dM13312a.m13316c() != null) {
                    C3696d<E> c3696d2 = c3696dM13312a;
                    c3696dM13312a = c3696dM13312a.m13312a();
                    i++;
                    c3696d = c3696d2;
                } else {
                    return i;
                }
            }
        } else {
            C3696d<E> c3696dM13312a2 = this.f13624b.m13312a();
            int i2 = 0;
            C3696d<E> c3696d3 = null;
            while (c3696dM13312a2 != null && c3696d3 != this.f13624b.m13314b()) {
                if (!obj.equals(c3696dM13312a2.m13316c())) {
                    C3696d<E> c3696d4 = c3696dM13312a2;
                    c3696dM13312a2 = c3696dM13312a2.m13312a();
                    i2++;
                    c3696d3 = c3696d4;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f13623a == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.f13623a - 1;
        if (obj == null) {
            C3696d<E> c3696dM13314b = this.f13624b.m13314b();
            int i2 = i;
            C3696d<E> c3696d = null;
            while (c3696dM13314b != null && c3696d != this.f13624b.m13312a()) {
                if (c3696dM13314b.m13316c() != null) {
                    C3696d<E> c3696d2 = c3696dM13314b;
                    c3696dM13314b = c3696dM13314b.m13314b();
                    i2--;
                    c3696d = c3696d2;
                } else {
                    return i2;
                }
            }
        } else {
            C3696d<E> c3696dM13314b2 = this.f13624b.m13314b();
            int i3 = i;
            C3696d<E> c3696d3 = null;
            while (c3696dM13314b2 != null && c3696d3 != this.f13624b.m13312a()) {
                if (!obj.equals(c3696dM13314b2.m13316c())) {
                    C3696d<E> c3696d4 = c3696dM13314b2;
                    c3696dM13314b2 = c3696dM13314b2.m13314b();
                    i3--;
                    c3696d3 = c3696d4;
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
        if (i < 0 || i > this.f13623a) {
            throw new IndexOutOfBoundsException(i + " < 0 or > " + this.f13623a);
        }
        return new C3695c(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        C3696d<E> c3696dM13312a = this.f13624b.m13312a();
        C3696d<E> c3696d = null;
        while (c3696dM13312a != null && c3696d != this.f13624b.m13314b()) {
            if (obj == null && c3696dM13312a.m13316c() == null) {
                mo13296a((C3696d) c3696dM13312a);
                return true;
            }
            if (obj == null || !obj.equals(c3696dM13312a.m13316c())) {
                C3696d<E> c3696d2 = c3696dM13312a;
                c3696dM13312a = c3696dM13312a.m13312a();
                c3696d = c3696d2;
            } else {
                mo13296a((C3696d) c3696dM13312a);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List
    public E remove(int i) {
        C3696d<E> c3696dM13299b = m13299b(i);
        E eM13316c = c3696dM13299b.m13316c();
        mo13296a((C3696d) c3696dM13299b);
        return eM13316c;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        if (collection.size() != 0 && this.f13623a != 0) {
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
    public E mo13298b() {
        if (this.f13624b.m13312a() != null) {
            E eM13316c = this.f13624b.m13312a().m13316c();
            mo13296a((C3696d) this.f13624b.m13312a());
            return eM13316c;
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
        C3696d<E> c3696dM13299b = m13299b(i);
        E eM13311a = c3696dM13299b.m13311a((C3696d<E>) e);
        m13301b((C3696d) c3696dM13299b);
        return eM13311a;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f13623a;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[this.f13623a];
        int i = 0;
        C3696d<E> c3696d = null;
        for (C3696d<E> c3696dM13312a = this.f13624b.m13312a(); c3696dM13312a != null && c3696d != this.f13624b.m13314b(); c3696dM13312a = c3696dM13312a.m13312a()) {
            objArr[i] = c3696dM13312a.m13316c();
            i++;
            c3696d = c3696dM13312a;
        }
        return objArr;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Object[] objArr = tArr.length < this.f13623a ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f13623a)) : tArr;
        int i = 0;
        C3696d<E> c3696d = null;
        for (C3696d<E> c3696dM13312a = this.f13624b.m13312a(); c3696dM13312a != null && c3696d != this.f13624b.m13314b(); c3696dM13312a = c3696dM13312a.m13312a()) {
            objArr[i] = c3696dM13312a.m13316c();
            i++;
            c3696d = c3696dM13312a;
        }
        if (objArr.length > this.f13623a) {
            objArr[this.f13623a] = null;
        }
        return (T[]) objArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        C3696d<E> c3696dM13312a = this.f13624b.m13312a();
        C3696d<E> c3696d = null;
        while (c3696dM13312a != null && c3696d != this.f13624b.m13314b()) {
            if (this.f13624b.m13312a() != c3696dM13312a) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(c3696dM13312a.m13316c());
            C3696d<E> c3696d2 = c3696dM13312a;
            c3696dM13312a = c3696dM13312a.m13312a();
            c3696d = c3696d2;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        if (i < 0 || i2 > this.f13623a || i > i2) {
            throw new IndexOutOfBoundsException();
        }
        return (i == 0 && i2 == this.f13623a) ? this : new C3697e(this, i, i2);
    }

    /* renamed from: a */
    protected C3696d<E> mo13294a(C3696d<E> c3696d, C3696d<E> c3696d2, E e) {
        this.f13625c++;
        this.f13623a++;
        C3696d<E> c3696d3 = new C3696d<>(c3696d, c3696d2, e);
        if (c3696d != null) {
            c3696d.m13313a((C3696d) c3696d3);
        } else {
            this.f13624b.m13313a((C3696d) c3696d3);
        }
        if (c3696d2 != null) {
            c3696d2.m13315b(c3696d3);
        } else {
            this.f13624b.m13315b(c3696d3);
        }
        m13304d(c3696d3);
        return c3696d3;
    }

    /* renamed from: a */
    protected void mo13296a(C3696d<E> c3696d) {
        this.f13625c++;
        this.f13623a--;
        if (this.f13624b.m13312a() == c3696d) {
            this.f13624b.m13313a((C3696d) c3696d.m13312a());
        }
        if (c3696d.m13312a() != null) {
            c3696d.m13312a().m13315b(c3696d.m13314b());
        }
        if (this.f13624b.m13314b() == c3696d) {
            this.f13624b.m13315b(c3696d.m13314b());
        }
        if (c3696d.m13314b() != null) {
            c3696d.m13314b().m13313a((C3696d) c3696d.m13312a());
        }
        m13303c(c3696d);
    }

    /* renamed from: b */
    protected C3696d<E> m13299b(int i) {
        C3696d<E> c3696dM13314b;
        if (i < 0 || i >= this.f13623a) {
            throw new IndexOutOfBoundsException(String.valueOf(i) + " < 0 or " + String.valueOf(i) + " >= " + this.f13623a);
        }
        if (i <= this.f13623a / 2) {
            c3696dM13314b = this.f13624b.m13312a();
            int i2 = 0;
            while (i2 < i) {
                i2++;
                c3696dM13314b = c3696dM13314b.m13312a();
            }
        } else {
            c3696dM13314b = this.f13624b.m13314b();
            int i3 = this.f13623a - 1;
            while (i3 > i) {
                i3--;
                c3696dM13314b = c3696dM13314b.m13314b();
            }
        }
        return c3696dM13314b;
    }

    /* renamed from: a */
    protected void m13295a(C3694a<E>.b bVar) {
        Iterator<WeakReference<C3694a<E>.b>> it = this.f13626d.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
        this.f13626d.add(new WeakReference<>(bVar));
    }

    /* renamed from: b */
    protected void m13300b(C3694a<E>.b bVar) {
        Iterator<WeakReference<C3694a<E>.b>> it = this.f13626d.iterator();
        while (it.hasNext()) {
            WeakReference<C3694a<E>.b> next = it.next();
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
    protected void m13301b(C3696d<E> c3696d) {
        Iterator<WeakReference<C3694a<E>.b>> it = this.f13626d.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.m13309c(c3696d);
            }
        }
    }

    /* renamed from: c */
    protected void m13303c(C3696d<E> c3696d) {
        Iterator<WeakReference<C3694a<E>.b>> it = this.f13626d.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.m13306a(c3696d);
            }
        }
    }

    /* renamed from: d */
    protected void m13304d(C3696d<E> c3696d) {
        Iterator<WeakReference<C3694a<E>.b>> it = this.f13626d.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar == null) {
                it.remove();
            } else {
                bVar.m13308b(c3696d);
            }
        }
    }

    /* compiled from: CursorableLinkedList.java */
    /* renamed from: org.a.a.a.a.b */
    public class b extends C3694a<E>.C3695c implements ListIterator<E> {

        /* renamed from: a */
        boolean f13627a;

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
            super(C3694a.this, i);
            this.f13627a = false;
            this.f13627a = true;
            C3694a.this.m13295a(this);
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
            m13305a();
            C3696d<E> c3696dMo13294a = C3694a.this.mo13294a(this.c.m13314b(), this.c.m13312a(), e);
            this.c.m13315b(c3696dMo13294a);
            this.c.m13313a((C3696d) c3696dMo13294a.m13312a());
            this.d = null;
            this.f++;
            this.e++;
        }

        /* renamed from: a */
        protected void m13306a(C3696d<E> c3696d) {
            if (C3694a.this.f13624b.m13314b() == null) {
                this.c.m13313a((C3696d) null);
            } else if (this.c.m13312a() == c3696d) {
                this.c.m13313a((C3696d) c3696d.m13312a());
            }
            if (C3694a.this.f13624b.m13312a() == null) {
                this.c.m13315b(null);
            } else if (this.c.m13314b() == c3696d) {
                this.c.m13315b(c3696d.m13314b());
            }
            if (this.d == c3696d) {
                this.d = null;
            }
        }

        /* renamed from: b */
        protected void m13308b(C3696d<E> c3696d) {
            if ((this.c.m13312a() == null && this.c.m13314b() == null) || this.c.m13314b() == c3696d.m13314b()) {
                this.c.m13313a((C3696d) c3696d);
            }
            if (this.c.m13312a() == c3696d.m13312a()) {
                this.c.m13315b(c3696d);
            }
            if (this.d == c3696d) {
                this.d = null;
            }
        }

        /* renamed from: c */
        protected void m13309c(C3696d<E> c3696d) {
            if (this.d == c3696d) {
                this.d = null;
            }
        }

        /* renamed from: a */
        protected void m13305a() {
            if (!this.f13627a) {
                throw new ConcurrentModificationException();
            }
        }

        /* renamed from: b */
        public void m13307b() {
            if (this.f13627a) {
                this.f13627a = false;
                C3694a.this.m13300b(this);
            }
        }
    }
}
