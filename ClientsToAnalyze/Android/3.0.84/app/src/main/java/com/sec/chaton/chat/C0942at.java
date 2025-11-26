package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.util.C3250y;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.at */
/* loaded from: classes.dex */
class C0942at extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3888a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0942at(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f3888a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.f3888a.f3605bb) {
            this.f3888a.f3597bT = this.f3888a.f3550aZ + 30;
            this.f3888a.f3551aa.startQuery(16, null, C1454v.m6344a(this.f3888a.f3597bT), null, "message_inbox_no=?", new String[]{this.f3888a.f3703r}, null);
            C3250y.m11450b("onChange - QUERY_MESSAGE_FOR_MARK", getClass().getSimpleName());
            return;
        }
        if (this.f3888a.f3563am) {
            this.f3888a.f3551aa.startQuery(12, null, C1454v.m6350b(this.f3888a.f3703r), null, null, null, null);
        }
        if (this.f3888a.f3503E) {
            this.f3888a.f3597bT = 30;
            this.f3888a.f3551aa.startQuery(0, null, C1454v.m6344a(this.f3888a.f3597bT), null, "message_inbox_no=?", new String[]{this.f3888a.f3703r}, null);
            C3250y.m11450b("onChange - QUERY_MESSAGE", getClass().getSimpleName());
        }
    }
}
