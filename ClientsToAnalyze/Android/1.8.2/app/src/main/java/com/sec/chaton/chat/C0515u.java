package com.sec.chaton.chat;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.util.C1786r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.u */
/* loaded from: classes.dex */
class C0515u extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2125a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0515u(ChatFragment chatFragment, Handler handler) {
        super(handler);
        this.f2125a = chatFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C1786r.m6061b("onChange - QUERY_MESSAGE", getClass().getSimpleName());
        this.f2125a.f1783X.startQuery(0, null, C0698m.m3148a(this.f2125a.f1895cg), null, "message_inbox_no=?", new String[]{this.f2125a.f1912z}, null);
    }
}
