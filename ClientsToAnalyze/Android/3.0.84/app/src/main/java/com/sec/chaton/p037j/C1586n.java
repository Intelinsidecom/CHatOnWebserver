package com.sec.chaton.p037j;

import com.sec.chaton.p025d.p026a.AbstractC1145a;
import java.util.concurrent.FutureTask;

/* compiled from: HttpNetworkQueue.java */
/* renamed from: com.sec.chaton.j.n */
/* loaded from: classes.dex */
class C1586n<T> extends FutureTask<T> implements Comparable<C1586n<T>> {

    /* renamed from: a */
    private AbstractC1145a f5896a;

    public C1586n(AbstractC1145a abstractC1145a) {
        super(abstractC1145a);
        this.f5896a = abstractC1145a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1586n<T> c1586n) {
        return this.f5896a.compareTo(c1586n.f5896a);
    }
}
