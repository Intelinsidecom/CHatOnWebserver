package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC4716ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17380a;

    ViewOnClickListenerC4716ab(MyInfoFragment myInfoFragment) {
        this.f17380a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            this.f17380a.startActivity(new Intent(this.f17380a.getActivity(), (Class<?>) EditStatusActivity.class));
        }
    }
}
