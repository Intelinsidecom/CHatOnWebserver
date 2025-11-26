package com.sec.vip.amschaton.fragment;

import android.os.Handler;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cs */
/* loaded from: classes.dex */
class C3525cs extends Thread {

    /* renamed from: a */
    final /* synthetic */ String f12925a;

    /* renamed from: b */
    final /* synthetic */ Handler f12926b;

    /* renamed from: c */
    final /* synthetic */ C3523cq f12927c;

    C3525cs(C3523cq c3523cq, String str, Handler handler) {
        this.f12927c = c3523cq;
        this.f12925a = str;
        this.f12926b = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws NumberFormatException {
        this.f12926b.sendMessage(this.f12926b.obtainMessage(1, this.f12927c.m12728a(this.f12925a)));
    }
}
