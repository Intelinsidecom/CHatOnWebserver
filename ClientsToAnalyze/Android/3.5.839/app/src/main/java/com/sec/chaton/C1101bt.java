package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2264bj;
import com.sec.chaton.util.C4904y;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.bt */
/* loaded from: classes.dex */
class C1101bt extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f3502a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1101bt(PlusFragment plusFragment, Handler handler) {
        super(handler);
        this.f3502a = plusFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f3502a.f1995v.startQuery(101, null, C2264bj.f8054a, null, null, null, "start_time DESC");
        if (C4904y.f17872b) {
            C4904y.m18639b("onChange - Plus list changed, ", PlusFragment.f1956a);
        }
    }
}
