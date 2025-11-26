package com.sec.chaton.global;

import android.location.Country;
import android.location.CountryListener;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.c */
/* loaded from: classes.dex */
class C2351c implements CountryListener {

    /* renamed from: a */
    final /* synthetic */ GlobalApplication f8383a;

    C2351c(GlobalApplication globalApplication) {
        this.f8383a = globalApplication;
    }

    public synchronized void onCountryDetected(Country country) {
        this.f8383a.f8374s = country.getCountryIso();
    }
}
