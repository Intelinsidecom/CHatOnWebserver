package com.sec.chaton.qmlog;

import java.util.ArrayList;
import java.util.List;

/* compiled from: QMLogHelper.java */
/* renamed from: com.sec.chaton.qmlog.b */
/* loaded from: classes.dex */
class C3120b {

    /* renamed from: a */
    protected long f11470a;

    /* renamed from: b */
    final /* synthetic */ C3119a f11471b;

    /* renamed from: c */
    private List<C3121c> f11472c = new ArrayList();

    C3120b(C3119a c3119a) {
        this.f11471b = c3119a;
    }

    /* renamed from: a */
    void m12727a(long j) {
        this.f11470a = j;
    }

    /* renamed from: a */
    long m12726a() {
        return this.f11470a;
    }

    /* renamed from: a */
    void m12728a(long j, long j2) {
        this.f11472c.add(new C3121c(this, j, j2));
    }

    /* renamed from: a */
    void m12729a(EnumC3124f enumC3124f, long j) {
        for (C3121c c3121c : this.f11472c) {
            C3122d.m12732a().m12747a(enumC3124f, c3121c.f11473a, c3121c.f11474b, this.f11470a, j);
        }
    }
}
