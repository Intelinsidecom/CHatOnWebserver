package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.chat.x */
/* loaded from: classes.dex */
class C0162x extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f984a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0162x(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f984a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f984a.f743M.startQuery(6, null, ChatONContract.InBoxTable.f1717a, null, "inbox_unread_count > 0", null, null);
    }
}
