package com.sec.chaton.push.p039c;

import android.content.Context;

/* compiled from: AbstractMessageTask.java */
/* renamed from: com.sec.chaton.push.c.f */
/* loaded from: classes.dex */
public abstract class AbstractC0894f implements Comparable {

    /* renamed from: a */
    private Context f3063a;

    /* renamed from: b */
    private final long f3064b;

    /* renamed from: d */
    public abstract C0881a mo3488d();

    public AbstractC0894f(Context context, long j) {
        this.f3063a = context;
        this.f3064b = j;
    }

    /* renamed from: e */
    public Context m3518e() {
        return this.f3063a;
    }

    /* renamed from: f */
    public long m3519f() {
        return this.f3064b;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AbstractC0894f abstractC0894f) {
        long jM3519f = this.f3064b - abstractC0894f.m3519f();
        if (jM3519f < 0) {
            return -1;
        }
        if (jM3519f == 0) {
            return 0;
        }
        return 1;
    }

    public String toString() {
        return String.format("%s(Priority: %d).", getClass().getSimpleName(), Long.valueOf(this.f3064b));
    }
}
