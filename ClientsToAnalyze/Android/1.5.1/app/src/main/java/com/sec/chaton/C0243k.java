package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.k */
/* loaded from: classes.dex */
class C0243k extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f1919a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0243k(HomeTabFragment homeTabFragment, Handler handler) {
        super(handler);
        this.f1919a = homeTabFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f1919a.f310l.startQuery(1, null, ChatONContract.BuddyTable.f1713a, null, "buddy_is_new='Y'", null, null);
    }
}
