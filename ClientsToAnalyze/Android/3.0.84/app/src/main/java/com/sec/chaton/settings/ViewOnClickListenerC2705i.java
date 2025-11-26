package com.sec.chaton.settings;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.AdminMenu;

/* compiled from: AboutServiceFragment.java */
/* renamed from: com.sec.chaton.settings.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC2705i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2703g f10011a;

    ViewOnClickListenerC2705i(C2703g c2703g) {
        this.f10011a = c2703g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f10011a.f10001a.f8923n >= 17) {
            this.f10011a.f10001a.f8923n = 0;
            this.f10011a.f10001a.startActivity(new Intent(this.f10011a.f10001a.getActivity(), (Class<?>) AdminMenu.class));
            return;
        }
        AboutServiceFragment.m8933l(this.f10011a.f10001a);
    }
}
