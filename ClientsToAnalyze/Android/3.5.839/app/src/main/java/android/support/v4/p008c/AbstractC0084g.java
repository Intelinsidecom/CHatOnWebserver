package android.support.v4.p008c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: MapCollections.java */
/* renamed from: android.support.v4.c.g */
/* loaded from: classes.dex */
abstract class AbstractC0084g<K, V> {

    /* renamed from: b */
    AbstractC0084g<K, V>.i f254b;

    /* renamed from: c */
    AbstractC0084g<K, V>.j f255c;

    /* renamed from: d */
    AbstractC0084g<K, V>.l f256d;

    /* renamed from: a */
    protected abstract int mo249a();

    /* renamed from: a */
    protected abstract int mo250a(Object obj);

    /* renamed from: a */
    protected abstract Object mo251a(int i2, int i3);

    /* renamed from: a */
    protected abstract V mo252a(int i2, V v);

    /* renamed from: a */
    protected abstract void mo253a(int i2);

    /* renamed from: a */
    protected abstract void mo254a(K k, V v);

    /* renamed from: b */
    protected abstract int mo255b(Object obj);

    /* renamed from: b */
    protected abstract Map<K, V> mo256b();

    /* renamed from: c */
    protected abstract void mo257c();

    AbstractC0084g() {
    }

    /* compiled from: MapCollections.java */
    /* renamed from: android.support.v4.c.i */
    final class i implements Set<Map.Entry<K, V>> {
        i() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iMo249a = AbstractC0084g.this.mo249a();
            for (Map.Entry<K, V> entry : collection) {
                AbstractC0084g.this.mo254a((AbstractC0084g) entry.getKey(), (K) entry.getValue());
            }
            return iMo249a != AbstractC0084g.this.mo249a();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0084g.this.mo257c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iMo250a = AbstractC0084g.this.mo250a(entry.getKey());
            if (iMo250a >= 0) {
                return C0080c.m260a(AbstractC0084g.this.mo251a(iMo250a, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0084g.this.mo249a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C0086k(AbstractC0084g.this);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0084g.this.mo249a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0084g.m273a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iMo249a = AbstractC0084g.this.mo249a() - 1;
            int iHashCode = 0;
            while (iMo249a >= 0) {
                Object objMo251a = AbstractC0084g.this.mo251a(iMo249a, 0);
                Object objMo251a2 = AbstractC0084g.this.mo251a(iMo249a, 1);
                iMo249a--;
                iHashCode += (objMo251a2 == null ? 0 : objMo251a2.hashCode()) ^ (objMo251a == null ? 0 : objMo251a.hashCode());
            }
            return iHashCode;
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: android.support.v4.c.j */
    final class j implements Set<K> {
        j() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0084g.this.mo257c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0084g.this.mo250a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return AbstractC0084g.m272a((Map) AbstractC0084g.this.mo256b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0084g.this.mo249a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new C0085h(AbstractC0084g.this, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iMo250a = AbstractC0084g.this.mo250a(obj);
            if (iMo250a < 0) {
                return false;
            }
            AbstractC0084g.this.mo253a(iMo250a);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return AbstractC0084g.m274b(AbstractC0084g.this.mo256b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return AbstractC0084g.m275c(AbstractC0084g.this.mo256b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0084g.this.mo249a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return AbstractC0084g.this.m277b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0084g.this.m276a(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0084g.m273a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo249a = AbstractC0084g.this.mo249a() - 1; iMo249a >= 0; iMo249a--) {
                Object objMo251a = AbstractC0084g.this.mo251a(iMo249a, 0);
                iHashCode += objMo251a == null ? 0 : objMo251a.hashCode();
            }
            return iHashCode;
        }
    }

    /* compiled from: MapCollections.java */
    /* renamed from: android.support.v4.c.l */
    final class l implements Collection<V> {
        l() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            AbstractC0084g.this.mo257c();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0084g.this.mo255b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return AbstractC0084g.this.mo249a() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new C0085h(AbstractC0084g.this, 1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iMo255b = AbstractC0084g.this.mo255b(obj);
            if (iMo255b < 0) {
                return false;
            }
            AbstractC0084g.this.mo253a(iMo255b);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int iMo249a = AbstractC0084g.this.mo249a();
            boolean z = false;
            while (i < iMo249a) {
                if (collection.contains(AbstractC0084g.this.mo251a(i, 1))) {
                    AbstractC0084g.this.mo253a(i);
                    i--;
                    iMo249a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int iMo249a = AbstractC0084g.this.mo249a();
            boolean z = false;
            while (i < iMo249a) {
                if (!collection.contains(AbstractC0084g.this.mo251a(i, 1))) {
                    AbstractC0084g.this.mo253a(i);
                    i--;
                    iMo249a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return AbstractC0084g.this.mo249a();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC0084g.this.m277b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0084g.this.m276a(tArr, 1);
        }
    }

    /* renamed from: a */
    public static <K, V> boolean m272a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static <K, V> boolean m274b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m275c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: b */
    public Object[] m277b(int i2) {
        int iMo249a = mo249a();
        Object[] objArr = new Object[iMo249a];
        for (int i3 = 0; i3 < iMo249a; i3++) {
            objArr[i3] = mo251a(i3, i2);
        }
        return objArr;
    }

    /* renamed from: a */
    public <T> T[] m276a(T[] tArr, int i2) {
        int iMo249a = mo249a();
        Object[] objArr = tArr.length < iMo249a ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iMo249a)) : tArr;
        for (int i3 = 0; i3 < iMo249a; i3++) {
            objArr[i3] = mo251a(i3, i2);
        }
        if (objArr.length > iMo249a) {
            objArr[iMo249a] = null;
        }
        return (T[]) objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> boolean m273a(java.util.Set<T> r4, java.lang.Object r5) {
        /*
            r0 = 1
            r1 = 0
            if (r4 != r5) goto L6
            r1 = r0
        L5:
            return r1
        L6:
            boolean r2 = r5 instanceof java.util.Set
            if (r2 == 0) goto L5
            java.util.Set r5 = (java.util.Set) r5
            int r2 = r4.size()     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            int r3 = r5.size()     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            if (r2 != r3) goto L1e
            boolean r2 = r4.containsAll(r5)     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            if (r2 == 0) goto L1e
        L1c:
            r1 = r0
            goto L5
        L1e:
            r0 = r1
            goto L1c
        L20:
            r0 = move-exception
            goto L5
        L22:
            r0 = move-exception
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.p008c.AbstractC0084g.m273a(java.util.Set, java.lang.Object):boolean");
    }

    /* renamed from: d */
    public Set<Map.Entry<K, V>> m278d() {
        if (this.f254b == null) {
            this.f254b = new i();
        }
        return this.f254b;
    }

    /* renamed from: e */
    public Set<K> m279e() {
        if (this.f255c == null) {
            this.f255c = new j();
        }
        return this.f255c;
    }

    /* renamed from: f */
    public Collection<V> m280f() {
        if (this.f256d == null) {
            this.f256d = new l();
        }
        return this.f256d;
    }
}
