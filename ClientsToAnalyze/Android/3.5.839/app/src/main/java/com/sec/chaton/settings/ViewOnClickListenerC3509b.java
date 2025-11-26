package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC3509b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f12997a;

    ViewOnClickListenerC3509b(AboutServiceFragment aboutServiceFragment) {
        this.f12997a = aboutServiceFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            Intent intent = new Intent(this.f12997a.getActivity(), (Class<?>) ActivityWebView.class);
            intent.putExtra(FragmentWebView.PARAM_MENU, "PRIVACY_POLICY");
            intent.putExtra(FragmentWebView.FROM_ABOUT_CHATON, true);
            this.f12997a.startActivity(intent);
        }
    }
}
