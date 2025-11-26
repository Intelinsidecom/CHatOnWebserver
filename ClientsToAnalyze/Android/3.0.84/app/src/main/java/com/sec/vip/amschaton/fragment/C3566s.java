package com.sec.vip.amschaton.fragment;

import android.os.Handler;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.s */
/* loaded from: classes.dex */
class C3566s extends Thread {

    /* renamed from: a */
    final /* synthetic */ String f13004a;

    /* renamed from: b */
    final /* synthetic */ Handler f13005b;

    /* renamed from: c */
    final /* synthetic */ C3564q f13006c;

    C3566s(C3564q c3564q, String str, Handler handler) {
        this.f13006c = c3564q;
        this.f13004a = str;
        this.f13005b = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f13005b.sendMessage(this.f13005b.obtainMessage(1, this.f13006c.m12748a(this.f13004a)));
    }
}
