package com.facebook.p032b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.C0478ba;

/* compiled from: SessionTracker.java */
/* renamed from: com.facebook.b.q */
/* loaded from: classes.dex */
class C0474q extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C0472o f1163a;

    private C0474q(C0472o c0472o) {
        this.f1163a = c0472o;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C0478ba c0478baM1749j;
        if ("com.facebook.sdk.ACTIVE_SESSION_SET".equals(intent.getAction()) && (c0478baM1749j = C0478ba.m1749j()) != null) {
            c0478baM1749j.m1758a(this.f1163a.f1159b);
        }
    }
}
