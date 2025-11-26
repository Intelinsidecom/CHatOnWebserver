package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1323bs;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.am */
/* loaded from: classes.dex */
class ViewOnClickListenerC0941am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f3328a;

    ViewOnClickListenerC0941am(AuthenticatorActivity authenticatorActivity) {
        this.f3328a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AsyncTaskC0930ab(this).execute(new Void[0]);
        C1323bs.m4575a().edit().putString("provisioning_disclaimer_status", "DONE").commit();
        this.f3328a.startActivityForResult(new Intent(this.f3328a, (Class<?>) ActivityRegist.class), 1);
    }
}
