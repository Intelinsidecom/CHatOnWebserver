package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.samsungaccount.DirectCallSAActivity;
import com.sec.chaton.util.C4904y;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC4720af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17384a;

    ViewOnClickListenerC4720af(MyInfoFragment myInfoFragment) {
        this.f17384a = myInfoFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4904y.m18646e("mypage_sign_in_to_your_samsung_account", getClass().getSimpleName());
        Intent intent = new Intent(this.f17384a.getActivity(), (Class<?>) DirectCallSAActivity.class);
        intent.putExtra("is_mapping_mode", true);
        this.f17384a.startActivity(intent);
    }
}
