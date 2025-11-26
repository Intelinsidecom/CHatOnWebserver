package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1449q;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ax */
/* loaded from: classes.dex */
class C0946ax extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3892a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0946ax(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f3892a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f3892a.f3551aa.startQuery(6, null, C1449q.f5381a, null, "inbox_unread_count > 0", null, null);
    }
}
