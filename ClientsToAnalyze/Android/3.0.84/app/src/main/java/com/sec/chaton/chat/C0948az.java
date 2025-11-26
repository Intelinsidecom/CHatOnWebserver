package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1449q;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.az */
/* loaded from: classes.dex */
class C0948az extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3894a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0948az(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f3894a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f3894a.f3551aa.startQuery(10, null, C1449q.f5381a, new String[]{"inbox_valid", "inbox_session_id", "inbox_last_timestamp", "inbox_title", "inbox_last_tid", "inbox_chat_type"}, "inbox_no=?", new String[]{this.f3894a.f3703r}, null);
    }
}
