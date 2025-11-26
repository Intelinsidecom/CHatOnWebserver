package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC2412a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f9270a;

    ViewOnClickListenerC2412a(AboutServiceFragment aboutServiceFragment) {
        this.f9270a = aboutServiceFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f9270a.getActivity(), (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "TERMS_AND_CONDITION");
        intent.putExtra("FROM_ABOUT_CHATON", true);
        this.f9270a.startActivity(intent);
    }
}
