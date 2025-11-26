package com.sec.chaton.push.p054c;

import android.content.Context;

/* compiled from: AbstractMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC2072a implements Comparable<AbstractC2072a> {

    /* renamed from: a */
    private Context f7942a;

    /* renamed from: b */
    private final long f7943b;

    /* renamed from: c */
    public abstract C2087h mo8194c();

    public AbstractC2072a(Context context, long j) {
        this.f7942a = context;
        this.f7943b = j;
    }

    /* renamed from: a */
    public Context m8192a() {
        return this.f7942a;
    }

    /* renamed from: b */
    public long m8193b() {
        return this.f7943b;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AbstractC2072a abstractC2072a) {
        long jM8193b = this.f7943b - abstractC2072a.m8193b();
        if (jM8193b < 0) {
            return -1;
        }
        if (jM8193b == 0) {
            return 0;
        }
        return 1;
    }

    public String toString() {
        return String.format("%s(Priority: %d).", getClass().getSimpleName(), Long.valueOf(this.f7943b));
    }
}
