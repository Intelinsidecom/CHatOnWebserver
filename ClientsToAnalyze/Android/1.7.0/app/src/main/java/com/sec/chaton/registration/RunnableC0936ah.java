package com.sec.chaton.registration;

import android.os.Handler;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ah */
/* loaded from: classes.dex */
class RunnableC0936ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f3323a;

    RunnableC0936ah(AuthenticatorActivity authenticatorActivity) {
        this.f3323a = authenticatorActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3323a.m3739a();
        new Handler().postDelayed(this.f3323a.f3281m, 700L);
    }
}
