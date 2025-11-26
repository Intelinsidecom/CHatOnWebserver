package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC1708r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6221a;

    ViewOnClickListenerC1708r(MyPageFragment myPageFragment) {
        this.f6221a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6221a.f5815C = true;
        this.f6221a.startActivity(new Intent(this.f6221a.getActivity(), (Class<?>) UserProfileDetail.class));
    }
}
