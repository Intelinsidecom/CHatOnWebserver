package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C4847bl;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.v */
/* loaded from: classes.dex */
class ViewOnClickListenerC4803v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17535a;

    ViewOnClickListenerC4803v(MyInfoFragment myInfoFragment) {
        this.f17535a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            this.f17535a.startActivity(new Intent(this.f17535a.getActivity(), (Class<?>) ProfileImageHistoryActivity.class));
        }
    }
}
