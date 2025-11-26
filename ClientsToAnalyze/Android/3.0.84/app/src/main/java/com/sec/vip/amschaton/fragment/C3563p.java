package com.sec.vip.amschaton.fragment;

import android.os.Handler;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.p */
/* loaded from: classes.dex */
class C3563p extends Thread {

    /* renamed from: a */
    final /* synthetic */ int f12997a;

    /* renamed from: b */
    final /* synthetic */ Handler f12998b;

    /* renamed from: c */
    final /* synthetic */ C3561n f12999c;

    C3563p(C3561n c3561n, int i, Handler handler) {
        this.f12999c = c3561n;
        this.f12997a = i;
        this.f12998b = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f12998b.sendMessage(this.f12998b.obtainMessage(1, this.f12999c.m12746a(this.f12997a)));
    }
}
