package com.sec.chaton.p057e.p059b;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.common.CommonApplication;

/* compiled from: BuddyGroupDeleteTask.java */
/* renamed from: com.sec.chaton.e.b.j */
/* loaded from: classes.dex */
public class C2249j extends AbstractC2240a {

    /* renamed from: c */
    private long[] f8005c;

    public C2249j(InterfaceC2243d interfaceC2243d, int i) {
        super(interfaceC2243d, new Handler(Looper.getMainLooper()));
        this.f8005c = new long[]{i};
    }

    @Override // com.sec.chaton.p057e.p059b.AbstractC2240a
    /* renamed from: a */
    public Object mo8896a() {
        for (long j : this.f8005c) {
            C2191e.m9856a(CommonApplication.m18732r().getContentResolver(), String.valueOf(j));
            C2191e.m9862b(CommonApplication.m18732r().getContentResolver(), String.valueOf(j));
        }
        return this.f8005c;
    }
}
