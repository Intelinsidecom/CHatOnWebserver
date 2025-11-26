package com.sec.chaton.registration;

import android.os.Handler;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.av */
/* loaded from: classes.dex */
class RunnableC1168av implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f4370a;

    RunnableC1168av(AuthenticatorActivity authenticatorActivity) {
        this.f4370a = authenticatorActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4370a.m4427a();
        new Handler().postDelayed(this.f4370a.f4306m, 700L);
    }
}
