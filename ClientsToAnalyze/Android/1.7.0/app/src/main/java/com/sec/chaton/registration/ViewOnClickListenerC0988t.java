package com.sec.chaton.registration;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivityRegist;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.t */
/* loaded from: classes.dex */
class ViewOnClickListenerC0988t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f3384a;

    ViewOnClickListenerC0988t(ActivityRegist.RegistFragment registFragment) {
        this.f3384a = registFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f3384a.getActivity(), (Class<?>) CountryActivity.class);
        intent.setFlags(67108864);
        this.f3384a.startActivityForResult(intent, 16);
    }
}
