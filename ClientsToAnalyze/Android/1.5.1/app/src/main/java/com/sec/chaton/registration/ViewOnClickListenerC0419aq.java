package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivityRegist;

/* renamed from: com.sec.chaton.registration.aq */
/* loaded from: classes.dex */
class ViewOnClickListenerC0419aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegisteFragment f2930a;

    ViewOnClickListenerC0419aq(ActivityRegist.RegisteFragment registeFragment) {
        this.f2930a = registeFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2930a.startActivityForResult(new Intent(this.f2930a.getActivity(), (Class<?>) CountryActivity.class), 16);
    }
}
