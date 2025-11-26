package com.sec.chaton.forward;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0694i;

/* compiled from: ChatForwardFragment.java */
/* renamed from: com.sec.chaton.forward.c */
/* loaded from: classes.dex */
class C0750c extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f2766a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0750c(ChatForwardFragment chatForwardFragment, Handler handler) {
        super(handler);
        this.f2766a = chatForwardFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f2766a.f2760o.startQuery(2, null, C0694i.f2616a, null, "inbox_unread_count > 0", null, null);
    }
}
