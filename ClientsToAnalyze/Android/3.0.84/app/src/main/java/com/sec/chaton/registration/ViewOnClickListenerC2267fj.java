package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: FragmentSelectLanguage.java */
/* renamed from: com.sec.chaton.registration.fj */
/* loaded from: classes.dex */
class ViewOnClickListenerC2267fj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSelectLanguage f8563a;

    ViewOnClickListenerC2267fj(FragmentSelectLanguage fragmentSelectLanguage) {
        this.f8563a = fragmentSelectLanguage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f8563a.getActivity(), (Class<?>) SelectLanguage.class);
        intent.setFlags(67108864);
        this.f8563a.startActivityForResult(intent, 0);
    }
}
