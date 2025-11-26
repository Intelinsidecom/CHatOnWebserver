package com.sec.chaton.smsplugin.transaction;

import android.net.Uri;
import com.sec.chaton.smsplugin.p110g.C3870p;

/* compiled from: BackgroundSenderService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.f */
/* loaded from: classes.dex */
class RunnableC4070f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Uri f14669a;

    /* renamed from: b */
    final /* synthetic */ C3870p f14670b;

    /* renamed from: c */
    final /* synthetic */ C4066b f14671c;

    RunnableC4070f(C4066b c4066b, Uri uri, C3870p c3870p) {
        this.f14671c = c4066b;
        this.f14669a = uri;
        this.f14670b = c3870p;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14671c.m15649a(this.f14669a, this.f14670b, this.f14671c.f14664l, this.f14671c.f14665m);
    }
}
