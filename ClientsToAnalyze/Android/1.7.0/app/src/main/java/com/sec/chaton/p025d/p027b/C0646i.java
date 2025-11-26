package com.sec.chaton.p025d.p027b;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.p026a.C0622b;

/* compiled from: BuddyGroupDeleteTask.java */
/* renamed from: com.sec.chaton.d.b.i */
/* loaded from: classes.dex */
public class C0646i extends AbstractC0647j {

    /* renamed from: a */
    private long[] f2248a;

    public C0646i(InterfaceC0641d interfaceC0641d, int i) {
        super(interfaceC0641d, new Handler(Looper.getMainLooper()));
        this.f2248a = new long[]{i};
    }

    @Override // com.sec.chaton.p025d.p027b.AbstractC0647j
    /* renamed from: a */
    public Object mo2950a() {
        for (long j : this.f2248a) {
            C0622b.m2845a(GlobalApplication.m3100a().getContentResolver(), String.valueOf(j));
            C0622b.m2846b(GlobalApplication.m3100a().getContentResolver(), String.valueOf(j));
        }
        return this.f2248a;
    }
}
