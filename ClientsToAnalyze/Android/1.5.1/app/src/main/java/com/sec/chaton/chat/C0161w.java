package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.database.ChatONContract;

/* renamed from: com.sec.chaton.chat.w */
/* loaded from: classes.dex */
class C0161w extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f983a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0161w(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f983a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f983a.f743M.startQuery(5, null, ChatONContract.ParticipantTable.m2199a(this.f983a.f822s), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "buddy_name ASC");
    }
}
