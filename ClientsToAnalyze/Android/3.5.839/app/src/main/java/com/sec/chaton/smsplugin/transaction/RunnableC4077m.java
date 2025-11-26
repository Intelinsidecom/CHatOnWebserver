package com.sec.chaton.smsplugin.transaction;

import android.content.Context;
import android.widget.Toast;

/* compiled from: MessagingNotification.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.m */
/* loaded from: classes.dex */
final class RunnableC4077m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f14684a;

    /* renamed from: b */
    final /* synthetic */ CharSequence f14685b;

    /* renamed from: c */
    final /* synthetic */ long f14686c;

    RunnableC4077m(Context context, CharSequence charSequence, long j) {
        this.f14684a = context;
        this.f14685b = charSequence;
        this.f14686c = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f14684a, this.f14685b, (int) this.f14686c).show();
    }
}
