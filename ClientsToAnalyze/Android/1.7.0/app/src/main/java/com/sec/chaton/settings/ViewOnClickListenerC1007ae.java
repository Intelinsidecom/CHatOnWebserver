package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1346u;

/* compiled from: AboutFragment.java */
/* renamed from: com.sec.chaton.settings.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC1007ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AboutFragment f3611a;

    ViewOnClickListenerC1007ae(AboutFragment aboutFragment) {
        this.f3611a = aboutFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1346u.m4676a()) {
            Intent intent = new Intent(this.f3611a.getActivity(), (Class<?>) ActivityWebView.class);
            intent.putExtra(FragmentWebView.PARAM_MENU, "License");
            this.f3611a.startActivity(intent);
        }
    }
}
