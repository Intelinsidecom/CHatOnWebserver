package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0688c;

/* compiled from: HomeTabletFragment.java */
/* renamed from: com.sec.chaton.an */
/* loaded from: classes.dex */
class C0223an extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ HomeTabletFragment f757a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0223an(HomeTabletFragment homeTabletFragment, Handler handler) {
        super(handler);
        this.f757a = homeTabletFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f757a.f265m.startQuery(1, null, C0688c.f2606a, null, "buddy_is_new='Y'", null, null);
    }
}
