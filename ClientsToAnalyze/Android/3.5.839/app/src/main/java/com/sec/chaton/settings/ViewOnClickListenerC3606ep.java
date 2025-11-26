package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.ep */
/* loaded from: classes.dex */
class ViewOnClickListenerC3606ep implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3605eo f13136a;

    ViewOnClickListenerC3606ep(C3605eo c3605eo) {
        this.f13136a = c3605eo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f13136a.f13131a.startActivity(new Intent(this.f13136a.f13131a.getActivity(), (Class<?>) ActivityDeregister.class));
    }
}
