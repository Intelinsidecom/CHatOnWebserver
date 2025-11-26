package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dm */
/* loaded from: classes.dex */
class ViewOnClickListenerC2216dm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8510a;

    ViewOnClickListenerC2216dm(FragmentRegist fragmentRegist) {
        this.f8510a = fragmentRegist;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f8510a.getActivity(), (Class<?>) CountryActivity.class);
        intent.putExtra("ADD_BUDDY_TYPE", 100);
        intent.putExtra("needBackKey", true);
        intent.setFlags(67108864);
        this.f8510a.startActivityForResult(intent, 16);
    }
}
