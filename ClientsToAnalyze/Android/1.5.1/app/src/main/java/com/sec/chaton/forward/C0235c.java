package com.sec.chaton.forward;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.forward.c */
/* loaded from: classes.dex */
class C0235c extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f1892a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0235c(ChatForwardFragment chatForwardFragment, Handler handler) {
        super(handler);
        this.f1892a = chatForwardFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f1892a.f1887n.startQuery(2, null, ChatONContract.InBoxTable.f1717a, null, "inbox_unread_count > 0", null, null);
    }
}
