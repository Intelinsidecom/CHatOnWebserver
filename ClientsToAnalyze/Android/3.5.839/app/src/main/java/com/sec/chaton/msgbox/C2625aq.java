package com.sec.chaton.msgbox;

import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.aq */
/* loaded from: classes.dex */
class C2625aq extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9474a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2625aq(MsgboxFragment msgboxFragment, Handler handler) {
        super(handler);
        this.f9474a = msgboxFragment;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C4904y.m18639b("[CMAS Thread] mCMASlistObserver ", MsgboxFragment.f9318i);
        C2654bs.m11169a().m11187a(3, this.f9474a.f9355ai);
    }
}
