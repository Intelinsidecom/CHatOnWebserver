package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2299s;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.br */
/* loaded from: classes.dex */
class C1610br extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6127a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1610br(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f6127a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f6127a.f5546ao.startQuery(6, null, C2299s.f8209a, null, "inbox_unread_count > 0", null, null);
    }
}
