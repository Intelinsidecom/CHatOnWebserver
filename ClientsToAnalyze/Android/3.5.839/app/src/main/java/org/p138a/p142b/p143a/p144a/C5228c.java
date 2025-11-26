package org.p138a.p142b.p143a.p144a;

import java.util.Iterator;

/* compiled from: ByteQueue.java */
/* renamed from: org.a.b.a.a.c */
/* loaded from: classes.dex */
public class C5228c implements Iterable<Byte> {

    /* renamed from: b */
    private int f19064b = -1;

    /* renamed from: a */
    private C5231f f19063a = new C5231f();

    /* renamed from: a */
    public void m19918a(byte b2) {
        this.f19063a.m19935a(b2);
    }

    /* renamed from: a */
    public byte m19917a() {
        return this.f19063a.m19937c();
    }

    /* renamed from: b */
    public int m19919b() {
        return this.f19063a.m19934a();
    }

    /* renamed from: c */
    public void m19920c() {
        if (this.f19064b != -1) {
            this.f19063a = new C5231f(this.f19064b);
        } else {
            this.f19063a = new C5231f();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return this.f19063a.m19938d();
    }
}
