package com.sec.chaton.chat.p054a;

import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.common.CommonApplication;

/* compiled from: AudioBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.h */
/* loaded from: classes.dex */
class RunnableC1535h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f5941a;

    /* renamed from: b */
    final /* synthetic */ String f5942b;

    /* renamed from: c */
    final /* synthetic */ long f5943c;

    /* renamed from: d */
    final /* synthetic */ String f5944d;

    /* renamed from: e */
    final /* synthetic */ long f5945e;

    /* renamed from: f */
    final /* synthetic */ String f5946f;

    /* renamed from: g */
    final /* synthetic */ C1534g f5947g;

    RunnableC1535h(C1534g c1534g, boolean z, String str, long j, String str2, long j2, String str3) {
        this.f5947g = c1534g;
        this.f5941a = z;
        this.f5942b = str;
        this.f5943c = j;
        this.f5944d = str2;
        this.f5945e = j2;
        this.f5946f = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5941a) {
            C2204r.m10030a(CommonApplication.m18732r().getContentResolver(), this.f5942b, Long.valueOf(this.f5943c), this.f5944d);
        } else {
            C2204r.m10031a(CommonApplication.m18732r().getContentResolver(), this.f5942b, Long.valueOf(this.f5945e), this.f5944d, this.f5946f);
        }
    }
}
