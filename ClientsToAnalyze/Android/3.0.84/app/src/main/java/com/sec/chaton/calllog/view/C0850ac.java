package com.sec.chaton.calllog.view;

import android.os.Handler;

/* compiled from: DeleteCallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.ac */
/* loaded from: classes.dex */
class C0850ac extends Thread {

    /* renamed from: a */
    final Handler f3359a;

    /* renamed from: b */
    final /* synthetic */ DeleteCallLogFragment f3360b;

    C0850ac(DeleteCallLogFragment deleteCallLogFragment, Handler handler) {
        this.f3360b = deleteCallLogFragment;
        this.f3359a = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f3360b.m4593d();
        this.f3359a.sendMessage(this.f3359a.obtainMessage());
    }
}
