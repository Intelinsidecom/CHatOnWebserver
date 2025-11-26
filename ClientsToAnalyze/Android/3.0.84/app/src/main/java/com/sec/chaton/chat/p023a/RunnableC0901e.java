package com.sec.chaton.chat.p023a;

import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.common.CommonApplication;

/* compiled from: AudioBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.e */
/* loaded from: classes.dex */
class RunnableC0901e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f3832a;

    /* renamed from: b */
    final /* synthetic */ String f3833b;

    /* renamed from: c */
    final /* synthetic */ long f3834c;

    /* renamed from: d */
    final /* synthetic */ String f3835d;

    /* renamed from: e */
    final /* synthetic */ long f3836e;

    /* renamed from: f */
    final /* synthetic */ String f3837f;

    /* renamed from: g */
    final /* synthetic */ C0900d f3838g;

    RunnableC0901e(C0900d c0900d, boolean z, String str, long j, String str2, long j2, String str3) {
        this.f3838g = c0900d;
        this.f3832a = z;
        this.f3833b = str;
        this.f3834c = j;
        this.f3835d = str2;
        this.f3836e = j2;
        this.f3837f = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3832a) {
            C1373q.m6178a(CommonApplication.m11493l().getContentResolver(), this.f3833b, Long.valueOf(this.f3834c), this.f3835d);
        } else {
            C1373q.m6179a(CommonApplication.m11493l().getContentResolver(), this.f3833b, Long.valueOf(this.f3836e), this.f3835d, this.f3837f);
        }
    }
}
