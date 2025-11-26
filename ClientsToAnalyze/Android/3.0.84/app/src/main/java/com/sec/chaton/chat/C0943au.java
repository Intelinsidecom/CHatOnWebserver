package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.au */
/* loaded from: classes.dex */
class C0943au extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3889a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0943au(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f3889a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (!this.f3889a.f3503E) {
            if (C3250y.f11734b) {
                C3250y.m11450b("mUpdatedMessageObserver", getClass().getSimpleName());
            }
            this.f3889a.f3551aa.startQuery(0, null, C1454v.m6344a(this.f3889a.f3597bT), null, "message_inbox_no=?", new String[]{this.f3889a.f3703r}, null);
        }
    }
}
