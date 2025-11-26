package com.sec.google.android.p134a.p136b;

import java.util.HashMap;

/* compiled from: AbstractCache.java */
/* renamed from: com.sec.google.android.a.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC5105a<K, V> {

    /* renamed from: a */
    private final HashMap<K, C5107c<V>> f18584a = new HashMap<>();

    protected AbstractC5105a() {
    }

    /* renamed from: a */
    public boolean mo19483a(K k, V v) {
        if (this.f18584a.size() >= 500 || k == null) {
            return false;
        }
        C5107c<V> c5107c = new C5107c<>();
        c5107c.f18586b = v;
        this.f18584a.put(k, c5107c);
        return true;
    }

    /* renamed from: a */
    public V m19481a(K k) {
        C5107c<V> c5107c;
        if (k == null || (c5107c = this.f18584a.get(k)) == null) {
            return null;
        }
        c5107c.f18585a++;
        return c5107c.f18586b;
    }

    /* renamed from: b */
    public V mo19484b(K k) {
        C5107c<V> c5107cRemove = this.f18584a.remove(k);
        if (c5107cRemove != null) {
            return c5107cRemove.f18586b;
        }
        return null;
    }

    /* renamed from: a */
    public void mo19482a() {
        this.f18584a.clear();
    }
}
