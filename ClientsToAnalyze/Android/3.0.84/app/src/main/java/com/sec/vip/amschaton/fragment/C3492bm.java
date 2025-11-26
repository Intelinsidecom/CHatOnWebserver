package com.sec.vip.amschaton.fragment;

import android.os.Handler;

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bm */
/* loaded from: classes.dex */
class C3492bm extends Thread {

    /* renamed from: a */
    final /* synthetic */ String f12864a;

    /* renamed from: b */
    final /* synthetic */ Handler f12865b;

    /* renamed from: c */
    final /* synthetic */ C3490bk f12866c;

    C3492bm(C3490bk c3490bk, String str, Handler handler) {
        this.f12866c = c3490bk;
        this.f12864a = str;
        this.f12865b = handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f12865b.sendMessage(this.f12865b.obtainMessage(1, this.f12866c.m12710a(this.f12864a)));
    }
}
