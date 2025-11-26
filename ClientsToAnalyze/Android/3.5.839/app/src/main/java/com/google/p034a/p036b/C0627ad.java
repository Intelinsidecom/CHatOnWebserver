package com.google.p034a.p036b;

import java.util.Map;

/* compiled from: LinkedTreeMap.java */
/* renamed from: com.google.a.b.ad */
/* loaded from: classes.dex */
final class C0627ad<K, V> implements Map.Entry<K, V> {

    /* renamed from: a */
    C0627ad<K, V> f1488a;

    /* renamed from: b */
    C0627ad<K, V> f1489b;

    /* renamed from: c */
    C0627ad<K, V> f1490c;

    /* renamed from: d */
    C0627ad<K, V> f1491d;

    /* renamed from: e */
    C0627ad<K, V> f1492e;

    /* renamed from: f */
    final K f1493f;

    /* renamed from: g */
    V f1494g;

    /* renamed from: h */
    int f1495h;

    C0627ad() {
        this.f1493f = null;
        this.f1492e = this;
        this.f1491d = this;
    }

    C0627ad(C0627ad<K, V> c0627ad, K k, C0627ad<K, V> c0627ad2, C0627ad<K, V> c0627ad3) {
        this.f1488a = c0627ad;
        this.f1493f = k;
        this.f1495h = 1;
        this.f1491d = c0627ad2;
        this.f1492e = c0627ad3;
        c0627ad3.f1491d = this;
        c0627ad2.f1492e = this;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.f1493f;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.f1494g;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        V v2 = this.f1494g;
        this.f1494g = v;
        return v2;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.f1493f == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!this.f1493f.equals(entry.getKey())) {
            return false;
        }
        if (this.f1494g == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!this.f1494g.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (this.f1493f == null ? 0 : this.f1493f.hashCode()) ^ (this.f1494g != null ? this.f1494g.hashCode() : 0);
    }

    public String toString() {
        return this.f1493f + "=" + this.f1494g;
    }

    /* renamed from: a */
    public C0627ad<K, V> m2036a() {
        for (C0627ad<K, V> c0627ad = this.f1489b; c0627ad != null; c0627ad = c0627ad.f1489b) {
            this = c0627ad;
        }
        return this;
    }

    /* renamed from: b */
    public C0627ad<K, V> m2037b() {
        for (C0627ad<K, V> c0627ad = this.f1490c; c0627ad != null; c0627ad = c0627ad.f1490c) {
            this = c0627ad;
        }
        return this;
    }
}
