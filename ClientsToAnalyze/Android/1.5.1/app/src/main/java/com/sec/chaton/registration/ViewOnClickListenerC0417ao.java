package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* renamed from: com.sec.chaton.registration.ao */
/* loaded from: classes.dex */
class ViewOnClickListenerC0417ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CountryActivity f2928a;

    ViewOnClickListenerC0417ao(CountryActivity countryActivity) {
        this.f2928a = countryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2928a.startActivityForResult(new Intent(this.f2928a.f2900f, (Class<?>) CountryWrite.class), 1);
    }
}
