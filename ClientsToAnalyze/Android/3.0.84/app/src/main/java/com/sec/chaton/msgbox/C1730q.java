package com.sec.chaton.msgbox;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.q */
/* loaded from: classes.dex */
class C1730q extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f6402a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f6403b;

    C1730q(MsgboxFragment msgboxFragment, Handler handler) {
        this.f6403b = msgboxFragment;
        this.f6402a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f6402a.post(new RunnableC1731r(this));
    }
}
