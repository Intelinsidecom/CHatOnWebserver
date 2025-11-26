package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.sec.chaton.util.C3250y;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ax */
/* loaded from: classes.dex */
class C2146ax extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8421a;

    C2146ax(AuthenticatorActivity authenticatorActivity) {
        this.f8421a = authenticatorActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("validation_result", false);
        if (C3250y.f11734b) {
            C3250y.m11450b("validation : " + booleanExtra, this.f8421a.f8138A);
        }
        this.f8421a.f8160s = booleanExtra;
        new Handler().postDelayed(this.f8421a.f8139B, 0L);
    }
}
