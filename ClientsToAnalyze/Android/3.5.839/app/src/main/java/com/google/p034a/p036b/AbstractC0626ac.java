package com.google.p034a.p036b;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: LinkedTreeMap.java */
/* renamed from: com.google.a.b.ac */
/* loaded from: classes.dex */
abstract class AbstractC0626ac<T> implements Iterator<T> {

    /* renamed from: b */
    C0627ad<K, V> f1484b;

    /* renamed from: c */
    C0627ad<K, V> f1485c;

    /* renamed from: d */
    int f1486d;

    /* renamed from: e */
    final /* synthetic */ C0660w f1487e;

    private AbstractC0626ac(C0660w c0660w) {
        this.f1487e = c0660w;
        this.f1484b = this.f1487e.f1556e.f1491d;
        this.f1485c = null;
        this.f1486d = this.f1487e.f1555d;
    }

    /* synthetic */ AbstractC0626ac(C0660w c0660w, C0661x c0661x) {
        this(c0660w);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1484b != this.f1487e.f1556e;
    }

    /* renamed from: b */
    final C0627ad<K, V> m2035b() {
        C0627ad<K, V> c0627ad = this.f1484b;
        if (c0627ad == this.f1487e.f1556e) {
            throw new NoSuchElementException();
        }
        if (this.f1487e.f1555d != this.f1486d) {
            throw new ConcurrentModificationException();
        }
        this.f1484b = c0627ad.f1491d;
        this.f1485c = c0627ad;
        return c0627ad;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f1485c == null) {
            throw new IllegalStateException();
        }
        this.f1487e.m2091a((C0627ad) this.f1485c, true);
        this.f1485c = null;
        this.f1486d = this.f1487e.f1555d;
    }
}
