package com.sec.chaton.msgbox;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ap */
/* loaded from: classes.dex */
class C2624ap extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9473a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2624ap(MsgboxFragment msgboxFragment, Handler handler) {
        super(handler);
        this.f9473a = msgboxFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C4904y.m18639b("[MSGBOX] mChatlistObserver ", MsgboxFragment.f9318i);
        if (this.f9473a.f9338Q || this.f9473a.f9346Y) {
            this.f9473a.f9341T = true;
        } else {
            this.f9473a.f9325D.startQuery(1, null, C2299s.m10188b(), null, null, null, null);
        }
    }
}
