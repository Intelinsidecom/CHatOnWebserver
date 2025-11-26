package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC2439b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f9299a;

    ViewOnClickListenerC2439b(AboutServiceFragment aboutServiceFragment) {
        this.f9299a = aboutServiceFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f9299a.getActivity(), (Class<?>) ActivityWebView.class);
        intent.putExtra("PARAM_MENU", "PRIVACY_POLICY");
        intent.putExtra("FROM_ABOUT_CHATON", true);
        this.f9299a.startActivity(intent);
    }
}
