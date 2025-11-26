package com.sec.chaton.msgbox;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.util.C3250y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.j */
/* loaded from: classes.dex */
class C1723j extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6389a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1723j(MsgboxFragment msgboxFragment, Handler handler) {
        super(handler);
        this.f6389a = msgboxFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3250y.m11450b("[MSGBOX] mChatlistObserver ", MsgboxFragment.f6228a);
        if (this.f6389a.f6237F || this.f6389a.f6248Q) {
            this.f6389a.f6243L = true;
        } else {
            this.f6389a.f6276p.startQuery(1, null, C1449q.m6331b(), null, null, null, null);
        }
    }
}
