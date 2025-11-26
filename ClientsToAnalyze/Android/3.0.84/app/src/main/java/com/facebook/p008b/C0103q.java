package com.facebook.p008b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.C0107ba;

/* compiled from: SessionTracker.java */
/* renamed from: com.facebook.b.q */
/* loaded from: classes.dex */
class C0103q extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0101o f194a;

    private C0103q(C0101o c0101o) {
        this.f194a = c0101o;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C0107ba c0107baM305j;
        if ("com.facebook.sdk.ACTIVE_SESSION_SET".equals(intent.getAction()) && (c0107baM305j = C0107ba.m305j()) != null) {
            c0107baM305j.m314a(this.f194a.f190b);
        }
    }
}
