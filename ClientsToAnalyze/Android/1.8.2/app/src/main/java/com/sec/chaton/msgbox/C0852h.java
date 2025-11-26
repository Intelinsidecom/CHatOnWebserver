package com.sec.chaton.msgbox;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.h */
/* loaded from: classes.dex */
class C0852h extends Thread {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f3171a;

    C0852h(MsgboxFragment msgboxFragment) {
        this.f3171a = msgboxFragment;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        if (this.f3171a.f3111e != null) {
            this.f3171a.m3511g();
            this.f3171a.f3111e = null;
        }
    }
}
