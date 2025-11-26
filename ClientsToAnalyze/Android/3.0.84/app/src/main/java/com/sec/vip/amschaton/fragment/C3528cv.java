package com.sec.vip.amschaton.fragment;

import android.os.Handler;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cv */
/* loaded from: classes.dex */
class C3528cv extends Thread {

    /* renamed from: a */
    final /* synthetic */ int f12933a;

    /* renamed from: b */
    final /* synthetic */ Handler f12934b;

    /* renamed from: c */
    final /* synthetic */ C3526ct f12935c;

    C3528cv(C3526ct c3526ct, int i, Handler handler) {
        this.f12935c = c3526ct;
        this.f12933a = i;
        this.f12934b = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f12934b.sendMessage(this.f12934b.obtainMessage(1, this.f12935c.m12730a(this.f12933a)));
    }
}
