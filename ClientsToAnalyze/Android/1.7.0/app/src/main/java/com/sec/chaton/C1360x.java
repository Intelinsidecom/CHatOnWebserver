package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p025d.C0671x;

/* compiled from: HomeTabFragment.java */
/* renamed from: com.sec.chaton.x */
/* loaded from: classes.dex */
class C1360x extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f4619a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1360x(HomeTabFragment homeTabFragment, Handler handler) {
        super(handler);
        this.f4619a = homeTabFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f4619a.f274g.startQuery(2, null, C0671x.f2315a, null, "inbox_unread_count > 0", null, null);
    }
}
