package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1789u;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC1172az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f4374a;

    ViewOnClickListenerC1172az(AuthenticatorActivity authenticatorActivity) {
        this.f4374a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AsyncTaskC1174ba(this).execute(new Void[0]);
        C1789u.m6075a().edit().putString("provisioning_disclaimer_status", "DONE").commit();
        this.f4374a.startActivityForResult(new Intent(this.f4374a, (Class<?>) ActivityRegist.class), 1);
    }
}
