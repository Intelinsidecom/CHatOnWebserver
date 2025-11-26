package com.sec.chaton.p027e.p029b;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.common.CommonApplication;

/* compiled from: BuddyGroupDeleteTask.java */
/* renamed from: com.sec.chaton.e.b.j */
/* loaded from: classes.dex */
public class C1419j extends AbstractC1410a {

    /* renamed from: c */
    private long[] f5265c;

    public C1419j(InterfaceC1413d interfaceC1413d, int i) {
        super(interfaceC1413d, new Handler(Looper.getMainLooper()));
        this.f5265c = new long[]{i};
    }

    @Override // com.sec.chaton.p027e.p029b.AbstractC1410a
    /* renamed from: a */
    public Object mo6263a() {
        for (long j : this.f5265c) {
            C1362f.m6063a(CommonApplication.m11493l().getContentResolver(), String.valueOf(j));
            C1362f.m6069b(CommonApplication.m11493l().getContentResolver(), String.valueOf(j));
        }
        return this.f5265c;
    }
}
