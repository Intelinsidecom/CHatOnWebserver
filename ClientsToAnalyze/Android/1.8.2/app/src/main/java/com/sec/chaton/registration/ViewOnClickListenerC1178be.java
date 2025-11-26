package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: CountryActivity.java */
/* renamed from: com.sec.chaton.registration.be */
/* loaded from: classes.dex */
class ViewOnClickListenerC1178be implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CountryActivity f4379a;

    ViewOnClickListenerC1178be(CountryActivity countryActivity) {
        this.f4379a = countryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4379a.startActivityForResult(new Intent(this.f4379a.f4313f, (Class<?>) CountryWrite.class), 1);
    }
}
