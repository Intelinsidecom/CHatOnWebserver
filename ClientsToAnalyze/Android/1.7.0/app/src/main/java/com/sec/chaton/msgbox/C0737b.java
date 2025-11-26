package com.sec.chaton.msgbox;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.b */
/* loaded from: classes.dex */
class C0737b extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f2531a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f2532b;

    C0737b(MsgboxFragment msgboxFragment, Handler handler) {
        this.f2532b = msgboxFragment;
        this.f2531a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2531a.post(new RunnableC0741f(this));
    }
}
