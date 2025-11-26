package com.sec.chaton.smsplugin.p111h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: RateController.java */
/* renamed from: com.sec.chaton.smsplugin.h.v */
/* loaded from: classes.dex */
class C3899v extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C3898u f14013a;

    C3899v(C3898u c3898u) {
        this.f14013a = c3898u;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.sec.chaton.smsplugin.RATE_LIMIT_CONFIRMED".equals(intent.getAction())) {
            synchronized (this) {
                this.f14013a.f14011d = intent.getBooleanExtra("answer", false) ? 1 : 2;
                notifyAll();
            }
        }
    }
}
