package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.AdminMenu;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC3661i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3644g f13237a;

    ViewOnClickListenerC3661i(C3644g c3644g) {
        this.f13237a = c3644g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f13237a.f13204a.f12453n >= 17) {
            this.f13237a.f13204a.f12453n = 0;
            this.f13237a.f13204a.startActivity(new Intent(this.f13237a.f13204a.getActivity(), (Class<?>) AdminMenu.class));
            return;
        }
        AboutServiceFragment.m13323n(this.f13237a.f13204a);
    }
}
