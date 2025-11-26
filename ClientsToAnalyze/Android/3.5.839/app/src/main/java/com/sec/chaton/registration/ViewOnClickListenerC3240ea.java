package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ea */
/* loaded from: classes.dex */
class ViewOnClickListenerC3240ea implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12007a;

    ViewOnClickListenerC3240ea(FragmentRegist fragmentRegist) {
        this.f12007a = fragmentRegist;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f12007a.getActivity(), (Class<?>) CountryActivity.class);
        intent.putExtra("ADD_BUDDY_TYPE", 100);
        intent.putExtra("needBackKey", true);
        intent.setFlags(67108864);
        this.f12007a.startActivityForResult(intent, 16);
    }
}
