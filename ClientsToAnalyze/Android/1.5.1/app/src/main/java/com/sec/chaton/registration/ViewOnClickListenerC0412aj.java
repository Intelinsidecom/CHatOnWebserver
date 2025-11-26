package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.registration.aj */
/* loaded from: classes.dex */
class ViewOnClickListenerC0412aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f2920a;

    ViewOnClickListenerC0412aj(AuthenticatorActivity authenticatorActivity) {
        this.f2920a = authenticatorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new AsyncTaskC0418ap(this).execute(new Void[0]);
        ChatONPref.m3519a().edit().putString("provisioning_disclaimer_status", "DONE").commit();
        Intent intent = new Intent(this.f2920a, (Class<?>) ActivityRegist.class);
        this.f2920a.f2886b = ChatONPref.m3519a().getString("msisdn", "");
        intent.putExtra("REG_PNO", this.f2920a.f2886b);
        this.f2920a.startActivityForResult(intent, 1);
    }
}
