package org.p138a.p139a.p140a.p141a;

import com.sec.spp.push.Config;

/* compiled from: GenericKeyedObjectPool.java */
/* renamed from: org.a.a.a.a.o */
/* loaded from: classes.dex */
class C5217o<T> implements Comparable<T> {

    /* renamed from: a */
    @Deprecated
    T f19031a;

    /* renamed from: b */
    @Deprecated
    long f19032b;

    C5217o(T t) {
        this(t, System.currentTimeMillis());
    }

    C5217o(T t, long j) {
        this.f19031a = t;
        this.f19032b = j;
    }

    public String toString() {
        return this.f19031a + Config.KEYVALUE_SPLIT + this.f19032b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return m19895a((C5217o) obj);
    }

    /* renamed from: a */
    public int m19895a(C5217o<T> c5217o) {
        long j = this.f19032b - c5217o.f19032b;
        return j == 0 ? System.identityHashCode(this) - System.identityHashCode(c5217o) : (int) Math.min(Math.max(j, -2147483648L), 2147483647L);
    }

    /* renamed from: a */
    public T m19896a() {
        return this.f19031a;
    }
}
