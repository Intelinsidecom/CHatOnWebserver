package com.sec.vip.amschaton.fragment;

import android.os.Handler;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bp */
/* loaded from: classes.dex */
class C3495bp extends Thread {

    /* renamed from: a */
    final /* synthetic */ int f12873a;

    /* renamed from: b */
    final /* synthetic */ Handler f12874b;

    /* renamed from: c */
    final /* synthetic */ C3493bn f12875c;

    C3495bp(C3493bn c3493bn, int i, Handler handler) {
        this.f12875c = c3493bn;
        this.f12873a = i;
        this.f12874b = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f12874b.sendMessage(this.f12874b.obtainMessage(1, this.f12875c.m12712a(this.f12873a)));
    }
}
