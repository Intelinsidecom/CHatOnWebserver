package com.google.p034a.p036b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: LinkedTreeMap.java */
/* renamed from: com.google.a.b.w */
/* loaded from: classes.dex */
public final class C0660w<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: f */
    static final /* synthetic */ boolean f1550f;

    /* renamed from: g */
    private static final Comparator<Comparable> f1551g;

    /* renamed from: a */
    Comparator<? super K> f1552a;

    /* renamed from: b */
    C0627ad<K, V> f1553b;

    /* renamed from: c */
    int f1554c;

    /* renamed from: d */
    int f1555d;

    /* renamed from: e */
    final C0627ad<K, V> f1556e;

    /* renamed from: h */
    private C0660w<K, V>.y f1557h;

    /* renamed from: i */
    private C0660w<K, V>.C0624aa f1558i;

    static {
        f1550f = !C0660w.class.desiredAssertionStatus();
        f1551g = new C0661x();
    }

    public C0660w() {
        this(f1551g);
    }

    public C0660w(Comparator<? super K> comparator) {
        this.f1554c = 0;
        this.f1555d = 0;
        this.f1556e = new C0627ad<>();
        this.f1552a = comparator == null ? f1551g : comparator;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f1554c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        C0627ad<K, V> c0627adM2088a = m2088a(obj);
        if (c0627adM2088a != null) {
            return c0627adM2088a.f1494g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return m2088a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C0627ad<K, V> c0627adM2089a = m2089a((C0660w<K, V>) k, true);
        V v2 = c0627adM2089a.f1494g;
        c0627adM2089a.f1494g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f1553b = null;
        this.f1554c = 0;
        this.f1555d++;
        C0627ad<K, V> c0627ad = this.f1556e;
        c0627ad.f1492e = c0627ad;
        c0627ad.f1491d = c0627ad;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        C0627ad<K, V> c0627adM2092b = m2092b(obj);
        if (c0627adM2092b != null) {
            return c0627adM2092b.f1494g;
        }
        return null;
    }

    /* renamed from: a */
    C0627ad<K, V> m2089a(K k, boolean z) {
        C0627ad<K, V> c0627ad;
        int i;
        C0627ad<K, V> c0627ad2;
        Comparator<? super K> comparator = this.f1552a;
        C0627ad<K, V> c0627ad3 = this.f1553b;
        if (c0627ad3 == null) {
            c0627ad = c0627ad3;
            i = 0;
        } else {
            Comparable comparable = comparator == f1551g ? (Comparable) k : null;
            while (true) {
                int iCompareTo = comparable != null ? comparable.compareTo(c0627ad3.f1493f) : comparator.compare(k, c0627ad3.f1493f);
                if (iCompareTo == 0) {
                    return c0627ad3;
                }
                C0627ad<K, V> c0627ad4 = iCompareTo < 0 ? c0627ad3.f1489b : c0627ad3.f1490c;
                if (c0627ad4 == null) {
                    int i2 = iCompareTo;
                    c0627ad = c0627ad3;
                    i = i2;
                    break;
                }
                c0627ad3 = c0627ad4;
            }
        }
        if (!z) {
            return null;
        }
        C0627ad<K, V> c0627ad5 = this.f1556e;
        if (c0627ad == null) {
            if (comparator == f1551g && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            c0627ad2 = new C0627ad<>(c0627ad, k, c0627ad5, c0627ad5.f1492e);
            this.f1553b = c0627ad2;
        } else {
            c0627ad2 = new C0627ad<>(c0627ad, k, c0627ad5, c0627ad5.f1492e);
            if (i < 0) {
                c0627ad.f1489b = c0627ad2;
            } else {
                c0627ad.f1490c = c0627ad2;
            }
            m2087b(c0627ad, true);
        }
        this.f1554c++;
        this.f1555d++;
        return c0627ad2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    C0627ad<K, V> m2088a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return m2089a((C0660w<K, V>) obj, false);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /* renamed from: a */
    C0627ad<K, V> m2090a(Map.Entry<?, ?> entry) {
        C0627ad<K, V> c0627adM2088a = m2088a(entry.getKey());
        if (c0627adM2088a != null && m2085a(c0627adM2088a.f1494g, entry.getValue())) {
            return c0627adM2088a;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m2085a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    void m2091a(C0627ad<K, V> c0627ad, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            c0627ad.f1492e.f1491d = c0627ad.f1491d;
            c0627ad.f1491d.f1492e = c0627ad.f1492e;
        }
        C0627ad<K, V> c0627ad2 = c0627ad.f1489b;
        C0627ad<K, V> c0627ad3 = c0627ad.f1490c;
        C0627ad<K, V> c0627ad4 = c0627ad.f1488a;
        if (c0627ad2 != null && c0627ad3 != null) {
            C0627ad<K, V> c0627adM2037b = c0627ad2.f1495h > c0627ad3.f1495h ? c0627ad2.m2037b() : c0627ad3.m2036a();
            m2091a((C0627ad) c0627adM2037b, false);
            C0627ad<K, V> c0627ad5 = c0627ad.f1489b;
            if (c0627ad5 != null) {
                i = c0627ad5.f1495h;
                c0627adM2037b.f1489b = c0627ad5;
                c0627ad5.f1488a = c0627adM2037b;
                c0627ad.f1489b = null;
            } else {
                i = 0;
            }
            C0627ad<K, V> c0627ad6 = c0627ad.f1490c;
            if (c0627ad6 != null) {
                i2 = c0627ad6.f1495h;
                c0627adM2037b.f1490c = c0627ad6;
                c0627ad6.f1488a = c0627adM2037b;
                c0627ad.f1490c = null;
            }
            c0627adM2037b.f1495h = Math.max(i, i2) + 1;
            m2084a((C0627ad) c0627ad, (C0627ad) c0627adM2037b);
            return;
        }
        if (c0627ad2 != null) {
            m2084a((C0627ad) c0627ad, (C0627ad) c0627ad2);
            c0627ad.f1489b = null;
        } else if (c0627ad3 != null) {
            m2084a((C0627ad) c0627ad, (C0627ad) c0627ad3);
            c0627ad.f1490c = null;
        } else {
            m2084a((C0627ad) c0627ad, (C0627ad) null);
        }
        m2087b(c0627ad4, false);
        this.f1554c--;
        this.f1555d++;
    }

    /* renamed from: b */
    C0627ad<K, V> m2092b(Object obj) {
        C0627ad<K, V> c0627adM2088a = m2088a(obj);
        if (c0627adM2088a != null) {
            m2091a((C0627ad) c0627adM2088a, true);
        }
        return c0627adM2088a;
    }

    /* renamed from: a */
    private void m2084a(C0627ad<K, V> c0627ad, C0627ad<K, V> c0627ad2) {
        C0627ad<K, V> c0627ad3 = c0627ad.f1488a;
        c0627ad.f1488a = null;
        if (c0627ad2 != null) {
            c0627ad2.f1488a = c0627ad3;
        }
        if (c0627ad3 != null) {
            if (c0627ad3.f1489b == c0627ad) {
                c0627ad3.f1489b = c0627ad2;
                return;
            } else {
                if (!f1550f && c0627ad3.f1490c != c0627ad) {
                    throw new AssertionError();
                }
                c0627ad3.f1490c = c0627ad2;
                return;
            }
        }
        this.f1553b = c0627ad2;
    }

    /* renamed from: b */
    private void m2087b(C0627ad<K, V> c0627ad, boolean z) {
        while (c0627ad != null) {
            C0627ad<K, V> c0627ad2 = c0627ad.f1489b;
            C0627ad<K, V> c0627ad3 = c0627ad.f1490c;
            int i = c0627ad2 != null ? c0627ad2.f1495h : 0;
            int i2 = c0627ad3 != null ? c0627ad3.f1495h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                C0627ad<K, V> c0627ad4 = c0627ad3.f1489b;
                C0627ad<K, V> c0627ad5 = c0627ad3.f1490c;
                int i4 = (c0627ad4 != null ? c0627ad4.f1495h : 0) - (c0627ad5 != null ? c0627ad5.f1495h : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    m2083a((C0627ad) c0627ad);
                } else {
                    if (!f1550f && i4 != 1) {
                        throw new AssertionError();
                    }
                    m2086b((C0627ad) c0627ad3);
                    m2083a((C0627ad) c0627ad);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                C0627ad<K, V> c0627ad6 = c0627ad2.f1489b;
                C0627ad<K, V> c0627ad7 = c0627ad2.f1490c;
                int i5 = (c0627ad6 != null ? c0627ad6.f1495h : 0) - (c0627ad7 != null ? c0627ad7.f1495h : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    m2086b((C0627ad) c0627ad);
                } else {
                    if (!f1550f && i5 != -1) {
                        throw new AssertionError();
                    }
                    m2083a((C0627ad) c0627ad2);
                    m2086b((C0627ad) c0627ad);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                c0627ad.f1495h = i + 1;
                if (z) {
                    return;
                }
            } else {
                if (!f1550f && i3 != -1 && i3 != 1) {
                    throw new AssertionError();
                }
                c0627ad.f1495h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            c0627ad = c0627ad.f1488a;
        }
    }

    /* renamed from: a */
    private void m2083a(C0627ad<K, V> c0627ad) {
        C0627ad<K, V> c0627ad2 = c0627ad.f1489b;
        C0627ad<K, V> c0627ad3 = c0627ad.f1490c;
        C0627ad<K, V> c0627ad4 = c0627ad3.f1489b;
        C0627ad<K, V> c0627ad5 = c0627ad3.f1490c;
        c0627ad.f1490c = c0627ad4;
        if (c0627ad4 != null) {
            c0627ad4.f1488a = c0627ad;
        }
        m2084a((C0627ad) c0627ad, (C0627ad) c0627ad3);
        c0627ad3.f1489b = c0627ad;
        c0627ad.f1488a = c0627ad3;
        c0627ad.f1495h = Math.max(c0627ad2 != null ? c0627ad2.f1495h : 0, c0627ad4 != null ? c0627ad4.f1495h : 0) + 1;
        c0627ad3.f1495h = Math.max(c0627ad.f1495h, c0627ad5 != null ? c0627ad5.f1495h : 0) + 1;
    }

    /* renamed from: b */
    private void m2086b(C0627ad<K, V> c0627ad) {
        C0627ad<K, V> c0627ad2 = c0627ad.f1489b;
        C0627ad<K, V> c0627ad3 = c0627ad.f1490c;
        C0627ad<K, V> c0627ad4 = c0627ad2.f1489b;
        C0627ad<K, V> c0627ad5 = c0627ad2.f1490c;
        c0627ad.f1489b = c0627ad5;
        if (c0627ad5 != null) {
            c0627ad5.f1488a = c0627ad;
        }
        m2084a((C0627ad) c0627ad, (C0627ad) c0627ad2);
        c0627ad2.f1490c = c0627ad;
        c0627ad.f1488a = c0627ad2;
        c0627ad.f1495h = Math.max(c0627ad3 != null ? c0627ad3.f1495h : 0, c0627ad5 != null ? c0627ad5.f1495h : 0) + 1;
        c0627ad2.f1495h = Math.max(c0627ad.f1495h, c0627ad4 != null ? c0627ad4.f1495h : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        C0660w<K, V>.y yVar = this.f1557h;
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y();
        this.f1557h = yVar2;
        return yVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        C0660w<K, V>.C0624aa aaVar = this.f1558i;
        if (aaVar != null) {
            return aaVar;
        }
        C0624aa c0624aa = new C0624aa();
        this.f1558i = c0624aa;
        return c0624aa;
    }

    /* compiled from: LinkedTreeMap.java */
    /* renamed from: com.google.a.b.y */
    class y extends AbstractSet<Map.Entry<K, V>> {
        y() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C0660w.this.f1554c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C0662z(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && C0660w.this.m2090a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            C0627ad<K, V> c0627adM2090a;
            if (!(obj instanceof Map.Entry) || (c0627adM2090a = C0660w.this.m2090a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            C0660w.this.m2091a((C0627ad) c0627adM2090a, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C0660w.this.clear();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K] */
    /* compiled from: LinkedTreeMap.java */
    /* renamed from: com.google.a.b.aa */
    class C0624aa extends AbstractSet<K> {
        C0624aa() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C0660w.this.f1554c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new C0625ab(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C0660w.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return C0660w.this.m2092b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C0660w.this.clear();
        }
    }
}
