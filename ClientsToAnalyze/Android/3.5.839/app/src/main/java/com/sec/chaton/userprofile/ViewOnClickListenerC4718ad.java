package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.settings.ActivityPrivacy;
import com.sec.chaton.util.C4847bl;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC4718ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17382a;

    ViewOnClickListenerC4718ad(MyInfoFragment myInfoFragment) {
        this.f17382a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            this.f17382a.startActivity(new Intent(this.f17382a.getActivity(), (Class<?>) ActivityPrivacy.class));
        }
    }
}
