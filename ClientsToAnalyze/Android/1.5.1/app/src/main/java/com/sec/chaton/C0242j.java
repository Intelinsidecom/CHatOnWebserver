package com.sec.chaton;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.j */
/* loaded from: classes.dex */
class C0242j extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ HomeTabFragment f1918a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0242j(HomeTabFragment homeTabFragment, Handler handler) {
        super(handler);
        this.f1918a = homeTabFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f1918a.f310l.startQuery(2, null, ChatONContract.InBoxTable.f1717a, null, "inbox_unread_count > 0", null, null);
    }
}
