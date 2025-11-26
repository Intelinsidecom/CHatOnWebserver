package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.as */
/* loaded from: classes.dex */
class C0941as extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3887a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0941as(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f3887a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3250y.m11453c("QUERY_PARTICIPANTS_AFTER_INSERTED_onChange", ChatFragment.f3484a);
        this.f3887a.f3551aa.startQuery(5, null, C1457y.m6367a(this.f3887a.f3703r), null, null, null, null);
    }
}
