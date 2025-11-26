package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC3432a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AboutServiceFragment f12843a;

    ViewOnClickListenerC3432a(AboutServiceFragment aboutServiceFragment) {
        this.f12843a = aboutServiceFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            Intent intent = new Intent(this.f12843a.getActivity(), (Class<?>) ActivityWebView.class);
            intent.putExtra(FragmentWebView.PARAM_MENU, "TERMS_AND_CONDITION");
            intent.putExtra(FragmentWebView.FROM_ABOUT_CHATON, true);
            this.f12843a.startActivity(intent);
        }
    }
}
