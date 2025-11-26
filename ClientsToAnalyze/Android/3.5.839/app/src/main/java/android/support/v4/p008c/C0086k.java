package android.support.v4.p008c;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: MapCollections.java */
/* renamed from: android.support.v4.c.k */
/* loaded from: classes.dex */
final class C0086k<K, V> implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

    /* renamed from: a */
    int f264a;

    /* renamed from: d */
    final /* synthetic */ AbstractC0084g f267d;

    /* renamed from: c */
    boolean f266c = false;

    /* renamed from: b */
    int f265b = -1;

    C0086k(AbstractC0084g abstractC0084g) {
        this.f267d = abstractC0084g;
        this.f264a = abstractC0084g.mo249a() - 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f265b < this.f264a;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        this.f265b++;
        this.f266c = true;
        return this;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f266c) {
            throw new IllegalStateException();
        }
        this.f265b--;
        this.f264a--;
        this.f266c = false;
        this.f267d.mo253a(this.f265b);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        if (!this.f266c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return (K) this.f267d.mo251a(this.f265b, 0);
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        if (!this.f266c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return (V) this.f267d.mo251a(this.f265b, 1);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        if (!this.f266c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return (V) this.f267d.mo252a(this.f265b, (int) v);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f266c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return C0080c.m260a(entry.getKey(), this.f267d.mo251a(this.f265b, 0)) && C0080c.m260a(entry.getValue(), this.f267d.mo251a(this.f265b, 1));
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f266c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        Object objMo251a = this.f267d.mo251a(this.f265b, 0);
        Object objMo251a2 = this.f267d.mo251a(this.f265b, 1);
        return (objMo251a2 != null ? objMo251a2.hashCode() : 0) ^ (objMo251a == null ? 0 : objMo251a.hashCode());
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
