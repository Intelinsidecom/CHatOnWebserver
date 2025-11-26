package com.sec.chaton.userprofile;

import android.content.Intent;
import android.view.View;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC1258h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4355a;

    ViewOnClickListenerC1258h(MyPageFragment myPageFragment) {
        this.f4355a = myPageFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4355a.f4113K = true;
        this.f4355a.startActivity(new Intent(this.f4355a.getActivity(), (Class<?>) UserProfileDetail.class));
    }
}
