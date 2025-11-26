package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bm */
/* loaded from: classes.dex */
class C0573bm extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1990a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0573bm(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f1990a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C1341p.m4658b("onChange - QUERY_MESSAGE", getClass().getSimpleName());
        if (this.f1990a.f1745F) {
            this.f1990a.f1852by = ChatFragment.f1729bx;
            this.f1990a.f1760U.startQuery(0, null, C0662o.m2995a(this.f1990a.f1852by), null, "message_inbox_no=?", new String[]{this.f1990a.f1861t}, null);
        }
    }
}
