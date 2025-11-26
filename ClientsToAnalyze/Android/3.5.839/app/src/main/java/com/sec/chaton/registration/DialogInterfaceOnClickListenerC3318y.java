package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: CountryActivity.java */
/* renamed from: com.sec.chaton.registration.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3318y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CountryActivity f12101a;

    DialogInterfaceOnClickListenerC3318y(CountryActivity countryActivity) {
        this.f12101a = countryActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12101a.finishActivity(8);
    }
}
