package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC3536c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f13024a;

    ViewOnClickListenerC3536c(AboutServiceFragment aboutServiceFragment) {
        this.f13024a = aboutServiceFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            Intent intent = new Intent(this.f13024a.getActivity(), (Class<?>) ActivityWebView.class);
            intent.putExtra(FragmentWebView.PARAM_MENU, "License");
            this.f13024a.startActivity(intent);
        }
    }
}
