package com.sec.chaton.samsungaccount;

import android.app.Activity;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ay */
/* loaded from: classes.dex */
class RunnableC3346ay implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3344aw f12284a;

    RunnableC3346ay(C3344aw c3344aw) {
        this.f12284a = c3344aw;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12284a.f12282a.m13186w();
        if (!((Activity) this.f12284a.f12282a.f12192B).isFinishing()) {
            this.f12284a.f12282a.m13187x();
        }
    }
}
