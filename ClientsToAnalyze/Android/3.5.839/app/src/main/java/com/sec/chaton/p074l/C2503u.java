package com.sec.chaton.p074l;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: ProfileImageManager.java */
/* renamed from: com.sec.chaton.l.u */
/* loaded from: classes.dex */
final class C2503u<T> extends FutureTask<T> implements Comparable<C2503u<T>> {

    /* renamed from: a */
    private InterfaceC2493k f8966a;

    public C2503u(Callable<T> callable) {
        super(callable);
        try {
            this.f8966a = (InterfaceC2493k) callable;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public C2503u(Runnable runnable, T t) {
        super(runnable, t);
        try {
            this.f8966a = (InterfaceC2493k) runnable;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C2503u<T> c2503u) {
        return this.f8966a.compareTo(c2503u.f8966a);
    }
}
