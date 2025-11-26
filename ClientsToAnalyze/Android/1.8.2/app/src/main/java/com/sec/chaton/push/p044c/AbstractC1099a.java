package com.sec.chaton.push.p044c;

import android.content.Context;

/* compiled from: AbstractMessageTask.java */
/* renamed from: com.sec.chaton.push.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC1099a implements Comparable {

    /* renamed from: a */
    private Context f4040a;

    /* renamed from: b */
    private final long f4041b;

    /* renamed from: c */
    public abstract C1114h mo4150c();

    public AbstractC1099a(Context context, long j) {
        this.f4040a = context;
        this.f4041b = j;
    }

    /* renamed from: a */
    public Context m4148a() {
        return this.f4040a;
    }

    /* renamed from: b */
    public long m4149b() {
        return this.f4041b;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AbstractC1099a abstractC1099a) {
        long jM4149b = this.f4041b - abstractC1099a.m4149b();
        if (jM4149b < 0) {
            return -1;
        }
        if (jM4149b == 0) {
            return 0;
        }
        return 1;
    }

    public String toString() {
        return String.format("%s(Priority: %d).", getClass().getSimpleName(), Long.valueOf(this.f4041b));
    }
}
