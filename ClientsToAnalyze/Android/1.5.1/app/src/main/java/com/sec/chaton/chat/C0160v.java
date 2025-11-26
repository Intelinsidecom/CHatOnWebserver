package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.chat.v */
/* loaded from: classes.dex */
class C0160v extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f982a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0160v(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f982a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f982a.f743M.startQuery(0, null, ChatONContract.MessageTable.m2190a(), null, "message_inbox_no=?", new String[]{this.f982a.f822s}, "message_is_failed , message_time , _id");
    }
}
