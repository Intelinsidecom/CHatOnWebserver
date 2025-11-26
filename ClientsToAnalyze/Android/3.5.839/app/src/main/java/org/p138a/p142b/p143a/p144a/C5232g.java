package org.p138a.p142b.p143a.p144a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: UnboundedFifoByteBuffer.java */
/* renamed from: org.a.b.a.a.g */
/* loaded from: classes.dex */
class C5232g implements Iterator<Byte> {

    /* renamed from: a */
    final /* synthetic */ C5231f f19075a;

    /* renamed from: b */
    private int f19076b;

    /* renamed from: c */
    private int f19077c = -1;

    C5232g(C5231f c5231f) {
        this.f19075a = c5231f;
        this.f19076b = this.f19075a.f19073b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f19076b != this.f19075a.f19074c;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Byte next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f19077c = this.f19076b;
        this.f19076b = this.f19075a.m19930a(this.f19076b);
        return new Byte(this.f19075a.f19072a[this.f19077c]);
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.f19077c == -1) {
            throw new IllegalStateException();
        }
        if (this.f19077c == this.f19075a.f19073b) {
            this.f19075a.m19937c();
            this.f19077c = -1;
            return;
        }
        int i = this.f19077c + 1;
        while (i != this.f19075a.f19074c) {
            if (i >= this.f19075a.f19072a.length) {
                this.f19075a.f19072a[i - 1] = this.f19075a.f19072a[0];
                i = 0;
            } else {
                this.f19075a.f19072a[i - 1] = this.f19075a.f19072a[i];
                i++;
            }
        }
        this.f19077c = -1;
        this.f19075a.f19074c = this.f19075a.m19932b(this.f19075a.f19074c);
        this.f19075a.f19072a[this.f19075a.f19074c] = 0;
        this.f19076b = this.f19075a.m19932b(this.f19076b);
    }
}
