package com.sec.chaton.push.p094c;

import android.content.Context;

/* compiled from: AbstractMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC3072a implements Comparable<AbstractC3072a> {

    /* renamed from: a */
    private Context f11352a;

    /* renamed from: b */
    private final long f11353b;

    /* renamed from: c */
    public abstract C3087h mo12537c();

    public AbstractC3072a(Context context, long j) {
        this.f11352a = context;
        this.f11353b = j;
    }

    /* renamed from: a */
    public Context m12535a() {
        return this.f11352a;
    }

    /* renamed from: b */
    public long m12536b() {
        return this.f11353b;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AbstractC3072a abstractC3072a) {
        long jM12536b = this.f11353b - abstractC3072a.m12536b();
        if (jM12536b < 0) {
            return -1;
        }
        if (jM12536b == 0) {
            return 0;
        }
        return 1;
    }

    public String toString() {
        return String.format("%s(Priority: %d).", getClass().getSimpleName(), Long.valueOf(this.f11353b));
    }
}
