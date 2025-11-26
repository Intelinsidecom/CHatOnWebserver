package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0694i;

/* compiled from: HomeTabFragment.java */
/* renamed from: com.sec.chaton.aj */
/* loaded from: classes.dex */
class C0219aj extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f754a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0219aj(HomeTabFragment homeTabFragment, Handler handler) {
        super(handler);
        this.f754a = homeTabFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f754a.f248l.startQuery(2, null, C0694i.f2616a, null, "inbox_unread_count > 0", null, null);
    }
}
