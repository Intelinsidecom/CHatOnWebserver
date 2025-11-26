package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: FragmentSelectLanguage.java */
/* renamed from: com.sec.chaton.registration.fs */
/* loaded from: classes.dex */
class ViewOnClickListenerC3285fs implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSelectLanguage f12053a;

    ViewOnClickListenerC3285fs(FragmentSelectLanguage fragmentSelectLanguage) {
        this.f12053a = fragmentSelectLanguage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f12053a.getActivity(), (Class<?>) SelectLanguage.class);
        intent.setFlags(67108864);
        this.f12053a.startActivityForResult(intent, 0);
    }
}
