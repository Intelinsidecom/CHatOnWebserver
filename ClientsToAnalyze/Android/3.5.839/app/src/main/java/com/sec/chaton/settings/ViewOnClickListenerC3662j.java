package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;

/* compiled from: AccountFragment.java */
/* renamed from: com.sec.chaton.settings.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC3662j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AccountFragment f13238a;

    ViewOnClickListenerC3662j(AccountFragment accountFragment) {
        this.f13238a = accountFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f13238a.startActivity(new Intent(this.f13238a.getActivity(), (Class<?>) ActivityDeregister.class));
    }
}
