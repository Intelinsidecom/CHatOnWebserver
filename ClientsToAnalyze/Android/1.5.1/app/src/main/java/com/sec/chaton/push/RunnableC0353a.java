package com.sec.chaton.push;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.sec.chaton.push.a */
/* loaded from: classes.dex */
class RunnableC0353a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f2597a;

    /* renamed from: b */
    final /* synthetic */ Intent f2598b;

    /* renamed from: c */
    final /* synthetic */ SystemStateMoniter f2599c;

    RunnableC0353a(SystemStateMoniter systemStateMoniter, Context context, Intent intent) {
        this.f2599c = systemStateMoniter;
        this.f2597a = context;
        this.f2598b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2599c.m2862a(this.f2597a, this.f2598b);
    }
}
