package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ac */
/* loaded from: classes.dex */
class ViewOnClickListenerC4717ac implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17381a;

    ViewOnClickListenerC4717ac(MyInfoFragment myInfoFragment) {
        this.f17381a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            this.f17381a.startActivity(new Intent(this.f17381a.getActivity(), (Class<?>) BirthdayActivity.class));
        }
    }
}
