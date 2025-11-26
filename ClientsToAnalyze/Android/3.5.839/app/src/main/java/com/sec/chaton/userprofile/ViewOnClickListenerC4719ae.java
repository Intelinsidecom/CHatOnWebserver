package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.registration.ActivityRegist;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ae */
/* loaded from: classes.dex */
class ViewOnClickListenerC4719ae implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17383a;

    ViewOnClickListenerC4719ae(MyInfoFragment myInfoFragment) {
        this.f17383a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f17383a.startActivity(new Intent(this.f17383a.getActivity(), (Class<?>) ActivityRegist.class));
    }
}
