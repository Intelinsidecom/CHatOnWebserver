package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0704s;

/* compiled from: HomeTabletFragment.java */
/* renamed from: com.sec.chaton.ao */
/* loaded from: classes.dex */
class C0224ao extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ HomeTabletFragment f758a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0224ao(HomeTabletFragment homeTabletFragment, Handler handler) {
        super(handler);
        this.f758a = homeTabletFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f758a.f265m.startQuery(3, null, C0704s.f2647a, null, "isNew='Y'", null, null);
    }
}
