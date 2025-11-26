package com.sec.chaton.registration;

import android.view.View;
import com.sec.chaton.util.C3250y;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.av */
/* loaded from: classes.dex */
class ViewOnClickListenerC2144av implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8418a;

    ViewOnClickListenerC2144av(AuthenticatorActivity authenticatorActivity) {
        this.f8418a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AuthenticatorActivity.m8456e(this.f8418a);
        if (C3250y.f11734b) {
            C3250y.m11450b("Touch Count : " + this.f8418a.f8163v, this.f8418a.f8138A);
        }
        if (this.f8418a.f8163v == 5 || this.f8418a.f8163v > 13) {
            this.f8418a.f8166y.show();
        }
    }
}
