package com.sec.chaton.registration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ay */
/* loaded from: classes.dex */
class C2147ay extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8422a;

    C2147ay(AuthenticatorActivity authenticatorActivity) {
        this.f8422a = authenticatorActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i = intent.getExtras().getInt("which_service");
        this.f8422a.m8462h();
        if (i == 0) {
            this.f8422a.m8466j();
        } else if (i == 2) {
            this.f8422a.f8151j.m5693a("FIRST");
        }
    }
}
