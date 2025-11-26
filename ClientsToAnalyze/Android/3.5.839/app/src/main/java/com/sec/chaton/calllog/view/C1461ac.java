package com.sec.chaton.calllog.view;

import android.os.Handler;

/* compiled from: DeleteCallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.ac */
/* loaded from: classes.dex */
class C1461ac extends Thread {

    /* renamed from: a */
    final Handler f5332a;

    /* renamed from: b */
    final /* synthetic */ DeleteCallLogFragment f5333b;

    C1461ac(DeleteCallLogFragment deleteCallLogFragment, Handler handler) {
        this.f5333b = deleteCallLogFragment;
        this.f5332a = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f5333b.m7749d();
        this.f5332a.sendMessage(this.f5332a.obtainMessage());
    }
}
