package com.sec.chaton.p017e.p019b;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.p018a.C0658b;

/* compiled from: BuddyGroupDeleteTask.java */
/* renamed from: com.sec.chaton.e.b.h */
/* loaded from: classes.dex */
public class C0681h extends AbstractC0674a {

    /* renamed from: b */
    private long[] f2577b;

    public C0681h(InterfaceC0677d interfaceC0677d, int i) {
        super(interfaceC0677d, new Handler(Looper.getMainLooper()));
        this.f2577b = new long[]{i};
    }

    @Override // com.sec.chaton.p017e.p019b.AbstractC0674a
    /* renamed from: a */
    public Object mo3098a() {
        for (long j : this.f2577b) {
            C0658b.m2991a(GlobalApplication.m3260b().getContentResolver(), String.valueOf(j));
            C0658b.m2994b(GlobalApplication.m3260b().getContentResolver(), String.valueOf(j));
        }
        return this.f2577b;
    }
}
