package com.sec.chaton.samsungaccount;

import android.app.Activity;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ax */
/* loaded from: classes.dex */
class RunnableC3345ax implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3344aw f12283a;

    RunnableC3345ax(C3344aw c3344aw) {
        this.f12283a = c3344aw;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!((Activity) this.f12283a.f12282a.f12192B).isFinishing()) {
            this.f12283a.f12282a.m13186w();
        }
    }
}
