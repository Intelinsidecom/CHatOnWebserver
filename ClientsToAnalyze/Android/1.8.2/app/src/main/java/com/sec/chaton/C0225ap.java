package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0694i;

/* compiled from: HomeTabletFragment.java */
/* renamed from: com.sec.chaton.ap */
/* loaded from: classes.dex */
class C0225ap extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ HomeTabletFragment f759a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0225ap(HomeTabletFragment homeTabletFragment, Handler handler) {
        super(handler);
        this.f759a = homeTabletFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f759a.f265m.startQuery(2, null, C0694i.f2616a, null, "inbox_unread_count > 0", null, null);
    }
}
