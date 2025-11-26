package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C3197bl;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC2466c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f9326a;

    ViewOnClickListenerC2466c(AboutServiceFragment aboutServiceFragment) {
        this.f9326a = aboutServiceFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C3197bl.m11159a()) {
            Intent intent = new Intent(this.f9326a.getActivity(), (Class<?>) ActivityWebView.class);
            intent.putExtra("PARAM_MENU", "License");
            this.f9326a.startActivity(intent);
        }
    }
}
