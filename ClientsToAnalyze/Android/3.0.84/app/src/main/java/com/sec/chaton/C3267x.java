package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1403au;
import com.sec.chaton.util.C3250y;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.x */
/* loaded from: classes.dex */
class C3267x extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f11792a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3267x(PlusFragment plusFragment, Handler handler) {
        super(handler);
        this.f11792a = plusFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f11792a.f719q.startQuery(0, null, C1403au.f5215a, null, null, null, "priority");
        C3250y.m11450b("onChange - More Apps list changed, ", PlusFragment.f703a);
    }
}
