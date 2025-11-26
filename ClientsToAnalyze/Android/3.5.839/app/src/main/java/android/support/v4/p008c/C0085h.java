package android.support.v4.p008c;

import java.util.Iterator;

/* compiled from: MapCollections.java */
/* renamed from: android.support.v4.c.h */
/* loaded from: classes.dex */
final class C0085h<T> implements Iterator<T> {

    /* renamed from: a */
    final int f257a;

    /* renamed from: b */
    int f258b;

    /* renamed from: c */
    int f259c;

    /* renamed from: d */
    boolean f260d = false;

    /* renamed from: e */
    final /* synthetic */ AbstractC0084g f261e;

    C0085h(AbstractC0084g abstractC0084g, int i) {
        this.f261e = abstractC0084g;
        this.f257a = i;
        this.f258b = abstractC0084g.mo249a();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f259c < this.f258b;
    }

    @Override // java.util.Iterator
    public T next() {
        T t = (T) this.f261e.mo251a(this.f259c, this.f257a);
        this.f259c++;
        this.f260d = true;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f260d) {
            throw new IllegalStateException();
        }
        this.f259c--;
        this.f258b--;
        this.f260d = false;
        this.f261e.mo253a(this.f259c);
    }
}
