package com.sec.chaton.msgbox;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.p */
/* loaded from: classes.dex */
class C0860p extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f3184a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f3185b;

    C0860p(MsgboxFragment msgboxFragment, Handler handler) {
        this.f3185b = msgboxFragment;
        this.f3184a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f3184a.post(new RunnableC0861q(this));
    }
}
