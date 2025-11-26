package com.sec.chaton.smsplugin.p102b;

/* compiled from: WorkingMessage.java */
/* renamed from: com.sec.chaton.smsplugin.b.t */
/* loaded from: classes.dex */
class RunnableC3801t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3790i f13654a;

    /* renamed from: b */
    final /* synthetic */ String f13655b;

    /* renamed from: c */
    final /* synthetic */ String f13656c;

    /* renamed from: d */
    final /* synthetic */ C3799r f13657d;

    RunnableC3801t(C3799r c3799r, C3790i c3790i, String str, String str2) {
        this.f13657d = c3799r;
        this.f13654a = c3790i;
        this.f13655b = str;
        this.f13656c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13657d.m14402a(this.f13654a, this.f13655b, this.f13656c);
        this.f13657d.m14424d(this.f13654a);
    }
}
