package com.sec.chaton.forward;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.forward.b */
/* loaded from: classes.dex */
class C0234b extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f1891a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0234b(ChatForwardFragment chatForwardFragment, Handler handler) {
        super(handler);
        this.f1891a = chatForwardFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f1891a.f1887n.startQuery(1, null, ChatONContract.BuddyTable.f1713a, null, "buddy_is_new='Y'", null, null);
    }
}
