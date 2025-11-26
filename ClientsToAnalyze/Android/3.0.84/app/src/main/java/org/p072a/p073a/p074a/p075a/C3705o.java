package org.p072a.p073a.p074a.p075a;

import com.sec.spp.push.Config;

/* compiled from: GenericKeyedObjectPool.java */
/* renamed from: org.a.a.a.a.o */
/* loaded from: classes.dex */
class C3705o<T> implements Comparable<T> {

    /* renamed from: a */
    @Deprecated
    T f13676a;

    /* renamed from: b */
    @Deprecated
    long f13677b;

    C3705o(T t) {
        this(t, System.currentTimeMillis());
    }

    C3705o(T t, long j) {
        this.f13676a = t;
        this.f13677b = j;
    }

    public String toString() {
        return this.f13676a + Config.KEYVALUE_SPLIT + this.f13677b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return m13367a((C3705o) obj);
    }

    /* renamed from: a */
    public int m13367a(C3705o<T> c3705o) {
        long j = this.f13677b - c3705o.f13677b;
        return j == 0 ? System.identityHashCode(this) - System.identityHashCode(c3705o) : (int) Math.min(Math.max(j, -2147483648L), 2147483647L);
    }

    /* renamed from: a */
    public T m13368a() {
        return this.f13676a;
    }
}
