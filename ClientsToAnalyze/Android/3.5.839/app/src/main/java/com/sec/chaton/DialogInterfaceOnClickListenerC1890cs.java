package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: SplashActivity.java */
/* renamed from: com.sec.chaton.cs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1890cs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SplashActivity f7107a;

    DialogInterfaceOnClickListenerC1890cs(SplashActivity splashActivity) {
        this.f7107a = splashActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7107a.finish();
    }
}
