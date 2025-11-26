package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2262bh;
import com.sec.chaton.util.C4904y;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.bn */
/* loaded from: classes.dex */
class C1095bn extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f3494a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1095bn(PlusFragment plusFragment, Handler handler) {
        super(handler);
        this.f3494a = plusFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f3494a.f1993t = true;
        this.f3494a.f1995v.startQuery(102, null, C2262bh.f8053a, null, null, null, "priority");
        if (C4904y.f17872b) {
            C4904y.m18639b("onChange - More Apps list changed, ", PlusFragment.f1956a);
        }
    }
}
