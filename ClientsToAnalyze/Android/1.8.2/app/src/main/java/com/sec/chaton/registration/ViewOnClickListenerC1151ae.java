package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivityRegist;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC1151ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f4353a;

    ViewOnClickListenerC1151ae(ActivityRegist.RegistFragment registFragment) {
        this.f4353a = registFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4353a.getActivity(), (Class<?>) CountryActivity.class);
        intent.setFlags(67108864);
        this.f4353a.startActivityForResult(intent, 16);
    }
}
