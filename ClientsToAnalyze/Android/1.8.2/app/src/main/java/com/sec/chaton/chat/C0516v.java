package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0694i;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.v */
/* loaded from: classes.dex */
class C0516v extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2126a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0516v(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f2126a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2126a.f1783X.startQuery(6, null, C0694i.f2616a, null, "inbox_unread_count > 0", null, null);
    }
}
